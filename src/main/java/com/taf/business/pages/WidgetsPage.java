package com.taf.business.pages;

import com.taf.core.ConfigManager;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class WidgetsPage {

    private static final String PROJECT_NAME = "//div[@class='projectSelector__project-selector--FXbsR projectSelector__shown--YcXp5']//span[contains(@title, '%s')]";
    private static final String DASHBOARD_WIDGET = "//div[@class = 'projectSelector__project-selector--FXbsR']";

    public void chooseProjectName() {
        String userLogin = ConfigManager.getLogin().toLowerCase();
        $x(PROJECT_NAME.formatted(userLogin)).shouldBe(visible).click();
    }

    public void clickProjectWidget() {
        $x(DASHBOARD_WIDGET).shouldBe(visible).click();
    }
}
