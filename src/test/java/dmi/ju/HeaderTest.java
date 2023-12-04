package dmi.ju;

import dmi.ju.model.HomePage;
import dmi.ju.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HeaderTest extends BaseTest {

    @Test
    public void testSearchBox() {
        String productTextInSearchResults = new HomePage(getDriver())
                .enterSearchQuery("short")
                .getProductLinkText();

        assertTrue(productTextInSearchResults.contains("short"));
    }
}
