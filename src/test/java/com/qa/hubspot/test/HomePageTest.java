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
import com.qa.HubSpot.Utils.Constants;
import com.qa.HubSpot.Utils.TimeUtils;

public class HomePageTest {
	
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	
	public void SetUp()  {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_browser(prop);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		TimeUtils.MediumWait();
		homepage = loginpage.DoLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		}
	
	@Test
	
	public void VerifyHomePageTitle() {
		String Title = homepage.getHomePageTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, Constants.Home_Page_Title);
	}
	
	@Test
	
	public void VerifyHomePageHeader() {
		String Header = homepage.getHomePageHeader();
		System.out.println(Header);
		Assert.assertEquals(Header, Constants.Home_Page_Header);
	}
	
	@Test
	
	public void VerifyLoggedInAccountName() {
		String acctname = homepage.getLoggedInAccountName();
		System.out.println(acctname);
		Assert.assertEquals(acctname, prop.getProperty("AccountName"));
	}
	

	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}
	
}
