package com.taf.tests.steps.ui.selenium;

import com.taf.business.pages.selenium.Sidebar;
import io.cucumber.java.en.When;

public class SidebarDefinitionSteps extends BaseDefinitionSteps {

    public Sidebar getSidebar() {
        return new Sidebar();
    }

    @When("Choose project name")
    public void chooseProjectName() {
        getSidebar().chooseProject();
    }
}
