package com.qalegend.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class WebElementUtility {
    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String valueToEnter) {
        element.sendKeys(valueToEnter);
    }

    public void userid(WebElement element, String userId) {
        element.sendKeys(userId);
    }

    public void passWord(WebElement element, String passWrd) {
        element.sendKeys(passWrd);
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public String getTagName(WebElement element) {
        return element.getTagName();
    }

    public String getCssValue(WebElement element, String value) {
        return element.getCssValue(value);
    }

    public String getHTMLTag(WebElement element) {
        return element.getTagName();
    }

    public void FindElementByXpath(WebElement element, String locator) {
        element.findElement(By.xpath(locator));
    }

    public void FindElementById(WebElement element, String locator) {
        element.findElement(By.id(locator));
    }

    public void FindElementByCssSelector(WebElement element, String locator) {
        element.findElement(By.cssSelector(locator));
    }

    public void FindElementByClassName(WebElement element, String locator) {
        element.findElement(By.className(locator));
    }

    public void FindElementByName(WebElement element, String locator) {
        element.findElement(By.name(locator));
    }

    public void FindElementByLinkText(WebElement element, String locator) {
        element.findElement(By.linkText(locator));
    }

    public boolean buttonEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean buttonSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean buttonDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public Point getLocationOfElement(WebElement element) {
        return element.getLocation();
    }

    public void elementClick(WebElement element) {
        element.click();
    }

    public Dimension getSizeOfElement(WebElement element) {
        return element.getSize();
    }

    public void getRightClick(WebElement rightClick, WebDriver driver) {
        Actions action = new Actions(driver);
        action.contextClick(rightClick).build().perform();
    }

    public void getDoubleClick(WebElement element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.doubleClick(element).build().perform();
    }

    public void getDragAndDrop(WebElement drag, WebElement drop, WebDriver driver) {
        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop).build().perform();
    }

    public void getDragAndDropByOffSet(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(element, 150, 100).build().perform();
    }

    public void getMoveToElement(WebDriver driver, WebElement targetElement) {
        Actions action = new Actions(driver);
        action.moveToElement(targetElement);
    }

    public void getProgressBar(WebDriver driver, WebElement targetElement) {
        Actions action = new Actions(driver);
        action.moveToElement(targetElement).clickAndHold().moveToElement(targetElement, 150, 0).release().build().perform();
    }

}
