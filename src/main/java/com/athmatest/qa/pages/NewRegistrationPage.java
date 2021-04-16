package com.athmatest.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.athmatest.qa.base.NewTestBase;

public class NewRegistrationPage extends NewTestBase {

	@FindBy(xpath = "//span[contains(text(),'Patient Registration')]")
	WebElement newRegistrationPageTitle;

	@FindBy(xpath = "//select[@ng-reflect-model='20']")
	WebElement registrationform;

	@FindBy(xpath = "//ng-select[@name='patientPrefix']")
	WebElement prefixDropdown;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='age']")
	WebElement ptage;

	@FindBy(xpath = "//input[@name='mobileNumber']")
	WebElement mobileNumber;

	@FindBy(xpath = "//input[@name='correspondencePincode']")
	WebElement correspondencePincode;

	// @FindBy(xpath = "button[contains(text(),'Register')]" )
	// @FindBy(xpath = "//button[@clas='athma-btn athma-btn-priamry']")
	@FindBy(css = "button[class='athma-btn athma-btn-priamry']")
	WebElement registerButton;

	// @FindBy(xpath = "button[contains(text(),'Cancel')]" )
	// @FindBy(xpath = "(//button[@class='athma-btn athma-btn-secondary'])[1]")
	// @FindBy(css = "button[ng-reflect-jhi-translate='register.button.cancel']")
	@FindBy(xpath = "//div[@class='navbar-arrow']")
	WebElement cancelButton;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okButtonOnConfirmationMsg;

	// button[contains(text(),'Register')]
	// button[contains(text(),'Cancel')]

	public NewRegistrationPage() throws IOException {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}

	public String newpatientRegistrationPageTitle() {
		commonWait(newRegistrationPageTitle);
		return newRegistrationPageTitle.getText();
	}

	public void selectRegistrationform(String form) {
		commonWait(registrationform);

		org.openqa.selenium.support.ui.Select sel = new org.openqa.selenium.support.ui.Select(registrationform);
		List<WebElement> options = sel.getOptions();

		/*
		 * for(WebElement item : options) { System.out.println(item.getText());
		 * 
		 * if(item.getText().equals("RPR_MRN_ONLY")); item.click(); break;
		 * 
		 * }
		 */
		sel.selectByVisibleText(form);

	}

	public void selectprefix(String prefix) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(prefixDropdown).click().build().perform();
		// commonSleep();
		// System.out.println((driver.findElement(By.xpath("(//span[@class='ng-option-label'])[1]"))).getText());
		for (int i = 1; i <= 27; i++) {

			WebElement dd = driver.findElement(By.xpath("(//span[@class='ng-option-label'])[" + i + "]"));
			// System.out.println(i);
			System.out.println(dd.getText());
			if (dd.getText().equals(prefix)) {
				commonWait(dd);
				dd.click();
				break;
			}
		}
	}

	public void EnterPatientDetails(String fn, String age, String zipcode) throws InterruptedException {
		commonWait(firstName);
		commonWait(ptage);
		commonWait(mobileNumber);
		commonWait(correspondencePincode);
		firstName.sendKeys(fn);
		ptage.sendKeys(age);
		// mobileNumber.sendKeys(mobile);
		correspondencePincode.sendKeys(zipcode);
		correspondencePincode.sendKeys(Keys.TAB);

	}

	public void clickOnRegisterandCancelButton() throws InterruptedException {
		commonWait(registerButton);
		commonActions(registerButton);
		// registerButton.click();
		commonSleep();
		commonWait(cancelButton);
		// cancelButton.click();
		// commonSleep();
		commonActions(cancelButton);
		commonWait(okButtonOnConfirmationMsg);
		commonActions(okButtonOnConfirmationMsg);
		// okButtonOnConfirmationMsg.click();
	}

}
