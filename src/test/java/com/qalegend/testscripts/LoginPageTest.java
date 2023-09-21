package com.qalegend.testscripts;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.LoginPage;
import com.qalegend.reports.TestListener;
import com.qalegend.retryanalyzer.RetryAnalyzer;
import com.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class LoginPageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(groups = {"smoke"})
    public void verifyLoginPageTitle() {
        extentTest.get().assignCategory("smoke");
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        LoginPage login = new LoginPage(driver);
        String actualTitle = login.getLoginPageTitle();
        extentTest.get().log(Status.PASS,"login page title received as"+actualTitle);
        String expectedTitle = data.get(0).get(1);
        Assert.assertEquals(actualTitle, expectedTitle, "login page Title mismatch  found");
        extentTest.get().log(Status.PASS,"expected login page title "+expectedTitle+" matched with actual title "+actualTitle);
    }
}
