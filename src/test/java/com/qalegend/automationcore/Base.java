package com.qalegend.automationcore;

import com.qalegend.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public Properties prop;
    public FileInputStream fs;

    public Base() {
        try {
            prop = new Properties();
            fs = new FileInputStream(System.getProperty("user.dir") + Constants.PROPERTY_FILE);
            prop.load(fs);
        } catch (IOException e) {
            throw new IllegalArgumentException("GIVEN property file is not found" + e.getMessage());
        }
    }

    public void initialiseTest(String browser) {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("fox")) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("invalid browser name received");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browserName) {
        String baseUrl = prop.getProperty("url");
        initialiseTest(browserName);
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenShot(result);
        }
        driver.close();
    }

    public void takeScreenShot(ITestResult result) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
    }
}
