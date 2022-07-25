package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {
    @Test(description = "checking information about the product in the basket",groups = {"regression"})
    public void itemShoppingCartTest() {
        LoginPageFactory.login(USERNAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(ShoppingCartPage.getProductShoppingCartPrice(PRODUCT_NAME), PRICE);
        Assert.assertEquals(ShoppingCartPage.getProductDescriptionShoppingCartText(PRODUCT_NAME), ITEM_DESCRIPTION);
    }

    @Test(description = "removing an item from the cart",groups = {"regression"})
    public void removeItemShoppingCartTest() {
        LoginPageFactory.login(USERNAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickRemoveButton(PRODUCT_NAME);
        Assert.assertFalse(ShoppingCartPage.productPresent(PRODUCT_NAME));
    }

@Test(description = "deleting an item from the shopping cart",groups = {"regression"})
    public void removeItemShoppingCartTestTwo() {
        LoginPageFactory.login(USERNAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(ShoppingCartPage.getProductShoppingCartPrice(PRODUCT_NAME), PRICE);
        Assert.assertEquals(ShoppingCartPage.getProductDescriptionShoppingCartText(PRODUCT_NAME), ITEM_DESCRIPTION);
        ShoppingCartPage.clickContinueShoppingButton();
        ProductsPage.clickRemoveButton();
        ProductsPage.clickShoppingCartButton();
        Assert.assertFalse(ShoppingCartPage.productPresent(PRODUCT_NAME));
    }
}
