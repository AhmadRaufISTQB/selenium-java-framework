package com.ahmad.automation.tests;

import com.ahmad.automation.base.BaseTest;
import com.ahmad.automation.pages.AutomationPracticePage;
import com.ahmad.automation.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Practice")
@Feature("URL")

public class AutomationPracticeTests extends BaseTest {

    @Test(description = "Automation Practice")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify Blinking URL is present")
    public void testValidLogin() {
        AutomationPracticePage page = new AutomationPracticePage(getDriver());
        Assert.assertTrue(page.isBlinkingURLDisplayed(), "Blinking URL is not displayed");
    }
}
