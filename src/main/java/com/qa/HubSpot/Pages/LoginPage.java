package com.qa.HubSpot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	 @FindBy(id = "username")
	 WebElement emailId;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "loginBtn")
	WebElement LoginButton;
	
	@FindBy (linkText = "Sign up")
	WebElement SignUpLink;
	
	@FindBy (xpath = "//div[@class = 'private-checkbox m-bottom-4']//input[@id = 'remember']")
	WebElement CheckBox;
	
	@FindBy (linkText = "Show Password")
    WebElement PasswordLink;	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//define Page Actions/Methods
	
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean VerifySignUpLink() {
		return SignUpLink.isDisplayed();
	}
	
	
	public boolean clickCheckBox() {
	 return	CheckBox.isSelected();
	}
	
	
	public void ShowPasswordLink() {
		PasswordLink.click();
	}
    
	public HomePage DoLogin(String username, String Pwd) {
		emailId.sendKeys(username);
		password.sendKeys(Pwd);
		LoginButton.click();
		return new HomePage(driver);
	}
	
	

}
