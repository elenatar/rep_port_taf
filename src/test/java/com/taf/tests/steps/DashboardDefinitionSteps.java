package com.taf.tests.steps;

import com.taf.business.pages.DashboardsPage;
import com.taf.business.pages.WidgetsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.page;

public class DashboardDefinitionSteps {

    private DashboardsPage dashboardsPage = page(DashboardsPage.class);
    private WidgetsPage widgetsPage = page(WidgetsPage.class);

    @Then("Dashboards page is opened")
    public void dashboardsPageIsOpened() {
        dashboardsPage.dashboardPageShouldBeVisible();
    }

    @When("Click project widget")
    public void clickProjectWidget() {
        widgetsPage.clickProjectWidget();
    }

    @Then("Choose project name")
    public void chooseProjectName() {
        widgetsPage.chooseProjectName();
    }

    @Then("Dashboards table should have items")
    public void dashboardTableShouldHaveItems() {
        dashboardsPage.dashboardListShouldHaveItems();
    }

    @Then("Dashboards table should have name {}")
    public void dashboardTableShouldHaveNameDashboardName(final String dashboardName) {
        dashboardsPage.dashboardItemNameShouldHaveText(dashboardName);
    }

    @Then("Dashboards table should have description {}")
    public void dashboardTableShouldHaveDescriptionDescriptionName(final String dashboardDescription) {
        dashboardsPage.dashboardItemDescriptionShouldHaveText(dashboardDescription);
    }

    @Then("Dashboards table columns should have headers {}")
    public void dashboardsTableColumnsShouldHaveHeadersHeaderName(final String columnHeader) {
        dashboardsPage.checkDashboardColumnsHeaders(columnHeader);
    }

    @Then("Dashboards table should have owner {string}")
    public void dashboardsTableShouldHaveOwner(final String dashboardOwner) {
        dashboardsPage.dashboardItemOwnerShouldHaveText(dashboardOwner);
    }
}
