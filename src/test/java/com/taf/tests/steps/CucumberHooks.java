package com.taf.tests.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.open;

public class CucumberHooks {

    @Before
    public void openBaseUrl() { open("/"); }

    @After
    public void tearDown() {
        Selenide.closeWindow();
    }
}
