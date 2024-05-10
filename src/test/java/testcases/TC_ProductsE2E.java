package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetests.BaseTest;
import basetests.DriverFactory;

public class TC_ProductsE2E extends BaseTest {

	@Test
	public void testIfCartTotalIsCorrectE2E() {

		// click on Products link,
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[2]/a"))
				.click();

		// Enter the valid search string "Jeans" in the search text box
		DriverFactory.getInstance().getDriver().findElement(By.id("search_product")).sendKeys("Jeans");
		DriverFactory.getInstance().getDriver().findElement(By.id("submit_search")).click();

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='choose'][1]/ul/li/a")).click();

		String itemQty = "4";
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));
		WebElement qtyInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity")));
		qtyInput.clear();
		qtyInput.sendKeys(itemQty);

		//get the price of the item to be added to the cart 
		WebElement priceSpan = 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-7']/div/span/span")));
		String itemPrice = priceSpan.getText().substring(3).trim();
		
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@class='btn btn-default cart']"))
				.click();

		WebElement addedToCartPopUp = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Added!']")));
		Assert.assertTrue(addedToCartPopUp.isDisplayed());
		
		// Navigate to View Cart Page
		WebElement viewCartLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/p[2]/a")));
		viewCartLink.click();
		
		//Get the Total amount text from the td
		WebElement cartTotalSpan = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_total']/p")));
		int aTotalAmount = Integer.valueOf(cartTotalSpan.getText().substring(3).trim());
		
		Assert.assertEquals(aTotalAmount, (Integer.valueOf(itemPrice)* Integer.valueOf(itemQty)));
		
		
	}

}
