package com.srm.hackathon.adminpanel.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static Object[][] getTestData(String sheetName) {

        String path = System.getProperty("user.dir") + "/src/main/resources/FormData.xlsx";

        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);

                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}