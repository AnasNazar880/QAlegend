package com.qalegend.pages;

import com.qalegend.utilities.PageUtility;
import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage extends TestHelperUtility {
    WebDriver driver;
    public ResetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(id = "email")
    WebElement resetEmail;
    @FindBy(xpath = "//div[@class='col-md-6']//span//strong")
    WebElement resetErrorMessage;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement passWordResetLink;
    public void enterResetEmail(String invalidUserName) {
        webElement.enterText(resetEmail, invalidUserName);
    }
    public String getInvalidErrorMessage() {
        return webElement.getElementText(resetErrorMessage);
    }
    public void clickOnResetPassWordLink() {
        webElement.clickOnElement(passWordResetLink);
    }
}



