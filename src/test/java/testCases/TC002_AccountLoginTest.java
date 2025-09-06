package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_account_login() {
		
		try {
			logger.info("*****Starting TC_002_AccountLoginTest**********");
			
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login
			LoginPage lgnpage = new LoginPage(driver);
			lgnpage.setEmail(p.getProperty("email"));
			lgnpage.setPassword(p.getProperty("password"));
			lgnpage.clickLogin();
			
			//MyAccount Page
			MyAccountPage macc=new MyAccountPage(driver);
			Boolean targetPage=macc.isMyAccountPageExists();
			
			//Logout 
			macc.clickLogout();
			
			//Assert.assertEquals(targetPage, true,"Login failed"); // compare first two parameters if pass & if failed pass 3rd parameter.
			Assert.assertTrue(targetPage);
			
			
			
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*********Finished TC_002_LoginTest**********");
		
		
		
		
		
		
	}
	

}
