package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagementPage extends TestHelperUtility {
    WebDriver driver;

    public UserManagementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@class='treeview  active']//li//span[@class='title']")
    List<WebElement> panelValues;

    @FindBy(xpath = "//i[@class='fa fa-user'] /following-sibling::span")
    WebElement users;


    public List<String> getUserManagementPanelValues() {
        return page.getValuesAsText(panelValues);
    }

    public List<String> getSplitedPanelValues(String panelValue) {
        return page.splitString(panelValue, ";");
    }

   public ManageUsersPage clickOnUsers(){
        wait.waitForVisibilityOfWebElementLocatedByXpath(driver,"//i[@class='fa fa-user'] /following-sibling::span");
        webElement.clickOnElement(users);
        return new ManageUsersPage(driver);
   }
}
