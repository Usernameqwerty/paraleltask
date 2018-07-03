package core;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import static core.Utils.getLOGGER;
import static core.Utils.waitForPageLoad;


public class CustomEventHandler implements WebDriverEventListener {
    Logger LOGGER = getLOGGER(CustomEventHandler.class);

    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        waitForPageLoad(webDriver);
        LOGGER.error("Page fully loaded");
    }

    public void beforeNavigateBack(WebDriver webDriver) {

    }

    public void afterNavigateBack(WebDriver webDriver) {

    }

    public void beforeNavigateForward(WebDriver webDriver) {

    }

    public void afterNavigateForward(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        LOGGER.error("Before @FindBy " + by);
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        LOGGER.error(String.format("Element found with the locator %s ", by));
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        LOGGER.error("Before click on the element" + webElement.toString());
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        LOGGER.error("Clicked on the element " + webElement.toString());
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        LOGGER.error(String.format("There is something wrong.Error message: %s",
                throwable.getMessage()));
    }
}
