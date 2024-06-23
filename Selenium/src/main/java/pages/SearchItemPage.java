package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * SearchItemPage class represents the page object for the search results page.
 * <p>
 * Extends the BasePage class.
 * </p>
 */
public class SearchItemPage extends BasePage {

    /**
     * Constructs a new SearchItemPage object and initializes the WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by the page
     */
    public SearchItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "bx_3966226736_113178_pict")
    private WebElement vitaminCItemLink;

    @FindBy(css = "#bx_3966226736_120517_pict")
    private WebElement appleJuiceWithoutPulp;


    @Step("Click on the Vitamin C item link")
    public VitaminCItemPage clickVitaminCItemLink() {
        // getWait2().until(ExpectedConditions.visibilityOf(vitaminCItemLink)).click();
        vitaminCItemLink.click();

        return new VitaminCItemPage(getDriver());
    }

    @Step("Click on the Apple Juice without pulp item link")
    public BabyFoodIAppleJuiceItemPage clickAppleJuiceItemLink() {
        getWait5().until(ExpectedConditions.visibilityOf(appleJuiceWithoutPulp)).click();

        return new BabyFoodIAppleJuiceItemPage(getDriver());
    }
}
