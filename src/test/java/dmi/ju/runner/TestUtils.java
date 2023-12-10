package dmi.ju.runner;

import dmi.ju.model.base.BaseModel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestUtils {

    public enum MenuOption {
        WHATS_NEW {},
        WOMEN {},
        MEN {},
        GEAR {},
        TRAINING {},
        SALE {}
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
