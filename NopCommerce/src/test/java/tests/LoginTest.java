package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	 LoginPage loginPage;

	    @BeforeMethod
	    public void setUp() {
//	        setup();
	    	driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.nopcommerce.com");
	        driver.findElement(By.className("ico-login")).click(); // Navigate to login page
	        loginPage = new LoginPage(driver);
	    }

	    @Test
	    public void testValidLogin() {
	        SoftAssert softAssert = new SoftAssert();

	        loginPage.enterEmail("test@example.com");
	        loginPage.enterPassword("P@ssw0rd");
	        loginPage.clickLogin();

	        String currentUrl = driver.getCurrentUrl();
	        boolean myAccountDisplayed = loginPage.isMyAccountVisible();

	        softAssert.assertEquals(currentUrl, "https://demo.nopcommerce.com/", "URL mismatch after login");
	        softAssert.assertTrue(myAccountDisplayed, "'My Account' tab not displayed");

	        softAssert.assertAll();
	    }

	    @Test
	    public void testInvalidLogin() {
	        SoftAssert softAssert = new SoftAssert();

	        loginPage.enterEmail("wrong@example.com");
	        loginPage.enterPassword("P@ssw0rd");
	        loginPage.clickLogin();

	        String errorText = loginPage.getErrorMessageText();
	        softAssert.assertTrue(errorText.contains("Login was unsuccessful."), "Error message content mismatch");

	        String rgbaColor = loginPage.getErrorMessageColor(); // Should return: rgba(228, 67, 75, 1)
	        String hexColor = Color.fromString(rgbaColor).asHex(); // Expected: #e4434b

	        softAssert.assertEquals(hexColor, "#e4434b", "Error message color mismatch");

	        softAssert.assertAll();
	    }

	    @AfterMethod
	    public void tearDownTest() {
	        tearDown();
	    }
}
