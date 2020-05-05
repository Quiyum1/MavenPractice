package com.QuiyumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	WebDriver driver= (ChromeDriver) new ChromeDriver();

	//Object RemoteWebDriver;
	
	//(RemoteWebDriver)driver.get("https://www.seleniumhq.org/download/");
	//driver = new ChromeDriver();
	driver.get("https://s1.demo.opensourcecms.com/s/44");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[text()='Remove Frame']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("txtUsername")).sendKeys("opensourcecms");
	Thread.sleep(2000);
	driver.findElement(By.id("txtPassword")).sendKeys("opensourcecms");
	Thread.sleep(2000);
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(2000);
	driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("shakir");
	Thread.sleep(5000);
	driver.findElement(By.id("empsearch_supervisor_name")).sendKeys("mr. chow");
	Thread.sleep(5000);
	Select include = new Select(driver.findElement(By.id("empsearch_termination")));
	include.selectByValue("3");
	Thread.sleep(5000);
	driver.findElement(By.id("searchBtn")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(5000);
	
	Actions builder = new Actions(driver);
	builder.moveToElement(driver.findElement(By.xpath("//span[text()='PIM']"))).build().perform();
	builder.moveToElement(driver.findElement(By.xpath("//span[text()='Reports']"))).build().perform();
	driver.findElement(By.xpath("//span[text()='Reports']")).click();
	Thread.sleep(5000);
	driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	driver.findElement(By.id("search_search")).sendKeys("report");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@value='Search']")).click();
	Thread.sleep(5000);
	driver.switchTo().defaultContent();
	driver.close();
}
}
