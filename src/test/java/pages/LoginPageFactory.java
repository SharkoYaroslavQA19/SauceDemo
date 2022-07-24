package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static void setUserName(String userName) {
        usernameInput.sendKeys(userName);
    }

    public static void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public static void clickLoginButton() {
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMassage.isDisplayed();
    }

    public String getErrorMessageTest() {
        return errorMassage.getText();
    }

    public static void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }

    public boolean isLoginFormPresent() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginForm));
        LoginPageFactory.loginForm.isDisplayed();
        return true;
    }
}