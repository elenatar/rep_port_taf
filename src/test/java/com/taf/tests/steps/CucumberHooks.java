package com.taf.tests.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.taf.core.ConfigManager;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;

public class CucumberHooks {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = ConfigManager.getBrowser();
        Configuration.baseUrl = ConfigManager.getUrl();
    }

    @After
    public void tearDown() {
        Selenide.closeWindow();
    }
}
