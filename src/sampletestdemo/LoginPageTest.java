package sampletestdemo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {
	LoginBase lbase = new LoginBase();
	String fName = "FirstName";
	String lName = "LastName";
	String fNameVal = "Amarnath";
	String lNameVal = "M";
	String monthval = "BirthMonth";
	String monthname = "September"; 
	String checkval = "iOptinEmail";
	String submitbutton = "CredentialsAction";
	String country = "PhoneCountry";
	String value = "india";
	//String imgcssval = "#logocont > a > img";
	//String tabval = "//table/tbody/tr[5]/td[2]";
	
	
	@BeforeTest
	public void launchPage(){
			lbase.launchTest("https://signup.live.com");	
	}
	/*@Test
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
	
}*/
	
	@Test
	public void enterValue(){
		try{
			lbase.enterData(fName, fNameVal);
			lbase.enterData(lName, lNameVal);
		} catch(Exception e){
			e.printStackTrace();
		}
	}	
	
	@Test
	public void dropdown(){
		try{
			lbase.dropDown(monthval, monthname);
		} catch (Exception e){
			e.printStackTrace();
		}
	}	
	
	@Test
	public void checkbox(){
		try{
			lbase.isChecked(checkval);
		} catch (Exception e){
			e.printStackTrace();
		}
	}	
	
	@Test
	public void submit(){
		try{
			lbase.submitButton(submitbutton);
		} catch (Exception e){
			e.printStackTrace();
		}
	}	

	@Test
	public void dropDownval(){
		try{
			lbase.dropDown(country, value);
			//System.out.println("All Values in Combo - " +new Select(driver.findElement(By.id(country))).getOptions());
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
/*	@Test
	public void getTable(){
		try{
			lbase.tabledemo(tabval);
		} catch (Exception e){
			e.printStackTrace();
		}
	}	

	@Test
	public void getimage(){
		try{
			lbase.imagedemo(imgcssval);
		} catch (Exception e){
			e.printStackTrace();
		}
	}	*/
}