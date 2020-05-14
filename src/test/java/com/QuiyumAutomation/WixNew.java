package com.QuiyumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WixNew {
			
			public WebDriver driver;
			
			@BeforeClass
			public void test() {
				String os= System.getProperty("os.name").toLowerCase();
				if(os.contains("mac"))
					System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
				else
					System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
				driver= (ChromeDriver) new ChromeDriver();
				driver.manage().window().maximize();
			}
			
			@Test
			public void Test1_OpenApplication() {
				driver.get("http://wix.com");
			}
			
			@Test(dependsOnMethods= "Test1_OpenApplication")
			
			public void Test2_ClickOnGetStartedButton() throws InterruptedException {
				//Thread.sleep(5000); //Implicit wait or hard wait
				WebElement getStarted= driver.findElement(By.xpath("(//span[text()='Get Started'])[1]"));
				//waitUntilElementDisplayed(driver,getStarted);
				getStarted.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[text()='Log In']")).click();
				
			
				
			}
			
			@Test(dependsOnMethods= "Test2_ClickOnGetStartedButton")
			public void Test3_LogIn() throws InterruptedException {
				Thread.sleep(5000);
				driver.findElement(By.id("input_4")).sendKeys("a.quiyum07@gmail.com");
				driver.findElement(By.id("input_5")).sendKeys("Nabhaan11");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[text()='Log In']")).click();
				
			}
				
		
			
	
}
	
