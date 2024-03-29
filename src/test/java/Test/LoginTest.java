package Test;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(description = "website authorization check",groups = {"smoke"})
    @Description("authorization on the site with input parameters USERNAME=standard_user, PASSWORD=secret_sauce")
    public void positiveLoginTest() {
        LoginPageFactory.setUserName(USERNAME);
        LoginPageFactory.setPassword(PASSWORD);
        LoginPageFactory.clickLoginButton();
        Assert.assertTrue(ProductsPage.isProductsPageHeaderDisplayed(), "ProductsPageHeader should be on display");
    }

    @Test(description = "checking the logout of an authorized user", groups = {"regression"})
    @Description("logout authorized user")
    public void logOutTest() {
        LoginPageFactory.setUserName(USERNAME);
        LoginPageFactory.setPassword(PASSWORD);
        LoginPageFactory.clickLoginButton();
        BurgerPage.clickMenuButton();
        BurgerPage.clickLogoutButton();
        Assert.assertTrue(LoginPageFactory.isLoginFormPresent());
    }

    @Test(description = "verification of data input during authorization",groups = {"negative"},dataProvider = "negativeLoginData")
    @Description("authorization on the site with incorrect data")
    public void negativeLoginTest(String userName, String password, String expectedErrorMessage) {
        LoginPageFactory.setUserName(userName);
        LoginPageFactory.setPassword(password);
        LoginPageFactory.clickLoginButton();
        Assert.assertTrue(LoginPageFactory.isErrorMessageDisplayed(), "Error message should be on display");
        Assert.assertEquals(LoginPageFactory.getErrorMessageTest(), expectedErrorMessage);
    }
    @DataProvider(name = "negativeLoginData")
    public Object [][] negativeLoginTestData(){
        return new Object[][]{
                {"",PASSWORD,"Epic sadface: Username is required"},
                {USERNAME,"","Epic sadface: Password is required"},
                {"","","Epic sadface: Username is required"},
        };
    }

}