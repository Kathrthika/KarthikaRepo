package com.athmatest.qa.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.athmatest.qa.base.NewTestBase;

public class CommonUtils extends NewTestBase{
	
	public static long common_Wait = 30;

	public CommonUtils() throws IOException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public  void commonWait1(WebElement ele) {
	WebDriverWait wait = new WebDriverWait(driver, common_Wait);
	wait.until(ExpectedConditions.invisibilityOf(ele));
	
	
	
	} 
	
	
	

}
