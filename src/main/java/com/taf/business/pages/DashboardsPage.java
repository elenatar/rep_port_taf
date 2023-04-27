package com.taf.business.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardsPage {
    public SelenideElement pageHeader = $(By.xpath("//span[@title='All Dashboards']"));
}
