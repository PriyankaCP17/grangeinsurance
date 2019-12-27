package com.grange.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.grange.qa.base.TestBase;

public class SignInPage extends TestBase{
	
	@FindBy(xpath = "//a[contains(@href,'/login')]")
	WebElement loginButton;
	
	@FindBy(xpath ="//a[contains(@href,'/login/register-policy-number-step-1')]")
	WebElement createAnAccount;
	
	@FindBy(xpath ="//a[contains(@id,'grid_0_LinkButton1')]")
	WebElement personalPolicy;
	
	@FindBy(xpath="//input[@name='grid_0$tbPLName']")
	WebElement name;
	
	@FindBy(xpath="//input[@name='grid_0$tbPLDateOfBirth']")
	WebElement DateOfBirth;
	
	@FindBy(xpath="//input[@name='grid_0$tbPLPolicyZIPCode']")
	WebElement ZipCode;
	
	
	@FindBy(xpath="//input[@name='grid_0$cmdContinue']")
	WebElement nextButton;
	
	@FindBy(xpath="//input[@name='grid_0$tbPolicyNumberMoreInfo']")
	
	WebElement policyNumber;
	
	@FindBy(xpath="//input[@name='grid_0$tbPinMoreInfo']")
	WebElement PIN;
	
	@FindBy(xpath="//input[@name='grid_0$cmdContinue']")
	WebElement nextbutton2;
	
	
	public SignInPage(){
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	public void fillSignInDetails(String name1,String date,String zip,String policy,int pin){
		
		loginButton.click();
		createAnAccount.click();
		personalPolicy.click();
		
		name.sendKeys(name1);
		DateOfBirth.sendKeys(date);
		ZipCode.sendKeys(zip);
		
		nextButton.click();
		System.out.println("Policy is " +policy);
		
		policyNumber.sendKeys(policy);
		
		System.out.println("PIN is " +pin);
		
		String pin1 = String.valueOf(pin);
		
		System.out.println("PIN1 is " +pin1);
		
		PIN.sendKeys(pin1);
		
		nextbutton2.click();
		
		
	}
	

}
