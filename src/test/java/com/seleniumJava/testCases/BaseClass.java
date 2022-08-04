package com.seleniumJava.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.seleniumJava.utilities.ReadConfig;

public class BaseClass {
	
	public ReadConfig readConfig = new ReadConfig();
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	public String baseURL = readConfig.getBaseUrl();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();

	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",readConfig.getChromeDriverPath());
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
			logger.info(" Chrome Broswer is launched");
		}
		else {
			logger.error("Please pass the correct browser parameter: " + br);
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
