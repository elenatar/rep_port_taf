package com.taf.core.utils;

import com.taf.business.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JsExecutorUtil {
    private JsExecutorUtil() {
    }

    public static void clickOnElementUsingJs(final WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoView(final WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].scrollIntoView();", element);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).build().perform();
    }
}
