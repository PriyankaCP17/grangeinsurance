package com.grange.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.grange.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//This is home Page class
	
	//Page factory : Object Repository
	
	//'Login '  button on  home page

	@FindBy(xpath = "//a[contains(@href,'/login')]")
	WebElement loginButton;
	
	@FindBy(xpath ="//a[@class='site-logo']")
	WebElement GrangeImage;


//Initializing the Page objects
  public HomePage()
  {
	  PageFactory.initElements(driver,this);
  }
  
  
  //Actions
  public String validateHomePage(){
	  return driver.getTitle();
  }
  
  public boolean validateGrangeImage(){
	  return GrangeImage.isDisplayed();
  }
  
  public LoginPage clickLogin(){
	  loginButton.click();
	  return new LoginPage();
  }
  
}

