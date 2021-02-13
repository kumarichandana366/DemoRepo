package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.base.Testbase;

public class HomePage extends Testbase {
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement demouser;

	

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsbutton;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean  demo()
	{
		return demouser.isDisplayed();
		
	}
	
	public void contacts()
	{
		demouser.click();
		
	}
}
