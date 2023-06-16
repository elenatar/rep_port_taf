package com.taf.business.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> containerWebDriver = ThreadLocal.withInitial(() -> null);
    private static DriverManager instance;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return containerWebDriver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        containerWebDriver.set(webDriver);
    }

    public static void removeDriver() {
        containerWebDriver.remove();
    }
}
