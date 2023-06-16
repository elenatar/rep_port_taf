package com.taf.tests.steps.ui;

import com.taf.business.pages.Sidebar;
import io.cucumber.java.en.Then;

public class SidebarDefinitionSteps {

    private final Sidebar sidebar = new Sidebar();

    @Then("Choose dashboard")
    public void chooseDashboard() {
        sidebar.chooseDashboard();
    }
}
