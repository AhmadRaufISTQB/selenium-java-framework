package com.ahmad.automation.tests;

import com.ahmad.automation.base.BaseTest;
import com.ahmad.automation.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ahmad.automation.drivers.DriverManager.getDriver;

@Epic("E-Commerce")
@Feature("Login")
public class LoginTests extends BaseTest {

    @Test(description = "Verify login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid User Login")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.navigateToLoginPage();
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
    }

    @Test(description = "Verify login with invalid password")
    @Severity(SeverityLevel.NORMAL)
    @Story("Invalid User Login")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.navigateToLoginPage();
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not displayed!");
    }
}
