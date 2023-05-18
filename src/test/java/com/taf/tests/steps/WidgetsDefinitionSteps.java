package com.taf.tests.steps;

import com.taf.business.pages.WidgetsPage;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.page;

public class WidgetsDefinitionSteps {

    private final WidgetsPage widgetsPage = page(WidgetsPage.class);

    @Then("Choose dashboard")
    public void chooseDashboard() {
        widgetsPage.chooseDashboard();
    }
}
