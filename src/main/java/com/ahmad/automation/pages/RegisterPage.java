package com.ahmad.automation.pages;

import com.ahmad.automation.base.BasePage;
import com.ahmad.automation.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {


    private final String registerPageURL = "/register";
    private final By maleGenderRadioButton = By.id("gender-male");
    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By confirmPassword = By.id("ConfirmPassword");
    private final By registerBtn = By.cssSelector("button[type='submit'].register-next-step-button");
    private final By successMsg = By.className("result");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRegisterationPage() {
        NavigationUtil.navigateTo(registerPageURL);
    }

    public void selectMaleGender(){
        driver.findElement(maleGenderRadioButton).click();
    }

    public void enterFirstName(String fName) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fName);
    }

    public void enterLastName(String lName) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pword) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pword);
    }

    public void enterConfirmPassword(String cpword) {
        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword).sendKeys(cpword);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }

    public boolean isRegisterSuccessfull() {
        return driver.findElements(successMsg).size() > 0;
    }

}
