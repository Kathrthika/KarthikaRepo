package com.athmatest.qa.ExtentReportListener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzertest implements IRetryAnalyzer {
   
	
	int count = 0 ; 
	int maxcount = 2;
	public RetryAnalyzertest() {
		// TODO Auto-generated constructor stub
		
		
	}

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxcount) {
			System.out.println("Retring "+result.getName()+" again and count is "+(count+1));
			count++;
			return true;
		}
		
		return false;
	}

}
