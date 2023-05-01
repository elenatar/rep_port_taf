package com.taf.business.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardsPage {

    private static final String PAGE_HEADER = "//span[@title='All Dashboards']";

    public SelenideElement getPageHeader() {
        return $x(PAGE_HEADER);
    }

}
