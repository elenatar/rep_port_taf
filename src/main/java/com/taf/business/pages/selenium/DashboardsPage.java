package com.taf.business.pages.selenium;

import com.taf.core.utils.JsExecutorUtil;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardsPage extends BasePage {

    @FindBy(xpath = "//span[@title='All Dashboards']")
    private WebElement pageHeader;

    @FindBy(xpath = "//a[contains(@class, 'gridCell')]")
    private List<WebElement> dashboardNamesList;

    @FindBy(xpath = "//div[contains(@class, 'gridRow')]//a[text() = 'DEMO DASHBOARD']")
    private WebElement demoDashboard;

    @FindBy(xpath = "//div[@class='widget__widget-container--3ZTIX']")
    private List<WebElement> widgetsList;

    @FindBy(xpath = "//span[contains(@class, 'react-resizable')]")
    private List<WebElement> resizeButtonsList;

    public List<WebElement> getDashboardNamesList() {
        return dashboardNamesList;
    }

    public List<WebElement> getWidgetsList() {
        return widgetsList;
    }

    public boolean dashboardPageIsDisplayed() {
        waitVisibilityOfElement(pageHeader);
        return pageHeader.isDisplayed();
    }

    public void clickDashboardName() {
        JsExecutorUtil.clickOnElementUsingJs(demoDashboard);
    }

    public Dimension getWidgetSize(int widgetIndex) {
        return getWidgetsList().get(widgetIndex).getSize();
    }

    public void resizeWidget(int widgetIndex, int xOffset, int yOffset) {
        WebElement resizeButton = resizeButtonsList.get(widgetIndex);
        JsExecutorUtil.scrollIntoView(resizeButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(resizeButton).perform();
        waitVisibilityOfElement(resizeButton);
        actions.clickAndHold(resizeButton)
                .moveByOffset(xOffset, yOffset)
                .perform();
        actions.release(resizeButton).perform();
    }
}
