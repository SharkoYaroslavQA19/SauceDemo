package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends HomePage {
    String productContainerLocator = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private final By addToCartButton = By.cssSelector("button[id^='add-']");
    private final By productLink = By.cssSelector("a[id$='_link']");
    private final By productsPageHeader = By.id("header_container");
    private final By productsRemove = By.cssSelector("button[id^='remove-']");
    private final By productPrice = By.className("inventory_item_price");
    private final By descriptionText = By.className("inventory_item_desc");
    private final By sortingButton = By.className("product_sort_container");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }


    public void clickRemoveButton(){
        driver.findElement(productsRemove).click();
    }
    public void openItemByName(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(productLink).click();
    }

    public void clickAddToCartButton(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(addToCartButton).click();
    }

    public WebElement getProductContainerByName(String productName) {
        return driver.findElement(By.xpath(String.format(productContainerLocator, productName)));
    }

    public String getProductPrice(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(productPrice).getText();
    }

    public String getProductDescription(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(descriptionText).getText();
    }
    public void clickSorting(String visibleText) {
        Select select = new Select(driver.findElement(sortingButton));
        select.selectByVisibleText(visibleText);
    }
    public List<String> getSortingProduct() {
        List<WebElement> productsName = driver.findElements(By.className("inventory_item_name"));
        List<String> name = productsName.stream().map(option -> option.getText()).toList();
        return name;
    }

}