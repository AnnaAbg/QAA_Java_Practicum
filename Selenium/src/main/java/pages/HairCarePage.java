package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.Normalizer;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * HairCarePage class represents the page object for the hair care page.
 * <p>
 * Extends the BasePage class.
 * </p>
 */
public class HairCarePage extends BasePage {

    /**
     * Constructs a new HairCarePage object and initializes the WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by the page
     */
    public HairCarePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#navigation.breadcrumbs")
    private WebElement breadcrumbs;

    @FindBy(xpath = "//div/div/ul/li/a/span[contains(text(), 'Косметика')]")
    private WebElement cosmeticsLeftBlockMenu;

    @FindBy(xpath = "//li[contains(@class,'current')]//span[contains(text(),'Уход волосы')]")
    private WebElement hairCareSubmenu;

    /**
     * Gets the list of breadcrumbs.
     * This method splits the breadcrumb text, trims and normalizes each item, and returns the list.
     *
     * @return a list of breadcrumb items
     */
    @Step("Get breadcrumb list")
    public List<String> getBreadcrumbList() {
        // Split the breadcrumb text and clean up each item, then return the list directly
        return Arrays.stream(breadcrumbs.getText().split("-"))
                .map(String::trim)
                .map(s -> Normalizer.normalize(s, Normalizer.Form.NFKC)) // Normalize strings to ensure consistency
                .collect(Collectors.toList());
    }

    @Step("Scroll and move to specified webElement")
    public void scrollAndMoveToMedicationsDietarySupplementsMenu(WebElement element) {
        new Actions(getDriver())
                .scrollToElement(element)
                .moveToElement(element)
                .pause(Duration.ofMillis(300))
                .perform();
    }

    @Step("Scroll and move to cosmetics left block menu")
    public HairCarePage getCosmeticsLeftBlockMenu() {
        scrollAndMoveToMedicationsDietarySupplementsMenu(cosmeticsLeftBlockMenu);

        return this;
    }

    @Step("Get hair care submenu block text")
    public String getHairCareSubmenuBlockText() {
        return getWait5().until(ExpectedConditions.visibilityOf(hairCareSubmenu)).getText();
    }
}
