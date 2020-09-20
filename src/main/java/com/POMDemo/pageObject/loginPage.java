package com.POMDemo.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.POMDemo.helper.wait.*;

import com.POMDemo.helper.assertion.assertionHelper;
import com.POMDemo.helper.javaScript.javaScriptHelper;
import com.POMDemo.helper.logger.loggerHelper;

public class loginPage {
	
	private WebDriver driver;

	waitHelper waitHelper;
	
	@FindBy(xpath="//*[@class='navTabButtonArrowDown']")
	WebElement operationDropDown;
	
	@FindBy(xpath="//*[@class='nav-rowLabel' and contains(text(),'Contacts')]")
	WebElement operationContact;
	
	
	  @FindBy(xpath="//li[@id='contact|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.contact.NewRecord']/span/a/span") 
	  WebElement operationNEW;
	 

	@FindBy(xpath="//*[@class='ms-crm-div-NotVisible' and contains(text(),'Create a new Contact record. ')]")
	WebElement operationOLD;
	 
	
	@FindBy(id="Full Name_label")
	WebElement operationFullNameClick;
	
	@FindBy(xpath="//*[@aria-describedby='fullname_compositionLinkControl_firstname_c']")
	WebElement operationFirstNameClick;
	
	@FindBy(xpath="//*[@aria-describedby='fullname_compositionLinkControl_lastname_c']")
	WebElement operationLastNameClick;

	
	@FindBy(xpath="//*[@class='ui-button-text' and contains(text(),'Done')]")
	WebElement doneButton;
	
	public loginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new waitHelper(driver);
		//waitHelper.waitForElementVisibleWithPollingTime(operationFullNameClick, 20, 500);
		
	}
	
	public void clickOnoperationDropDownLink() {
		operationDropDown.click();
	}
	
	public void clickOnContactsLink() {
		operationContact.click();
	}
	
	public void clickOnNEWLink() {
	
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", operationNEW);
	}
	
	public void clickOnFullName() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", operationFullNameClick);
	}
	
	public void clickOnFirstName(String text) {
		operationFirstNameClick.click();
		operationFirstNameClick.sendKeys(text);
	}
	
	public void clickOnLastName(String text) {
		operationLastNameClick.click();
		operationLastNameClick.sendKeys(text);
	}
	
	public void clickOnDoneBtn() {
		doneButton.click();
	}
	
	
	public void loginToApplication(String firstName, String lastName) {
		clickOnoperationDropDownLink();
		clickOnContactsLink();
		clickOnNEWLink();
		driver.switchTo().frame(1);
	
		driver.findElement(By.xpath("xpath=//div[@id='fullname']/div")).click();
		
		//clickOnFullName();
		clickOnFirstName(firstName);
		clickOnLastName(lastName);
		clickOnDoneBtn();
	}
}
