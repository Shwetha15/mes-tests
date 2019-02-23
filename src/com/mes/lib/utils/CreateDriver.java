package com.mes.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver {
	
	public static WebDriver getDriverInstance()
	{
		WebDriver driver=null;
		String browser=GetData.fromProperties("configuration", "browser");
		String url=GetData.fromProperties("configuration", "url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./browser-exe/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
	
			System.setProperty("Webdriver.gecko.driver", "./browser-exe/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("Webdriver.ie.driver", "./browser-exe/iedriver.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.err.println("----Invalid browser option please check"+"the value in configuration.properties file---");
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(url.equalsIgnoreCase("test"))
		{
			String test_url = GetData.fromProperties("configuration", "test_url");
			driver.get(test_url);
		}
		
		else if(url.equalsIgnoreCase("prod"))
		{
			String prod_url = GetData.fromProperties("configuration", "prod-url");
			driver.get(prod_url);
		}
		
		return driver;
		
	}


}
