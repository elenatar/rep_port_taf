package com.taf.tests;

import com.taf.business.pages.DashboardsPage;
import com.taf.business.pages.HomePage;
import com.taf.business.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.page;

@Execution(ExecutionMode.CONCURRENT)
    class DashboardTests extends BaseTest {
    LoginPage loginPage = page(LoginPage.class);
    DashboardsPage dashboardsPage = page(DashboardsPage.class);
    HomePage homePage = page(HomePage.class);

    @Test
    void checkThatDashboardListHasItems() {
        loginPage.fillLoginForm();
        homePage.clickProjectWidget();
        homePage.chooseProjectName();
        dashboardsPage.dashboardListShouldHaveItems();
    }

    @ParameterizedTest
    @ValueSource(strings = {"DASHBOARD NAME", "DESCRIPTION", "OWNER", "SHARED", "EDIT", "DELETE"})
    void checkDashboardColumnHeadersText(String columnHeaderText) {
        loginPage.fillLoginForm();
        homePage.clickProjectWidget();
        homePage.chooseProjectName();
        dashboardsPage.dashboardListShouldHaveItems();
        dashboardsPage.checkDashboardColumnsHeaders(columnHeaderText);
    }

    @ParameterizedTest
    @ValueSource(strings = {"DEMO DASHBOARD", "TEST DASHBOARD"})
    void checkDashboardItemNames(String dashboardName) {
        loginPage.fillLoginForm();
        homePage.clickProjectWidget();
        homePage.chooseProjectName();
        dashboardsPage.dashboardListShouldHaveItems();
        dashboardsPage.dashboardItemNameShouldHaveText(dashboardName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Dashboard for demo", "Dashboard for test"})
    void checkDashboardItemDescriptions(String dashboardDescription) {
        loginPage.fillLoginForm();
        homePage.clickProjectWidget();
        homePage.chooseProjectName();
        dashboardsPage.dashboardListShouldHaveItems();
        dashboardsPage.dashboardItemDescriptionShouldHaveText(dashboardDescription);
    }

    @ParameterizedTest
    @ValueSource(strings = {"rptestuser"})
    void checkDashboardItemOwner(String dashboardOwner) {
        loginPage.fillLoginForm();
        homePage.clickProjectWidget();
        homePage.chooseProjectName();
        dashboardsPage.dashboardListShouldHaveItems();
        dashboardsPage.dashboardItemOwnerShouldHaveText(dashboardOwner);
    }
}
