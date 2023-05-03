package com.taf.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.taf.business.driver.Driver;
import com.taf.core.ConfigManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

class BaseTest {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = ConfigManager.getInstance().getConfigDTO().getUrl();
        open("/");
    }

    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
        Selenide.closeWindow();
    }
}
