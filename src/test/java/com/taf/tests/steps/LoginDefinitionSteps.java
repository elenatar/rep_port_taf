package com.taf.tests.steps;

import com.taf.business.service.LoginService;
import io.cucumber.java.en.Given;

import static com.taf.core.ConfigManager.getConfig;

public class LoginDefinitionSteps {
    private final LoginService loginService = new LoginService();

    @Given("User logins to Report Portal")
    public void userLoginsToReportPortal() {
        loginService.loginWithUser(getConfig().getUser());
    }
}
