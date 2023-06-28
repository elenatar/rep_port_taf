package com.taf.tests.steps.ui.selenium;

import com.taf.business.pages.selenium.DashboardsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;

import static org.junit.Assert.assertTrue;

@Slf4j
public class DashboardDefinitionSteps extends BaseDefinitionSteps {

    private DashboardsPage getDashboardPage() {
        return new DashboardsPage();
    }

    @Given("Dashboards page is displayed")
    public void userLoginsToReportPortal() {
        assertTrue("Dashboard page is not displayed", getDashboardPage().dashboardPageIsDisplayed());
    }

    @Then("Dashboards table should contain items")
    public void dashboardsTableShouldContainItems() {
        assertTrue("There are no dashboards to display",
                getDashboardPage().getDashboardNamesList().size() > 0);
    }

    @And("Choose dashboard name")
    public void chooseDashboardName() {
        getDashboardPage().clickDashboardName();
        log.info("Dashboard has been chosen");
    }

    @Then("Widgets should be displayed")
    public void widgetsShouldBeDisplayed() {
        assertTrue("There are no widgets to display",
                getDashboardPage().getWidgetsList().size() > 0);
    }

    @And("Resize widget with index {int}")
    public void resizeWidgetWithIndex(int widgetIndex) {
        Dimension initWidgetDimensions = getDashboardPage().getWidgetSize(widgetIndex);
        getDashboardPage().resizeWidget(widgetIndex, 100, 100);
        Dimension afterResizeWidgetDimensions = getDashboardPage().getWidgetSize(widgetIndex);
        assertTrue("Widget was not resized",
                afterResizeWidgetDimensions.getHeight() > initWidgetDimensions.getHeight() &&
                        afterResizeWidgetDimensions.getWidth() > initWidgetDimensions.getWidth());
    }
}
