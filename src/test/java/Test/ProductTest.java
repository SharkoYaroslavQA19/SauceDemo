package Test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductTest extends BaseTest {

    protected final static String SORT_Z_TO_A = "Name (Z to A)";
    protected final static String SORT_A_TO_Z = "Name (A to Z)";

    @Test(description = "Checking the availability of products in the catalog by name, price and description", groups = {"regression"}, dataProvider = "isProductInCatalogPresentTestData")
    @Description("Checking the ratio of the name, price and description of the product in the catalog")
    public void isProductInCatalogPresentTest(String productName, String priceProduct, String description) {
        LoginPageFactory.setUserName(USERNAME);
        LoginPageFactory.setPassword(PASSWORD);
        LoginPageFactory.clickLoginButton();
        ProductsPage.isProductsPageHeaderDisplayed();
        Assert.assertEquals(ProductsPage.getProductDescription(productName), description);
        Assert.assertEquals(ProductsPage.getProductPrice(productName), priceProduct);
    }

    @DataProvider
    public Object[][] isProductInCatalogPresentTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."}
        };
    }


    public List<String> expectedSortingProductAtoZ() {
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("Sauce Labs Bike Light");
        expectedResult.add("Sauce Labs Fleece Jacket");
        expectedResult.add("Sauce Labs Bolt T-Shirt");
        expectedResult.add("Sauce Labs Backpack");
        expectedResult.add("Test.allTheThings() T-Shirt (Red)");
        expectedResult.add("Sauce Labs Onesie");
        Collections.sort(expectedResult);
        return expectedResult;
    }

    @Test(description = "Сheck for sorting product from A to Z", groups = {"regression"})
    @Description("Checking the sorting of goods in the catalog from A to Z")
    public void sortTestAToZ() {
        LoginPageFactory.setUserName(USERNAME);
        LoginPageFactory.setPassword(PASSWORD);
        LoginPageFactory.clickLoginButton();
        ProductsPage.clickSorting(SORT_A_TO_Z);
        ProductsPage.getSortingProduct();
        Assert.assertEquals(ProductsPage.getSortingProduct(), expectedSortingProductAtoZ());
    }

    public List<String> expectedSortingProductZtoA() {
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("Sauce Labs Bike Light");
        expectedResult.add("Sauce Labs Fleece Jacket");
        expectedResult.add("Sauce Labs Bolt T-Shirt");
        expectedResult.add("Sauce Labs Backpack");
        expectedResult.add("Test.allTheThings() T-Shirt (Red)");
        expectedResult.add("Sauce Labs Onesie");
        Collections.sort(expectedResult);
        Collections.reverse(expectedResult);
        return expectedResult;
    }

    @Test(description = "Check for sorting product from Z to A", groups = {"regression"})
    @Description("Checking the sorting of goods in the catalog from Z to A")
    public void sortTestZToA() {
        LoginPageFactory.setUserName(USERNAME);
        LoginPageFactory.setPassword(PASSWORD);
        LoginPageFactory.clickLoginButton();
        ProductsPage.clickSorting(SORT_Z_TO_A);
        ProductsPage.getSortingProduct();
        Assert.assertEquals(ProductsPage.getSortingProduct(), expectedSortingProductZtoA());
    }
}