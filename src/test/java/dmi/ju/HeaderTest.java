package dmi.ju;

import dmi.ju.model.HomePage;
import dmi.ju.runner.BaseTest;
import dmi.ju.runner.TestUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HeaderTest extends BaseTest {

    @Test
    public void testSearchBox() {
        String productTextInSearchResults = new HomePage(getDriver())
                .enterSearchQuery("short")
                .getProductLinkText();

        assertTrue(productTextInSearchResults.contains("short"));
    }

    @Test
    public void testMenuOptions() {
        final List<String> menuOptions = List.of(
                "What's New",
                "Women",
                "Men",
                "Gear",
                "Training",
                "Sale"
        );

        List<String> actualMenuOptions = new HomePage(getDriver())
                .getMenuOptions();

        assertEquals(actualMenuOptions, menuOptions);
    }


    @DataProvider(name = "menu-options")
    public Object[][] menuOptions() {
        return new Object[][]{
                {TestUtils.MenuOption.WHATS_NEW, "What's New"},
                {TestUtils.MenuOption.WOMEN, "Women"},
                {TestUtils.MenuOption.MEN, "Men"},
                {TestUtils.MenuOption.GEAR, "Gear"},
                {TestUtils.MenuOption.TRAINING, "Training"},
                {TestUtils.MenuOption.SALE, "Sale"}
        };
    }

    @Test(dataProvider = "menu-options")
    public void testPagesOpenedFromMenu(TestUtils.MenuOption menuOption, String pageHeader) {
        String actualPageHeader = new HomePage(getDriver())
                .clickMenuOption(menuOption)
                .getPageHeader();

        assertEquals(actualPageHeader, pageHeader);
    }
}
