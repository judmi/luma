package dmi.ju.runner;

import dmi.ju.model.*;
import dmi.ju.model.base.BaseModel;
import dmi.ju.model.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestUtils {

    public enum MenuOption {
        WHATS_NEW {
            @Override
            public BasePage<?> createPage(WebDriver driver) {
                return new WhatsNewPage(driver);
            }

        },
        WOMEN {
            @Override
            public BasePage<?> createPage(WebDriver driver) {
                return new WomenPage(driver);
            }
        },
        MEN {
            @Override
            public BasePage<?> createPage(WebDriver driver) {
                return new MenPage(driver);
            }
        },
        GEAR {
            @Override
            public BasePage<?> createPage(WebDriver driver) {
                return new GearPage(driver);
            }
        },
        TRAINING {
            @Override
            public BasePage<?> createPage(WebDriver driver) {
                return new TrainingPage(driver);
            }
        },
        SALE {
            @Override
            public BasePage<?> createPage(WebDriver driver) {
                return new SalePage(driver);
            }
        };

        public abstract BasePage<?> createPage(WebDriver driver);
    }

    public static void scrollToElementByJavaScript(BaseModel baseModel, WebElement element) {
        JavascriptExecutor jsc = (JavascriptExecutor) baseModel.getDriver();
        jsc.executeScript("arguments[0].scrollIntoView();", baseModel.getWait5().until(ExpectedConditions.elementToBeClickable(element)));
    }

    public static void clickByJavaScript(BaseModel baseModel, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) baseModel.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }
}
