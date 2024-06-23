import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;


/**
 * WishListTest class contains a test method to verify adding an item to the wish list functionality.
 * This class extends BaseTest for setting up the test environment.
 */
@Epic("Wish List Functionality")
@Feature("Wish List")
public class WishListTest extends BaseTest {


    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify Add Item to Wish List Functionality")
    @Description("Verify adding an item 'Витамин С' to wish list and verifying the message for basket wish list count.")
    @Test
    public void testAddItemToWishList() {

        String isWishListCountFoundAndDisplayed = new MainPage(getDriver())
                .setItemName("Витамин С")
                .clickSubmit()
                .clickVitaminCItemLink()
                .addToWishList()
                .clickTheBasket()
                .getWishListCountTitle();

        Assert.assertEquals(isWishListCountFoundAndDisplayed, "В отложенных товаров на 379 руб.");
    }
}