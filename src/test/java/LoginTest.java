import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.Login;

import dev.failsafe.internal.util.Assert;

public class LoginTest {
 
	 WebDriver d;
	@BeforeMethod
	public void  setup(){
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://testffc.nimapinfotech.com/");
	}
	@Test(dataProvider="loginData")
    public void loginTest(String id, String p){
        Login l = new Login(d);
        l.entername(id);
        l.enterpass(p);
        l.logclick();
        org.testng.Assert.assertTrue(l.validate(),"login failed");
    }
	  @DataProvider
	    public Object[][] loginData(){
	        return new Object[][] {
	            {"9519519519", "12345678" }
	        };
	    }
	  @AfterMethod
		public void closebrow() {
			d.quit();
		}
	
 }

