package com.ahmad.automation.pages;

import com.ahmad.automation.base.BasePage;
import com.ahmad.automation.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListPage extends BasePage {

    int RETRIES = 5;

    private final String productsListPageURL = "https://rahulshettyacademy.com/seleniumPractise";
    private final By searchBar = By.cssSelector("input[type='search'].search-keyword");
    private final By productName = By.className("product-name");
    private final By emptyResult = By.className("no-results");

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProductsPage() {
        NavigationUtil.navigateTo(productsListPageURL);
    }

    public void searchForProduct(String product) {
        waitForElementVisible(searchBar).sendKeys(product);
    }

    public boolean isProductDisplayed(String product) throws InterruptedException {
        while (RETRIES > 0) {
            String pName = waitForElementVisible(productName).getText();
            if (pName.contains(product)){
                RETRIES = 0;
                return true;
            } else {
                RETRIES--;
                Thread.sleep(1500);
            }
        }
        return false;
    }

    public boolean isNoResultDisplayed() throws InterruptedException {
        while (RETRIES > 0) {
            WebElement noResult = waitForElementVisible(emptyResult);
            if (noResult.isDisplayed()){
                RETRIES = 0;
                return true;
            } else {
                RETRIES--;
                Thread.sleep(1500);
            }
        }
        return false;
    }
}
