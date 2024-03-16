package com.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.LogInPage;

public class LogInPageTestRunner extends BaseClass {
	 LogInPage loginPage;
	 
	 public void checkNotLoggedIn() {
		 
			boolean Validate_logIn = driver.findElement(By.xpath("//span[@id='myAccountTrigger']")).isDisplayed();
 		    Assert.assertFalse(Validate_logIn );
		 
	 }

		
		// get url of targeted website
		@Test(priority=0)
		public void test1() {
			TC_linkTest_001 tc1=new TC_linkTest_001();
			tc1.linkTest();
		}
		
		
//.....................................................Normal Login................................................................................
		
		@Test(priority=1, description = "User will be able to logged in normally with correct email and password")
		public void validNormalLogin() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			loginPage.login("shoily9192@gmail.com", "daraz91922");
			boolean Validate_logIn = driver.findElement(By.xpath("//span[@id='myAccountTrigger']")).isDisplayed();
			Assert.assertTrue(Validate_logIn );     // check user logged in successfully......................................
			loginPage.doLogOut();
			}
		
		
//.....................................................Empty Email................................................................................		
		
		@Test(priority=2, description = "Varify error text with empty Email and user will be not able to log in")
		public void validEmailTest1() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			//loginPage.passwordValidation("", "daraz91922");
			loginPage.login("", "daraz91922");
	        String validationError_Email_actual = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[1]/span[1]")).getText();
	        String validationError_expected = "You can't leave this empty.";
	        //Assert.assertFalse(validationError_Email_actual.contains(validationError_expected));
	        Assert.assertTrue(validationError_Email_actual.contains(validationError_expected)); // check error message is displayed
	        
	        checkNotLoggedIn(); // User is unable to log in......................................
		}
		
		
//.....................................................asd........................................................................................			
		
		@Test(priority=3, description = "Varify error text with empty email \"asd\" and user will be not able to log in")
		public void validEmailTest2() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			//loginPage.emailValidation("asd");
			loginPage.login("asd", "daraz91922");
	        String validationError_actual = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[1]/span[1]")).getText();
	        String validationError_expected = "The length of the Phone or Email should be 6-60 characters.";
	        Assert.assertTrue(validationError_actual.contains(validationError_expected)); // check error message is displayed
	        
	        checkNotLoggedIn(); // User is unable to log in......................................
		}
		
		
		
//.....................................................asd@........................................................................................			
		
		@Test(priority=4, description = "Varify error text with empty email \\\"asd\\\" and user will be not able to log in")
		public void validEmailTest3() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			//loginPage.emailValidation("asd");
			loginPage.login("asd@", "daraz91922");
	        String validationError_actual = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[1]/span[1]")).getText();
	        String validationError_expected = "The length of the Phone or Email should be 6-60 characters.";
	        Assert.assertTrue(validationError_actual.contains(validationError_expected)); // check error message is displayed
	        
	        checkNotLoggedIn(); // User is unable to log in......................................
		
		}
		
		
//....................................................asd@gmail.com........................................................................................			
		
		@Test(priority=5, description = "Varify error text with empty email \\\"asd@gmail.com\\\" and user will be not able to log in. ")
		public void validEmailTest4() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			//loginPage.emailValidation("asd");
			loginPage.login("asd@gmail.com", "daraz91922");
			boolean Error_Validate_Invalid_Email = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[1]/span[1]")).isDisplayed();
			Assert.assertFalse(Error_Validate_Invalid_Email); // check error message is displayed
			
			checkNotLoggedIn(); // User is unable to log in......................................
			
//			boolean Validate_logIn = driver.findElement(By.xpath("//span[@id='myAccountTrigger']")).isDisplayed();
// 		    Assert.assertFalse(Validate_logIn );
		
		}
		
		
//.....................................................Empty Password................................................................................				
		
		@Test(priority=6, description = "Varify error text with empty password and user will be not able to log in")
		public void validPassTest1() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			loginPage.login("shoily9192@gmail.com", "");;
	        String validationError_actual = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/div[2]/span[1]")).getText();
	        String validationError_expected = "You can't leave this empty.";
	        Assert.assertTrue(validationError_actual.contains(validationError_expected)); // check error message is displayed
	        
	        checkNotLoggedIn(); // User is unable to log in......................................
		
		}
		
		
//.....................................................Password 123...............................................................................			
		
		@Test(priority=7, description = "Varify error text with password 123 and user will be not able to log in")
		public void validPassTest2() throws InterruptedException {
			
			loginPage=new LogInPage(driver);
			loginPage.login("shoily9192@gmail.com", "123");
			
//			checkNotLoggedIn(); // User is unable to log in......................................
			
			boolean Validate_logIn = driver.findElement(By.xpath("//span[@id='myAccountTrigger']")).isDisplayed();
			Assert.assertFalse(Validate_logIn );
		
		}
		

}
