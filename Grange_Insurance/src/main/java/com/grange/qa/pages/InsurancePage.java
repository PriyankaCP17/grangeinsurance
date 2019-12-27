package com.grange.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.grange.qa.base.TestBase;

public class InsurancePage extends TestBase{
	
	@FindBy(xpath="//*[@href='/insurance' and @class='icon-down']")
	WebElement insurance;
	
	@FindBy(xpath="//*[@href='/insurance/auto']")
	WebElement auto;
	
	
	
	public InsurancePage(){
		
		PageFactory.initElements(driver,this);
		
	}
	
	public String validateAutoPage(){
		
		Actions action = new Actions(driver);
        action.moveToElement(insurance).build().perform();
        auto.click();
        return driver.getTitle();
	}

}
