package com.mes.test.regression.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mes.lib.ui.LoginPage;
import com.mes.lib.utils.CreateDriver;
import com.mes.lib.utils.GetData;

public class TestLoginU13456 {
	
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preCondition()
	{
		driver=CreateDriver.getDriverInstance();
		login=new LoginPage(driver);
		
	}
	
	@AfterMethod
	public void postCondition()
	{
      driver.close();
	}
  @Test
public void testLoginInvalidTC134579() {
	  
	  String username=GetData.fromExcel("data", "TC134579", 1, 0);
	  String password=GetData.fromExcel("data", "TC134579", 1, 1);
	  
	  login.waitForLoginPageToLoad();
	  login.getUserNameTextBox().sendKeys(username);
	  login.getPasswordTextBox().sendKeys(password);
	  login.getLoginButton().click();
	  String acterrmsg=login.getLoginErrorMsg().getText();
	  String experrmsg="Username or Password is invalid. Please try again.";
	  Assert.assertEquals(acterrmsg, experrmsg);
  }

}
