package sampletestdemo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {
	LoginBase lbase = new LoginBase();
	String uName = "login1";
	String pass = "password";
	String uNameVal = "amarnath1793";
	String passVal = "iamstupid";

	@BeforeTest
	public void launchPage(){

		try{
			lbase.launchTest("http://www.w3schools.com/html/html_tables.asp");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
/*	@Test
	public void enterValue(){
		try{
			lbase.enterData(uName, uNameVal);
			lbase.enterData(pass, passVal);
			lbase.clickData("proceed");
		} catch(Exception e){
			e.printStackTrace();
		}
	}	*/
	
	@Test
	public void getTable(){
		try{
			 lbase.tabledemo("//table/tbody/tr[5]/td[2]");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}