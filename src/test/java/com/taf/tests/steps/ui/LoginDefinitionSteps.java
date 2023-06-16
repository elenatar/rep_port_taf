package com.taf.tests.steps.ui;

import com.taf.business.services.LoginService;
import io.cucumber.java.en.Given;

import static com.taf.core.UserConfigManager.getUserConfig;

public class LoginDefinitionSteps {
    private final LoginService loginService = new LoginService();

    @Given("User logins to Report Portal")
    public void userLoginsToReportPortal() {
        loginService.loginWithUser(getUserConfig().getUser());
    }
}
