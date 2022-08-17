package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Screen;

public class ShoppingCartPage extends HomePage{
    String productShoppingCartLocator ="//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='cart_item']";
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By productShoppingCartPrice = By.className("inventory_item_price");
    private By descriptionShoppingCartText = By.className("inventory_item_desc");
    private By removeButton = By.cssSelector("button[id^='remove-']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @Step("click on the button to return to the catalog from the basket")
    public void clickContinueShoppingButton(){
        driver.findElement(continueShoppingButton).click();
    }
    @Step("click on the button to make a purchase")
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
        Screen.attachScreenshot(driver);
    }
    @Step("get product name")
    private WebElement getProductShoppingCartByName(String productName){
        return driver.findElement(By.xpath(String.format(productShoppingCartLocator, productName)));
    }
    @Step("get product price")
    public String getProductShoppingCartPrice(String productName){
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(productShoppingCartPrice).getText();
    }
    @Step("get product description")
    public String getProductDescriptionShoppingCartText(String productName){
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(descriptionShoppingCartText).getText();
    }
    @Step("remove item from cart")
    public void clickRemoveButton(String productName){
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        productShoppingCartContainer.findElement(removeButton).click();
    }
    public boolean productPresent(String productName){
        return !driver.findElements(By.xpath(String.format(productShoppingCartLocator, productName))).isEmpty();
    }
}
