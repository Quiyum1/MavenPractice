package com.QuiyumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage {
	
	WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    
    @FindBy(id="input_0")
    WebElement email;
    
    @FindBy(id="input_1")
    WebElement re_email;
    
    @FindBy(id="input_2")
    WebElement password;
    
    @FindBy(id="input_3")
    WebElement re_password;
    
    @FindBy(name="submit")
    WebElement submit;
    
    public void enterEmail() {
    	email.sendKeys("Test1234@gmail.com");
    }
    
    public void enterReEmail() {
    	re_email.sendKeys("Test1234@gmail.com");
    }
    
    public void enterPassword() {
    	password.sendKeys("Test1234@gmail.com");
    }
    
    public void enterRePassword() {
    	re_password.sendKeys("Test1234@gmail.com");
    }
    
    public void clickOnSubmitButton() {
    	submit.click();
    }

}
