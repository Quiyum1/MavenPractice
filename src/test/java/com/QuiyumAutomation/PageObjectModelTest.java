package com.QuiyumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageObjectModelTest {
	
	public static WebDriver driver;
	HomePage hp ;
	SignupPage sp;
	
	
	@BeforeClass
	public void test() {
		String os= System.getProperty("os.name").toLowerCase();
		if(os.contains("mac"))
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
		else
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver= (ChromeDriver) new ChromeDriver();
		driver.manage().window().maximize();
		
		hp = PageFactory.initElements(driver, HomePage.class);
		sp = PageFactory.initElements(driver, SignupPage.class);
	}
	
	@Test
	public void Test1_OpenApplication() {
		driver.get("http://wix.com");
	}
	
	@Test(dependsOnMethods= "Test1_OpenApplication")
	public void Test2_ClickOnGetStartedButton() throws InterruptedException {
		Thread.sleep(5000); 
		hp.clickOnGetStarted();
		
	}
	
	@Test(dependsOnMethods= "Test2_ClickOnGetStartedButton")
	public void Test3_InputEmail() throws InterruptedException {
		Thread.sleep(2000);
		sp.enterEmail();
	}
	
	@Test(dependsOnMethods= "Test3_InputEmail")
	public void Test4_InputConfirmEmail() {
		sp.enterReEmail();
	}
	
	@Test(dependsOnMethods= "Test4_InputConfirmEmail")
	public void Test5_InputPassword() {
		sp.enterPassword();
	}
	
	@Test(dependsOnMethods= "Test5_InputPassword")
	public void Test6_InputRepassword() {
		sp.enterRePassword();
	}
	
	@Test(dependsOnMethods= "Test6_InputRepassword")
	public void Test7_ClickOnSubmit() {
		sp.clickOnSubmitButton();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
