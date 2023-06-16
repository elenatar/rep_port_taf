package com.taf.business.pages.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginField(String userLogin) {
        waitVisibilityOfElement(loginField);
        loginField.clear();
        loginField.sendKeys(userLogin);
    }

    public void fillPasswordField(String userPassword) {
        waitVisibilityOfElement(passwordField);
        passwordField.clear();
        passwordField.sendKeys(userPassword);
    }

    public void clickSubmitButton() {
        waitVisibilityOfElement(submitButton);
        submitButton.click();
    }
}
