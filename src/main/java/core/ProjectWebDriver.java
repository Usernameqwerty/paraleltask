package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


public class ProjectWebDriver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>()
    {
        @Override
        protected WebDriver initialValue()
        {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/chromedriver.exe");
            return new ChromeDriver(); // can be replaced with other browser drivers
        }
    };

    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }

    private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";


    static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    static DesiredCapabilities setChromeCapability() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        return capability;
    }

    public static WebDriver createWebDriverInstance() {
        driver.set(createChromeDriver());
        driver.get().manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        return driver.get();
    }
}