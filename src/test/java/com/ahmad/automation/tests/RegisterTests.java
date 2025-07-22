package com.ahmad.automation.tests;

import com.ahmad.automation.base.BaseTest;
import com.ahmad.automation.pages.LoginPage;
import com.ahmad.automation.pages.RegisterPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("E-Commerce")
@Feature("Login")
public class RegisterTests extends BaseTest {

    @Test(description = "Verify registeration with valid details")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid User Login")
    public void testValidLogin() {
        RegisterPage registerPage = new RegisterPage(getDriver());

        registerPage.navigateToRegisterationPage();
        registerPage.selectMaleGender();
        registerPage.enterFirstName("Ahmad");
        registerPage.enterLastName("Rauf");
        registerPage.enterEmail("arauf@gmail.com");
        registerPage.enterPassword("Ahmad0");
        registerPage.enterConfirmPassword("Ahmad0");
        registerPage.clickRegister();

        Assert.assertTrue(registerPage.isRegisterSuccessfull(), "Register failed!");
    }

}
