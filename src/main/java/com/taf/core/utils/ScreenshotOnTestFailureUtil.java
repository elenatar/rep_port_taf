package com.taf.core.utils;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

@Slf4j
public class ScreenshotOnTestFailureUtil {

    private ScreenshotOnTestFailureUtil() {
    }

    public static void captureScreenshot(WebDriver driver) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment("Failed screenshot", new ByteArrayInputStream(screenshot));
            log.info("Screenshot on test failure has been taken");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
