package com.QuiyumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Find a single element
    @FindBy(xpath="(//span[text()='Get Started'])[1]")
    WebElement getStarted;
    
    public void clickOnGetStarted() {
    	getStarted.click(); 	
    }

}
