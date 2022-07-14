package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends HomePage {
    private  By FirstNameInput = By.id("first-name");
    private  By LastNameInput = By.id("last-name");
    private  By ZipCodeInput = By.id("postal-code");
    private  By CancelButton = By.id("cancel");
    private  By ContinueButton = By.id("continue");

    private  By ErrorMessage = By.cssSelector(".error-message-container.error");

    private By checkoutForm = By.xpath("//form/div[@class='checkout_info']");

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

}
