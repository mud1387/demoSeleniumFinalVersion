package com.POMDemo.helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.POMDemo.helper.logger.loggerHelper;


public class assertionHelper {

	private Logger log=loggerHelper.getLogger(assertionHelper.class);
	
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
