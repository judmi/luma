package dmi.ju.model.base;

import dmi.ju.model.SearchResultsPage;
import dmi.ju.runner.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasePage<Self extends BasePage<?>> extends BaseModel {

    @FindBy(id = "ui-id-2")
    private WebElement whatsNewMenuOption;

    @FindBy(id = "ui-id-3")
    private WebElement womenMenuOption;

    @FindBy(id = "ui-id-12")
    private WebElement menMenuOption;

    @FindBy(id = "ui-id-21")
    private WebElement gearMenuOption;

    @FindBy(id = "ui-id-25")
    private WebElement trainingMenuOption;

    @FindBy(id = "ui-id-27")
    private WebElement saleMenuOption;


    @FindBy(id = "search")
    private WebElement searchBox;

    @FindBy(xpath = "//ul[@id='ui-id-1']/li")
    private List<WebElement> menuOptionsList;

    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    private WebElement pageHeader;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage enterSearchQuery(String searchQuery) {
        searchBox.sendKeys(String.format("%s\n", searchQuery));

        return new SearchResultsPage(getDriver());
    }

    public List<String> getMenuOptions() {

        return menuOptionsList.stream().map(WebElement::getText).toList();
    }

    public Self clickMenuOption(TestUtils.MenuOption menuOption) {
        switch (menuOption) {
            case WHATS_NEW:
                whatsNewMenuOption.click();
                break;
            case WOMEN:
                womenMenuOption.click();
                break;
            case MEN:
                menMenuOption.click();
                break;
            case GEAR:
                gearMenuOption.click();
                break;
            case TRAINING:
                trainingMenuOption.click();
                break;
            case SALE:
                saleMenuOption.click();
                break;
        }

        return (Self) this;
    }

    public String getPageHeader() {

        return pageHeader.getText();
    }
}
