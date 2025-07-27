package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
	
	 WebDriver driver;

	    public WishlistPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Qty input for the wishlist item (assumed only 1 item in wishlist for now)
	    By quantityInput = By.cssSelector("input.qty-input");

	    public int getQuantityValue() {
	        String qtyValue = driver.findElement(quantityInput).getAttribute("value");
	        return Integer.parseInt(qtyValue);
	    }

}
