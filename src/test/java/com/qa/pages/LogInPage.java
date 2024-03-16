package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LogInPage extends BaseClass{
	public LogInPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class=\"bld-txt\"  and contains(text(),\"Login\")]")
	WebElement login;
	
//	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]/a")
//	WebElement login;
	
//	@FindBy(xpath="//input[@data-qa='login-email']")
//	WebElement email;
//	
//	@FindBy(xpath="//input[@data-qa='login-password']")
	
	@FindBy(xpath = "//input[@placeholder=\"Please enter your Phone Number or Email\"]") 
    WebElement Email; 
	
	@FindBy(xpath = "//input[@placeholder=\"Please enter your password\"]") 
    WebElement password; 
	
	
	
//	WebElement password;
	
	@FindBy(xpath=" //button[contains(text(),'LOGIN')]")
	WebElement loginSubmit;
	
//	
//	public void loginWithEmptyInput() throws InterruptedException {
//		login.click();
//		Thread.sleep(2000);
//		
//		loginSubmit.click();
//		Thread.sleep(2000);
//		
//	}

//	
	public void login(String e,String p) throws InterruptedException {
		login.click();
		Thread.sleep(2000);
	
		Email.sendKeys(e);
		Thread.sleep(2000);
		
		password.sendKeys(p);
		Thread.sleep(2000);
		
		loginSubmit.click();
		Thread.sleep(2000);
		
	
	}
	
//	public void emailValidation(String e) throws InterruptedException {
//		login.click();
//		Email.clear();
//		password.clear();
//		Thread.sleep(1000);
//		Email.sendKeys(e);
//		Thread.sleep(3000);
//		Email.clear();
//		Thread.sleep(3000);
//	}
	
	
	
	public void doLogOut() throws InterruptedException {
		
		WebElement accountHover=driver.findElement(By.xpath("//span[@id='myAccountTrigger']"));
		accountHover.click();
		Thread.sleep(2000);
		
		WebElement logOutButton=driver.findElement(By.xpath("//span[@class=\"account-icon test logout\"]"));
		logOutButton.click();
		Thread.sleep(1000);
	}

}
