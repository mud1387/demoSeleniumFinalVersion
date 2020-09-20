package com.POMDemo.helper.browserConfiguration.config;

import com.POMDemo.helper.browserConfiguration.browserType;

public interface configReader {

	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public browserType getBroserType();
	public String getUrl();
	public String getFirstName();
	public String getLastName();
	
}
