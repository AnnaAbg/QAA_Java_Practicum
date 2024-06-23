import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

/**
 * CatalogTest class contains test methods related to catalog navigation and menus.
 * This class extends BaseTest for setting up the test environment.
 */

@Epic("Catalog Navigation")
@Feature("Catalog Items")
public class VitaminsCatalogTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Story("Navigate through Breadcrumbs")
    @Description("Verify navigation through breadcrumbs item list on the catalog page.")
    @Test
    public void testNavigateToBreadcrumbsItemList() {

        final List<String> expectedBreadcrumbList = List.of("Главная", "Каталог", "Лекарства и БАДы", "Витамины");

        List<String> actualBreadcrumbList = new MainPage(getDriver())
                .moveToMedicationsAndDietarySupplementsMenu()
                .clickVitaminsSubMenu()
                .getBreadcrumbList();

        Assert.assertEquals(expectedBreadcrumbList.size(), 4);
        Assert.assertEquals(actualBreadcrumbList, expectedBreadcrumbList);
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Left Block Catalog Menu")
    @Description("Verify the submenu block text in the left catalog menu on the catalog page.")
    @Test
    public void estLeftBlockCatalogMenu() {

        String actualSubmenuBlockText = new MainPage(getDriver())
                .moveToMedicationsAndDietarySupplementsMenu()
                .clickVitaminsSubMenu()
                .getMedicationsAndDietarySupplementsLeftBlockMenu()
                .getVitaminsSubmenuBlockText();

        Assert.assertEquals(actualSubmenuBlockText, "Витамины");

    }
}