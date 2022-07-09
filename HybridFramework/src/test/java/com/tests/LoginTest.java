package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

public class LoginTest extends BaseClass{
	
	LoginPage lp=null;
	
	@BeforeSuite
	public void setup() throws Exception {
		
		initialization();
		reportInit();
		lp=new LoginPage(driver);
	}
	@AfterSuite
	public void tearDown() {
		driver.close();
		report.flush();
		
	}
	
	@Test
	public void passTest() {
		
		lp.loginToApplication("kiran@gmail.com", "123456");
		
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		
	}
	
	@Test
	public void failTest() {
		
		Assert.assertTrue(false);
		
	}
	@Test
	public void skipTest() {
		
		throw new SkipException("Skipping a TestCase");
		
	}
	

}
