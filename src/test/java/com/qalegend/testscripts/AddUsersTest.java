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

public class AddUsersTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    ManageUsersPage manageUser;
    AddUsersPage addUsers;
    SignOutPage signOut;
    @Test(groups = "Regression")
    public void verifyUserCreation(){
        extentTest.get().assignCategory("Regression");
        String prefix=RandomDataUtility.getPrefix();
        String firstName=RandomDataUtility.getFirstName();
        String lastName=RandomDataUtility.getLastName();
        String email=RandomDataUtility.getEmail();
        String uName=firstName.toLowerCase()+lastName.toLowerCase();
        String passWord=RandomDataUtility.getPassword();
        String salesCommissionPercentage=RandomDataUtility.getRandomNumber();
        List<List<String>> data= ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        login=new LoginPage(driver);
        home=login.loginToApplication(userName,password);
        userManagement=home.clickOnUserManagementPanel();
        manageUser=userManagement.clickOnUsers();
        addUsers=manageUser.clickOnAddButton();
        manageUser=addUsers.addUserDetails(prefix,firstName,lastName,email,uName,passWord,passWord,salesCommissionPercentage);
        manageUser.enterValueInSearchField(email);
        List<List<String>> actualUserDetails= manageUser.getUserDetails(email);
        List<List<String>> expectedUserData=manageUser.getUserDetails(prefix,firstName,lastName,uName,email,"Admin");
        Assert.assertEquals(actualUserDetails,expectedUserData,"User creation failed");
    }
    @Test(groups = "smoke")
    public void verifyUserLoginForNewlyCreatedUser(){
        extentTest.get().assignCategory("smoke");
        String prefix=RandomDataUtility.getPrefix();
        String firstName=RandomDataUtility.getFirstName();
        String lastName=RandomDataUtility.getLastName();
        String email=RandomDataUtility.getEmail();
        String uName=firstName.toLowerCase()+lastName.toLowerCase();
        String passWord=RandomDataUtility.getPassword();
        String salesCommissionPercentage=RandomDataUtility.getRandomNumber();
        List<List<String>> data= ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expectedUserAccountName = firstName+" "+lastName;
        login=new LoginPage(driver);
        home=login.loginToApplication(userName,password);
        userManagement=home.clickOnUserManagementPanel();
        manageUser=userManagement.clickOnUsers();
        addUsers=manageUser.clickOnAddButton();
        manageUser=addUsers.addUserDetails(prefix,firstName,lastName,email,uName,passWord,passWord,salesCommissionPercentage);
        manageUser.enterValueInSearchField(email);
        signOut= manageUser.clickOnUserAccountName();
        login= signOut.ClickOnSignOutButton();
        login.RetryLoginUsingNewlyCreatedCredentials(uName,passWord);
        String actualUserAccountName = home.getUserAccountName();
        Assert.assertEquals(actualUserAccountName, expectedUserAccountName, "user login failed");
    }
}
