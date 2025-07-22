package com.ahmad.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    public static void initReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static void createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        testThread.set(test);
    }

    public static ExtentTest getTest() {
        return testThread.get();
    }

    public static void log(String message) {
        getTest().info(message);
    }

    public static void attachScreenshot(String screenshotPath) {
        getTest().addScreenCaptureFromPath(screenshotPath);
    }

    public static void attachVideo(String videoPath) {
        getTest().info("Video Recording: " + videoPath);
    }
}
