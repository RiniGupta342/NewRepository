package com.qa.HubSpot.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	//public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	public WebDriver init_browser(Properties prop) {
		
		String browser = prop.getProperty("browser");
		
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
			 driver = new ChromeDriver();
			//tldriver.set(new ChromeDriver());
		}
		
		else {
			System.out.println("No Driver");
		}
		
//		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("PageLoadTimeout")), TimeUnit.SECONDS);
		return driver;
	} 
	
	
//	public static synchronized WebDriver getDriver() {
//		return tldriver.get();
//	}
	
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\HubSpotPOMF\\src\\main\\java\\com\\qa\\HubSpot\\config\\Config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
//	public String getScreenshot() { 
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis()+ ".png";
//		File Destination = new File(path);
//		try {
//		FileUtils.copyFile(src,Destination);
//		}catch(IOException e) {
//			System.out.println("Capture Failed" + e.getMessage());
//		}
//		
//		return path;
//	}

}
