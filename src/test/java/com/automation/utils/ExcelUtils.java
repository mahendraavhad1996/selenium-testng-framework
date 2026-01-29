package com.automation.utils;

import java.io.InputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {

    public static Object[][] getTestData(String sheetName) {

        try {
            InputStream is = ExcelUtils.class
                    .getClassLoader()
                    .getResourceAsStream("TestData.xlsx");

            if (is == null) {
                throw new RuntimeException("Excel file not found in resources");
            }

            Workbook wb = WorkbookFactory.create(is);
            Sheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }

            return data;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel data");
        }
    }
}