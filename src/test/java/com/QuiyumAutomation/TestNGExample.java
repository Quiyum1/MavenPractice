package com.QuiyumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGExample {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void test() {
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
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[text()='Get Started'])[1]")).click();
	}
	
	@Test(dependsOnMethods= "Test2_ClickOnGetStartedButton")
	public void Test3_InputEmail() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("input_0")).sendKeys("Test1234@gmail.com");
	}
	
	@Test(dependsOnMethods= "Test3_InputEmail")
	public void Test4_InputConfirmEmail() {
		driver.findElement(By.id("input_1")).sendKeys("Test1234@gmail.com");
	}
	
	@Test(dependsOnMethods= "Test4_InputConfirmEmail")
	public void Test5_InputPassword() {
		driver.findElement(By.id("input_2")).sendKeys("Test1234@gmail.com");
	}
	
	@Test(dependsOnMethods= "Test5_InputPassword")
	public void Test6_InputRepassword() {
		driver.findElement(By.id("input_3")).sendKeys("Test1234@gmail.com");
	}
	
	@Test(dependsOnMethods= "Test6_InputRepassword")
	public void Test7_ClickOnSubmit() {
		driver.findElement(By.name("submit")).click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
