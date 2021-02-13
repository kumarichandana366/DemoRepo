package com.demo.qa.utils;

import com.demo.qa.base.Testbase;

public class TestUtil extends Testbase{
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPICIT_WAIT=30;
	
	public void  switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
}
