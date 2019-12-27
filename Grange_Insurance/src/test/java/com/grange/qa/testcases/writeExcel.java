package com.grange.qa.testcases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class writeExcel {
	
	@Test
	public void writeExcelFile() throws IOException{
		
		FileOutputStream file = new FileOutputStream("C://priyanka//testdata//test1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Data");
		
		for(int i=0;i<=5;i++)
		{
			XSSFRow row = sheet.createRow(i);
			
			for(int j=0;j<3;j++)
			{
				row.createCell(j).setCellValue("abc");
				
			}
			
		}
		workbook.write(file);
		
		System.out.println("Write data to file is completed");
				
		
	}

}
