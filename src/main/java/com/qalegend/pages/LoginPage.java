package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestHelperUtility {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement passWord;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement loginButton;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    WebElement endTour;

    @FindBy(xpath = "//a[@class='btn btn-link']")
    WebElement forgetPassWord;

    @FindBy(xpath = "//span[@class='help-block']//strong[text()='These credentials do not match our records.']")
    WebElement userNameErrorMessage;





    public String getLoginPageTitle() {
        return webDriver.getTitleOfPage(driver);
    }

    public void enterUserName(String uName) {
        webElement.enterText(userName, uName);
    }

    public void enterPassWord(String pWord) {
        webElement.enterText(passWord, pWord);
    }

    public void clickOnLoginButton() {
        webElement.clickOnElement(loginButton);

    }
    public void clickOnEndTour() {
        webElement.clickOnElement(endTour);
    }

    public ResetPage clickOnForgetPassword() {
        webElement.clickOnElement(forgetPassWord);
        return new ResetPage(driver);
    }
    public String getInvalidUserNameErrorMessage(){
       return webElement.getElementText(userNameErrorMessage);
    }

    public HomePage loginToApplication(String uName, String pWord) {
        enterUserName(uName);
        enterPassWord(pWord);
        clickOnLoginButton();
        clickOnEndTour();
        return new HomePage(driver);

    }

}
