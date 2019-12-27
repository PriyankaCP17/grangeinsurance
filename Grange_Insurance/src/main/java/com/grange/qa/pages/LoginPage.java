package com.grange.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.grange.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement loginButton;

	@FindBy(xpath="//input[@name='grid_0$content_1$tbEmail']")
	WebElement username;
	
	
	@FindBy(xpath="//input[@name='grid_0$content_1$tbPassword']")
	WebElement password;
	

	@FindBy(xpath="//input[@name='grid_0$content_1$cmdSubmit']")
	WebElement submitButton;
	
	public LoginPage(){
		
		PageFactory.initElements(driver,this);
	}
	
    
	public void login(String un,String pw)
	{   
		loginButton.click();
		username.sendKeys(un);
		password.sendKeys(pw);
		submitButton.click();
		

	}
	
	public String validateLoginPageTitle(){
		loginButton.click();
		return driver.getTitle();
	}
	
	

}
