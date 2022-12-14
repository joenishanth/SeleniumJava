package com.seleniumJava.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumJava.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() {
		
		String expectedTitle = "Guru99 Bank Manager HomePage";
		
		driver.get(readConfig.getBaseUrl());
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		
		String originalTitle = driver.getTitle();		
		Assert.assertEquals(originalTitle, expectedTitle);
		
		logger.info("Test case: 001 is successfully executed");
	
	}

}
