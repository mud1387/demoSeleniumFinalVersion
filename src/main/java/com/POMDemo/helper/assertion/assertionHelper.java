package com.POMDemo.helper.assertion;

import org.testng.Assert;

import com.POMDemo.helper.logger.loggerHelper;


public class assertionHelper {

	
	public static void verifyText(String s1, String s2) {
		
		Assert.assertEquals(s1, s2);
		
	
	}
	
	public static void verifyTrue() {
		
		Assert.assertTrue(true);
	
	}
	
	public static void verifyTrue(String msg) {
		
		Assert.assertTrue(true,msg);
	
	}
}
