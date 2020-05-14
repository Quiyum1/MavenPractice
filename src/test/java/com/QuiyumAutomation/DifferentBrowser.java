package com.QuiyumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class DifferentBrowser {
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}

		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		if(browser.equals("safari"))
		{
			System.setProperty("webdriver.chrome.driver", "Driver/safaridriver");
			driver = new SafariDriver();
			
		}
	
	}
	
	@Test
	public void open() throws InterruptedException {
		driver.get("http://google.com");
		Thread.sleep(10000);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
}
