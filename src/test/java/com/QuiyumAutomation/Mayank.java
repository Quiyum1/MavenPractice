package com.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class AppTest {
	public WebDriver driver;

	@DataProvider
	public String[][] getExcelData() throws InvalidFormatException, IOException, BiffException{
		Object[][] arrayObject = getExcelData1("/Users/Mayank/eclipse-workspace1/sample/TestData/Test.xlsx", "Sheet1");
		return (String[][]) arrayObject;
	}

	@BeforeClass
	public void launchApp(){
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://senchatutorials.in/");
	}

	@Test(dataProvider = "getExcelData")
	public void Login(String Username, String Password) throws InterruptedException{
		System.out.println("Username"+Username);
		System.out.println("Password"+Password);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("(//span[text()='Sign In'])[2]")).click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
	
	public String[][] getExcelData1(String fileName, String sheetName) throws BiffException {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} 
		return arrayExcelData;
	}
}