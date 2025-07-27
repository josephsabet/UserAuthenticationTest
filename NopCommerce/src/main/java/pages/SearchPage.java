package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class SearchPage {
	 WebDriver driver;

	    public SearchPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By searchInput = By.id("small-searchterms"); // search text box locator
	    By searchButton = By.cssSelector("button.search-box-button"); // search button locator
	    // Locator for all search result items.
	    // Adjust the CSS selector based on the actual structure; here we assume that each product is inside a div with class "item-box"
	    By searchResults = By.cssSelector("div.product-grid div.item-box");

	    // Actions
	    public void enterSearchText(String text) {
	        driver.findElement(searchInput).clear();
	        driver.findElement(searchInput).sendKeys(text);
	    }

	    public void clickSearchButton() {
	        driver.findElement(searchButton).click();
	    }

	    // Returns a list of search result elements
	    public List<WebElement> getSearchResults() {
	        return driver.findElements(searchResults);
	    }

	    // For SKU search, click on the first product link inside the result.
	    // Here we assume the product title link is within each "item-box".
	    public void clickFirstProduct() {
	        // Here we assume that each product has a link with this selector.
	        driver.findElement(By.cssSelector("div.product-grid div.item-box h2.product-title a")).click();
	    }

}
