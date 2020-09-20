package com.POMDemo.helper.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.POMDemo.helper.wait.waitHelper;

public class frameHelper {
	
	private WebDriver driver;
	
	
	public frameHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
	
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);

	}
	
}
