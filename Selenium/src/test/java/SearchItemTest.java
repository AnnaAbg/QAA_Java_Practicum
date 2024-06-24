import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

/**
 * SearchItemTest class contains a test method to verify searching for an item functionality.
 * This class extends BaseTest for setting up the test environment.
 */
@Epic("Search Item Functionality")
@Feature("Search Item")
public class SearchItemTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Story("Verify Search Item Functionality")
    @Description("Verify searching for an item 'Витамин С' and verifying the page title.")
    @Test(priority = 2)
    public void testSearchItem() throws InterruptedException {
        String itemName = new MainPage(getDriver())
                .setItemName("Витамин С")
                .clickSubmit()
                .clickVitaminCItemLink()
                .getTitle();

        Assert.assertEquals(itemName, "OVIE Витамин С 900мг тб шип 4г №20");
    }
}
