package com.qalegend.utilities;
import org.openqa.selenium.WebElement;
import java.util.List;
public class PageUtility {
    public void selectValue(List<WebElement> dropDownValues,String valueToSelect){
        for(int i=0;i<dropDownValues.size();i++){
            String value=dropDownValues.get(i).getText();
            if(value.equals(valueToSelect)){
                dropDownValues.get(i).click();
                break;
            }
        }
    }
}
