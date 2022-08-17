package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)
public  class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPageFactory LoginPageFactory;
    protected ProductsPage ProductsPage;
    protected ItemDetailsPage ItemDetailsPage;
    protected ShoppingCartPage ShoppingCartPage;
    protected CheckOutPage CheckOutPage;
    protected BurgerPage BurgerPage;
    protected final static String USERNAME = "standard_user";
    protected final static String PASSWORD = "secret_sauce";
    protected final static String PRICE = "$9.99";
    protected final static String PRODUCT_NAME = "Sauce Labs Bike Light";
    protected final static String ITEM_DESCRIPTION = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Undefined browser type");
        }
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LoginPageFactory = new LoginPageFactory(driver);
        ProductsPage = new ProductsPage(driver);
        ItemDetailsPage = new ItemDetailsPage(driver);
        CheckOutPage  = new CheckOutPage(driver);
        ShoppingCartPage = new ShoppingCartPage(driver);
        BurgerPage = new BurgerPage(driver);
        testContext.setAttribute("driver", driver);

    }


    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        this.driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }

    @AfterClass(alwaysRun = true)
    public void finish() {
        this.driver.quit();
    }
}