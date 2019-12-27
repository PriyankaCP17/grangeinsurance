package sample1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readExcel1 {
	
	@Test
	public void readExcel() throws IOException{
		
		FileInputStream file = new FileInputStream("C://priyanka//testdata//Sample2.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount= sheet.getLastRowNum();
		
		int colCount = sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<rowCount;i++)
		{
			XSSFRow currentRow= sheet.getRow(i);
			String value= "";
			
			for(int j=0;j<colCount;j++)
			{
				value = value+currentRow.getCell(j).toString()+",";
				
			}
			System.out.print(value);
			
			System.out.println();
			
		}
		
	}

}
