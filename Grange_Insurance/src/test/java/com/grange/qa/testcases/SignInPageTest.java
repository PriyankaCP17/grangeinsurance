package com.grange.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grange.qa.base.TestBase;

import com.grange.qa.pages.SignInPage;

public class SignInPageTest extends TestBase{
	
	SignInPage signinpage;
	
	public SignInPageTest()
	{
		super();
		
	}
	

	
	@BeforeMethod()
	public void setUp(){
	
	initialization();
	signinpage = new SignInPage();
		
	}
	
	@Test(priority=1)
	public void SignInTest() throws IOException{
		
		String name,bdate,zipcode,policy;
		int pin;
		
		  // Create File object to access excel file and specify file location
				File file = new File("C:\\priyanka\\testdata\\SignInDetails.xlsx");
				
				// Create FIS object to read excel file
				FileInputStream fis=new FileInputStream(file);
				
				// Now Load Workbook
				XSSFWorkbook wb=new XSSFWorkbook(fis);
				
				// Now Load sheet
				XSSFSheet signInSheet = wb.getSheet("SignInSheet");
				
				int rowCount = signInSheet.getLastRowNum();
				
				System.out.println("Row Count::" + rowCount);
				
				// Loop to print the excel data
				for (int r=1; r<=rowCount; r++){
					Row row = signInSheet.getRow(r);
					
					name=row.getCell(0).toString();
					
					bdate=row.getCell(1).toString();
					
					zipcode=row.getCell(2).toString();
					
					policy=row.getCell(3).toString();
					
					//pin=row.getCell(4).toString();
					
				//	XSSFCell pinvalue = row.getCell(4);
				//	pin = (int)pinvalue.getNumericCellValue();
					
					
					pin=(int)((row.getCell(4)).getNumericCellValue());
					
				//	System.out.print(name+","+bdate+","+zipcode+","+policy+","+pin);
					
					//signinpage.fillSignInDetails(name,bdate,zipcode,policy,pin.substring(0,pin.length()-2));
					
					signinpage.fillSignInDetails(name,bdate,zipcode,policy,pin);
					
				}
				
				}
				
		
		//signinpage.fillSignInDetails(prop.getProperty("name1"), prop.getProperty("date"), prop.getProperty("zip"),prop.getProperty("policy"),prop.getProperty("pin"));
	
	
	
//	@Test(priority=2)
//	public void getValueThruExcel(){
		
		
		
		//signinpage.fillSignInDetails(String uname,int bdate,int zip,String policy,int pin);
		
		
	//}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
			
		}
}
