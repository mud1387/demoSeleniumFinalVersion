package com.POMDemo.helper.window;

import java.util.Set;

import org.openqa.selenium.WebDriver;



public class windowHelper {

	private WebDriver driver;
	
	
	public windowHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToParentWindow() {
		
		driver.switchTo().defaultContent();
	}
	
	public void switchToWindow(int index) {
	
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
