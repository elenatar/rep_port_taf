package com.taf.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.taf.business.driver.Driver;
import com.taf.core.ConfigManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseTest {

    @BeforeEach
    public void setUp() {
        open(ConfigManager.getInstance().getConfigDTO().getUrl());
    }

    @Test
    void testLoginPageURL() {
        String url = WebDriverRunner.url();
        assertEquals(ConfigManager.getInstance().getConfigDTO().getUrl(), url);
    }

    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }
}
