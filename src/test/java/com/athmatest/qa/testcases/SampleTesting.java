package com.athmatest.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.athmatest.qa.base.NewTestBase;
import com.athmatest.qa.pages.HomePage;
import com.athmatest.qa.pages.LoginPage;



public class SampleTesting extends NewTestBase {
   LoginPage lp ;
   HomePage hp;
	public SampleTesting() throws IOException {
		super();
	
	}
	
	
	/*
	 * @BeforeMethod public void loginToTheApplication() throws IOException,
	 * InterruptedException { //intialization(); lp = new LoginPage();
	 * 
	 * String userId = prop.getProperty("userName"); String userPass =
	 * prop.getProperty("passWord");
	 * System.out.println(("Before method "+userId+" "+userPass)); //lp = new
	 * LoginPage(); lp.enterUserName(userId, userPass); Thread.sleep(4000); hp = new
	 * HomePage(); }
	 * 
	 * @AfterMethod public void logOutFromTheApplication() throws IOException {
	 * System.out.println("Loging Out from the application");
	 * 
	 * hp.logOutFromApplication();
	 * 
	 * 
	 * }
	 */
	
	@Test(priority = 1)
	public void myFirstTest() throws IOException {
		System.out.println("myFirstTest");
	    hp = new HomePage();
	    
		System.out.println(hp.getHomePageTitle());
		assertEquals(false, true);
		
		
	}
	@Test(priority = 2)
	public void mySecondTest() throws InterruptedException {
		System.out.println("mySecondTest");
		System.out.println(hp.getHomePageTitle());
		hp.openRegistrationPage();
		assertEquals(false, true);
		commonSleep();
	}
	@Test( priority = 3)
	public void myThirdTest() throws InterruptedException {
		System.out.println("myThirdTest");
		hp.openInvoicePage();
		commonSleep();
		assertEquals(false, true);
	}
	@Test( priority = 4)
	public void myFourthTest() throws InterruptedException {
		System.out.println("myFourthTest");
		hp.openReceiptPage();
		commonSleep();
		assertEquals(false, false);
	}
	

}
