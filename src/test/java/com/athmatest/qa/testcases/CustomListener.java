package com.athmatest.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.athmatest.qa.base.NewTestBase;

public class CustomListener extends NewTestBase implements ITestListener{

	public CustomListener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	 public void onTestStart(ITestResult result) {
		    // not implemented
		 System.out.println("onTestStart");
		  }

	 public	void onTestSuccess(ITestResult result) {
		    // not implemented
		 System.out.println("onTestSuccess");
		}
		 
	 public void onTestFailure(ITestResult result) {
		    // not implemented
		 System.out.println("Failed Test case from listenner");
		 takeScreeShot(result.getMethod().getMethodName());
		  }

	
	 public void onTestSkipped(ITestResult result) {
		    // not implemented
		 System.out.println("onTestSkipped");
		  }

	

}
