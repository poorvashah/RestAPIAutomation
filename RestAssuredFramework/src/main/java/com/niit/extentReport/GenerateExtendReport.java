package com.niit.extentReport;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class GenerateExtendReport {
    ExtentHtmlReporter reporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @BeforeClass
    public void loginTest() throws IOException {
        reporter = new ExtentHtmlReporter("./reports/APIReport.html");
        extent = new ExtentReports();
        // attach the reporter which we created in Step 1
        extent.attachReporter(reporter);
    }
    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, "getAPI failed");
            logger.fail(MarkupHelper.createLabel(result.getName() + "Test case failed", ExtentColor.RED));
            logger.fail(result.getThrowable());
            //.createLabel(result.getName()), "Test Case Failed", ExtendColour.RED)
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, "get API Passed");
            logger.pass(MarkupHelper.createLabel(result.getName() + "Test case failed", ExtentColor.GREEN));
        }
    }

    @AfterClass
    public void teardown() {
        extent.flush();
    }


}
