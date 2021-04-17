package com.athmatest.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.athmatest.qa.base.NewTestBase;
import com.athmatest.qa.pages.HomePage;
import com.athmatest.qa.pages.LoginPage;



public class Sample1Test extends NewTestBase {
   LoginPage lp ;
   HomePage hp;
	public Sample1Test() throws IOException {
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
		
	}
	@Test(priority = 2)
	public void mySecondTest() {
		System.out.println("mySecondTest");
		System.out.println(hp.getHomePageTitle());
	}
	@Test(priority = 3)
	public void myThirdTest() {
		System.out.println("myThirdTest");
		System.out.println(hp.getHomePageTitle());
	}
	@Test(priority = 4)
	public void myFourthTest() {
		System.out.println("myFourthTest");
		System.out.println(hp.getHomePageTitle());
	}
	
	

}

