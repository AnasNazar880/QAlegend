package com.qalegend.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.*;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ManageUserTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    ManageUsersPage manageUser;
    AddUsersPage addUsers;
    @Test(groups = {"smoke"})
    public void verifyInvalidUserSearch(){
        extentTest.get().assignCategory("smoke");
        String email=RandomDataUtility.getEmail();
        List<List<String>> data= ExcelUtility.excelDataReader("LoginPage");
        List<List<String>> manageData= ExcelUtility.excelDataReader("ManageUsers");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expectedMessage=manageData.get(0).get(1);
        login=new LoginPage(driver);
        home=login.loginToApplication(userName,password);
        userManagement=home.clickOnUserManagementPanel();
        manageUser=userManagement.clickOnUsers();
        manageUser.enterValueInSearchField(email);
        String actualErrorMessage= manageUser.getInvalidUserErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedMessage,"The error message does not match the expected message.");
    }
    @Test(groups = {"Regression"})
    public void verifyNewlyCreatedUserDelete(){
        extentTest.get().assignCategory("Regression");
        String prefix=RandomDataUtility.getPrefix();
        String firstName=RandomDataUtility.getFirstName();
        String lastName=RandomDataUtility.getLastName();
        String email=RandomDataUtility.getEmail();
        String uName=firstName.toLowerCase()+lastName.toLowerCase();
        String passWord=RandomDataUtility.getPassword();
        String salesCommissionPercentage=RandomDataUtility.getRandomNumber();
        List<List<String>> data= ExcelUtility.excelDataReader("LoginPage");
        List<List<String>> manageData= ExcelUtility.excelDataReader("ManageUsers");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expectedMessage=manageData.get(0).get(1);
        login=new LoginPage(driver);
        home=login.loginToApplication(userName,password);
        userManagement=home.clickOnUserManagementPanel();
        manageUser=userManagement.clickOnUsers();
        addUsers=manageUser.clickOnAddButton();
        manageUser=addUsers.addUserDetails(prefix,firstName,lastName,email,uName,passWord,passWord,salesCommissionPercentage);
        manageUser.enterValueInSearchField(email);
        manageUser.clickOnRandomUserDeleteButton();
        manageUser.acceptUserDeletionPopUp();
        manageUser.enterValueInSearchField(email);
        String actualErrorMessage= manageUser.getInvalidUserErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedMessage,"unable to delete the button");
    }
}
