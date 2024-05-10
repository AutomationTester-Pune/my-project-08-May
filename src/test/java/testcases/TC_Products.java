package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetests.BaseTest;
import basetests.DriverFactory;

public class TC_Products extends BaseTest {

	@Test(groups = { "PRODUCTS" })
	public void verifyIfCanSearchValidProducts() {

		// click on Products link,
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[2]/a"))
				.click();

		// Enter the valid search string "Jeans" in the search text box
		DriverFactory.getInstance().getDriver().findElement(By.id("search_product")).sendKeys("Jeans");
		DriverFactory.getInstance().getDriver().findElement(By.id("submit_search")).click();

		List<WebElement> searchedProductsList = DriverFactory.getInstance().getDriver()
				.findElements(By.xpath("//div[@class='features_items']/div[@class='col-sm-4']"));

		Assert.assertTrue(searchedProductsList.size() > 0);
	}

	@Test(groups = "PRODUCTS")
	public void verifyIfCanSearchInvalidProducts() {

		// click on Products link,
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[2]/a"))
				.click();

		// Enter the valid search string "Jeans" in the search text box
		DriverFactory.getInstance().getDriver().findElement(By.id("search_product")).sendKeys("Cap");
		DriverFactory.getInstance().getDriver().findElement(By.id("submit_search")).click();

		List<WebElement> searchedProductsList = DriverFactory.getInstance().getDriver()
				.findElements(By.xpath("//div[@class='features_items']/div[@class='col-sm-4']"));

		Assert.assertTrue(searchedProductsList.size() > 0);
	}

	@Test
	public void testIfAddToCartWorks() {

		// click on Products link,
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[2]/a"))
				.click();

		// Enter the valid search string "Jeans" in the search text box
		DriverFactory.getInstance().getDriver().findElement(By.id("search_product")).sendKeys("Jeans");
		DriverFactory.getInstance().getDriver().findElement(By.id("submit_search")).click();

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='choose'][1]/ul/li/a")).click();

		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));
		WebElement qtyInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity")));
		qtyInput.clear();
		qtyInput.sendKeys("4");

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@class='btn btn-default cart']"))
				.click();

		WebElement addedToCartPopUp = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Added!']")));
		Assert.assertTrue(addedToCartPopUp.isDisplayed());

	}

	@Test
	public void testIfAddToCartWorksTrickyAddtoCartOption() {

		// click on Products link,
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[2]/a"))
				.click();

		// Enter the valid search string "Jeans" in the search text box
		DriverFactory.getInstance().getDriver().findElement(By.id("search_product")).sendKeys("Jeans");
		DriverFactory.getInstance().getDriver().findElement(By.id("submit_search")).click();
		
		
		 DriverFactory.getInstance().getDriver()
		.findElement(By.linkText("Add to cart")).click();
		

		
	}

}
