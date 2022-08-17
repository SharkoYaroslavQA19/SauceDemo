package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Screen;

public abstract class HomePage extends BasePage {
    private By menuButton = By.id("react-burger-menu-btn");
    private By shoppingCartButton = By.id("shopping_cart_container");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Step("Click menu button")
    public void clickMenuButton(){
        driver.findElement(menuButton).click();
    }
    @Step("Click cart button")
    public void clickShoppingCartButton(){
        driver.findElement(shoppingCartButton).click();
        Screen.attachScreenshot(driver);
    }
}