import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

/**
 * WishListItemToOrderTest class contains a test method to verify adding a wish list item to order functionality.
 * This class extends BaseTest for setting up the test environment.
 */
@Epic("Wish List Item to Order Functionality")
@Feature("Wish List Item")
public class WishListItemToOrderTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify Add Wish List Item to Order Functionality")
    @Description("Verify adding a wish list item 'Витамин С' to order and verifying the price per item.")
    @Test
    public void addWishListItemToOrder() {

        String pricePerItemText = new MainPage(getDriver())
                .setItemName("Витамин С")
                .clickSubmit()
                .clickVitaminCItemLink()
                .addToWishList()
                .clickTheBasket()
                .addItemToOrder()
                .getPricePerItem();

        Assert.assertEquals(pricePerItemText,"379 руб.\nцена за 1 шт");
    }
}
