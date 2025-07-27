package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class SliderTest extends BaseTest{
	 HomePage homePage;

	    @BeforeMethod
	    public void setUp() {
	    	    driver = new ChromeDriver();
	    	    driver.manage().window().maximize();
	    	    driver.get("https://demo.nopcommerce.com/");
	        homePage = new HomePage(driver);
	    }

	    @Test
	    public void testNokiaLumiaSlider() {
	        homePage.clickFirstSlider();

	        String actualUrl = homePage.getCurrentUrlAfterWait();
	        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";

	        // The test should fail because the slider is broken
	        Assert.assertEquals(actualUrl, expectedUrl, "❌ Nokia slider did not navigate correctly");
	    }

	    @Test
	    public void testIphoneSlider() {
	        homePage.clickSecondSlider();

	        String actualUrl = homePage.getCurrentUrlAfterWait();
	        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";

	        // The test should fail because the slider is broken
	        Assert.assertEquals(actualUrl, expectedUrl, "❌ iPhone slider did not navigate correctly");
	    }

	    @AfterMethod
	    public void tearDownTest() {
	        tearDown();
	    }

}
