package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;

public class LoginPage extends TestHelperUtility {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPageTitle() {
        return webDriver.getTitleOfPage(driver);
    }
}
