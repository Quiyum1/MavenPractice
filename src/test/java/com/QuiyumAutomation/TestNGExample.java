package com.QuiyumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGExample extends BaseMethod{
	
	public static WebDriver driver;
	
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
		waitUntilElementDisplayed(driver,getStarted);
		getStarted.click();
		//driver.findElement(By.xpath("(//span[text()='Get Started'])[1]")).click();
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
