package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

/**
 * MainPage class represents the page object for the main page.
 * <p>
 * Extends the BasePage class.
 * </p>
 */
public class MainPage extends BasePage {

    /**
     * Constructs a new MainPage object and initializes the WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by the page
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='logo']/a")
    private WebElement logoIcon;

    @FindBy(id = "title-search-input_fixed")
    private WebElement searchInputField;

    @FindBy(name = "s")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'Лекарства и БАДы')]")
    private WebElement medicationsAndDietarySupplementsMenu;
    @FindBy(xpath = "//a/span[contains(text(),'Витамины')]")
    private WebElement vitaminsSubMenu;

    @FindBy(xpath = "//div[contains(text(),'Косметика')]")
    private WebElement cosmeticsMenu;

    @FindBy(xpath = "//a/span[contains(text(),'Уход волосы')]")
    private WebElement hairCareSubMenu;


    @Step("Click on the logo icon on the header")
    public MainPage clickLogo() {
        logoIcon.click();

        return this;
    }

    @Step("Check whether the logo icon is displayed")
    public boolean isDisplayedLogoIcon() {
        return logoIcon.isDisplayed();
    }

    @Step("Set item name in the search input field")
    public MainPage setItemName(String name) {
        getWait2().until(ExpectedConditions.visibilityOf(searchInputField)).sendKeys(name);

        return this;
    }

    @Step("Move to element")
    public void moveToElement(WebElement element) {
        new Actions(getDriver())
                .moveToElement(element)
                .build()
                .perform();
    }
    @Step("Click the submit button to search for an item")
    public SearchItemPage clickSubmit() {
        moveToElement(submitButton);
        submitButton.click();

        return new SearchItemPage(getDriver());
    }

    @Step("Hover over element")
    public void hoverOverElement(WebElement element) {
        new Actions(getDriver())
                .moveToElement(element)
                .pause(Duration.ofMillis(300))
                .perform();
    }

    @Step("Scroll to element" )
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Hover over the Medications and Dietary Supplements menu")
    public MainPage moveToMedicationsAndDietarySupplementsMenu() {
        hoverOverElement(medicationsAndDietarySupplementsMenu);

        return this;
    }

    @Step("Click the Vitamins submenu")
    public VitaminsPage clickVitaminsSubMenu() {
        getWait10().until(ExpectedConditions.visibilityOf(vitaminsSubMenu));
        scrollToElement(vitaminsSubMenu);
        vitaminsSubMenu.click();

        return new VitaminsPage(getDriver());
    }

    @Step("Hover over the Cosmetics menu")
    public MainPage moveToCosmeticsMenu() {
        hoverOverElement(cosmeticsMenu);

        return this;
    }

    @Step("Click the Hair Care submenu")
    public HairCarePage clickHairCareSubMenu() {
        getWait10().until(ExpectedConditions.visibilityOf(hairCareSubMenu));
        scrollToElement(hairCareSubMenu);
        hairCareSubMenu.click();

        return new HairCarePage(getDriver());
    }
}
