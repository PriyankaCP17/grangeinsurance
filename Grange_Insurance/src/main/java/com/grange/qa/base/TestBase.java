package com.grange.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.grange.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/resources/config.properties");		   
				prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	public static void initialization(){
		
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("chrome"))	
		{
			System.setProperty("webdriver.chrome.driver", ".drivers/chromedriver.exe");
		//	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", ".drivers/geckodriver.exe");
		//	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
/*	public void readExcel() throws IOException{
		
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
		for (int r=0; r<=rowCount; r++){
			Row row = signInSheet.getRow(r);
			System.out.println("Last cell num ::" + row.getLastCellNum());
			for (int c=0; c<row.getLastCellNum(); c++){
				System.out.print(row.getCell(c).getStringCellValue());
				}
			
			
			System.out.println();
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	
	
}
