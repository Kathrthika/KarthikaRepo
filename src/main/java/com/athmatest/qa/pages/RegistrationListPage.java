package com.athmatest.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.athmatest.qa.base.NewTestBase;

public class RegistrationListPage extends NewTestBase {
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Patient Registrations')]")
	WebElement registrationListPageTitle;
	
	@FindBy(xpath = "//button[@class='athma-btn athma-btn-priamry-outline']")
	WebElement createNewButton;
	
	@FindBy(xpath = "//input[@id='inputDebounce']")
	WebElement patientSearch;
	
	@FindBy(xpath = "(//athma-string-manipulation[@class='nav-unit'])[2]//span")
	WebElement patientNameinSearchList;
	
	@FindBy(xpath = "(//tbody[@class='md-table']//tr//td)[1]")
	WebElement patientMrninthesearchlist;
	
	

	public RegistrationListPage() throws IOException {
		//super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public String getRegistrationPagetitle() {
		commonWait(registrationListPageTitle);		
		return registrationListPageTitle.getText();
	}
	
	public void clickOnCreateNewButton() {
		commonWait(createNewButton);
		createNewButton.click();
	}
	
	public void searchPatient(String patientName) {
		commonWait(patientSearch);
		patientSearch.sendKeys(patientName);
	}
	
	public String getpatientName() {		
		commonWait(patientNameinSearchList);
		return patientNameinSearchList.getText();
		
	}
	
	public String getpatientMrn() {
		commonWait(patientMrninthesearchlist);
		return patientMrninthesearchlist.getText();
	}

}
