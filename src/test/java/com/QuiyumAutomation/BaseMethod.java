package com.QuiyumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethod {
	
	
	//Explicit wait
	public static void waitUntilElementDisplayed(WebDriver driver,WebElement webElement) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(webElement));
	}

}
