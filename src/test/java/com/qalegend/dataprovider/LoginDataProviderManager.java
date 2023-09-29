package com.qalegend.dataprovider;

import com.qalegend.utilities.ExcelUtility;
import org.testng.annotations.DataProvider;

public class LoginDataProviderManager {
    @DataProvider(name = "userCredentialsFormExcel")
    public Object[][] userCredentialsFormExcel() {
        ExcelUtility excel = new ExcelUtility();
        Object[][] data = excel.dataProviderRead("InvalidLoginCredentials");
        return data;
    }
}