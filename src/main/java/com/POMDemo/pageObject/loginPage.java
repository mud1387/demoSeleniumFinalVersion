package com.POMDemo.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.POMDemo.helper.wait.*;

import com.POMDemo.helper.assertion.assertionHelper;
import com.POMDemo.helper.logger.loggerHelper;

public class loginPage {
	
	private WebDriver driver;

	waitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	public loginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new waitHelper(driver);
		waitHelper.waitForElementVisibleWithPollingTime(signIn, 20, 500);
		
	}
	
	public void clickOnSignInLink() {
		signIn.click();
	}
	
	public void clickOnSubmitBtn() {
		submitButton.click();
	}
	
	public void enterEmailAddress(String email) {
		loginEmailAddress.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		loginPassword.sendKeys(pwd);
	}
	
	public void loginToApplication(String email, String pwd) {
		clickOnSignInLink();
		enterEmailAddress(email);
		enterPassword(pwd);
		clickOnSubmitBtn();
	}
}
