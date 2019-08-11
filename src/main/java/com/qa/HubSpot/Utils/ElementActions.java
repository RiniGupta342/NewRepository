package com.qa.HubSpot.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.HubSpot.Pages.BasePage;

public class ElementActions extends BasePage {
	
	WebDriver driver;
	
	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElementActions(By Selector) {
		WaitForElement(Selector);
		WebElement element = driver.findElement(Selector);
		return element;
	}
	
	public void WaitForElement(By Selector) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.Default_Explicit_Wait);
		wait.until(ExpectedConditions.presenceOfElementLocated(Selector));
		
	}
	
	
	public void DoClick(By Selector) {
		try {
		getElementActions(Selector).click();
	}catch(Exception e) {
		System.out.println("exception occurred with locator :"  + Selector);
	}
	}
	
	public void DoSendKeys(By Selector , String values) {
		try {
			getElementActions(Selector).sendKeys(values);
		}catch(Exception e) {
			System.out.println("exception occurred with locator :"  + Selector);
		}
	}
	
	public boolean VerifyDisplayed(By Selector) {
		return getElementActions(Selector).isDisplayed();	
	}
}
