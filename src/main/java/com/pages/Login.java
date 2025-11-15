package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;
	 WebDriverWait wait;
	 
	 @FindBy(xpath = "/html/body/kt-auth/div/div/div[2]/kt-login/div[2]/div/form/div[1]/mat-form-field/div/div[1]/div/input") WebElement id;
	 @FindBy(xpath = "/html/body/kt-auth/div/div/div[2]/kt-login/div[2]/div/form/div[2]/mat-form-field/div/div[1]/div/input") WebElement pass;
	 @FindBy(xpath = "/html/body/kt-auth/div/div/div[2]/kt-login/div[2]/div/form/div[4]/button[1]") WebElement btn;
	 @FindBy(xpath = "/html/body/kt-base/div[2]/div/div/kt-header/div/kt-page-title/div/div/div/h3") WebElement titel;
	 public Login(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 wait =new WebDriverWait(driver, Duration.ofSeconds(4));
		 
	 }
	 public void entername(String name) {
		 id.sendKeys(name);
	 
	}
	 public void enterpass(String p) {
		 pass.sendKeys(p);
	 }
	  public void logclick() {
		  btn.click();
	  }
	  public boolean validate() {
		  return wait.until(ExpectedConditions.visibilityOf(titel)).isDisplayed();
	  }
}
