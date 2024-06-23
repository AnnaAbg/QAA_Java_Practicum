package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * VitaminCItemPage class represents the page object for the Vitamin C item page.
 * <p>
 * Extends the BasePage class
 * </p>
 */
public class VitaminCItemPage extends BasePage {

    /**
     * Constructs a new VitaminCItemPage object and initializes the WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by the page
     */
    public VitaminCItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='value']//i")
    private WebElement wishList;

    @FindBy(xpath = "//i[@class='svg inline  svg-inline-basket big']")
    private WebElement basket;

    @Step("Get title of Vitamin C item page")
    public String getTitle() {
        return getDriver().getTitle();
    }

    @Step("Add item to wish list")
    public VitaminCItemPage addToWishList() {
        wishList.click();

        return this;
    }

    @Step("Move item to basket")
    public BasketPage clickTheBasket() {
        basket.click();

        return new BasketPage(getDriver());
    }
}
