package com.qalegend.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WebDriverUtility {
    public String getWindowHandleId(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandlesId(WebDriver driver) {
        return driver.getWindowHandles();
    }

    public void switchToWindow(WebDriver driver, String handleId) {
        driver.switchTo().window(handleId);
    }

    public void maximizingTheWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public void closeTheWindow(WebDriver driver) {
        driver.close();
    }

    public void closeAllBrowserWindows(WebDriver driver) {
        driver.quit();
    }

    public void switchToFrameByName(WebDriver driver, String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrameById(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    public void pageNavigationForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public void pageNavigationBackWord(WebDriver driver) {
        driver.navigate().back();
    }

    public void pageNavigationRefresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void getUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getTitleOfPage(WebDriver driver) {
        return driver.getTitle();
    }
}
