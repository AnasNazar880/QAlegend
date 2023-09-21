package com.qalegend.utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class CommandUtility {
    public void dismissAlert(Alert alert){
        alert.dismiss();
    }
    public void acceptAlert(Alert alert){
        alert.accept();
    }
    public void sendKeysAlert(Alert alert,String text){
        alert.sendKeys(text);
    }
    public void getTextAlert(Alert alert){
        alert.getText();
    }
    public void selectFromDropDownUsingText(Select select,String dropDownValueToSelect){
        select.selectByVisibleText(dropDownValueToSelect);
    }
    public void selectFromDropDownUsingByValue(Select select,String dropDownValueToSelect){
        select.selectByValue(dropDownValueToSelect);
    }
    public void selectFromDropDownUsingByIndex(Select select,int dropDownValueToSelectIndex){
        select.selectByIndex(dropDownValueToSelectIndex);
    }

    public List<WebElement> getAllDropDownValues(Select select){
        return select.getOptions();
    }
    public List<WebElement> getAllSelectedDropDownValues(Select select){
        return select.getAllSelectedOptions();
    }
    public void getFirstDropDownValue(Select select){
        select.getFirstSelectedOption();
    }
    public void isDropDownMultiple(Select select){
        select.isMultiple();
    }
}
