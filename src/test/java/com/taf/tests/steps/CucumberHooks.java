package com.taf.tests.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

public class CucumberHooks {

    @After
    public void tearDown() {
        Selenide.closeWindow();
    }
}
