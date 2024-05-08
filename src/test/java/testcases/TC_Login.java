package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetests.BaseTest;
import basetests.DriverFactory;
import reusablecomponents.CommonData;

//Wed_May_08_18_36_01@gmail.com
//pass@123

public class TC_Login extends BaseTest {

	@Test(description = "Check if the user can log in with the newly created password")
	public void testLogin() throws InterruptedException {
		
		 DriverFactory.getInstance().getDriver()
         .findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a")).click();
		 
		 DriverFactory.getInstance().getDriver()
         .findElement(By.xpath("//form[@action='/login']/input[@name='email']"))
         .sendKeys("Wed_May_08_18_36_01@gmail.com");
		 
		 DriverFactory.getInstance().getDriver()
         .findElement(By.xpath("//form[@action='/login']/input[@name='password']"))
         .sendKeys("pass@123");
		 
		 DriverFactory.getInstance().getDriver()
         .findElement(By.xpath("//form[@action='/login']/button")).click();
		 
		 WebElement logoutOption = DriverFactory.getInstance().getDriver()
         .findElement(By.linkText(" Logout"));
		 
		 Assert.assertTrue(logoutOption.isDisplayed(), "Log-in function not working");

	}

}
