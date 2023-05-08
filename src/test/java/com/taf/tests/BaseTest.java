package com.taf.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.taf.core.ConfigManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = ConfigManager.getUrl();
    }

    @BeforeEach
    public void openBaseURL() {
        open("/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWindow();
    }
}
