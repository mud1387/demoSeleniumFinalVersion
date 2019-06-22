package com.POMDemo.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.POMDemo.helper.logger.loggerHelper;
import com.POMDemo.helper.wait.waitHelper;

public class frameHelper {
	
	private WebDriver driver;
	
	private Logger log=loggerHelper.getLogger(frameHelper.class);
	
	public frameHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		log.info("Switched to :"+ index+ "frame");
	}

	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
		log.info("Switched to :"+ name+ "frame");
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switched to :"+ element.toString());
	}
	
}
