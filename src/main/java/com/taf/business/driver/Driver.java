package com.taf.business.driver;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver webDriver;
    public static WebDriver getWebDriver(){
        if(webDriver == null){
            loadDriver();
        }
        return webDriver;
    }
    private static void setWebDriver(WebDriver driver){

        webDriver = driver;
    }
    private static void loadDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        setWebDriver(driver);
        WebDriverRunner.setWebDriver(driver);
    }
    public static void closeDriver(){
        if(webDriver != null){
            getWebDriver().quit();
            setWebDriver(null);
            WebDriverRunner.setWebDriver(null);
        }
    }
}
