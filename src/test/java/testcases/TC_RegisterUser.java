package testcases;


import basetests.BaseTest;
import basetests.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusablecomponents.CommonData;
import reusablecomponents.UtilFunctions;

import java.time.Duration;
import java.util.Date;

public class TC_RegisterUser extends BaseTest {

    @Test(description = "Should navigate to the Signup page")
    public void verifyNavigationToSignupPage() throws InterruptedException {

        //click on Signup link,
        DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a")).click();
        Assert.assertEquals(DriverFactory.getInstance().getDriver().getCurrentUrl(), "https://automationexercise.com/login");
    }

    @Test(description = "Should display message 'Email Address already exist!")
    public void verifyValidationMessageForDuplicateEmail() throws InterruptedException {

        //click on Signup link,
        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a")).click();

        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//form[@action='/signup']//input[@name='name']"))
                .sendKeys("A buyer");

        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//form[@action='/signup']//input[@name='email']")).sendKeys("test@gmail.com");

        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//button[text()='Signup']")).click();

        String eValidationMessage = "Email Address already exist!";
        String aValidationMessage = DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//form[@action='/signup']/p")).getText();

        Assert.assertEquals(aValidationMessage,eValidationMessage, "Validation message does not match !!" );
    }

    @Test(description = "Test the navigation to the sign up page")
    public void verifyIfCanGoToSignupPage() {
        //click on Signup link
        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a")).click();

        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//form[@action='/signup']//input[@name='name']"))
                .sendKeys("A buyer");

        if(CommonData.newSignUpEmail == null) {
            CommonData.newSignUpEmail= UtilFunctions.getDynamicEmailId();
        }

        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//form[@action='/signup']//input[@name='email']")).sendKeys(CommonData.newSignUpEmail);

        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//button[text()='Signup']")).click();

        // Check if the paragraph will the text ENTER ACCOUNT INFORMATION is visible on the page
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(12));
        WebElement paragraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-form']/h2/b")));
        String aPText = paragraph.getText();
        String ePText = "ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(aPText, ePText);
    }

    @Test(description = "Positive scenario to verify if the user can use sign-up function")
    public void verifyIfCanSignup() throws InterruptedException {

        //click on Signup link
        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a")).click();

        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//form[@action='/signup']//input[@name='name']"))
                .sendKeys("A buyer");

        // generate and set the new email to be used for Sign-up
        CommonData.newSignUpEmail = UtilFunctions.getDynamicEmailId();

        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//form[@action='/signup']//input[@name='email']")).sendKeys(CommonData.newSignUpEmail);

        DriverFactory.getInstance().getDriver()
                .findElement(By.xpath("//button[text()='Signup']")).click();

        // Enter the details on the Sign-up page
        DriverFactory.getInstance().getDriver()
                .findElement(By.id("id_gender1")).click();

        DriverFactory.getInstance().getDriver()
                .findElement(By.id("password")).sendKeys("pass@123");

        DriverFactory.getInstance().getDriver()
                .findElement(By.id("first_name")).sendKeys("James");

        DriverFactory.getInstance().getDriver()
                .findElement(By.id("last_name")).sendKeys("Wong");

        DriverFactory.getInstance().getDriver()
                .findElement(By.id("address1")).sendKeys("1234, Heroku Street");

        // select the country
        WebElement countryDD = DriverFactory.getInstance().getDriver().findElement(By.id("country"));
        Select countrySelect = new Select(countryDD);
        countrySelect.selectByValue("India"); //

        DriverFactory.getInstance().getDriver()
                .findElement(By.id("state")).sendKeys("Maharashtra");

        DriverFactory.getInstance().getDriver()
                .findElement(By.id("city")).sendKeys("Pune"); //

        DriverFactory.getInstance().getDriver()
                .findElement(By.id("mobile_number")).sendKeys("7890312906");


        DriverFactory.getInstance().getDriver()
                        .findElement(By.xpath("//button[text() = 'Create Account']")).click();

        Thread.sleep(4000);

    }

}
