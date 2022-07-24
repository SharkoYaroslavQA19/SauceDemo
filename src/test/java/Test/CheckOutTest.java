package Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    final static String FIRST_NAME = "Jim";
    final static String LAST_NAME = "Jim";
    final static String ZIP_CODE = "123456";
    String CompletionText = "THANK YOU FOR YOUR ORDER";

    @Test(description = "data entry check when ordering",groups = {"smoke"})
    public void  positiveTest(){
        LoginPageFactory.login(USERNAME,PASSWORD);
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


   @Test(description = "checking the correct data when buying",dataProvider = "negativeTestData", groups = {"negative"})
    public void  negativeTest(String firstName, String lastName, String zip, String errorMessage){
       LoginPageFactory.login(USERNAME,PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckOutPage.setFirstName(firstName);
        CheckOutPage.setLastName(lastName);
        CheckOutPage.setZipCode(zip);
        CheckOutPage.clickContinueButton();
        Assert.assertTrue(CheckOutPage.isCheckoutErrorDisplayed());
        Assert.assertEquals(CheckOutPage.getCheckoutErrorText(),errorMessage);
    }

    @DataProvider
    public Object[][] negativeTestData() {
        return new Object[][]{
                {"Jim", "", "", "Error: Last Name is required"},
                {"", "jim", "", "Error: First Name is required"},
                {"", "", "123456", "Error: First Name is required"},
                {"Jim", "jim", "", "Error: Postal Code is required"},
                {"Jim", "", "123456", "Error: Last Name is required"},
                {"", "jim", "123456", "Error: First Name is required"}
        };
    }
    @Test(description = "verification of the final completed purchase", groups = {"smoke"})
    public void  checkOutFinishTest(){
        LoginPageFactory.login(USERNAME,PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickCheckoutButton();
        CheckOutPage.setFirstName(FIRST_NAME);
        CheckOutPage.setLastName(LAST_NAME);
        CheckOutPage.setZipCode(ZIP_CODE);
        CheckOutPage.clickContinueButton();
        Assert.assertFalse(CheckOutPage.checkoutFormPresent());
        CheckOutPage.OverviewFinishCheckout();
        Assert.assertEquals(CheckOutPage.getOrderCompletionText(),CompletionText );
    }
}
