package com.athmatest.qa.pages;

import java.io.IOException;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestNGUtils;

import com.athmatest.qa.base.NewTestBase;
import com.athmatest.qa.utils.CommonUtils;

public class LoginPage extends NewTestBase {
	
		
	
	@FindBy(id = "username")
	WebElement userNamefield;
	@FindBy(id = "password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement sign_in_Btn;
	public LoginPage( )  throws IOException{
		//super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	public String loginPageTitleTest() throws InterruptedException {
		commonSleep();
		return driver.getTitle();
	}
	
	
	public void enterUserName(String un, String password) throws InterruptedException {	
		
		System.out.println(un+ " "+password);
		//System.out.println("test1");
		commonWait(userNamefield);
		userNamefield.sendKeys(un);
		passwordfield.sendKeys(password);
		sign_in_Btn.click();
		commonSleep();
	}
   
	
	
}
