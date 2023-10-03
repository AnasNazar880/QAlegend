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

public class AddCategoryTest extends Base {

    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    LoginPage login;
    HomePage home;
    ProductsPage products;
    ManageCategoriesPage manageCategory;
    AddCategoryPage addCategory;
@Test(groups = {"sanity"})
    public void verifyCategoryCreation(){
    extentTest.get().assignCategory("Regression");
    List<List<String>> data= ExcelUtility.excelDataReader("LoginPage");
    String categoryName= RandomDataUtility.getRandomCategory();
    String categoryCode=RandomDataUtility.getRandomCategoryCode();
    String userName=data.get(1).get(1);
    String password=data.get(2).get(1);
    login=new LoginPage(driver);
    home=login.loginToApplication(userName,password);
    products=home.clickOnProductsPanel();
    manageCategory= products.clickOnCategories();
    addCategory= manageCategory.clickOnAddButton();
    manageCategory=addCategory.addCategoryDetails(categoryName,categoryCode);
    manageCategory.enterValueInSearchField(categoryName);
    List<List<String>> actualCategoryDetails= manageCategory.getCategoryDetails(categoryName);
    List<List<String>> expectedCategoryDetails=manageCategory.getCategoryDetails(categoryName,categoryCode);
    Assert.assertEquals(actualCategoryDetails,expectedCategoryDetails,"category creation failed");
    }
}

