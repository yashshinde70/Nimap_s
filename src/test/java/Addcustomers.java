import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.Customer;
import com.pages.Login;

public class Addcustomers {
	WebDriver d;
	@BeforeMethod
	public void  setup() {
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://testffc.nimapinfotech.com/");
		
	
	}
	@Test(dataProvider = "datacust")
	public void Addcust(String r,String c,String m) {
		Login l=new Login(d);
		Customer cp=new Customer(d);
		
		l.entername("9519519519");
		l.enterpass("12345678");
		l.logclick();

		cp.addCustomer(r, c, m);
		assertTrue(cp.validateAddedCustomer(r),"customer is not added ");
	}
	
	@DataProvider
	public  Object[][] datacust(){
		return new Object [][] {
			{ "Yash","jack","1111111111"}
		};
		
	}
	@AfterMethod
	public void closebrow() {
		d.quit();
	}
	

}
