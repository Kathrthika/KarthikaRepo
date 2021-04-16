package com.athmatest.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.bcel.generic.Select;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.athmatest.qa.base.NewTestBase;
import com.athmatest.qa.pages.HomePage;
import com.athmatest.qa.pages.LoginPage;
import com.athmatest.qa.pages.NewRegistrationPage;
import com.athmatest.qa.pages.RegistrationListPage;
import com.athmatest.qa.utils.CommonUtils;

public class NewRegistrationTest extends NewTestBase {
	 LoginPage lp ;
	  HomePage hp;
	  RegistrationListPage nrlp;
	  NewRegistrationPage nrp;
	  String formname = prop.getProperty("formName");
	  String prefix = prop.getProperty("prefix");
	  String firstName = prop.getProperty("firstName");
	  String age = prop.getProperty("age");
	  String mobile = prop.getProperty("mobile");
	  String zipCode = prop.getProperty("zipCode");

	public NewRegistrationTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@DataProvider
	public Object[][] getpatientinfo() throws EncryptedDocumentException, IOException{
		Object data[][] = CommonUtils.getPatientdetails("testdata");
		return data;
	}
	
	
	
	@Test(dataProvider = "getpatientinfo")
	public void newRegistration(String prefix1 , String patientName1, String age1, String zipcode1) throws IOException, InterruptedException {
		hp = new HomePage();
		hp.openRegistrationPage();
		nrlp = new RegistrationListPage();
		String prListpageTitle = nrlp.getRegistrationPagetitle();
		nrlp.clickOnCreateNewButton();
		assertEquals(prListpageTitle, "Patient Registrations","List page title Not Matched");
		nrp = new NewRegistrationPage();	
		String t2 = nrp.newpatientRegistrationPageTitle();
		assertEquals(t2, "Patient Registration","New registration Page title is not matched");
		nrp.selectRegistrationform(formname);		
		commonSleep();	
		nrp.selectprefix(prefix1);
		/*
		 * WebElement prdd =
		 * driver.findElement(By.xpath("//ng-select[@name='patientPrefix']")); Actions
		 * act = new Actions(driver); act.moveToElement(prdd).click().build().perform();
		 * commonSleep(); System.out.println((driver.findElement(By.xpath(
		 * "(//span[@class='ng-option-label'])[1]"))).getText()); for(int i=1;i<=27;i++)
		 * {
		 * 
		 * WebElement dd =
		 * driver.findElement(By.xpath("(//span[@class='ng-option-label'])["+i+"]"));
		 * //System.out.println(i); System.out.println(dd.getText());
		 * if(dd.getText().equals("Master")) { commonWait(dd); dd.click(); break; }
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
		 commonSleep();
		 nrp.EnterPatientDetails(patientName1,age1,zipcode1);
		 nrp.clickOnRegisterandCancelButton();
		 commonSleep();
		 assertEquals(nrlp.getRegistrationPagetitle(), "Patient Registrations","List page title Not Matched");
		 
		 nrlp.searchPatient(patientName1);
		 shortSleep();
		 String  searchptname = nrlp.getpatientName();
		  if(searchptname.contains(patientName1)) {
			  System.out.println(nrlp.getpatientMrn()+" "+patientName1);
		  }
		  else {
			System.out.println("Patient Name not match");
			System.out.println(searchptname);
		}
			
		}
		//WebElement dd =	driver.findElement(By.xpath("(//span[@class='ng-option-label'])[i]"));
		/*
		 * org.openqa.selenium.support.ui.Select sel = new
		 * org.openqa.selenium.support.ui.Select(dd); List<WebElement> prefix =
		 * sel.getOptions(); for(WebElement pre : prefix) {
		 * System.out.println(pre.getText()); }
		 */
	 
		
		 
		
		  
	
	

	

}
