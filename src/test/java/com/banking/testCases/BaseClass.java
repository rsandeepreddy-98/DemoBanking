package com.banking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.banking.Utilities.ReadConfig;

public class BaseClass {

	private Logger log = LogManager.getLogger(BaseClass.class);
	
	ReadConfig readConfig = new ReadConfig();
	public String url = readConfig.getApplicationUrl();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();

	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		driver = new ChromeDriver();
		log.info("ChromrDriver opened");
		driver.get(url);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public static String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"./Screenshots//"+testCaseName+".png";
		FileUtils.copyFile(sourceFile, new File(destinationFile));
		return destinationFile;
	}

}
