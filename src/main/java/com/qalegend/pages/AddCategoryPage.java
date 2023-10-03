package com.qalegend.pages;

import com.qalegend.utilities.PageUtility;
import com.qalegend.utilities.TestHelperUtility;
import com.qalegend.utilities.WaitUtility;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPage extends TestHelperUtility {
    WebDriver driver;
    public AddCategoryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='name']")
    WebElement categoryNameInputField;
    @FindBy(xpath = "//input[@id='short_code']")
    WebElement categoryCode;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveButton;
    public void enterCategoryName(String valueToEnter){
        wait.hardWait();
        webElement.enterText(categoryNameInputField,valueToEnter);
    }
    public void enterCategoryCode(String enterCode ){
        webElement.enterText(categoryCode,enterCode);
    }
    public void clickOnSaveButton(){
        webElement.clickOnElement(saveButton);
    }
    public ManageCategoriesPage addCategoryDetails(String categoryName,String categoryCode){
        enterCategoryName(categoryName);
        enterCategoryCode(categoryCode);
        clickOnSaveButton();
        return new ManageCategoriesPage(driver);
    }
}
