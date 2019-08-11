package com.qa.HubSpot.Utils;

import org.openqa.selenium.WebDriver;

public class DriverUtils {
	
	WebDriver driver;
	
	public DriverUtils(WebDriver driver) {
		this.driver = driver;
		}
	
	public String getPageTitle() {
		String GetTitle = driver.getTitle();
		return GetTitle;
	}

}
