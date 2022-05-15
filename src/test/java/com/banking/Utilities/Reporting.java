package com.banking.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting {

	public static ExtentReports extentReports;
	
	public static ExtentReports getExtentReports() {
		String path = System.getProperty("user.dir")+"./reports//index.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("WebAutomation report");
		extentSparkReporter.config().setDocumentTitle("Selenium Test");
		
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Sandeep");
		return extentReports;
	}
	
}
