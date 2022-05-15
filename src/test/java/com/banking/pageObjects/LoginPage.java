package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

		public WebDriver driver;
		
		public LoginPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	
		@FindBy(name = "uid")
		WebElement userId;
		
		@FindBy(name = "password")
		WebElement pwd;
		
		@FindBy(name = "btnLogin")
		WebElement submitButton;
		
		
		public void setUserName(String userName) {
			userId.sendKeys(userName);
		}
		public void setPassword(String password) {
			pwd.sendKeys(password);
		}
		public void clickSubmit() {
			submitButton.click();
		}

}
