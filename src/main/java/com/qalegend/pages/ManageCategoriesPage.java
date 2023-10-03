package com.qalegend.pages;

import com.qalegend.utilities.PageUtility;
import com.qalegend.utilities.TableUtility;
import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManageCategoriesPage extends TestHelperUtility {
    WebDriver driver;
    public ManageCategoriesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']//i")
    WebElement AddCategoryButton;
    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement searchField;
    @FindBy(xpath = "//tbody//tr[@role='row']")
    List<WebElement> rowElements;
    @FindBy(xpath = "//tbody//tr[@role='row']//td")
    List<WebElement> columnElements;

    public AddCategoryPage clickOnAddButton(){
        wait.hardWait();
        webElement.clickOnElement(AddCategoryButton);
        return new AddCategoryPage(driver);
    }
    public void enterValueInSearchField(String value) {
        wait.hardWait();
        webElement.enterText(searchField, value);

    }
    public List<List<String>> getCategoryDetails(String categoryName) {
       wait.hardWait();
        List<List<String>> categoryDetails = TableUtility.get_Dynamic_TwoDimension_TablElemnts(rowElements, columnElements);
        return categoryDetails;
}
    public List<List<String>> getCategoryDetails(String categoryName,String categoryCode){
        wait.hardWait();
        return page.getCategoryDataIntoList(categoryName,categoryCode);
    }
}
