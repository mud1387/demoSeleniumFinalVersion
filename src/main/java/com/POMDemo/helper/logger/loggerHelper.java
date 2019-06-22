package com.POMDemo.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.POMDemo.helper.resource.resourceHelper;

public class loggerHelper {
	
	private static boolean root= false;
	
	public static Logger getLogger(Class cls) {
		
		if(root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(resourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\log4j.properties"));
		root=true;
		return Logger.getLogger(cls);
	}
	
	
	  public static void main(String[] args) {
	  
		  Logger
	  log=loggerHelper.getLogger(loggerHelper.class);
	  log.info("Logger is configured"); log.info("Logger is configured");
	  log.info("Logger is configured"); 
	  
	  }
	  
	 

}
