import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

/**
 * ClearBasketTest class contains test methods related to clearing items from the basket.
 * This class extends BaseTest for setting up the test environment.
 */
@Epic("Basket Operations")
@Feature("Clear Basket")
public class ClearBasketTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Story("Remove Item from Basket")
    @Description("Verify removing an item from the basket and checking empty cart text.")
    @Test
    public void testRemoveItemFromTheBasket() {

        String removedItemText = new MainPage(getDriver())
                .setItemName("Витамин С")
                .clickSubmit()
                .clickVitaminCItemLink()
                .addToWishList()
                .clickTheBasket()
                .removeItemFromBasket()
                .getRemovedItemMessage();

        Assert.assertEquals(removedItemText, "Товар OVIE Витамин С 900мг тб шип 4г №20 был удален из корзины.");
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Wish List Icon")
    @Description("Verify that the wish list icon is active for an item.")
    @Test
    public void testAddWishListIconIsActive() {

        boolean isWishListIconDisplayedAndEnabled = new MainPage(getDriver())
                .setItemName("Сок яблочный")
                .clickSubmit()
                .clickAppleJuiceItemLink()
                .isElementDisplayedAndEnabled();

        Assert.assertTrue(isWishListIconDisplayedAndEnabled, "Wish Icon is not displayed and enabled on the page");


    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Add to Cart Button")
    @Description("Verify that the add to cart button is active for an item.")
    @Test
    public void testAddToCartButtonIsActive() {

        String addToCart = new MainPage(getDriver())
                .setItemName("Сок яблочный")
                .clickSubmit()
                .clickAppleJuiceItemLink()
                .getAddToCartButtonText();

        Assert.assertEquals(addToCart, "В корзину");
    }
}
