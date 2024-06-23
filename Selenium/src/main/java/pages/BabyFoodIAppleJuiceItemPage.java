package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * BabyFoodIAppleJuiceItemPage class represents the page object for the baby food apple juice item page.
 * <p>
 * Extends the BasePage class.
 * </p>
 */
public class BabyFoodIAppleJuiceItemPage extends BasePage {

    /**
     * Constructs a new BabyFoodIAppleJuiceItemPage object and initializes the WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by the page
     */
    public BabyFoodIAppleJuiceItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='value']")
    private WebElement wishItemIcon;

    @FindBy(xpath = "//span[contains(text(),'В корзину')]")
    private WebElement addToCartButton;

    @Step("Check if wish item icon is displayed and enabled")
    public boolean isElementDisplayedAndEnabled() {
        return wishItemIcon.isDisplayed() && wishItemIcon.isEnabled();
    }

    @Step("Get wish list count title")
    public String getWishItemTitle() {
        try {
            return wishItemIcon.getAttribute("title");
        } catch (NullPointerException | NoSuchElementException e) {
            return null;
        }
    }


    @Step("Get text from add to cart button")
    public String getAddToCartButtonText() {
        return addToCartButton.getText();
    }
}
