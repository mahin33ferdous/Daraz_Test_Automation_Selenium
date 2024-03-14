package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.LogInPage;

public class LogInPageTestRunner extends BaseClass {
	 LogInPage loginPage;

		
		// get url of targeted website
		@Test(priority=0)
		public void test1() {
			TC_linkTest_001 tc1=new TC_linkTest_001();
			tc1.linkTest();
		}
		
		
//.....................................................Normal Login................................................................................
		
		@Test(priority=1, description = "Validate Normal Login")
		public void validNormalLogin() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			loginPage.login("shoily9192@gmail.com", "daraz91922");
			boolean Validate_logIn = driver.findElement(By.xpath("//span[@id='myAccountTrigger']")).isDisplayed();
			Assert.assertTrue(Validate_logIn );
			loginPage.doLogOut();
			}
		
		
//.....................................................Empty Email................................................................................		
		
		@Test(priority=6, description = "Validate error with empty Email")
		public void validEmailTest1() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			//loginPage.passwordValidation("", "daraz91922");
			loginPage.login("", "daraz91922");
	        String validationError_Email_actual = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[2]/span[1]")).getText();
	        String validationError_expected = "You can't leave this empty.";
	        Assert.assertFalse(validationError_Email_actual.contains(validationError_expected));
		}
		
		
//.....................................................asd........................................................................................			
		
		@Test(priority=3, description = "Validate invalid email error with asd")
		public void validEmailTest2() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			//loginPage.emailValidation("asd");
			loginPage.login("asd", "daraz91922");
	        String validationError_actual = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[1]/span[1]")).getText();
	        String validationError_expected = "The length of the Phone or Email should be 6-60 characters.";
	        Assert.assertTrue(validationError_actual.contains(validationError_expected));
		}
		
		
		
//.....................................................asd@........................................................................................			
		
		@Test(priority=3, description = "Validate invalid email error with asd@")
		public void validEmailTest3() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			//loginPage.emailValidation("asd");
			loginPage.login("asd@", "daraz91922");
	        String validationError_actual = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[1]/span[1]")).getText();
	        String validationError_expected = "The length of the Phone or Email should be 6-60 characters.";
	        Assert.assertTrue(validationError_actual.contains(validationError_expected));
		
		}
		
		
//....................................................asd@gmail.com........................................................................................			
		
		@Test(priority=3, description = "Validate invalid email error text with asd@gmail.com")
		public void validEmailTest4() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			//loginPage.emailValidation("asd");
			loginPage.login("asd@gmail.com", "daraz91922");
			boolean Error_Validate_Invalid_Email = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[1]/span[1]")).isDisplayed();
			Assert.assertFalse(Error_Validate_Invalid_Email);
			
			boolean Validate_logIn = driver.findElement(By.xpath("//span[@id='myAccountTrigger']")).isDisplayed();
 		    Assert.assertFalse(Validate_logIn );
		
		}
		
		
//.....................................................Empty Password................................................................................				
		
		@Test(priority=6, description = "Validate error with empty password")
		public void validPassTest1() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			loginPage.login("shoily9192@gmail.com", "");;
	        String validationError_actual = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[2]/span[1]")).getText();
	        String validationError_expected = "You can't leave this empty.";
	        Assert.assertTrue(validationError_actual.contains(validationError_expected));
		
		}
		
		
//.....................................................Password 123...............................................................................			
		
		@Test(priority=6, description = "Validate error with password 123")
		public void validPassTest2() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			loginPage.login("shoily9192@gmail.com", "123");
			boolean Validate_logIn = driver.findElement(By.xpath("//span[@id='myAccountTrigger']")).isDisplayed();
			Assert.assertFalse(Validate_logIn );
		
		}
		

}
