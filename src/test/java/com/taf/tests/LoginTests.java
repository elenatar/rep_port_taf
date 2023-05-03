package com.taf.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.taf.business.pages.DashboardsPage;
import com.taf.business.pages.LoginPage;
import com.taf.core.ConfigManager;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTests extends BaseTest {
    LoginPage loginPage = page(LoginPage.class);
    DashboardsPage dashboardsPage = page(DashboardsPage.class);

    @Test
    void testLoginPageURL() {
        String url = WebDriverRunner.url();
        assertEquals(ConfigManager.getInstance().getConfigDTO().getUrl(), url);
    }

    @Test
    void testLoginSuccessfully() {
        loginPage.fillLoginForm();
        dashboardsPage.getPageHeader().shouldBe(Condition.visible);
    }
}
