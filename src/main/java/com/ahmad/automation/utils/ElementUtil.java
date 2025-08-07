package com.ahmad.automation.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ElementUtil {

    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Highlight an element in the browser for visibility
     */
    private void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    /**
     * Capture screenshot and attach to Allure report
     */
    private void attachScreenshot(String name) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
    }

    /**
     * Finds the first visible element using one or more locators.
     */
    private WebElement findElement(List<By> locators) {
        for (By locator : locators) {
            List<WebElement> elements = driver.findElements(locator);
            if (!elements.isEmpty()) {
                WebElement element = elements.get(0);
                highlightElement(element);
                System.out.println("[INFO] Found element using locator: " + locator);
                return element;
            }
        }
        System.out.println("[ERROR] Element not found with provided locators.");
        attachScreenshot("Element Not Found");
        return null;
    }

    /**
     * Check if element is displayed
     */

    public boolean isElementDisplayed(Map<String, By> locatorsInfo) {
        List<By> locators = new ArrayList<>(locatorsInfo.values());
        try {
            WebElement element = findElement(locators);
            if (element != null && element.isDisplayed()) {
                attachScreenshot("Element Displayed");
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("[WARN] Element not found: " + e.getMessage());
        }
        return false;
    }

    /**
     * Click element
     */
    public void clickElement(Map<String, By> locatorsInfo) {
        List<By> locators = new ArrayList<>(locatorsInfo.values());
        WebElement element = findElement(locators);
        if (element != null) {
            element.click();
            attachScreenshot("Element Clicked");
        } else {
            throw new RuntimeException("Unable to click element. Not found.");
        }
    }

    /**
     * Get text from element
     */
    public String getElementText(Map<String, By> locatorsInfo) {
        List<By> locators = new ArrayList<>(locatorsInfo.values());
        WebElement element = findElement(locators);
        if (element != null) {
            String text = element.getText();
            attachScreenshot("Element Text Retrieved");
            return text;
        }
        return "";
    }

    /**
     * Enter text into element
     */
    public void enterText(String text, Map<String, By> locatorsInfo) {
        List<By> locators = new ArrayList<>(locatorsInfo.values());
        WebElement element = findElement(locators);
        if (element != null) {
            element.clear();
            element.sendKeys(text);
            attachScreenshot("Text Entered");
        } else {
            throw new RuntimeException("Unable to enter text. Element not found.");
        }
    }
}
