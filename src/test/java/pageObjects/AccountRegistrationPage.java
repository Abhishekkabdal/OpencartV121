package pageObjects;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Page object Class-2

public class AccountRegistrationPage extends BasePage {
	// WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLasttname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement radiosubscribe;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1 [normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLasttname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}

	public void setPassword(String pwd) {
		String cp=pwd;
		setConfirmPassword(cp);
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}
	
	
	
	public void subscribe() {
		try {
			radiosubscribe.click();
		} catch(ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radiosubscribe);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radiosubscribe);
		}

		
	}

//	public void setConfirmPassword(String pwd) {
//		txtConfirmPassword.sendKeys(pwd);
//	}

	public void setPrivacyPolicy() {
		try {
			chkdPolicy.click();
		} catch(ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chkdPolicy);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkdPolicy);
		}
		
	}

	public void clickContinue() {

		// sol1
		
		
		//btnContinue.click();

		// sol2
//		 btnContinue.submit();

		// sol3
		// Actions act=new Actions(driver);
		// act.moveToElement(btnContinue).click().perform();

		// sol4
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", btnContinue);

		// Sol 5
		// btnContinue.sendKeys (Keys.RETURN);

		// Sol 6
		// WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds (10));
		// mywait.until (Expected Conditions.elementToBeClickable
		// (btnContinue)).click();

	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

}