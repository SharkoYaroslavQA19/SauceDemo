package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public  class BaseTest {
    protected WebDriver driver;
    public BaseTest() {
    }
    pages.LoginPage LoginPage;
    pages.ProductsPage ProductsPage;
    pages.ItemDetailsPage ItemDetailsPage;
    pages.CheckOutPage CheckOutPage;
    pages.ShoppingCartPage ShoppingCartPage;
    protected final static String USERNAME = "standard_user";
    protected final static String PASSWORD = "secret_sauce";
    protected final static String PRICE = "$9.99";
    protected final static String PRODUCT_NAME = "Sauce Labs Bike Light";
    protected final static String ITEM_DESCRIPTION = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";


    @BeforeClass
    public void initialise() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        LoginPage = new LoginPage(driver);
        ProductsPage = new ProductsPage(driver);
        ItemDetailsPage = new ItemDetailsPage(driver);
        CheckOutPage =new CheckOutPage(driver);
        ShoppingCartPage = new ShoppingCartPage(driver);

    }



    @BeforeMethod
    public void navigate() {
        this.driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void finish() {
        this.driver.quit();
    }
}