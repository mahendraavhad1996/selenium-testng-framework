package com.automation.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.utils.ExcelReportUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {

        ExcelReportUtil.writeResult(
                result.getMethod().getMethodName(),
                "Expected behaviour achieved",
                "Actual behaviour matched",
                "PASS"
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExcelReportUtil.writeResult(
                result.getMethod().getMethodName(),
                "Expected behaviour achieved",
                "Actual behaviour mismatch",
                "FAIL"
        );
    }
}