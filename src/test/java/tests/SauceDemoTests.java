package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoTests extends BaseTest {
        
    @Test
    public void successfulLogin() {
        logger.info("Entering valid credentials");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        logger.info("Verifying inventory page");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void addItemToCart() {
        logger.info("Logging in");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        logger.info("Adding item to cart");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        Assert.assertTrue(
                driver.findElement(By.className("inventory_item_name")).isDisplayed()
        );
    }

    @Test
    public void productSortingByPrice() {
        logger.info("Logging in");
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        logger.info("Sorting products by price (low to high)");
        driver.findElement(By.className("product_sort_container")).click();
        driver.findElement(By.cssSelector("option[value='lohi']")).click();

        logger.info("Verifying first product is the cheapest");
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        String firstPrice = prices.get(0).getText().replace("$", "");
        
        logger.info("First product price: $" + firstPrice);
        Assert.assertEquals(firstPrice, "7.99", "First product should be $7.99");
    }

    @Test
    public void verifyCartBadgeCount() {
        logger.info("Logging in");
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        logger.info("Adding two items to cart");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        logger.info("Verifying cart badge shows correct count");
        String badgeCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        
        // THIS TEST WILL FAIL - expected 2, but we're checking for 5
        logger.error("Intentional failure: expected 5, actual " + badgeCount);
        Assert.assertEquals(badgeCount, "5", "Cart badge should show 5 items");
    }
}