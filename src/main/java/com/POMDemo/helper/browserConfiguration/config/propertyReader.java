package com.POMDemo.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.POMDemo.helper.browserConfiguration.browserType;
import com.POMDemo.helper.resource.resourceHelper;

public class propertyReader implements configReader {
	
	private static Properties OR;
	private static FileInputStream file;
	
	public propertyReader()
	 {
		
		try {
			String filePath= resourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\config.properties");
			file= new FileInputStream(new File(filePath));
			OR= new Properties();
			OR.load(file);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int getImplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public browserType getBroserType() {
		// TODO Auto-generated method stub
		return browserType.valueOf(OR.getProperty("browsertype"));
		
	}

	public String getUrl() {
		// TODO Auto-generated method stub
		return OR.getProperty("url");
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return OR.getProperty("username");
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return OR.getProperty("password");
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return OR.getProperty("firstName");
		
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return OR.getProperty("lastName");
		
	}
	

	
}
