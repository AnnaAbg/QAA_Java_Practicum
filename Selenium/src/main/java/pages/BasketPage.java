package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * BasketPage class represents the page object for the basket page.
 * <p>
 * Extends the BasePage class.
 * </p>
 */
public class BasketPage extends BasePage {

    /**
     * Constructs a new BasketPage object and initializes the WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by the page
     */
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='В отложенных товаров на 379 руб.']")
    private WebElement basketWishList;

    @FindBy(xpath = "//a[@data-entity='basket-item-remove-delayed']")
    private WebElement addItemToOrder;

    @FindBy(xpath = "//div/span[@class='basket-item-price-current-text']")
    private WebElement itemPrice;

    @FindBy(xpath = "//div[@class='basket-item-price-title']")
    private WebElement pricePerItem;

    @FindBy(xpath = "//span[@class='basket-item-actions-remove d-block d-md-none']")
    private WebElement deleteItem;

    @FindBy(xpath = "//strong[contains(text(),'OVIE Витамин С 900мг тб шип 4г №20')]")
    private WebElement removedItemMessage;

    @FindBy(xpath = "//div[@class='bx-sbb-empty-cart-text']")
    private WebElement emptyCartText;

    @Step("Get wish list count title")
    public String getWishListCountTitle() {
        return basketWishList.getAttribute("title");
    }

    @Step("Add item to order")
    public BasketPage addItemToOrder() {
        addItemToOrder.click();

        return this;
    }

    @Step("Get price per item")
    public String getPricePerItem() {
        String itemPriceText = itemPrice.getText();
        String pricePerItemText = pricePerItem.getText();

        return itemPriceText + "\n" + pricePerItemText;
    }

    @Step("Remove item from basket")
    public BasketPage removeItemFromBasket() {
        deleteItem.click();

        return this;
    }

    @Step("Get removed item message")
    public String getRemovedItemMessage() {
        String removedItem = removedItemMessage.getText();

        return "Товар " + removedItem + " был удален из корзины.";
    }

    @Step("Refresh the page")
    public BasketPage refreshPage() {
        getDriver().navigate().refresh();

        return this;
    }

    @Step("Get empty cart text")
    public String getEmptyCartText() {
        return emptyCartText.getText();
    }
}
