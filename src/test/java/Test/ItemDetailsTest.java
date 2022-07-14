package Test;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemDetailsTest extends BaseTest {

  @Test
   public void verifyItemNameAndPriceOnDetailsPage() {
        LoginPage.login(USERNAME, PASSWORD);
        ProductsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(ItemDetailsPage.getItemName(), PRODUCT_NAME, "Checking product name");
        Assert.assertEquals(ItemDetailsPage.getItemPrice(), PRICE, "Checking price");
        Assert.assertEquals(ItemDetailsPage.getItemDescription(), ITEM_DESCRIPTION);
    }
}