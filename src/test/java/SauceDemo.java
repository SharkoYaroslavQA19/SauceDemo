import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SauceDemo extends BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void sauceDemoTest() {
        WebElement userName =  driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();
        WebElement labs =driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        labs.click();
        WebElement shopping =driver.findElement(By.className("shopping_cart_link"));
        shopping.click();
        Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(), "$29.99");

    }
}
