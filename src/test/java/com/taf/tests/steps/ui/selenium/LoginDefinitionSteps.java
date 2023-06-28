package com.taf.tests.steps.ui.selenium;

import com.taf.business.pages.selenium.LoginPage;
import io.cucumber.java.en.Given;

import static com.taf.core.UserConfigManager.getUserConfig;

public class LoginDefinitionSteps extends BaseDefinitionSteps {

    public LoginPage getLoginPage() {
        return new LoginPage();
    }

    @Given("User logins to Report Portal with a member user")
    public void userLoginsToReportPortal() {
        getLoginPage().fillLoginField(getUserConfig().getUser().getLogin());
        getLoginPage().fillPasswordField(getUserConfig().getUser().getPassword());
        getLoginPage().clickSubmitButton();
    }
}
