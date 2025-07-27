package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	
	 WebDriver driver;

	    public RegisterPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By genderMale = By.id("gender-male");
	    By firstName = By.id("FirstName");
	    By lastName = By.id("LastName");
//	    By day = By.name("DateOfBirthDay");
//	    By month = By.name("DateOfBirthMonth");
//	    By year = By.name("DateOfBirthYear");
	    By email = By.id("Email");
	    By password = By.id("Password");
	    By confirmPassword = By.id("ConfirmPassword");
	    By registerButton = By.id("register-button");
	    By successMessage = By.className("result");

	    // Actions
	    public void register(String fname, String lname, String emailText, String pwd) {
	        driver.findElement(genderMale).click();
	        driver.findElement(firstName).sendKeys(fname);
	        driver.findElement(lastName).sendKeys(lname);
//	        driver.findElement(day).sendKeys("1");
//	        driver.findElement(month).sendKeys("May");
//	        driver.findElement(year).sendKeys("1990");
	        driver.findElement(email).sendKeys(emailText);
	        driver.findElement(password).sendKeys(pwd);
	        driver.findElement(confirmPassword).sendKeys(pwd);
	        driver.findElement(registerButton).click();
	    }
	    
	    public String getSuccessMessageText() {
	        return driver.findElement(successMessage).getText();
	    }

	    public String getSuccessMessageColor() {
	        WebElement msg = driver.findElement(successMessage);
	        return msg.getCssValue("color");  // returns RGBA format
	    }

//	    public String getSuccessMessage() {
//	        return driver.findElement(successMessage).getText();
//	    }

}
