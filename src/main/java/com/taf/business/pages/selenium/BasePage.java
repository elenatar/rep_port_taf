package com.taf.business.pages.selenium;

import com.taf.business.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void waitVisibilityOfElement(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElementUsingJs(final WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollIntoView(final WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
