package com.QuiyumAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class Mayank {

	public WebDriver driver;



	@DataProvider

	public String[][] getExcelData() throws IOException{

		String[][] arrayObject = (String[][]) getExcelData1("/Users/Mayank/eclipse-workspace1/sample/TestData/Test.xlsx", "Sheet1");

		return arrayObject;

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

//		driver.findElement(By.name("username")).clear();

//		driver.findElement(By.name("username")).sendKeys(Username);

//		driver.findElement(By.name("password")).clear();

//		driver.findElement(By.name("password")).sendKeys(Password);

//		driver.findElement(By.xpath("(//span[text()='Sign In'])[2]")).click();

		Thread.sleep(2000);

	}



	@AfterClass

	public void closeBrowser(){

		driver.quit();

	}

	

	public Object getExcelData1(String fileName, String sheetName) {

		String[][] arrayExcelData = null;

		try {

			FileInputStream fs = new FileInputStream(fileName);

			XSSFWorkbook workbook= new XSSFWorkbook(fs);

			

			XSSFSheet sheet=workbook.getSheet("Sheet1");



			int totalRows=sheet.getLastRowNum();

			

			int totalColums=sheet.getRow(0).getPhysicalNumberOfCells();

			

			arrayExcelData=new String[totalRows][totalColums];

			

			for(int i=0;i<totalRows;i++)

			{

				arrayExcelData[i][0]=sheet.getRow(i+1).getCell(0).toString();

				arrayExcelData[i][1]=sheet.getRow(i+1).getCell(1).toString();

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