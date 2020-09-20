package com.POMDemo.helper.verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.POMDemo.helper.javaScript.javaScriptHelper;
import com.POMDemo.helper.logger.loggerHelper;

public class verificationHelper {

	private WebDriver driver;

	
	public verificationHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isDisplayed(WebElement element) {
		
		try {
			
			element.isDisplayed();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element) {
		
		try {
			
			element.isDisplayed();
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
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

