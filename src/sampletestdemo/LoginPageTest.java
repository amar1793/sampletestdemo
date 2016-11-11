package sampletestdemo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {
	LoginBase lbase = new LoginBase();
	WebDriver driver;
	String uName = "login1";
	String pass = "password";
	String uNameVal = "amarnath1793";
	String passVal = "iamstupid";

	@BeforeTest
	public void launchPage(){
		try{
			lbase.launchTest("https://mail.rediff.com/cgi-bin/login.cgi");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void enterValue(){
		try{
			lbase.enterData(uName, uNameVal);
			lbase.enterData(pass, passVal);
			lbase.clickData("proceed");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
