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
			lbase.launchTest("https://www.google.co.in/search?site=&q=Children%27s+Day+in+India&oi=ddle&ct=doodle-4-google-childrens-day-2016-india-5995349191688192-hp&hl=en&sa=X&ved=0ahUKEwi9ktfcz6fQAhXKCSwKHSRQAosQPQgE&biw=1366&bih=662&dpr=1");
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
	}	
	
	@Test
	public void getTable(){
		try{
			lbase.tabledemo("//table/tbody/tr[5]/td[2]");
		} catch (Exception e){
			e.printStackTrace();
		}
	}	*/

	@Test
	public void getimage(){
		try{
			lbase.imagedemo("#logocont > a > img");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}