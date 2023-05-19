package com.taf.tests;

import com.taf.business.pages.DashboardsPage;
import com.taf.business.pages.WidgetsPage;
import com.taf.business.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.page;

@Execution(ExecutionMode.CONCURRENT)
class DashboardTests extends BaseTest {

    private final LoginService loginService = page(LoginService.class);
    private final DashboardsPage dashboardsPage = page(DashboardsPage.class);
    private final WidgetsPage widgetsPage = page(WidgetsPage.class);

    @BeforeEach
    void navigateToDashboards() {
        loginService.loginWithUser();
        widgetsPage.clickProjectWidget();
        widgetsPage.chooseProjectName();
    }

    @Test
    void checkThatDashboardListHasItems() {
        dashboardsPage.dashboardListShouldHaveItems();
    }

    @ParameterizedTest
    @ValueSource(strings = {"DASHBOARD NAME", "DESCRIPTION", "OWNER", "SHARED", "EDIT", "DELETE"})
    void checkDashboardColumnHeadersText(final String columnHeaderText) {
        dashboardsPage.dashboardListShouldHaveItems();
        dashboardsPage.checkDashboardColumnsHeaders(columnHeaderText);
    }

    @ParameterizedTest
    @ValueSource(strings = {"DEMO DASHBOARD", "TEST DASHBOARD"})
    void checkDashboardItemNames(final String dashboardName) {
        dashboardsPage.dashboardListShouldHaveItems();
        dashboardsPage.dashboardItemNameShouldHaveText(dashboardName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Dashboard for demo", "Dashboard for test"})
    void checkDashboardItemDescriptions(final String dashboardDescription) {
        dashboardsPage.dashboardListShouldHaveItems();
        dashboardsPage.dashboardItemDescriptionShouldHaveText(dashboardDescription);
    }

    @ParameterizedTest
    @ValueSource(strings = {"rptestuser"})
    void checkDashboardItemOwner(final String dashboardOwner) {
        dashboardsPage.dashboardListShouldHaveItems();
        dashboardsPage.dashboardItemOwnerShouldHaveText(dashboardOwner);
    }
}
