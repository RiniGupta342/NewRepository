package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.HubSpot.Pages.BasePage;
import com.qa.HubSpot.Pages.HomePage;
import com.qa.HubSpot.Pages.LoginPage;
import com.qa.HubSpot.Pages.LoginPageBy;
import com.qa.HubSpot.Utils.Constants;
import com.qa.HubSpot.Utils.TimeUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTestBy {
	
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LoginPageBy loginpageby;
	HomePage homepage;
	

	@BeforeMethod
	
	public void SetUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_browser(prop);
		driver.get(prop.getProperty("url"));
		loginpageby = new LoginPageBy(driver);
		TimeUtils.MediumWait();	}
	
	
	@Test (priority = 1, description = "Verify the login Page Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Check the login page title")
	
	public void GetPageTitle() {
	String title =	loginpageby.getLoginPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, Constants.Login_Page_Title);
	}
	
	@Test (priority = 2)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Check visibility of SignUp Link")
	
	public void SignUpLinkTest() {
		Boolean b = loginpageby.VerifySignUpLink();
		Assert.assertTrue(b);
	}
	
	
	@Test (priority = 2 )
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify the Home Page Title")
	
	public void VerifyDologin() {
		homepage = loginpageby.DoLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(homepage.getHomePageHeader(),Constants.Home_Page_Header);
		Assert.assertEquals(homepage.getHomePageTitle(), Constants.Home_Page_Title);
		
	}
	
	@AfterMethod
	
	public void TearDown() {
		driver.close();
	}
}
