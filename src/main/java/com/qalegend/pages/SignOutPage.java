package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage extends TestHelperUtility {
    WebDriver driver;
    public SignOutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    @FindBy(xpath = "//div[@class='pull-right']//a[text()='Sign Out']")
    WebElement signOutButton;
    public LoginPage ClickOnSignOutButton(){
        webElement.clickOnElement(signOutButton);
        return new LoginPage(driver);
    }
}
