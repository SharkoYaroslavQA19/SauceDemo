package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Screen;

public class LoginPageFactory extends BasePage {
    static @FindBy(id = "login_button_container")
    WebElement loginForm;
    @FindBy(id = "user-name")
    static
    WebElement usernameInput;
    @FindBy(id = "password")
    static
    WebElement passwordInput;
    @FindBy(id = "login-button")
    static
    WebElement loginButton;
    @FindBy(css = ".error-message-container")
    WebElement errorMassage;


    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    @Step("Login to SauceDemo.com with username")
    public  void setUserName(String userName) {
        usernameInput.sendKeys(userName);
        Screen.attachScreenshot(driver);
    }
    @Step("Login to SauceDemo.com with password")
    public  void setPassword(String password) {
        passwordInput.sendKeys(password);
        Screen.attachScreenshot(driver);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginButton.click();
        Screen.attachScreenshot(driver);
    }

    public boolean isErrorMessageDisplayed() {
        return errorMassage.isDisplayed();
    }

    public String getErrorMessageTest() {
        return errorMassage.getText();
    }


    public boolean isLoginFormPresent() {
        return  LoginPageFactory.loginForm.isDisplayed();
    }
}