package com.taf.business.pages;

import com.taf.core.ConfigManager;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static final String LOGIN_FIELD = "//input[@name='login']";
    private static final String PASSWORD_FIELD = "//input[@name='password']";
    private static final String SUBMIT_BUTTON = "//button[@type='submit']";

    public void fillLoginForm() {
        $x(LOGIN_FIELD).shouldBe(visible, enabled).val(ConfigManager.getLogin());
        $x(PASSWORD_FIELD).shouldBe(visible, enabled).val(ConfigManager.getPassword());
        $x(SUBMIT_BUTTON).shouldBe(visible, enabled).click();
    }
}
