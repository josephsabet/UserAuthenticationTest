package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

	WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    By skuLocator = By.cssSelector("div.sku span.value");

    public String getProductSKU() {
        return driver.findElement(skuLocator).getText();
    }
}
