package com.taf.business.service;

import com.taf.business.pages.LoginPage;
import com.taf.core.dto.User;

import static com.codeborne.selenide.Selenide.page;

public class LoginService {

    private final LoginPage loginPage = page(LoginPage.class);

    public void loginWithUser(User user) {
        loginPage.fillLoginField(user.getLogin());
        loginPage.fillPasswordField(user.getPassword());
        loginPage.clickSubmitButton();
    }
}
