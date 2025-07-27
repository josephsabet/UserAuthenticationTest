package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	 WebDriver driver;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By emailField = By.xpath("//*[@id=\"Email\"]");
	    By passwordField = By.id("Password");
	    By loginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
	    By errorMessage = By.cssSelector("div.message-error.validation-summary-errors");
	    By myAccountLink = By.className("ico-account");

	    // Actions
	    public void enterEmail(String email) {
	        driver.findElement(emailField).clear();
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).clear();
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }

	    public String getErrorMessageText() {
	        return driver.findElement(errorMessage).getText();
	    }

	    public String getErrorMessageColor() {
	        WebElement error = driver.findElement(errorMessage);
	        return error.getCssValue("color");
	    }

	    public boolean isMyAccountVisible() {
	        return driver.findElement(myAccountLink).isDisplayed();
	    }
 
}
