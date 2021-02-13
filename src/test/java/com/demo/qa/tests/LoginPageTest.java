package com.demo.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.qa.base.Testbase;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LoginPage;

public class LoginPageTest extends Testbase {
	LoginPage loginPage;
	HomePage homePage;//homepage class reference variable
	
	//loginPageTest constructor is used to call Testbse class constructor
		public LoginPageTest() {
		super();
	}
		
		@BeforeMethod
		public void setUp()
		{
			initialization();
			//loginPage=new LoginPage();//to call loginPage methods
		}
		
		@Test(priority=1)
		public void loginPageTitleTest() {
			loginPage=new LoginPage();
			String title=loginPage.validateLoginPageTitle();
			Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
			
		}
		
		@Test(priority=2)
		public void loginTest() {
			homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		}

		@Test(priority=3)
		public void demo() {
			boolean flag= loginPage.validateuser();
			Assert.assertTrue(flag);
		}
		
		@AfterMethod
		public void closeBrowser()
		{
			driver.quit();
		}
		
}
