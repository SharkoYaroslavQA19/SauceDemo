package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class shoppingCartTest extends BaseTest {
    @Test
    public void itemShoppingCartTest() {
        LoginPage.login(USERNAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(ShoppingCartPage.getProductShoppingCartPrice(PRODUCT_NAME), PRICE);
        Assert.assertEquals(ShoppingCartPage.getProductDescriptionShoppingCartText(PRODUCT_NAME), ITEM_DESCRIPTION);
    }

    @Test
    public void removeItemShoppingCartTest() {
        LoginPage.login(USERNAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickRemoveButton(PRODUCT_NAME);
        Assert.assertFalse(ShoppingCartPage.productPresent(PRODUCT_NAME));
    }

@Test
    public void removeItemShoppingCartTestTwo() {
        LoginPage.login(USERNAME, PASSWORD);
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
