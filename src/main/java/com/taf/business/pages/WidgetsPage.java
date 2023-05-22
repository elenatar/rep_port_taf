package com.taf.business.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.taf.core.ConfigManager.getConfig;

public class WidgetsPage {

    private static final String PROJECT_NAME = "//div[contains(@class,'projectSelector__s')]//span[contains(@title,'%s')]";
    private static final String DASHBOARD_WIDGET = "//div[@class = 'projectSelector__project-selector--FXbsR']";

    public void chooseDashboard() {
        $x(DASHBOARD_WIDGET).shouldBe(visible).click();
        String userLogin = getConfig().getUser().getLogin().toLowerCase();
        $x(PROJECT_NAME.formatted(userLogin)).shouldBe(visible).click();
    }
}
