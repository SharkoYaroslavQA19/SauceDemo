package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class checkOutTest extends BaseTest {
    final static String FIRST_NAME = "Jim";
    final static String LAST_NAME = "Jim";
    final static String ZIP_CODE = "123456";
    String FirstNameError = "Error: First Name is required";
    String LastNameError = "Error: Last Name is required";

    @Test
    public void  positiveTest(){
        LoginPage.login(USERNAME,PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckOutPage.setFirstName(FIRST_NAME);
        CheckOutPage.setLastName(LAST_NAME);
        CheckOutPage.setZipCode(ZIP_CODE);
        CheckOutPage.clickContinueButton();
        Assert.assertFalse(CheckOutPage.checkoutFormPresent());
    }


   @Test
    public void  negativeTest(){
        LoginPage.login(USERNAME,PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckOutPage.setFirstName("");
        CheckOutPage.setLastName(LAST_NAME);
        CheckOutPage.setZipCode(ZIP_CODE);
        CheckOutPage.clickContinueButton();
        Assert.assertTrue(CheckOutPage.isCheckoutErrorDisplayed());
        Assert.assertEquals(CheckOutPage.getCheckoutErrorText(),FirstNameError);
    }
    @Test
    public void negativeTestLastName(){
        LoginPage.login(USERNAME,PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckOutPage.setFirstName(FIRST_NAME);
        CheckOutPage.setLastName("");
        CheckOutPage.setZipCode(ZIP_CODE);
        CheckOutPage.clickContinueButton();
        Assert.assertTrue(CheckOutPage.isCheckoutErrorDisplayed());
        Assert.assertEquals(CheckOutPage.getCheckoutErrorText(),LastNameError);
    }
}
