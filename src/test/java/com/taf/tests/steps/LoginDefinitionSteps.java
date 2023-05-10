package com.taf.tests.steps;

import com.taf.business.service.LoginService;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.page;

public class LoginDefinitionSteps {
   private LoginService loginPage = page(LoginService.class);

    @Given("User logins to Report Portal")
    public void userLoginsToReportPortal() {
        loginPage.loginWithUser();
    }
}
