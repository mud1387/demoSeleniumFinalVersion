package com.POMDemo.helper.verification;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.POMDemo.helper.javaScript.javaScriptHelper;
import com.POMDemo.helper.logger.loggerHelper;

public class verificationHelper {

	private WebDriver driver;
	
	private Logger log=loggerHelper.getLogger(verificationHelper.class);
	
	public verificationHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isDisplayed(WebElement element) {
		
		try {
			
			element.isDisplayed();
			log.info("Element is displayed "+element.getText());
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Element is not present "+e.getCause());
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element) {
		
		try {
			
			element.isDisplayed();
			log.info("Element is displayed ");
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Element is not present ");
			return true;
		}
	}
	
	public String getText(WebElement element) {
		
		if (element==null) {
			return null;
		}
		if(isDisplayed(element)) {
			return element.getText();
		}
		return null;
		
	}
}

