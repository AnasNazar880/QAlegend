package com.qalegend.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.ResetPage;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ResetPageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(groups = {"smoke"})
    public void verifyPassWordErrorMessage() {
        extentTest.get().assignCategory("smoke");
        List<List<String>> data = ExcelUtility.excelDataReader("ResetPage");
        String expectedErrorMessage = data.get(0).get(1);
        String invalidUserName = RandomDataUtility.firstName() + RandomDataUtility.LastName() + "@test.com";
        //ResetPage resetPage=new ResetPage(driver);
        LoginPage login = new LoginPage(driver);
        ResetPage reset = login.loginToResetPage(invalidUserName);
        String actualErrorMessage = reset.getInvalidUserNameText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "error message not similar");
    }
}
