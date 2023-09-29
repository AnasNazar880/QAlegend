package com.qalegend.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test
    public void verifyHomePageTitle(){
        extentTest.get().assignCategory("Regression");
        List<List<String>> data= ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String userAccountName=data.get(3).get(1);
        LoginPage login=new LoginPage(driver);
        HomePage home=login.loginToApplication(userName,password);
        String expectedTitle="Home - ABC";
        String actualTitle=home.getHomePageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Invalid homepage title found");
    }
}
