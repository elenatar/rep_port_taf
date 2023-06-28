package com.taf.tests.steps.ui.selenide;

import com.taf.business.pages.selenide.DashboardsPage;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.page;

public class DashboardDefinitionSteps {

    private final DashboardsPage dashboardsPage = page(DashboardsPage.class);

    @Then("Dashboards page is opened")
    public void dashboardsPageIsOpened() {
        dashboardsPage.dashboardPageShouldBeVisible();
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
