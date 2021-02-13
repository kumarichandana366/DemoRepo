package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.base.Testbase;
//Page Factory/object repository
public class LoginPage extends Testbase {

	//@findby is use to create Page Factory/object repository
	@FindBy(xpath="//input[@class='form-control'and @name='username']")
	WebElement usernamebutton;
	
	@FindBy(xpath="//input[@class='form-control'and @name='password']")
	WebElement passwordbutton;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement demo;
	
	//to initialize webelements with help of page factory-constructor is created,initElements : driver will be initialized with driver
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	public  HomePage login(String un,String pwd) {
		usernamebutton.sendKeys(un);
		passwordbutton.sendKeys(pwd);
		loginbutton.click();
		return new HomePage();
		
	}
	
	public boolean  validateuser()
	{
		return demo.isDisplayed();
	}
	
}
