import core.CustomEventHandler;
import core.ProjectWebDriver;
import core.Utils;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    GoogleLandingPage googleLandingPage;
    String URL = "https://www.google.com/";
    EventFiringWebDriver eventDriver;
    Logger LOGGER = Utils.getLOGGER(BaseTest.class);
    @BeforeMethod
    public void setUp() {
        driver = ProjectWebDriver.createWebDriverInstance();
        eventDriver = new EventFiringWebDriver(driver);
        eventDriver.register(new CustomEventHandler());
        googleLandingPage = PageFactory.initElements(eventDriver, GoogleLandingPage.class);
        LOGGER.setLevel(Level.DEBUG);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
