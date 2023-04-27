package com.taf.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.taf.business.driver.Driver;
import com.taf.business.pages.DashboardsPage;
import com.taf.business.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsJUnit {
    public static final String RP_URL = "https://rp.epam.com/ui/#login";
    LoginPage loginPage = page(LoginPage.class);
    DashboardsPage dashboardsPage = page(DashboardsPage.class);

    @BeforeEach
    public void setUp(){
        open(RP_URL);
    }

    @Test
    public void testLoginPageURL(){
        String url = WebDriverRunner.url();
        assertEquals(RP_URL, url);
    }

    @Test
    public void testLoginSuccessfully() {
        loginPage.loginField.val("RpTestUser").pressEnter();
        loginPage.passwordField.val("Test123");
        loginPage.submitButton.click();
        dashboardsPage.pageHeader.shouldBe(Condition.visible);
    }

    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }
}
