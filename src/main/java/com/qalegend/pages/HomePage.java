package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestHelperUtility {
    WebDriver driver;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    @FindBy(xpath = "//li[@class='dropdown user user-menu']//a[@class='dropdown-toggle']/span")
    WebElement userAccountName;
    @FindBy(xpath = "//span[text()='User Management']")
    WebElement userManagement;
    @FindBy(xpath = "//i[@class='fa fa-cubes'] / following-sibling::span")
    WebElement products;

    public String getUserAccountName(){
        return webElement.getElementText(userAccountName);
    }
    public UserManagementPage clickOnUserManagementPanel(){
        webElement.clickOnElement(userManagement);
        return new UserManagementPage(driver);
    }
    public String getHomePageTitle(){
        return webDriver.getTitleOfPage(driver);
    }
    public ProductsPage clickOnProductsPanel() {
        webElement.clickOnElement(products);
        return new ProductsPage(driver);
    }


}
