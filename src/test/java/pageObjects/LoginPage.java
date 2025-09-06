package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement lgnEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement lgnPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement lgnbutton;
	
	public void setEmail(String email) {
		lgnEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		lgnPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		lgnbutton.click();
	}

}
