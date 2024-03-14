package com.qa.testcases;

import com.qa.base.BaseClass;

import java.time.Duration;

import org.testng.annotations.Test;
public class TC_linkTest_001 extends BaseClass {
 @Test
   public void linkTest() {
	  
//	   driver.get("http://demowebshop.tricentis.com");
	 driver.get("https://www.daraz.com.bd/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   }
}
