package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

    WebDriver driver;
    WebDriverWait wait;

    // Punch-in Button
    @FindBy(xpath = "//button[contains(@class,'punch')]//span[contains(text(),'Punch')]")
    WebElement punchBtn;

    // Report textarea
    @FindBy(xpath = "//mat-dialog-container//textarea")
    WebElement reportBox;

    // Done button
    @FindBy(xpath = "//mat-dialog-container//button//span[text()='Done']/parent::button")
    WebElement doneBtn;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Click Punch In button
    public void punchIn() throws InterruptedException {
    	Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(punchBtn)).click();
        Thread.sleep(5000);
    }

    // Enter message in punch in dialog
    public void enterMessage(String msg) throws Exception  {
    	Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(reportBox)).sendKeys(msg);
        
    }

    // Click Done
    public void clickDone() throws InterruptedException {
    	Thread.sleep(4000);
    	wait.until(ExpectedConditions.elementToBeClickable(doneBtn)).click();
        Thread.sleep(4000);
        
    }

    // Validate Punch button is still enabled
    public boolean validatePunchButton() {
        return punchBtn.isEnabled();
    }
}
