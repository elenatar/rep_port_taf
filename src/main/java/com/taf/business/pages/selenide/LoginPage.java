package com.taf.business.pages.selenide;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static final String LOGIN_FIELD = "//input[@name='login']";
    private static final String PASSWORD_FIELD = "//input[@name='password']";
    private static final String SUBMIT_BUTTON = "//button[@type='submit']";

    public void fillLoginField(String userLogin) {
        $x(LOGIN_FIELD).shouldBe(visible, enabled).val(userLogin);
    }

    public void fillPasswordField(String userPassword) {
        $x(PASSWORD_FIELD).shouldBe(visible, enabled).val(userPassword);
    }

    public void clickSubmitButton() {
        $x(SUBMIT_BUTTON).shouldBe(visible, enabled).click();
    }
}
