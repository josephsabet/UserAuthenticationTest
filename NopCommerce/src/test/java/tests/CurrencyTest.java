package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class CurrencyTest extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
//	        setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
		driver.findElement(By.className("ico-login")).click(); // Navigate to login page
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("test@example.com");
        loginPage.enterPassword("P@ssw0rd");
        loginPage.clickLogin();

		
		
		homePage = new HomePage(driver);
	}

	@Test
	public void testEuroSymbolAppearsForAllProducts() {

		homePage.selectCurrency("Euro");

		List<WebElement> prices = homePage.getAllProductPrices();

		Assert.assertEquals(prices.size(), 4, "Expected 4 products on the homepage.");

		for (int i = 0; i < prices.size(); i++) {
			String priceText = prices.get(i).getText();
			System.out.println("Product " + (i + 1) + " price: " + priceText);
			Assert.assertTrue(priceText.contains("€"), "Price does not contain Euro symbol: " + priceText);
		}
	}

	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}

}
