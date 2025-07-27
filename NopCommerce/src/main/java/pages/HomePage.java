package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class HomePage {
	   WebDriver driver;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By currencyDropdown = By.id("customerCurrency");
	    By productPrices = By.cssSelector("span.price.actual-price");

	    // Actions
	    public void selectCurrency(String currency) {
	        driver.findElement(currencyDropdown).click();
	        driver.findElement(By.xpath("//select[@id='customerCurrency']/option[text()='" + currency + "']")).click();
	    }

	    public List<WebElement> getAllProductPrices() {
	        return driver.findElements(productPrices);
	    }

	    
	    
	 // LOCATORS
	    By firstSlider = By.cssSelector("div.nivoSlider a:nth-child(1)"); // Nokia Lumia
	    By secondSlider = By.cssSelector("div.nivoSlider a:nth-child(2)"); // iPhone 6

	    // ACTIONS

	    public void clickFirstSlider() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(firstSlider)).click();
	    }

	    public void clickSecondSlider() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(secondSlider)).click();
	    }

	    public String getCurrentUrlAfterWait() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));  // ensures page has loaded
	        return driver.getCurrentUrl();
	    }
	    
	    
	    // Social media icons
	    By facebookIcon = By.cssSelector("li.facebook a");
	    By twitterIcon = By.cssSelector("li.twitter a");
	    By rssIcon = By.cssSelector("li.rss a");
	    By youtubeIcon = By.cssSelector("li.youtube a");

	    public void clickFacebookIcon() {
	        driver.findElement(facebookIcon).click();
	    }

	    public void clickTwitterIcon() {
	        driver.findElement(twitterIcon).click();
	    }

	    public void clickRssIcon() {
	        driver.findElement(rssIcon).click();
	    }

	    public void clickYoutubeIcon() {
	        driver.findElement(youtubeIcon).click();
	    }
	    
	    
//	    Wishlist
	    
	    By htcWishlistButton = By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]");
	    By wishlistSuccessBar = By.cssSelector("div.bar-notification.success");
	    By wishlistSuccessText = By.cssSelector("div.bar-notification.success p");
	    By wishlistTab = By.className("ico-wishlist");

	    public void clickWishlistForHTCProduct() {
	        driver.findElement(htcWishlistButton).click();
	    }

	    public String getWishlistSuccessMessage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement bar = wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistSuccessText));
	        return bar.getText();
	    }

	    public String getWishlistSuccessColor() {
	        return driver.findElement(wishlistSuccessBar).getCssValue("background-color");
	    }

	    public void waitForWishlistMessageToDisappear() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(wishlistSuccessBar));
	    }

	    public void goToWishlistPage() {
	        driver.findElement(wishlistTab).click();
	    }
	    
}
