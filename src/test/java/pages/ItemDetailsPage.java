package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Screen;

public class ItemDetailsPage extends HomePage {
    private final By addToCartButton = By.cssSelector("button[id^=add-to-cart]");
    private final By backToProductsButton = By.id("back-to-products");

    private final By itemName = By.cssSelector(".inventory_details_name");
    private final By itemPrice = By.cssSelector(".inventory_details_price");
    private final By itemDescription = By.cssSelector(".inventory_details_desc");

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }
@Step("add product to cart")
    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        Screen.attachScreenshot(driver);
    }

    public void clickBackToProductsButton() {
        driver.findElement(backToProductsButton).click();
    }
    @Step("get item name")
    public String getItemName() {
        return driver.findElement(itemName).getText();
    }
    @Step("get item description")
    public String getItemDescription() {
        return driver.findElement(itemDescription).getText();
    }
    @Step("get item price")
    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

}