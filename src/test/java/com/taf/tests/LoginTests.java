package com.taf.tests;

import com.codeborne.selenide.Condition;
import com.taf.business.pages.DashboardsPage;
import com.taf.business.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

class LoginTests extends BaseTest {
    LoginPage loginPage = page(LoginPage.class);
    DashboardsPage dashboardsPage = page(DashboardsPage.class);

    @Test
    void testLoginSuccessfully() {
        loginPage.fillLoginForm();
        dashboardsPage.getPageHeader().shouldBe(Condition.visible);
    }
}
