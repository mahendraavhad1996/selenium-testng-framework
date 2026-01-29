package com.automation.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReportUtil {

    private static Workbook workbook;
    private static Sheet sheet;
    private static AtomicInteger rowNum = new AtomicInteger(1);

    private static final String DIR_PATH =
            System.getProperty("user.dir") + "/test-output/automation-log";

    private static final String FILE_PATH =
            DIR_PATH + "/ExecutionReport.xlsx";

    static {
        try {
            // Create directory if not exists
            File dir = new File(DIR_PATH);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Test Execution Report");

            // Header row
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("S.No");
            header.createCell(1).setCellValue("Test No");
            header.createCell(2).setCellValue("Expected Result");
            header.createCell(3).setCellValue("Actual Result");
            header.createCell(4).setCellValue("Status");

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Excel report", e);
        }
    }

    public static synchronized void writeResult(
            String testNo,
            String expected,
            String actual,
            String status) {

        Row row = sheet.createRow(rowNum.getAndIncrement());

        row.createCell(0).setCellValue(rowNum.get() - 1);
        row.createCell(1).setCellValue(testNo);
        row.createCell(2).setCellValue(expected);
        row.createCell(3).setCellValue(actual);
        row.createCell(4).setCellValue(status);

        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}