package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{
	 RegisterPage registerPage;

	    @BeforeMethod
	    public void setUp() {
//	        setUp();
	    	driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.nopcommerce.com");
	        driver.findElement(By.className("ico-register")).click(); // Navigate to register page
	        registerPage = new RegisterPage(driver);
	    }

	    @Test
	    public void validRegistrationTest() {
	        registerPage.register("automation", "tester", "test1@example.com", "P@ssw0rd");
	        
	        String actualMessage = registerPage.getSuccessMessageText();
	        Assert.assertEquals(actualMessage, "Your registration completed", "Text mismatch");

	        String actualColorRGBA = registerPage.getSuccessMessageColor();
	        String actualColorHex = Color.fromString(actualColorRGBA).asHex();
	        String expectedColorHex = "#4cb17c"; // Converted from rgba(76, 177, 124, 1)

//	        String message = registerPage.getSuccessMessage();
//	        Assert.assertEquals(message, "Your registration completed");
	    }

	    @AfterMethod
	    public void tearDownTest() {
	        tearDown();
	    }
}
