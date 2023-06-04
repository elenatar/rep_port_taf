package com.taf.business.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.taf.core.UserConfigManager.getUserConfig;

public class Sidebar {

    private static final String PROJECT_NAME = "//div[contains(@class,'projectSelector__s')]//span[contains(@title,'%s')]";
    private static final String PROJECT_SELECTOR = "//div[@class = 'projectSelector__project-selector--FXbsR']";

    public void chooseDashboard() {
        $x(PROJECT_SELECTOR).shouldBe(visible).click();
        String userLogin = getUserConfig().getUser().getLogin().toLowerCase();
        $x(PROJECT_NAME.formatted(userLogin)).shouldBe(visible).click();
    }
}
