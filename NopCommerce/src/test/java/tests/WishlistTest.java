package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.WishlistPage;

public class WishlistTest {
	 WebDriver driver;
	    HomePage homePage;
	    WishlistPage wishlistPage;

	    @BeforeMethod
	    public void setUp() {
//	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demo.nopcommerce.com/");
	        homePage = new HomePage(driver);
	    }

	    @Test
	    public void testAddToWishlistAndVerifyMessage() {
	        SoftAssert softAssert = new SoftAssert();

	        homePage.clickWishlistForHTCProduct();

	        String actualMessage = homePage.getWishlistSuccessMessage();
	        softAssert.assertEquals(actualMessage, "The product has been added to your wishlist", "❌ Wrong success message");

	        String rgbaColor = homePage.getWishlistSuccessColor();
	        String hexColor = Color.fromString(rgbaColor).asHex(); // convert RGBA to HEX
	        softAssert.assertEquals(hexColor, "#4bb07a", "❌ Wrong color for success message"); // expected green

	        softAssert.assertAll();
	    }

	    @Test
	    public void testVerifyItemInWishlistPage() {
	        // Step 1–2: Click again to make sure it's added
	        homePage.clickWishlistForHTCProduct();
	        homePage.waitForWishlistMessageToDisappear();

	        // Step 3: Click Wishlist tab
	        homePage.goToWishlistPage();

	        // Step 4: Validate Qty > 0
	        wishlistPage = new WishlistPage(driver);
	        int quantity = wishlistPage.getQuantityValue();

	        // Hard assertion: item should appear
	        assert quantity > 0 : "❌ Quantity in wishlist is zero!";
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
//	            driver.quit();
	        }
	    }
}
