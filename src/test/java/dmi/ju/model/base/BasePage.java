package dmi.ju.model.base;

import dmi.ju.model.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends BaseModel {

    @FindBy(id = "search")
    private WebElement searchBox;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage enterSearchQuery(String searchQuery) {
        searchBox.sendKeys(String.format("%s\n", searchQuery));

        return new SearchResultsPage(getDriver());
    }
}
