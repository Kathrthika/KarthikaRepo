package com.athmatest.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.athmatest.qa.base.NewTestBase;

public class HomePage extends NewTestBase {
	
	@FindBy(xpath = "//span[@class='icon-more']")
	WebElement moreOption;
	@FindBy(id = "logout")
	WebElement signOut;
	
	@FindBy(xpath = "//span[@class='sb-icon icon-athmamodules athma-ambulatory-module-icon']")
	WebElement ambMainMenu;
	
	@FindBy(xpath = "//a[@href='https://sqa.narayanahealth.org:7076/patient-registration']")
	WebElement regitrationMenu;
	
	
	@FindBy(xpath = "//span[@class='sb-icon icon-athmamodules athma-billing-module-icon']")
	WebElement opBillingMainMenu;
	
	@FindBy(xpath = "//a[@href='https://sqa.narayanahealth.org:7076/amb-invoice']")
	WebElement invoiceMenu;
	
	@FindBy(xpath = "//a[@href='https://sqa.narayanahealth.org:7076/amb-receipt']")
	WebElement receiptMenu;
	
	
	
	
	
	

	public HomePage() throws IOException {
	   PageFactory.initElements(driver, this);	
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public void logOutFromApplication() throws InterruptedException {
		commonWait(moreOption);
		moreOption.click();
		commonWait(signOut);
		signOut.click();
		commonSleep();
		
	}
	
	public void openRegistrationPage() throws InterruptedException {
		//commonWait(ambMainMenu);
		commonActions(ambMainMenu);
		//commonWait(regitrationMenu);
		commonActions(regitrationMenu);
		commonSleep();
		
		
	}
	public void openInvoicePage() throws InterruptedException {
		commonWait(opBillingMainMenu);		
		commonActions(opBillingMainMenu);
		commonWait(invoiceMenu);
		commonActions(invoiceMenu);
		commonSleep();
		
	}
	
	public void openReceiptPage() throws InterruptedException {
		commonWait(opBillingMainMenu);
		commonActions(opBillingMainMenu);
		commonWait(receiptMenu);
		commonActions(receiptMenu);
		commonSleep();
		
	}
	

}
