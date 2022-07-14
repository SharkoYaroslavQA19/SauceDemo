package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {


    @Test
    public void positiveLoginTest() {
        LoginPage.setUserName(USERNAME);
        LoginPage.setPassword(PASSWORD);
        LoginPage.clickLoginButton();
        Assert.assertTrue(ProductsPage.isProductsPageHeaderDisplayed(), "ProductsPageHeader should be on display");
    }

    @Test
    public void negativeLoginTest() {
        LoginPage.setUserName("");
        LoginPage.setPassword(PASSWORD);
        LoginPage.clickLoginButton();
        Assert.assertTrue(LoginPage.isErrorMessageDisplayed(), "Error message should be on display");
        Assert.assertEquals(LoginPage.getErrorMessageTest(), "Epic sadface: Username is required", "Error message should be 'Epic sadface: Username is required'");
    }

}