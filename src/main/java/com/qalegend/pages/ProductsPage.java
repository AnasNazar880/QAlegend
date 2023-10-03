package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends TestHelperUtility {
    WebDriver driver;
    public ProductsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//li[@class='treeview active active-sub']//ul[@class='treeview-menu']//li//i/following-sibling::span")
    List<WebElement> panelValues;
    @FindBy(xpath = "//i[@class='fa fa-tags']/following-sibling::span")
    WebElement categories;
    public List<String> getProductsPanelValuesAsText(){
        wait.hardWait();
       return page.getValuesAsText(panelValues);
    }
    public List<String> getSplitedPanelValues(String panelValue) {
        return page.splitString(panelValue, ";");
    }
    public ManageCategoriesPage clickOnCategories(){
        wait.hardWait();
        webElement.clickOnElement(categories);
        return new ManageCategoriesPage(driver);
    }
}
