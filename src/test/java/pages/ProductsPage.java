package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Screen;

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
@Step("checking the display of goods in the catalog")
    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    @Step("Remove item from cart")
    public void clickRemoveButton(){
        driver.findElement(productsRemove).click();
    }
    @Step("Open product by name")
    public void openItemByName(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(productLink).click();
        Screen.attachScreenshot(driver);
    }

    @Step("click on the add to cart button")
    public void clickAddToCartButton(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(addToCartButton).click();
    }

    @Step("Open product by name")
    public WebElement getProductContainerByName(String productName) {
        return driver.findElement(By.xpath(String.format(productContainerLocator, productName)));
    }

    @Step("Get item price")
    public String getProductPrice(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(productPrice).getText();
    }

    @Step("Get item description")
    public String getProductDescription(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(descriptionText).getText();
    }
    @Step("click on the sort button")
    public void clickSorting(String visibleText) {
        Select select = new Select(driver.findElement(sortingButton));
        select.selectByVisibleText(visibleText);
        Screen.attachScreenshot(driver);
    }
    @Step("select sorting")
    public List<String> getSortingProduct() {
        List<WebElement> productsName = driver.findElements(By.className("inventory_item_name"));
        List<String> name = productsName.stream().map(option -> option.getText()).toList();
        return name;

    }

}