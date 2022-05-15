package com.banking.testCases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;



public class TC_LoginCheck_001 extends BaseClass{

	private Logger log = LogManager.getLogger(TC_LoginCheck_001.class);
		
		@Test
		public void loginCheck() {
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setUserName(userName);
			log.info("Entered username");
			loginPage.setPassword(password);
			log.info("Password Entered");
			loginPage.clickSubmit();
			log.info("Cicked on submit button");
			
		}
		
		@Test
		public void titleCheck() {
			String expected = "Guru99 Bank Home Page";
			String actual = driver.getTitle();
			if(expected.equals(actual)) {
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		
		}
}
