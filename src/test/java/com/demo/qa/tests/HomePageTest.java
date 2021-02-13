package com.demo.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.qa.base.Testbase;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LoginPage;
import com.demo.qa.utils.TestUtil;

public class HomePageTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		//loginPage=new LoginPage();//to call loginPage methods
	}
	
	
	
	@Test(priority=1)
	public void demo1() {
		homePage.contacts();
	}

	@Test(priority=2)
	public  void verifyUserName()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.demo());
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
