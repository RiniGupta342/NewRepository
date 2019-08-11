package com.qa.HubSpot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.HubSpot.Utils.Constants;
import com.qa.HubSpot.Utils.TimeUtils;

public class ContactsPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//h1[@class = 'private-header__heading']")
	WebElement Contactspageheader;
	
	@FindBy (xpath = "//span[text()= 'Create contact']")
	WebElement CreateContactBtn;
	
	@FindBy (xpath = "//li//span[text()= 'Create contact']")
	WebElement CreateSecondContactBtn;
	
	@FindBy (xpath = "//input[@id = 'uid-ctrl-1']")
	WebElement emailId;
	
	@FindBy (xpath = "//input[@id = 'uid-ctrl-2']")
	WebElement firstname;
	
	@FindBy (xpath = "//input[@id = 'uid-ctrl-3']")
	WebElement lastname;
	
	@FindBy (xpath = "//input[@id = 'uid-ctrl-5']")
	WebElement jobtitle;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getContactsPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver,Constants.Default_Explicit_Wait);
		wait.until(ExpectedConditions.visibilityOf(Contactspageheader));
		 return Contactspageheader.getText();
	}
	
	
	public void CreateNewContact(String emailVal, String frstName, String Lstname, String jbtitle) {
		WebDriverWait wait = new WebDriverWait(driver,Constants.Default_Explicit_Wait);
		wait.until(ExpectedConditions.visibilityOf(CreateContactBtn));
		CreateContactBtn.click();
		

		wait.until(ExpectedConditions.visibilityOf(emailId));
		emailId.sendKeys(emailVal);
		
		wait.until(ExpectedConditions.visibilityOf(firstname));
		firstname.sendKeys(frstName);
		
		wait.until(ExpectedConditions.visibilityOf(lastname));
		lastname.sendKeys(Lstname);
		
		TimeUtils.LongWait();
		WebDriverWait wait1 = new WebDriverWait(driver,Constants.Default_Explicit_Wait);
		wait1.until(ExpectedConditions.visibilityOf(jobtitle));
		jobtitle.sendKeys(jbtitle);
		
		wait.until(ExpectedConditions.elementToBeClickable(CreateSecondContactBtn));
		CreateSecondContactBtn.click();
		
		
		
	}
	
	

}
