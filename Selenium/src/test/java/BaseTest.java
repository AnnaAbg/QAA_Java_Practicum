import config.BaseConfig;
import config.PopUpWindowConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static utils.ScreenHelper.makeScreenShot;

/**
 * BaseTest class serves as the base test class for Selenium tests.
 * It sets up and tears down the WebDriver instance, manages test configuration,
 * and handles pre- and post-test activities such as environment setup and cleanup.
 */
public class BaseTest {

    protected WebDriver driver;

    /**
     * Retrieves the WebDriver instance used for testing.
     *
     * @return the WebDriver instance used for testing
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Configuration instance for general test settings.
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());


    /**
     * Configuration instance for pop-up window specific settings.
     */
    private final PopUpWindowConfig popUpWindowConfig = ConfigFactory.create(PopUpWindowConfig.class, System.getenv());


    /**
     * Sets up the test environment before each test method execution.
     * Initializes WebDriver, sets necessary configurations, loads URL, manages cookies, and refreshes the page.
     */
    @BeforeMethod
    public void setUp() {

        // Set system properties for driver
        System.setProperty(config.driverProperty(), config.driverPath());

        // Initialize WebDriver
        driver = new ChromeDriver();

        // Navigate to base URL
        driver.get(config.baseUrl());

        //  Maximize the window
         driver.manage().window().maximize();

        // Add Cookie
        driver.manage().addCookie(new Cookie(popUpWindowConfig.cookieName(), popUpWindowConfig.cookieValue()));

        // Set session storage
        ((JavascriptExecutor) driver).executeScript("sessionStorage.setItem('" + popUpWindowConfig.sessionKey() + "', '" + popUpWindowConfig.sessionValue() + "')");

        // Set local storage
        ((JavascriptExecutor) driver).executeScript("localStorage.setItem('" + popUpWindowConfig.localStorageKey() + "', '\"" + popUpWindowConfig.localStorageValue() + "\"')");

        // Refresh the page
        driver.navigate().refresh();

        // Capture a screenshot
         makeScreenShot(driver);

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Quits the WebDriver instance after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
