package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Screen;

public class CheckOutPage extends HomePage {
    private final  By FirstNameInput = By.id("first-name");
    private final  By LastNameInput = By.id("last-name");
    private final  By ZipCodeInput = By.id("postal-code");
    private final  By CancelButton = By.id("cancel");
    private final  By ContinueButton = By.id("continue");

    private final  By ErrorMessage = By.cssSelector(".error-message-container.error");

    private final By checkoutForm = By.xpath("//form/div[@class='checkout_info']");
    private final By OverviewCancelButton = By.id("cancel");
    private final By OverviewFinishButton = By.id("finish");
    private final By orderCompletionMessage = By.className("complete-header");

    public CheckOutPage (WebDriver driver) {
        super(driver);
    }

    public boolean checkoutFormPresent(){
        return !driver.findElements(checkoutForm).isEmpty();
    }
    @Step("enter firstname for product clearance")
    public void setFirstName(String FirstName){
        driver.findElement(FirstNameInput).sendKeys(FirstName);
    }
    @Step("enter lastname for product clearance")
    public void setLastName(String LastName){
        driver.findElement(LastNameInput).sendKeys(LastName);
    }
    @Step("enter zipcode for product clearance")
    public void setZipCode(String ZipCode){
        driver.findElement(ZipCodeInput).sendKeys(ZipCode);
    }
    @Step("click button continue")
    public void clickContinueButton(){
        Screen.attachScreenshot(driver);
        driver.findElement(ContinueButton).click();
    }

    public boolean isCheckoutErrorDisplayed(){
        return driver.findElement(ErrorMessage).isDisplayed();
    }
    public String getCheckoutErrorText(){
        return driver.findElement(ErrorMessage).getText();
    }
    @Step("click button Cancel")
    public void OverviewCancelCheckout() {
        driver.findElement(OverviewCancelButton).click();
    }
    @Step("click on the button to finish the purchase")
    public void OverviewFinishCheckout() {
        driver.findElement(OverviewFinishButton).click();
    }
    public String getOrderCompletionText() {
        return driver.findElement(orderCompletionMessage).getText();
    }
}
