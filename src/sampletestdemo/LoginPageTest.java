package sampletestdemo;

import org.testng.annotations.Test;

public class LoginPageTest {
	LoginBase lbase = new LoginBase();
	String uName = "login1";
	String pass = "password";
	String uNameVal = "amarnath1793";
	String passVal = "iamstupid";

	@Test
	public void launchPage(){
			lbase.launchTest("http://www.facebook.com");
		
	}
	@Test
	public void launchPage1(){
		lbase.launchTest("http://www.google.com");
	
}
	@Test
	public void launchPage2(){
		lbase.launchTest("http://www.rediff.com");
	
}
	@Test
	public void launchPage3(){
		lbase.launchTest("http://www.outlook.com");
	
}
	@Test
	public void launchPage4(){
		lbase.launchTest("http://www.guru99.com");
	
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
	}	

	@Test
	public void getimage(){
		try{
			lbase.imagedemo("#logocont > a > img");
		} catch (Exception e){
			e.printStackTrace();
		}
	}	*/
}