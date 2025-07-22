package com.ahmad.automation.drivers;

import com.ahmad.automation.config.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    private static WebDriver driver;
    private static boolean reuseDriver = ConfigManager.getBoolean("reuseDriver");

    // Initialize only if not already active
    public static void initDriver() {
        if (driver == null || !reuseDriver) {
            String browser = ConfigManager.get("browser");
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default: // Chrome is default
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    driver = new ChromeDriver(options);
                    break;
            }
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    // Close only if reuseDriver=false
    public static void quitDriver() {
        if (driver != null && !reuseDriver) {
            driver.quit();
            driver = null;
        }
    }

    // Force cleanup (at end of suite)
    public static void forceQuitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
