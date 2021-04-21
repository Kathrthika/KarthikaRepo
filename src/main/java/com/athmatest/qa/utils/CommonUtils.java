package com.athmatest.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.athmatest.qa.base.NewTestBase;

public class CommonUtils extends NewTestBase{
	
	public static long common_Wait = 30;
	static Workbook book;
	static Sheet sheet;

	public CommonUtils() throws IOException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public  void commonWait1(WebElement ele) {
	WebDriverWait wait = new WebDriverWait(driver, common_Wait);
	wait.until(ExpectedConditions.invisibilityOf(ele));
	
	
	
	} 
	
	public static Object[][] getPatientdetails(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fis = null;
		try {
			fis  = new FileInputStream("C:\\Users\\339154\\eclipse-workspace\\NewFrameworkStart\\src\\main\\java\\com\\athmatest\\qa\\testdata\\NewPatients.xlsx");
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
			
			
		} catch (InvalidFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i<  sheet.getLastRowNum();i++) 
		{
			 for(int j = 0; j < sheet.getRow(0).getLastCellNum();j++) 
			 {
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				 
			 }
		
			
		}
		return data;
		
		
	}
	
	
	public static void takeScreenshotforfailed(String methodName) {
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			LocalDate date1 = java.time.LocalDate.now();
			LocalTime time1 = java.time.LocalTime.now();
			String current_date = date1.toString();
			String current_time = time1.toString();
			
			String d1 = current_date.replace("-", "_");
			String t1 = ((current_time.replace(":", "_")).replace(".","_")).substring(0, 8);
			
			FileUtils.copyFile(srcFile, new File("C:\\Users\\339154\\eclipse-workspace\\NewFrameworkStart\\SrcreenShot\\"+methodName+"_"+d1+t1+"_.jpg"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	

}
