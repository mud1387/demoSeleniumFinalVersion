package com.POMDemo.helper.resource;

public class resourceHelper {
	
	public static String getResourcePath(String path) {
		String basePath= System.getProperty("user.dir");
		System.out.println(basePath);
		return basePath+path;
	}
	

}
