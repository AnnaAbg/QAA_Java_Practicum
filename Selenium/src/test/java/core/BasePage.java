package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage class provides a base implementation for page objects in a Selenium WebDriver framework.
 * <p>
 * It initializes the WebDriver instance and provides methods to retrieve WebDriverWait instances
 * with different timeout durations.
 * </p>
 */
public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait2;
    private WebDriverWait wait5;
    private WebDriverWait wait10;

    /**
     * Constructs a new BasePage object and initializes the WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by the page
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    /**
     * Gets the WebDriver instance associated with this page.
     *
     * @return the WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets a WebDriverWait instance with a 2-second timeout.
     * <p>
     * If the wait2 instance is null, it initializes it before returning.
     * </p>
     *
     * @return a WebDriverWait instance with a 2-second timeout
     */
    public WebDriverWait getWait2() {
        if (wait2 == null) {
            wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        }

        return wait2;
    }

    /**
     * Gets a WebDriverWait instance with a 5-second timeout.
     * <p>
     * If the wait5 instance is null, it initializes it before returning.
     * </p>
     *
     * @return a WebDriverWait instance with a 5-second timeout
     */
    public WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }

        return wait5;
    }

    /**
     * Gets a WebDriverWait instance with a 10-second timeout.
     * <p>
     * If the wait10 instance is null, it initializes it before returning.
     * </p>
     *
     * @return a WebDriverWait instance with a 10-second timeout
     */
    public WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }

        return wait10;
    }
}
