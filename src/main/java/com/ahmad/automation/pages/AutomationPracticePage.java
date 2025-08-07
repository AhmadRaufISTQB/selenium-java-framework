package com.ahmad.automation.pages;

import com.ahmad.automation.base.BasePage;
import com.ahmad.automation.utils.ElementUtil;
import com.ahmad.automation.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutomationPracticePage extends BasePage {
    WebDriver driver;
    private final ElementUtil elementUtil;

    // Writing all possible locators so that minor UI changes shouldn't affect our test
    public final Map<String, By> blinkingTextLink = Map.of(
            "anchorByClassName", By.className("blinkingText"),
            "anchorByLinkText", By.linkText("Free Access to InterviewQues/ResumeAssistance/Material"),
            "anchorByPartialLinkText", By.partialLinkText("Free Access to"),
            "anchorByXpathFullText", By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']"),
            "anchorByXpathPartialText", By.xpath("//a[contains(text(),'InterviewQues')]"),
            "anchorByXpathNormalizedSpaces", By.xpath("//a[normalize-space()='Free Access to InterviewQues/ResumeAssistance/Material']"),
            "anchorCssSelectorClass", By.cssSelector("a.blinkingText"),
            "anchorCssSelectorHref", By.cssSelector("a[href='https://rahulshettyacademy.com/documents-request']")
    );

    public final Map<String, By> blinkingTextLink = Map.of(
            "anchorByClassName", By.className("blinkingText"),
            "anchorByLinkText", By.linkText("Free Access to InterviewQues/ResumeAssistance/Material"),
            "anchorByPartialLinkText", By.partialLinkText("Free Access to"),
            "anchorByXpathFullText", By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']"),
            "anchorByXpathPartialText", By.xpath("//a[contains(text(),'InterviewQues')]"),
            "anchorByXpathNormalizedSpaces", By.xpath("//a[normalize-space()='Free Access to InterviewQues/ResumeAssistance/Material']"),
            "anchorCssSelectorClass", By.cssSelector("a.blinkingText"),
            "anchorCssSelectorHref", By.cssSelector("a[href='https://rahulshettyacademy.com/documents-request']")
    );

    // ===== Constructor =====
    public AutomationPracticePage(WebDriver driver) {
        super(driver);
        this.elementUtil = new ElementUtil(driver);
    }

    // ===== Page Actions =====

    public boolean isBlinkingURLDisplayed() {
        NavigationUtil.navigateTo("https://rahulshettyacademy.com/AutomationPractice/");
        return elementUtil.isElementDisplayed(blinkingTextLink);
    }


}
