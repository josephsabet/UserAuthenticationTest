package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchTest extends BaseTest {
	public SearchTest() {
		// TODO Auto-generated constructor stub
	}

	SearchPage searchPage;

	@BeforeMethod
	public void setUp() {
//	        setup();
		// Navigate to the homepage
	  
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.nopcommerce.com");
		searchPage = new SearchPage(driver);
	}

	@Test
	public void testSearchByProductName() {
		// List of product names to search for
		String[] productNames = { "book", "laptop", "nike" };

		// Loop over each product name and run validations using SoftAssert
		for (String product : productNames) {
			// Enter search term and click search
			searchPage.enterSearchText(product);
			searchPage.clickSearchButton();

			SoftAssert softAssert = new SoftAssert();

			// Verify that the current URL contains the search query
			String currentUrl = driver.getCurrentUrl();
			softAssert.assertTrue(currentUrl.contains("https://demo.nopcommerce.com/search?q="),
					"URL does not contain search query for product: " + product);

			// Retrieve search results and verify at least one result is displayed
			List<WebElement> results = searchPage.getSearchResults();
			softAssert.assertTrue(results.size() > 0, "No search results found for product: " + product);

			// For each result, verify the result text contains the search term
			// (case-insensitive)
			for (WebElement result : results) {
				String resultText = result.getText().toLowerCase();
				softAssert.assertTrue(resultText.contains(product.toLowerCase()),
						"Result text does not contain '" + product + "': " + resultText);
			}

			// Collect all soft assertion failures for this search term
			softAssert.assertAll();
		}
	}

	@Test
	public void testSearchByProductSKU() {
		// Array of SKUs to test
		String[] skus = { "SCI_FAITH", "APPLE_CAM", "SF_PRO_11" };

		for (String sku : skus) {
			// Enter SKU into search and click search button
			searchPage.enterSearchText(sku);
			searchPage.clickSearchButton();

			// Click on the first product link from the search results
			searchPage.clickFirstProduct();

			// Create instance of ProductDetailsPage to verify the SKU on details page
			ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
			String displayedSKU = productDetailsPage.getProductSKU();

			// Hard assertion: the displayed SKU should contain the searched SKU value
			Assert.assertTrue(displayedSKU.contains(sku),
					"Product page SKU '" + displayedSKU + "' does not contain searched SKU '" + sku + "'.");

			// After verification, navigate back to home page to perform next SKU search
			driver.get("https://demo.nopcommerce.com/");
		}
	}

	@AfterMethod
	public void tearDownTest() {
		tearDown();
	}

}
