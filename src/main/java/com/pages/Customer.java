package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customer {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//span[text()='My Customers']")
	WebElement cust;

	@FindBy(xpath = "//button//span[contains(text(),'New Customer')]")
	WebElement addNewCustomerBtn;

	@FindBy(xpath = "//input[@formcontrolname='LeadName']")
	WebElement refName;

	@FindBy(xpath = "//input[@formcontrolname='PersonName']")
	WebElement contactName;

	@FindBy(xpath = "//input[@formcontrolname='MobileNo']")
	WebElement mobileNo;

	@FindBy(xpath = "//button/span[text()=' Save ']")
	WebElement saveBtn;

	@FindBy(xpath = "//mat-row[1]/mat-cell[3]")
	WebElement validateRowName;

	public Customer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void addCustomer(String ref_name, String con_name, String mobile_num) {

		wait.until(ExpectedConditions.elementToBeClickable(cust)).click();
		wait.until(ExpectedConditions.elementToBeClickable(addNewCustomerBtn)).click();

		wait.until(ExpectedConditions.visibilityOf(refName)).sendKeys(ref_name);
		contactName.sendKeys(con_name);
		mobileNo.sendKeys(mobile_num);
        
		saveBtn.click();
	}

	public boolean validateAddedCustomer(String expectedName) {
		String actualName = wait.until(ExpectedConditions.visibilityOf(validateRowName)).getText();
		return actualName.equalsIgnoreCase(expectedName);
	}
}
