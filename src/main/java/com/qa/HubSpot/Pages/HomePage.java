package com.qa.HubSpot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.HubSpot.Utils.Constants;
import com.qa.HubSpot.Utils.TimeUtils;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//h1[@class = 'private-header__heading']")
	WebElement HomePageHeader;
	
	@FindBy(xpath = "//span[@class = 'account-name ']")
	WebElement AccountName;
	
	@FindBy(id = "nav-primary-contacts-branch")
	WebElement PrimaryContacts;
	
	@FindBy (id = "nav-secondary-contacts")
	WebElement SecondaryContacts;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle() {
		
		WebDriverWait wait = new WebDriverWait(driver, Constants.Default_Explicit_Wait);
		wait.until(ExpectedConditions.titleContains(Constants.Home_Page_Title));
		return driver.getTitle();
	}
	
	public String getHomePageHeader() {
		WebDriverWait wait = new WebDriverWait(driver,Constants.Default_Explicit_Wait);
		wait.until(ExpectedConditions.visibilityOf(HomePageHeader));
		return HomePageHeader.getText();
	}
	
	public String getLoggedInAccountName() {
		WebDriverWait wait =  new WebDriverWait(driver,Constants.Default_Explicit_Wait);
		wait.until(ExpectedConditions.visibilityOf(AccountName));
		return AccountName.getText();
	}
	
	public ContactsPage GoToContactsPage() {
		ClickOnContactsPage();
		return new ContactsPage(driver);
		
	}
    
	public void ClickOnContactsPage() {
		PrimaryContacts.click();
		TimeUtils.ShortWait();
		SecondaryContacts.click();
		
	}
}
