package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void clickContinueShoppingButton(){
        driver.findElement(continueShoppingButton).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
    private WebElement getProductShoppingCartByName(String productName){
        return driver.findElement(By.xpath(String.format(productShoppingCartLocator, productName)));
    }

    public String getProductShoppingCartPrice(String productName){
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(productShoppingCartPrice).getText();
    }
    public String getProductDescriptionShoppingCartText(String productName){
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        return productShoppingCartContainer.findElement(descriptionShoppingCartText).getText();
    }

    public void clickRemoveButton(String productName){
        WebElement productShoppingCartContainer = getProductShoppingCartByName(productName);
        productShoppingCartContainer.findElement(removeButton).click();
    }
    public boolean productPresent(String productName){
        return !driver.findElements(By.xpath(String.format(productShoppingCartLocator, productName))).isEmpty();
    }
}
