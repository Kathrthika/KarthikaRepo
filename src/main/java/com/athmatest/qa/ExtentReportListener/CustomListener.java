package com.athmatest.qa.ExtentReportListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.athmatest.qa.base.NewTestBase;
import com.athmatest.qa.utils.CommonUtils;

public class CustomListener extends NewTestBase implements ITestListener {

	public CustomListener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	  public  void onTestStart(ITestResult result) {
		    // not implemented
		  }
	  public  void onTestSuccess(ITestResult result) {
		    // not implemented
		  }

	  public  void onTestFailure(ITestResult result) {
		    // not implemented
		  System.out.println("Failed Test");
		  CommonUtils.takeScreenshotforfailed(result.getMethod().getMethodName());
		  }
	  public  void onTestSkipped(ITestResult result) {
		    // not implemented
		  }


	  public  void onStart(ITestContext context) {
	    // not implemented
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
	   * and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public  void onFinish(ITestContext context) {
	    // not implemented
	  }
}
