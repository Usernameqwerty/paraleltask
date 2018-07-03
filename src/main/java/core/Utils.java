package core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    private static Logger LOGGER;

    public static Logger getLOGGER(Class clazz) {
        return LOGGER = LogManager.getLogger(clazz);
    }

    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until((ExpectedCondition<Boolean>) driver1 -> ((JavascriptExecutor) driver1)
                .executeScript(
                        "return document.readyState").equals("complete"));
    }
}
