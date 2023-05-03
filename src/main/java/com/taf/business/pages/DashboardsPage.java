package com.taf.business.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardsPage {
    private static final String PAGE_HEADER = "//span[@title='All Dashboards']";
    private static final String DASHBOARD_COLUMNS_NAME = "//span[@class='headerCell__title-short--3_s1A']";
    private static final String DASHBOARD_ITEM_NAME = "//a[contains(@class, 'gridCell')]";
    private static final String DASHBOARD_ITEM_DESCRIPTION = "//div[@class='gridCell__grid-cell--3e2mS gridCell__align-left--2beIG dashboardTable__description--2TbtF']";
    private static final String DASHBOARD_ITEM_OWNER = "//div[@class='gridCell__grid-cell--3e2mS gridCell__align-left--2beIG dashboardTable__owner--cR_59']";


    public SelenideElement getPageHeader() {
        return $x(PAGE_HEADER);
    }

    public void dashboardListShouldHaveItems() {
        $$x(DASHBOARD_ITEM_NAME).shouldHave(sizeGreaterThan(0));
    }

    public void checkDashboardColumnsHeaders(final String columnHeaderName) {
        $$x(DASHBOARD_COLUMNS_NAME).shouldHave(itemWithText(columnHeaderName));
    }

    public void dashboardItemNameShouldHaveText(String dashboardName) {
        $$x(DASHBOARD_ITEM_NAME).shouldHave(itemWithText(dashboardName));
    }

    public void dashboardItemDescriptionShouldHaveText(String dashboardDescription) {
        $$x(DASHBOARD_ITEM_DESCRIPTION).shouldHave(itemWithText(dashboardDescription));
    }

    public void dashboardItemOwnerShouldHaveText(String dashboardOwner) {
        $$x(DASHBOARD_ITEM_OWNER).shouldHave(itemWithText(dashboardOwner));
    }
}
