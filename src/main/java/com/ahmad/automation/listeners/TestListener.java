package com.ahmad.automation.listeners;

import com.ahmad.automation.base.WebDriverProvider;
import com.ahmad.automation.utils.ScreenshotUtil;
import com.ahmad.automation.utils.VideoRecorderUtil;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Object currentClass = result.getInstance();
            WebDriver driver = ((WebDriverProvider) currentClass).getDriver();

            WebElement failedElement = (WebElement) result.getAttribute("failedElement");

            if (failedElement != null) {
                ScreenshotUtil.captureElementHighlight(driver, failedElement, result.getName() + "_FAIL");
            } else {
                ScreenshotUtil.captureFullPageScreenshot(driver, result.getName() + "_FAIL");
            }

            VideoRecorderUtil.stopRecording(result.getTestName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshotToAllure(byte[] screenshot) {
        return screenshot;
    }
}
