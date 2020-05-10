package com.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample 
{
	public static WebDriver driver;
	public static String targetURL="https://gmail.com";
	
	@BeforeClass
	public void launchURL()
	{
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(targetURL);
	}
	
	@DataProvider(name="excelData")
	public Object[][] readExcel() throws IOException
	{
		File file=new File("/Users/Mayank/eclipse-workspace1/sample/TestData/Test.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int totalRows=sheet.getLastRowNum();
		int totalColums=sheet.getRow(0).getPhysicalNumberOfCells();
		
		// Read data from excel and store the same in the Object Array.
		Object obj[][]=new Object[totalRows][totalColums];
		for(int i=0;i<totalRows;i++)
		{
			obj[i][0]=sheet.getRow(i+1).getCell(0).toString();
			obj[i][1]=sheet.getRow(i+1).getCell(1).toString();
		}
		System.out.println("obj"+obj);
		return obj;
	}
	
	@Test(dataProvider="excelData")
	public void validateUser(String userName,String password) throws InterruptedException
	{
		By userNameXpath=By.xpath(".//*[@id='identifierId']");
		By nextBtnXpath=By.xpath(".//*[@id='identifierNext']");
		By passwordXpath=By.xpath(".//*[@id='password']//input[contains(@name,'password')]");
		By passwordNextBtnXpath=By.xpath(".//*[@id='passwordNext']");
		By searchXpath=By.xpath("//input[contains(@aria-label,'Search')]");
		
		wait(userNameXpath);
		driver.findElement(userNameXpath).click();
		driver.findElement(userNameXpath).clear();
		driver.findElement(userNameXpath).sendKeys(userName);
		driver.findElement(nextBtnXpath).click();
		
		wait(passwordXpath);
		driver.findElement(passwordXpath).click();
		driver.findElement(passwordXpath).sendKeys(password);
		driver.findElement(passwordNextBtnXpath).click();
		
		try
		{
			wait(searchXpath);
			
			String windowTitle=driver.getTitle();
			if(windowTitle.contains(userName))
			{
				Assert.assertTrue(true);
				logout();
				switchAccount();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			switchAccount();
			Assert.assertTrue(false);
		}
	}
	
	public void wait(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public void logout() throws InterruptedException
	{
		By myProfileXpath=By.xpath("//*[contains(@href,'SignOutOptions')]");
		By logoutBtnXpath=By.xpath("//*[contains(@href,'Logout')]");
		
		
		driver.findElement(myProfileXpath).click();
		wait(logoutBtnXpath);
		driver.findElement(logoutBtnXpath).click();
		
		
	}
	
	public void switchAccount()
	{
		By switchAccountXpath=By.xpath("//div[contains(@aria-label,'Switch account')]");
		By useOtherAccountXpath=By.xpath("//*[@id='identifierLink']");
		
		wait(switchAccountXpath);
		driver.findElement(switchAccountXpath).click();
		wait(useOtherAccountXpath);
		driver.findElement(useOtherAccountXpath).click();
		
	}

}
