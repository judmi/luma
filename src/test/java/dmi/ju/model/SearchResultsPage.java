package dmi.ju.model;

import dmi.ju.model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage<SearchResultsPage> {

    @FindBy(className = "product-item-link")
    private WebElement productLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductLinkText() {
        return productLink.getText().toLowerCase();
    }
}
