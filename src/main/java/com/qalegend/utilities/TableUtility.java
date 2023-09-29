package com.qalegend.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableUtility {
    public static List<List<String>> get_Dynamic_TwoDimension_TablElemnts(List<WebElement> rowItems, List<WebElement> columnItems) {
        int rSize = rowItems.size() ;
        int colnmSize = columnItems.size()-1;
        String[] columnList = new String[colnmSize / rSize];

        List<List<String>> gridData = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < columnList.length; j++) {
                columnList[j] = columnItems.get(x).getText();
                x++;
            }
            gridData.add(new ArrayList<String>(Arrays.asList(columnList)));
        }
        return gridData;
    }
}
