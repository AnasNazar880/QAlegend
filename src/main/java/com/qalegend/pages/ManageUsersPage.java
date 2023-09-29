package com.qalegend.pages;

import com.qalegend.utilities.TableUtility;
import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ManageUsersPage extends TestHelperUtility {
    WebDriver driver;

    public ManageUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButton;
    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement searchField;
    @FindBy(xpath = "//tbody//tr[@role='row']")
    List<WebElement> rowElements;
    @FindBy(xpath = "//tbody//tr[@role='row']//td")
    List<WebElement> columnElements;
    @FindBy(xpath = "//tbody//tr[@class='odd']//td[text()='No matching records found']")
    WebElement errorMessage;
    @FindBy(xpath = "//li[@class='dropdown user user-menu']//a//span")
    WebElement userAccountName;
   @FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_user_button']")
   WebElement deleteButton;
   @FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
   WebElement deletePopUpButton;
    public AddUsersPage clickOnAddButton() {
        webElement.clickOnElement(addButton);
        return new AddUsersPage(driver);
    }

    public void enterValueInSearchField(String value) {
        webElement.enterText(searchField, value);
        wait.hardWait();
    }

    public List<List<String>> getUserDetails(String emailId) {
        wait.fluentWaitForVisibilityOfElementByXpath(driver, "//tbody//tr[@role='row']");
        List<List<String>> userDetails = TableUtility.get_Dynamic_TwoDimension_TablElemnts(rowElements, columnElements);
        return userDetails;
    }
    public List<List<String>> getUserDetails(String prefix,String firstName,String lastName,String userName,String email,String role){
        return page.getUserDataIntoList(prefix,firstName,lastName,userName,email,role);
    }
    public String getInvalidUserErrorMessage(){
        return webElement.getElementText(errorMessage);
    }
    public SignOutPage clickOnUserAccountName(){
    webElement.clickOnElement(userAccountName);
    return new SignOutPage(driver);
    }
    public void clickOnRandomUserDeleteButton(){
        webElement.clickOnElement(deleteButton);
    }
    public void acceptUserDeletionPopUp(){
        webElement.clickOnElement(deletePopUpButton);
    }
    }




