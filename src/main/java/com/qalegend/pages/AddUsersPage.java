package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUsersPage extends TestHelperUtility {
    WebDriver driver;
    public AddUsersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Mr / Mrs / Miss']")
    WebElement prefix;
    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "username")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(name = "confirm_password")
    WebElement confirmPassword;
    @FindBy(id = "cmmsn_percent")
    WebElement salesCommissionPercentage;
    @FindBy(id = "submit_user_button")
    WebElement saveButton;
    public void enterPrefix(String pfix){
        webElement.enterText(prefix,pfix);
    }
    public void enterFirstName(String fName){
        webElement.enterText(firstName,fName);
    }
    public void enterLastName(String lName){
        webElement.enterText(lastName,lName);
    }
    public void enterEmail(String emailId){
        webElement.enterText(email,emailId);
    }
    public void enterUserName(String uName){
        webElement.enterText(userName,uName);
    }
    public void enterPassword(String pWord){
        webElement.enterText(password,pWord);
    }
    public void enterConfirmPassword(String cPassword){
        webElement.enterText(confirmPassword,cPassword);
    }
    public void enterSalesCommissionPercentage(String salesPercentage){
        webElement.enterText(salesCommissionPercentage,salesPercentage);
    }
    public void clickOnSaveButton(){
        webElement.clickOnElement(saveButton);
    }
    public ManageUsersPage addUserDetails(String pFix,String fName,String lName,String emailId,String uName,String pWord,String confirmPWord,String salesPercentage){
        enterPrefix(pFix);
        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(emailId);
        enterUserName(uName);
        enterPassword(pWord);
        enterConfirmPassword(confirmPWord);
        enterSalesCommissionPercentage(salesPercentage);
        clickOnSaveButton();
        wait.hardWait();
        return new ManageUsersPage(driver);
    }

}
