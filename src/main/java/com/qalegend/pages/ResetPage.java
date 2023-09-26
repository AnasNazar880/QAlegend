package com.qalegend.pages;

import com.qalegend.utilities.PageUtility;
import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage extends TestHelperUtility {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='col-md-6']//span//strong")
    WebElement resetEmail;

    public ResetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getInvalidUserNameText() {
        return webElement.getElementText(resetEmail);
    }
}



