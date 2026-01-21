package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void invalidLogin() {
        logger.info("Entering invalid credentials");

        driver.findElement(By.id("user-name"))
                .sendKeys("wrong_user");
        driver.findElement(By.id("password"))
                .sendKeys("wrong_pass");
        driver.findElement(By.id("login-button")).click();

        String error =
                driver.findElement(By.cssSelector("[data-test='error']")).getText();

        logger.info("Checking error message");
        Assert.assertTrue(error.contains("Epic sadface"));
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
}
