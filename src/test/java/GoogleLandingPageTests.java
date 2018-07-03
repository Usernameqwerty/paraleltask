import core.Utils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleLandingPageTests extends BaseTest {


    @Test
    public void findSomething() {
        eventDriver.get(URL);
        LOGGER.error("after get URL");
        eventDriver.navigate().to(URL);
        LOGGER.error("after navigate to");
        googleLandingPage.findSomething("sheet");
    }

    @Test
    public void checkThatOpenedRightPage() {
        driver.get(URL);
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.google.com",
                "Check that expected URL is not equal to current URL");
    }
}
