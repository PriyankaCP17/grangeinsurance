package com.grange.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grange.qa.base.TestBase;
import com.grange.qa.pages.HomePage;



public class HomePageTest extends TestBase{
	    HomePage homePage;
	
	   public HomePageTest(){
		   super();
	   }
	
		@BeforeMethod
		public void setUp()
		{
			initialization();
			homePage = new HomePage();
			
		}
		
		@Test(priority=1)
		public void homePageTitleTest(){
			
			String title= homePage.validateHomePage();
	      
			Assert.assertEquals(title, "Grange Insurance: Home, Life & Car Insurance Coverage");
			
			Reporter.log("Title of home page is " +title);
			
			
		}
		
		@Test(priority=2)
		public void grangeLogoImageTest(){
			
			boolean flag=homePage.validateGrangeImage();
			
			Reporter.log("Flag is " +flag);
			
			Assert.assertTrue(flag);
		}
		
		@AfterMethod 
		public void tearDown(){
			driver.quit();
		}
		
		

}
