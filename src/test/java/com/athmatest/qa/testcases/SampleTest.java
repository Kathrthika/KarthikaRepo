package com.athmatest.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.athmatest.qa.ExtentReportListener.CustomListener;
import com.athmatest.qa.base.NewTestBase;
import com.athmatest.qa.pages.HomePage;
import com.athmatest.qa.pages.LoginPage;


@Listeners(CustomListener.class)
public class SampleTest extends NewTestBase {
   LoginPage lp ;
   HomePage hp;
	public SampleTest() throws IOException {
		super();
	
	}
	
	
	
	
	@Test(priority = 1)
	public void myFirstTest() throws IOException {
		System.out.println("myFirstTest");
	    hp = new HomePage();
	    
		System.out.println(hp.getHomePageTitle());
		assertEquals(false, false);
		
		
	}
	@Test(priority = 2)
	public void mySecondTest() throws InterruptedException {
		System.out.println("mySecondTest");
		System.out.println(hp.getHomePageTitle());
		hp.openRegistrationPage();
		assertEquals(false, false);
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
		assertEquals(false, true);
	}
	

}
