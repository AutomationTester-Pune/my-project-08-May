package basetests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();

    @BeforeMethod
    public void launchSite() {

        DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance("chrome"));
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        DriverFactory.getInstance().getDriver().get("https://automationexercise.com/");
    }

    @AfterMethod
    public void tearDown() {
        //DriverFactory.getInstance().closeBrowser();
    }
}
