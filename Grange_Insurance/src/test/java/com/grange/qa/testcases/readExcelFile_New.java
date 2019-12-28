package com.grange.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readExcelFile_New {
	
	String username;
	double birthdate;
	double zipcode;
	String policyNumber;
	double pinNumber;
	
	@Test
    public void readExcelfile() throws IOException{
		
		
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
			System.out.println("Last cell num ::" + row.getLastCellNum());
			username = row.getCell(0).getStringCellValue();
			birthdate = row.getCell(1).getNumericCellValue();
			zipcode = row.getCell(2).getNumericCellValue();
			policyNumber = row.getCell(3).getStringCellValue();
			pinNumber=row.getCell(4).getNumericCellValue();
			
			System.out.println(username);
			System.out.println(birthdate);
			System.out.println(zipcode);
			System.out.println(policyNumber);
			System.out.println(pinNumber);
	/*	for (int c=0; c<row.getLastCellNum(); c++){
				inputString = inputString.concat(row.getCell(c).getStringCellValue().concat(space));
	
				System.out.println(row.getCell(c).getStringCellValue());
				
				}
			System.out.println();
		*/
			
			
		}
		
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
