import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Dashboard;
import com.pages.Login;

import dev.failsafe.internal.util.Assert;

public class PunchIn {
	WebDriver d;
	@BeforeMethod
	public void  setup() {
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://testffc.nimapinfotech.com/");
	}
	@Test
	public void check() throws Exception {
		Login l=new Login(d);
		Dashboard  dp=new Dashboard(d);
		l.entername("9519519519");
		l.enterpass("12345678");
		l.logclick();
		
		dp.punchIn();
		dp.enterMessage("hello Good Morning");
		dp.clickDone();
		assertTrue(dp.validatePunchButton(),"Punch-In  Successful");
	}
	@AfterMethod
    public void closebrow(){
        d.quit();
    }

}
