package com.taf.tests;

import com.taf.business.pages.DashboardsPage;
import com.taf.business.service.LoginService;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

class LoginTests extends BaseTest {
    LoginService loginPage = page(LoginService.class);
    DashboardsPage dashboardsPage = page(DashboardsPage.class);

    @Test
    void testLoginSuccessfully() {
        loginPage.loginWithUser();
        dashboardsPage.dashboardPageShouldBeVisible();
    }
}
