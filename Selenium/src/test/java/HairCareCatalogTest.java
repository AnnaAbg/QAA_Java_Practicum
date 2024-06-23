import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

/**
 * HairCareCatalogTest class contains test methods related to hair care catalog navigation.
 * This class extends BaseTest for setting up the test environment.
 */
@Epic("Hair Care Catalog Navigation")
@Feature("Hair Care Catalog")
public class HairCareCatalogTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Story("Navigate through Breadcrumbs")
    @Description("Verify navigation through breadcrumbs item list on the hair care catalog page.")
    @Test
    public void testNavigateToBreadcrumbsItemList() {

        final List<String> expectedBreadcrumbList = List.of("Главная", "Каталог", "Косметика", "Уход волосы");

        List<String> actualBreadcrumbList = new MainPage(getDriver())
                .moveToCosmeticsMenu()
                .clickHairCareSubMenu()
                .getBreadcrumbList();

        Assert.assertEquals(expectedBreadcrumbList.size(), 4);
        Assert.assertEquals(actualBreadcrumbList, expectedBreadcrumbList);

    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Left Block Catalog Menu")
    @Description("Verify the submenu block text in the left catalog menu on the hair care catalog page.")
    @Test
    public void testLeftBlockCatalogMenu() {

        String actualSubmenuBlockText = new MainPage(getDriver())
                .moveToCosmeticsMenu()
                .clickHairCareSubMenu()
                .getCosmeticsLeftBlockMenu()
                .getHairCareSubmenuBlockText();

        Assert.assertEquals(actualSubmenuBlockText, "Уход волосы");

    }
}
