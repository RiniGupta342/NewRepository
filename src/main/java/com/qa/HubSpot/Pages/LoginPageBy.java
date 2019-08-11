package com.qa.HubSpot.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.HubSpot.Utils.DriverUtils;
import com.qa.HubSpot.Utils.ElementActions;

import io.qameta.allure.Step;

public class LoginPageBy extends BasePage {
	
	ElementActions elementactions;
	DriverUtils driverutils;
	WebDriver driver;
	
	By emailId = By.id("username");
	By password = By.id("password");
	By LoginButton = By.id("loginBtn");
	By SignUpLink = By.linkText("Sign up");
	
public LoginPageBy (WebDriver driver) {
	this.driver = driver;
	elementactions = new ElementActions(driver);
	driverutils = new DriverUtils(driver);
	
}

@Step("Title step...")
public String getLoginPageTitle() {
	String Title = driverutils.getPageTitle();
	return Title;
}
	
@Step("Verify SignUp Link Step")
public boolean VerifySignUpLink() {
	
	return elementactions.VerifyDisplayed(SignUpLink);
}

@Step("Do the Login with username : {0} and pwd : {1}")
public HomePage DoLogin(String username, String pwd) {
	
	elementactions.DoSendKeys(emailId, username);
	elementactions.DoSendKeys(password, pwd);
	elementactions.DoClick(LoginButton);
	
	
	
	return new HomePage(driver);
}

}
