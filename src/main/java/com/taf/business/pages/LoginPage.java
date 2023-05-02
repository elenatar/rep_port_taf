package com.taf.business.pages;

import com.taf.core.ConfigManager;
import com.taf.core.dto.ConfigDTO;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static final String LOGIN_FIELD = "//input[@name='login']";
    private static final String PASSWORD_FIELD = "//input[@name='password']";
    private static final String SUBMIT_BUTTON = "//button[@type='submit']";

    public void fillLoginForm() {
        ConfigDTO config = ConfigManager.getInstance().getConfigDTO();
        $x(LOGIN_FIELD).shouldBe(visible, enabled).val(config.getLogin());
        $x(PASSWORD_FIELD).shouldBe(visible, enabled).val(config.getPassword());
        $x(SUBMIT_BUTTON).shouldBe(visible, enabled).click();
    }

}
