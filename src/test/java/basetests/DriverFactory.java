package basetests;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static DriverFactory instance = new DriverFactory();
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // private constructor
    private  DriverFactory() {
    }

    public static DriverFactory getInstance() {
    	System.out.println("Returning the DriverFactory instance");
        return instance;
    }

    // Set the driver object in ThreadLocal
    public void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public WebDriver getDriver() {
        return  driver.get();
    }

    public void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }


}
