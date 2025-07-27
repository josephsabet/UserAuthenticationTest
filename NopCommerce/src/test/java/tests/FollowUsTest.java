package tests;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;

public class FollowUsTest {
	 WebDriver driver;
	    HomePage homePage;

	    @BeforeMethod
	    public void setUp() {
//	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demo.nopcommerce.com/");
	        homePage = new HomePage(driver);
	    }

	    public String switchToNewTabAndGetUrl() {
	        String mainWindow = driver.getWindowHandle();
	        Set<String> allWindows = driver.getWindowHandles();

	        for (String window : allWindows) {
	            if (!window.equals(mainWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }

	        return driver.getCurrentUrl();
	    }

	    @Test
	    public void testFacebookLink() {
	        homePage.clickFacebookIcon();

	        String newTabUrl = switchToNewTabAndGetUrl();
	        Assert.assertEquals(newTabUrl, "https://www.facebook.com/nopCommerce", "Facebook URL mismatch");
	    }

	    @Test
	    public void testTwitterLink() {
	        homePage.clickTwitterIcon();

	        String newTabUrl = switchToNewTabAndGetUrl();
	        Assert.assertEquals(newTabUrl, "https://twitter.com/nopCommerce", "Twitter URL mismatch");
	    }

	    @Test
	    public void testRssLink() {
	        homePage.clickRssIcon();

	        String newTabUrl = driver.getCurrentUrl();  // RSS opens in same tab
	        String expectedUrl = "https://demo.nopcommerce.com/new-online-store-is-open";
	        // This test is expected to fail
	        Assert.assertEquals(newTabUrl, expectedUrl, "RSS URL does not match expected (this should fail)");
	    }

	    @Test
	    public void testYoutubeLink() {
	        homePage.clickYoutubeIcon();

	        String newTabUrl = switchToNewTabAndGetUrl();
	        Assert.assertEquals(newTabUrl, "https://www.youtube.com/user/nopCommerce", "YouTube URL mismatch");
	    }

	    @AfterMethod
	    public void tearDownTest() {
	        if (driver != null) {
//	            driver.quit();
	        }
	    }

}
