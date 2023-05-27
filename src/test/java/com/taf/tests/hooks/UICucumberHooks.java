package com.taf.tests.hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.open;

public class UICucumberHooks {

    @Before("@ui")
    public void openBaseUrl() {
        open("/ui/#login");
    }

    @After("@ui")
    public void tearDown() {
        Selenide.closeWindow();
    }
}
