package com.banking.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.banking.testCases.BaseClass;

public class ReadConfig  {

	public Properties properties;


	public ReadConfig()  {
		try {	
			FileInputStream fileInputStream = new FileInputStream("./Configurations/config.properties");
			
			properties = new Properties();

			properties.load(fileInputStream);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}

	}

	public String getApplicationUrl() {
		String url  = properties.getProperty("url");
		return url;
	}
	public String getUserName() {
		String userName  = properties.getProperty("userName");
		return userName;
	}
	public String getPassword() {
		String password  = properties.getProperty("password");
		return password;
	}
	public String getChromePath() {
		String chromepath  = properties.getProperty("chromepath");
		return chromepath;
	}
	
}