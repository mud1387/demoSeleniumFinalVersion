package com.POMDemo.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.POMDemo.helper.browserConfiguration.browserType;
import com.POMDemo.helper.browserConfiguration.chromeBrowser;
import com.POMDemo.helper.browserConfiguration.config.objectReader;
import com.POMDemo.helper.browserConfiguration.config.propertyReader;
import com.POMDemo.helper.logger.loggerHelper;
import com.POMDemo.helper.wait.waitHelper;

public class testBase {
	
	public WebDriver driver;

	
	@BeforeTest
	public void beforeTest() throws Exception {
		objectReader.reader= new propertyReader();
		setupDriver(objectReader.reader.getBroserType());
	}
	
	/*
	 * @AfterTest public void afterTest() { driver.close(); System.exit(0); }
	 */

	public WebDriver getBrowserObject(browserType btyp) throws Exception {
		
		try {
			
			switch(btyp) {
			case Chrome:
				chromeBrowser chrome= new chromeBrowser();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);	
			default:
				throw new Exception(btyp.name());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	public void setupDriver(browserType btyp) throws Exception {
		
		
		
		driver=getBrowserObject(btyp);
		waitHelper wait= new waitHelper(driver);
		wait.setImplicitWait(objectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(objectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void getApplicationUrl(String url) {
		
		driver.get(url);
		
	}
}
