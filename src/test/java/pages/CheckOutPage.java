package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public void setFirstName(String FirstName){
        driver.findElement(FirstNameInput).sendKeys(FirstName);
    }
    public void setLastName(String LastName){
        driver.findElement(LastNameInput).sendKeys(LastName);
    }
    public void setZipCode(String ZipCode){
        driver.findElement(ZipCodeInput).sendKeys(ZipCode);
    }

    public void clickContinueButton(){
        driver.findElement(ContinueButton).click();
    }

    public boolean isCheckoutErrorDisplayed(){
        return driver.findElement(ErrorMessage).isDisplayed();
    }
    public String getCheckoutErrorText(){
        return driver.findElement(ErrorMessage).getText();
    }
    public void OverviewCancelCheckout() {
        driver.findElement(OverviewCancelButton).click();
    }

    public void OverviewFinishCheckout() {
        driver.findElement(OverviewFinishButton).click();
    }
    public String getOrderCompletionText() {
        return driver.findElement(orderCompletionMessage).getText();
    }
}
