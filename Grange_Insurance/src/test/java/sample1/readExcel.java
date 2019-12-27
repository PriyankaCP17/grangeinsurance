package sample1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readExcel {
	
	
	double num1;
	double num2;
	
	
	@Test
    public void readExcelfile() throws IOException{
		
		
	     // Create File object to access excel file and specify file location
		File file = new File("C:\\priyanka\\testdata\\Sample1.xlsx");
		
		// Create FIS object to read excel file
		FileInputStream fis=new FileInputStream(file);
		
		// Now Load Workbook
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		// Now Load sheet
		XSSFSheet signInSheet = wb.getSheet("SampleSheet1");
		
		int rowCount = signInSheet.getLastRowNum();
		
		System.out.println("Row Count::" + rowCount);
		
		// Loop to print the excel data
		
		for (int r=0; r<=rowCount; r++){
			Row row = signInSheet.getRow(r);
			System.out.println("Last cell num ::" + row.getLastCellNum());
			num1 = row.getCell(0).getNumericCellValue();
			num2 = row.getCell(1).getNumericCellValue();
			
			
			System.out.println(num1);
			System.out.println(num2);
		
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		}
		
	}
}
	

