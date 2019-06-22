package com.POMDemo.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.POMDemo.helper.browserConfiguration.config.objectReader;
import com.POMDemo.helper.logger.loggerHelper;
import com.POMDemo.pageObject.loginPage;
import com.POMDemo.testBase.testBase;

public class loginTest extends testBase{
	
	public static final Logger log = loggerHelper.getLogger(loginTest.class);
	
	@Test
	public void testLoginToApplication() {
		
		getApplicationUrl(objectReader.reader.getUrl());
		loginPage loginPage= new loginPage(driver);
		loginPage.loginToApplication(objectReader.reader.getUsername(), objectReader.reader.getPassword());
		
		
	}

}
