package basetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    public WebDriver createBrowserInstance(String browserName) {
    	
        WebDriver driver = null;

        System.out.println("Receieved the browser name as " + browserName);
        
        if(browserName.equalsIgnoreCase("chrome")) {
        	System.out.println();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            
            System.out.println("DRIVER is " + driver);
            return driver;
        }
        
        System.out.println("executing createBrowserInstance done");
        return  driver;

    }
}
