package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

// Data is valid -- login success - test pass - logout
// Data is valid -- login failed - test fail
// Data is invalid -- login success -- test fail - logout
// Data is invalid -- login failed --test pass


//DDT - Data driven tesrtr case
public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven" ) //dataProviderClass=DataProvider.class written bcz DataProviderClass is inside another package, Not wriiten within same class
	public void verify_loginDDT(String email, String pwd, String exp) throws  InterruptedException {
		
		logger.info("**********Starting TC_003_LoginDDT***************");
		
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lgnpage = new LoginPage(driver);
		lgnpage.setEmail(email);
		lgnpage.setPassword(pwd);
		lgnpage.clickLogin();
		
		//MyAccount Page
		MyAccountPage macc=new MyAccountPage(driver);
		Boolean targetPage=macc.isMyAccountPageExists();
		
		// Data is valid -- login success - test pass - logout
		//                  login failed - test fail
		// Data is invalid -- login success -- test fail - logout
		//                    login failed --test pass
		
	try {
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	}catch(Exception e){
			Assert.fail();
		}
		
		logger.info("*********Finishing TC_003_LoginDDT*************");
		
	}
	

}
