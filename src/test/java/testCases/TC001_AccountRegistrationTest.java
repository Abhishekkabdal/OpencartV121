package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		

		logger.info("*******Starting TC001_AccountRegistrationTest************");

		try {

			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link.....");
			hp.clickRegister();
			logger.info("Clicked on Register Link.....");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			// -----------------------Dynamically generated data
			// --------------------------//
			logger.info("Providing Customer Details.....");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com"); // random or dynamically generated email
			regpage.setTelephone(randomNumber());

			// String password=randomAlphaNumeric();

			regpage.setPassword(randomAlphaNumeric());
			

			regpage.subscribe();
			// regpage.setConfirmPassword("Elee@123");

			//// input[@name='newsletter'][2]

			regpage.setPrivacyPolicy();

			regpage.clickContinue();

			logger.info("Validating expected message.....");
			
			

			String confmsg = regpage.getConfirmationMsg();
			

			Assert.assertEquals(confmsg, "Your Account Has Been Created!");// Your Account Has Been Created!

		} catch (Exception e) {
			
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.fail();

		}
		
		logger.info("*****Finished TC001_AccountRegistrationTest*******");

	}

}
