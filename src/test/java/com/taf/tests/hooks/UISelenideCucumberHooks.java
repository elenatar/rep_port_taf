package com.taf.tests.hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.open;

public class UISelenideCucumberHooks {

    @Before("@selenide")
    public void openBaseUrl() {
        open("/ui/#login");
    }

    @After("@selenide")
    public void tearDown() {
        Selenide.closeWindow();
    }
}
