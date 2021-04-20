package com.athmatest.qa.ExtentReportListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListenerClass implements IAnnotationTransformer {

	public RetryListenerClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzertest.class);
		
	}

}
