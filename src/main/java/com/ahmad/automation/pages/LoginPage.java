package com.ahmad.automation.pages;

import com.ahmad.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ahmad.automation.utils.NavigationUtil;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By successMessage = By.cssSelector("div#flash.flash.success");
    private final By errorMessage = By.cssSelector("div#flash.flash.error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        String loginPageURL = "/login";
        NavigationUtil.navigateTo(loginPageURL);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return waitForElementVisible(successMessage).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return waitForElementVisible(errorMessage).isDisplayed();
    }
}
