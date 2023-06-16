package com.taf.business.pages.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sidebar extends BasePage {

    @FindBy(xpath = "//div[@class = 'projectSelector__project-selector--FXbsR']")
    private WebElement projectSelector;

    @FindBy(xpath = "//div[contains(@class,'projectSelector__s')]//span[contains(@title,'rptestuser')]")
    private WebElement projectName;

    public Sidebar(WebDriver driver) {
        super(driver);
    }

    public void chooseProject() {
        clickProjectSelector();
        clickProjectName();
    }

    private void clickProjectName() {
        waitVisibilityOfElement(projectName);
        projectName.click();
    }

    private void clickProjectSelector() {
        waitVisibilityOfElement(projectSelector);
        projectSelector.click();
    }
}
