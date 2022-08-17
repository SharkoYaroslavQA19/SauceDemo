package Test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {
    @Test(description = "checking information about the product in the basket", groups = {"regression"})
    @Description("Checking information about the item in the cart")
    public void itemShoppingCartTest() {
        LoginPageFactory.setUserName(USERNAME);
        LoginPageFactory.setPassword(PASSWORD);
        LoginPageFactory.clickLoginButton();
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(ShoppingCartPage.getProductShoppingCartPrice(PRODUCT_NAME), PRICE);
        Assert.assertEquals(ShoppingCartPage.getProductDescriptionShoppingCartText(PRODUCT_NAME), ITEM_DESCRIPTION);
    }

    @Test(description = "removing an item from the cart", groups = {"regression"})
    @Description("Adding goods from the catalog to the cart")
    public void removeItemShoppingCartTest() {
        LoginPageFactory.setUserName(USERNAME);
        LoginPageFactory.setPassword(PASSWORD);
        LoginPageFactory.clickLoginButton();
        ProductsPage.openItemByName(PRODUCT_NAME);
        ItemDetailsPage.clickAddToCartButton();
        ItemDetailsPage.clickShoppingCartButton();
        ShoppingCartPage.clickRemoveButton(PRODUCT_NAME);
        Assert.assertFalse(ShoppingCartPage.productPresent(PRODUCT_NAME));
    }

    @Test(description = "deleting an item from the shopping cart", groups = {"regression"})
    @Description("Removing an item from the cart with the button from the catalog")
    public void removeItemShoppingCartTestTwo() {
        LoginPageFactory.setUserName(USERNAME);
        LoginPageFactory.setPassword(PASSWORD);
        LoginPageFactory.clickLoginButton();
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
