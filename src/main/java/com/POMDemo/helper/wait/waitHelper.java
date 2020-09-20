package com.POMDemo.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
	
	
	public waitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setImplicitWait(long timeOut, TimeUnit unit) {
		
		driver.manage().timeouts().implicitlyWait(timeOut, unit);
		
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

		WebDriverWait wait=getWait(timeOutInSec, pollingEveryMilliSec);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void waitForElementClickable(WebElement element, int timeOutInSec, int pollingEveryMilliSec) {
		
	
		WebDriverWait wait= new WebDriverWait(driver, timeOutInSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}
	
	public void pageLoadTime(long timeOutInSec, TimeUnit unit) {
		
	
		driver.manage().timeouts().pageLoadTimeout(timeOutInSec, unit);
	
	}
}
