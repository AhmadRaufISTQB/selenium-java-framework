package com.ahmad.automation.tests.product;

import com.ahmad.automation.base.BaseTest;
import com.ahmad.automation.pages.LoginPage;
import com.ahmad.automation.pages.ProductListPage;
import com.ahmad.automation.pages.RegisterPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("E-Commerce")
@Feature("Product Search")
public class SearchTests extends BaseTest {

    @Test(description = "Search for a specific product by full name")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search Product by full name")
    public void searchProductByFullName() throws InterruptedException {
        ProductListPage products = new ProductListPage(getDriver());
        products.navigateToProductsPage();
        String product = "Tomato";
        products.searchForProduct(product);
        Assert.assertTrue(products.isProductDisplayed(product));
    }

    @Test(description = "Search for a specific product by partial name")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search Product by partial name")
    public void searchProductByPartialName() throws InterruptedException {
        ProductListPage products = new ProductListPage(getDriver());
        products.navigateToProductsPage();
        String product = "Tom";
        products.searchForProduct(product);
        Assert.assertTrue(products.isProductDisplayed(product));
    }

    @Test(description = "Search for a invalid product by name")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search Product by invalid name")
    public void searchProductByInvalidName() throws InterruptedException {
        ProductListPage products = new ProductListPage(getDriver());
        products.navigateToProductsPage();
        String product = "XYZ";
        products.searchForProduct(product);
        Assert.assertTrue(products.isNoResultDisplayed());
    }
}
