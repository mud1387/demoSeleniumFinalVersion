package com.POMDemo.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.POMDemo.helper.logger.loggerHelper;

public class waitHelper {

	private WebDriver driver;
	
	private Logger log=loggerHelper.getLogger(waitHelper.class);
	
	public waitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setImplicitWait(long timeOut, TimeUnit unit) {
		
		driver.manage().timeouts().implicitlyWait(timeOut, unit);
		log.info("Implicit Wait has been set to "+ timeOut);
		
	}
	
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryMilliSec) {
		
		WebDriverWait wait= new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryMilliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	public void waitForElementVisibleWithPollingTime(WebElement element, int timeOutInSec, int pollingEveryMilliSec) {
		
		log.info("Waiting for element "+ element.toString()+"for :"+timeOutInSec);
		WebDriverWait wait=getWait(timeOutInSec, pollingEveryMilliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now");
	}
	
	public void waitForElementClickable(WebElement element, int timeOutInSec, int pollingEveryMilliSec) {
		
		log.info("Waiting for element "+ element.toString()+"for :"+timeOutInSec);
		WebDriverWait wait= new WebDriverWait(driver, timeOutInSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clickable now");
	}
	
	public void pageLoadTime(long timeOutInSec, TimeUnit unit) {
		
		log.info("Waiting for page to load for  "+ timeOutInSec+"for :"+unit);
		driver.manage().timeouts().pageLoadTimeout(timeOutInSec, unit);
		log.info("Page is loaded");
	}
}
