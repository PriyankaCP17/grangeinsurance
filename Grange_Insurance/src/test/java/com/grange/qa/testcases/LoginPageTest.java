package com.grange.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grange.qa.base.TestBase;
import com.grange.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	public LoginPageTest() {
		
		super();
	}
	
		@BeforeMethod()
			public void setUp(){
			
			initialization();
		    loginPage = new LoginPage();
				
			}
		
		
		@Test(priority=1)
		public void loginTest(){
			loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		@Test(priority=2)
		public void LoginPageTitleTest(){
			System.out.println("LoginPageTest: inside Login Page title test");
			String title = loginPage.validateLoginPageTitle();
			Assert.assertEquals(title, "MyGrange Account Login | Policy Access | Grange Insurance");
					
		}
		@AfterMethod
		public void tearDown(){
			driver.quit();
				
			}
		
		
	}


