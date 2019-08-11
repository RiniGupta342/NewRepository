package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.HubSpot.Pages.BasePage;
import com.qa.HubSpot.Pages.ContactsPage;
import com.qa.HubSpot.Pages.HomePage;
import com.qa.HubSpot.Pages.LoginPage;
import com.qa.HubSpot.Pages.LoginPageBy;
import com.qa.HubSpot.Utils.Constants;
import com.qa.HubSpot.Utils.ExcelUtils;
import com.qa.HubSpot.Utils.TimeUtils;

public class ContactsPageTest {
	
	
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	

	@BeforeMethod
	
	public void SetUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_browser(prop);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		TimeUtils.MediumWait();
		homepage = loginpage.DoLogin(prop.getProperty("username"), prop.getProperty("password"));
		TimeUtils.LongWait();
	    contactspage = homepage.GoToContactsPage();
		}
	
//	@Test
//	
//	public void VerifyContactsPageHeader() {
//		String header = contactspage.getContactsPageHeader();
//		System.out.println(header);
//		Assert.assertEquals(header, Constants.Contacts_Page_Header);
//	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object contactsdata[][] = ExcelUtils.getsheetdata("contacts");
		return contactsdata;
	}
	
	@Test(dataProvider = "getContactsTestData")
	
	public void createcontactsdata(String email, String firstName, String Lastname, String jobtitle) {
		contactspage.CreateNewContact(email, firstName, Lastname, jobtitle);
	}
	
	
	
	@AfterMethod
	
	public void TearDown() {
		driver.quit();
	}
}
