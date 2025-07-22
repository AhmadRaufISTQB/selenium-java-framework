package com.ahmad.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = "reports/screenshots/";

    // Capture full-page screenshot
    public static void captureFullPageScreenshot(WebDriver driver, String fileName) {
        try {
            File dir = new File(SCREENSHOT_DIR);
            if (!dir.exists()) dir.mkdirs();

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(SCREENSHOT_DIR + fileName + ".png");
            org.apache.commons.io.FileUtils.copyFile(screenshot, destination);

            System.out.println("Full-page screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Highlight and capture element screenshot
    public static void captureElementHighlight(WebDriver driver, WebElement element, String fileName) {
        try {
            File dir = new File(SCREENSHOT_DIR);
            if (!dir.exists()) dir.mkdirs();

            Screenshot screenshot = new AShot()
                    .coordsProvider(new WebDriverCoordsProvider())
                    .takeScreenshot(driver, element);

            BufferedImage image = screenshot.getImage();
            File output = new File(SCREENSHOT_DIR + fileName + ".png");
            ImageIO.write(image, "PNG", output);

            System.out.println("Element screenshot saved: " + output.getAbsolutePath());
        } catch (Exception e) {
            // Fallback if element is null or any error occurs
            captureFullPageScreenshot(driver, fileName);
        }
    }
}
