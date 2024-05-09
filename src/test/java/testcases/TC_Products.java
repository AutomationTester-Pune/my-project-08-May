package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetests.BaseTest;
import basetests.DriverFactory;

public class TC_Products extends BaseTest {

	@Test(groups = {"PRODUCTS"})
	public void verifyIfCanSearchValidProducts() {

		System.out.println("Executing verifyIfCanSearchValidProducts" + DriverFactory.getInstance().getDriver());
		
		//click on Products link,
        DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[2]/a")).click();
        
        // Enter the valid search string "Jeans" in the search text box 
        DriverFactory.getInstance().getDriver().findElement(By.id("search_product")).sendKeys("Jeans");
        DriverFactory.getInstance().getDriver().findElement(By.id("submit_search")).click();
        
        List<WebElement> searchedProductsList = DriverFactory.getInstance().getDriver()
        .findElements(By.xpath("//div[@class='features_items']/div[@class='col-sm-4']"));
        
        Assert.assertTrue(searchedProductsList.size() > 0);
	}
	
	@Test(groups = "PRODUCTS", enabled = false)
	public void verifyIfCanSearchInvalidProducts() {

		//click on Products link,
        DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[2]/a")).click();
        
        // Enter the valid search string "Jeans" in the search text box 
        DriverFactory.getInstance().getDriver().findElement(By.id("search_product")).sendKeys("Cap");
        DriverFactory.getInstance().getDriver().findElement(By.id("submit_search")).click();
        
        List<WebElement> searchedProductsList = DriverFactory.getInstance().getDriver()
        .findElements(By.xpath("//div[@class='features_items']/div[@class='col-sm-4']"));
        
        Assert.assertTrue(searchedProductsList.size() > 0);
	}

}
