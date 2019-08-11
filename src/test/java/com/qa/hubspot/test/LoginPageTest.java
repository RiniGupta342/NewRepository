package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.HubSpot.Pages.BasePage;
import com.qa.HubSpot.Pages.LoginPage;
import com.qa.HubSpot.Utils.Constants;
import com.qa.HubSpot.Utils.TimeUtils;

public class LoginPageTest   {
	
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	
	@BeforeMethod
	
	public void SetUp() throws InterruptedException {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_browser(prop);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		TimeUtils.MediumWait();
		}
	
	
	@Test
	
	public void VerfiyLoginPageTitleTest() {
		String Title = loginpage.getLoginPageTitle();
		System.out.println("Login Page Title is :" + Title);
		Assert.assertEquals(Title, Constants.Login_Page_Title);
		
	}
	
	@Test 
	
	public void VerfiySignUpLink() {
		boolean b = loginpage.VerifySignUpLink();
		System.out.println(b);
		Assert.assertTrue(b);
	}
	
	@Test
	
	public void TestCheckBox() {

		boolean b = loginpage.clickCheckBox();
		Assert.assertEquals(false, b);
		
	}
	
	@Test
	
	public void VerfiyDoLogin() {
		loginpage.DoLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
