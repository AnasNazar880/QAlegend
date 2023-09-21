package com.qalegend.utilities;
import com.qalegend.constants.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtility {
    public void waitForVisibilityOfWebElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForVisibilityOfWebElementLocatedByXpath(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

    }
    public void waitForVisibilityOfWebElementLocatedByCssSelector(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }
    public void waitForVisibilityOfWebElementLocatedById(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }
    public void waitForAlertToBePresent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void fluentWaitForVisibilityOfElementByXpath(WebDriver driver, String locator) {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(Constants.FLUENT_WAIT_WITH_TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(Constants.FLUENT_WAIT_WITH_POLLING_EVERY));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void fluentWaitForVisibilityOfElementByCssSelector(WebDriver driver, String locator) {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(Constants.FLUENT_WAIT_WITH_TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(Constants.FLUENT_WAIT_WITH_POLLING_EVERY));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }
    public void fluentWaitForVisibilityOfElementById(WebDriver driver, String locator) {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(Constants.FLUENT_WAIT_WITH_TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(Constants.FLUENT_WAIT_WITH_POLLING_EVERY));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }
    public void fluentWaitForAlertToBePresent(WebDriver driver, String locator) {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(Constants.FLUENT_WAIT_WITH_TIMEOUT));
        wait.pollingEvery(Duration.ofSeconds(Constants.FLUENT_WAIT_WITH_POLLING_EVERY));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
