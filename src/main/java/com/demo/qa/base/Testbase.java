package com.demo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demo.qa.utils.TestUtil;



public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase() {
		try {
			prop= new Properties();
			FileInputStream ip = new FileInputStream("/Users/Chandana1/eclipse-workspace/freecrm1/src/main/java/com/demo/qa/config/config.Properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public  void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/Chandana1/Downloads/chromedriver");
			 driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdrivergecko.driver", "/Users/Chandana1/Downloads/geckodriver");
			 driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(TestUtil.IMPICIT_WAIT,TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));
	}
	
}
