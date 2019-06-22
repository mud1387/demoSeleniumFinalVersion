package com.POMDemo.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.POMDemo.helper.logger.loggerHelper;

public class windowHelper {

	private WebDriver driver;
	
	private Logger log=loggerHelper.getLogger(windowHelper.class);
	
	public windowHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToParentWindow() {
		log.info("Switching to parent window");
		driver.switchTo().defaultContent();
	}
	
	public void switchToWindow(int index) {
		log.info("Switching to parent window");
		Set<String> windows= driver.getWindowHandles();
		int i=1;
		for (String window : windows) {
			
			if (i==index) {
				
				driver.switchTo().window(window);
			}
			else {
				i++;
			}
		}
	}
	
	public void closeAllTabsAndSwitchToMainWindow() {
		
		Set<String> windows= driver.getWindowHandles();
		String mainWindow= driver.getWindowHandle();
		for (String window : windows) {
			
			if (!window.equalsIgnoreCase(mainWindow)) {
				
				driver.close();
			}
		}
		
		driver.switchTo().window(mainWindow);
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}
}
