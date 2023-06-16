package com.taf.tests.hooks;

import com.codeborne.selenide.Configuration;
import com.taf.business.driver.DriverManager;
import com.taf.core.utils.ScreenshotOnTestFailureUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UISeleniumCucumberHooks {

    private static WebDriver driver;

    @Before("@selenium")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Configuration.baseUrl + "/ui/#login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        DriverManager.setDriver(driver);
    }

    @After("@selenium")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotOnTestFailureUtil.captureScreenshot(driver);
        }
        if (driver != null) {
            driver.quit();
        }
        DriverManager.removeDriver();
    }
}
