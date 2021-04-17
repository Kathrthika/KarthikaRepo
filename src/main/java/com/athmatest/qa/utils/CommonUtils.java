package com.athmatest.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
	
	
	
	
	
	

}
