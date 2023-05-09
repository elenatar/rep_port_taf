package com.taf.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.taf.core.ConfigManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = ConfigManager.getBrowser();
        Configuration.baseUrl = ConfigManager.getUrl();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWindow();
    }
}
