package com.banking.Utilities;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.banking.testCases.BaseClass;

public class Listeners extends BaseClass implements ITestListener {
	private Logger log = LogManager.getLogger(Listeners.class);
	ExtentTest test;
	ExtentReports extent = Reporting.getExtentReports();
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();//used for thread safe when running in parallel execution
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test = extent.createTest(result.getMethod().getMethodName());
		threadLocal.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println(threadLocal.get().pass("Test got passed"));
		log.info("sample testcase passed");
		}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.error("Login_check testcase Failed");
		threadLocal.get().fail(result.getThrowable());
		WebDriver driver=null ;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch(Exception e) {
			
		}
		try {
			
			getScreenshot(testMethodName);
			threadLocal.get().addScreenCaptureFromPath(getScreenshot(testMethodName), result.getMethod().getMethodName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
