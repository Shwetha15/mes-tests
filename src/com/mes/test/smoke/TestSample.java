package com.mes.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mes.lib.utils.CreateDriver;

public class TestSample {
	
	WebDriver driver;
	
	   @BeforeMethod
		public void preCondition()
		{
			driver=CreateDriver.getDriverInstance();
		}
		
		@AfterMethod
		public void postCondition()
		{
		driver.close();
		}
		
		@Test
		public void test_sample()
		{
			String actTitle=driver.getTitle();
			System.out.println(actTitle);
			String expTitle="actiTIME - Login";
			Assert.assertEquals(actTitle, expTitle);
			
		}
	


}
