package com.taf.tests.steps.ui.selenium;

import com.taf.business.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public class BaseDefinitionSteps {

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
