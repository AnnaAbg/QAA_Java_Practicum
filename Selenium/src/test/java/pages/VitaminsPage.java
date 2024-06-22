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
 * VitaminsPage class represents the page object for the vitamins' page.
 * <p>
 * Extends the BasePage class.
 * </p>
 */
public class VitaminsPage extends BasePage {

    /**
     * Constructs a new VitaminsPage object and initializes the WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by the page
     */
    public VitaminsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#navigation.breadcrumbs")
    private WebElement breadcrumbs;

    @FindBy(xpath = "//div/div/ul/li/a/span[contains(text(), 'Лекарства и БАДы')]")
    private WebElement medicationsAndDietarySupplementsLeftBlockMenu;

    @FindBy(xpath = "//li[contains(@class,'current')]//span[contains(text(),'Витамины')]")
    private WebElement vitaminsSubmenu;

    @Step("Get breadcrumb list")
    public List<String> getBreadcrumbList() {
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

    @Step("Scroll and move to medications & dietary supplements left block menu")
    public VitaminsPage getMedicationsAndDietarySupplementsLeftBlockMenu() {
        scrollAndMoveToMedicationsDietarySupplementsMenu(medicationsAndDietarySupplementsLeftBlockMenu);

        return this;
    }

    @Step("Get vitamins' submenu block text")
    public String getVitaminsSubmenuBlockText() {
        return getWait5().until(ExpectedConditions.visibilityOf(vitaminsSubmenu)).getText();
    }
}
