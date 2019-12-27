package com.grange.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grange.qa.base.TestBase;
import com.grange.qa.pages.InsurancePage;

public class InsurancePageTest extends TestBase{
	
	InsurancePage insurancePage;
	
	public InsurancePageTest(){
		
		super();
	}
	
	@BeforeMethod
	
	public void setUp(){
		
		initialization();
		insurancePage = new InsurancePage();	
	}
	
	@Test
	public void autoPageTitleTest(){
		
            String title = insurancePage.validateAutoPage();
	      
			Assert.assertEquals(title, "Full-Coverage Car Insurance | Grange Insurance");
			
			
		}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
		
		
	}
	
	
	
