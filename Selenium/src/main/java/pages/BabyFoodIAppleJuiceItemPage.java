package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
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

     @FindBy(xpath = "//div[@class='wish_item text']//span[@title='Отложить']")
     private WebElement wishItemIcon;

    //span[contains(text(),'Отложить')
    //div[@class='wish_item text']//span[@title='Отложить']
    //(//span[@title='Отложить'])[1]
    //CSS//div[class='wish_item text'] span[title='Отложить'

    @FindBy(xpath = "//span[contains(text(),'В корзину')]")
    private WebElement addToCartButton;

    @Step("Hover over the element ")
    public void hoverOverElement(WebElement element) {
        new Actions(getDriver())
                .moveToElement(element)
//                .pause(Duration.ofMillis(300))
                .perform();
    }

    @Step("Get text from wish item icon")
    public String getWishItemIconText() {
       // hoverOverElement(wishItemIcon);
       return getWait5().until(ExpectedConditions.visibilityOf(wishItemIcon)).getText();

     //  return wishItemIcon.getText();
    }

    @Step("Get text from add to cart button")
    public String getAddToCartButtonText() {
        return addToCartButton.getText();
    }
}
