import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

/**
 * LogoIconTest class contains a test method to verify the display of the logo icon.
 * This class extends BaseTest for setting up the test environment.
 */
@Epic("Logo Icon Display")
@Feature("Logo Icon")
public class LogoIconTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Story("Logo Icon Display Verification")
    @Description("Verify that the logo icon is displayed on the main page.")
    @Test(priority = 1)
    public void testLogoIcon() throws InterruptedException {
        boolean logoIcon = new MainPage(driver)
                .isDisplayedLogoIcon();

        Assert.assertTrue(logoIcon, "The Logo icon is not displayed");
    }
}