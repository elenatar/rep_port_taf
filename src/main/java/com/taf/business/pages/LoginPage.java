package com.taf.business.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement loginField = $(By.xpath("//input[@name='login']"));
    public SelenideElement passwordField = $(By.xpath("//input[@name='password']"));
    public SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));
}
