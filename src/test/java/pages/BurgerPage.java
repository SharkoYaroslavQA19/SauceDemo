package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Screen;

public class BurgerPage extends HomePage {

    private final By allItemsButton = By.id("inventory_sidebar_link");
    private final By aboutButton = By.id("inventory_sidebar_link");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By resetAppStateButton = By.id("reset_sidebar_link");

    public BurgerPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllItemsButton() {
        driver.findElement(allItemsButton).click();
    }

    public void clickAboutButton() {
        driver.findElement(aboutButton).click();
    }
@Step("Logout by authorized user")
    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
        Screen.attachScreenshot(driver);
    }

    public void clickResetAppStateButton() {
        driver.findElement(resetAppStateButton).click();
    }
}
