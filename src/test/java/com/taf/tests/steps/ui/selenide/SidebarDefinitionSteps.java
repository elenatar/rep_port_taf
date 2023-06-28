package com.taf.tests.steps.ui.selenide;

import com.taf.business.pages.selenide.Sidebar;
import io.cucumber.java.en.Then;

public class SidebarDefinitionSteps {

    private final Sidebar sidebar = new Sidebar();

    @Then("Choose dashboard")
    public void chooseDashboard() {
        sidebar.chooseDashboard();
    }
}
