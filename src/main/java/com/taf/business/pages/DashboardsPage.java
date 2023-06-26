package com.taf.business.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardsPage {
    private static final String PAGE_HEADER = "//span[@title='All Dashboards']";
    private static final String DASHBOARD_COLUMNS_NAME = "//span[@class='headerCell__title-short--3_s1A']";
    private static final String DASHBOARD_ITEM_NAME = "//a[contains(@class, 'gridCell')]";
    private static final String DASHBOARD_ITEM_DESCRIPTION = "//div[contains(@class, 'description')]";
    private static final String DASHBOARD_ITEM_OWNER = "//div[contains(@class, 'owner')]";

    public void dashboardPageShouldBeVisible() {
        $x(PAGE_HEADER).shouldBe(Condition.visible);
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
