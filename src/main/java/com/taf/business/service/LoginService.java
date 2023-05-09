package com.taf.business.service;

import com.taf.business.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginService {

    private final LoginPage loginPage = page(LoginPage.class);

    private void openLoginPage() {
        open("/");
    }

    public void loginWithUser() {
        openLoginPage();
        loginPage.fillLoginField();
        loginPage.fillPasswordField();
        loginPage.clickSubmitButton();
    }
}
