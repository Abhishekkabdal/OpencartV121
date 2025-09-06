package pageObjects;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") // added in step 6
	WebElement InkLogout;
	
	public boolean isMyAccountPageExists() {
		try {
			return(msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() throws InterruptedException{
		System.out.println("Logging out");
		Thread.sleep(3000);
		try {
			System.out.println("Logout successfully");
			InkLogout.click();
			
		} catch(ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",InkLogout );
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",InkLogout );
		}
	}
		
	
}
