package com.seleniumJava.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig(){
		File src = new File("./configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getBaseUrl() {
		return pro.getProperty("baseUrl");
	}
	
	public String getUserName() {
		String userName = pro.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		return pro.getProperty("password");
	}
	
	public String getChromeDriverPath() {
		return pro.getProperty("chromeDriver");
	}
	

}
