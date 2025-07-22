package com.ahmad.automation.base;

import com.ahmad.automation.config.ConfigManager;
import com.ahmad.automation.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class BaseTest implements WebDriverProvider {

    private static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException {
        deleteOldVideos(); // Clean old recordings
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(ConfigManager.get("baseUrl"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        System.out.println("Closing browser...");
        if (driver != null) {
            try {
                driver.close();
            } catch (Exception ignored) {}
            driver.quit();
        }
    }

    @Override
    public org.openqa.selenium.WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    private void deleteOldVideos() {
        File videosDir = new File("videos");
        if (videosDir.exists() && videosDir.isDirectory()) {
            File[] files = videosDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
    }
}
