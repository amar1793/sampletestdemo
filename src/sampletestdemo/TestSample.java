package sampletestdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSample {
	
	SeleniumBase sbase = new SeleniumBase();
	
	String url = "http://toolsqa.wpengine.com/automation-practice-form/";
	String fname = "/html/body/div[1]/div[5]/div[2]/div/div/form/fieldset/div[1]/input[1]";
	String fnameValue = "Zuci";
	String lname = "/html/body/div[1]/div[5]/div[2]/div/div/form/fieldset/div[1]/input[2]";
	String lnameValue = "Systems";
	String rvalue = "sex-0";
	String rvalue1 = "exp-5";
	String cvalue = "profession-0";
	String cvalue1 = "profession-1";
	String dvalue = "continents";
	String dvalue1 = "Australia";
	String qvalue = "tool-0";
	String qvalue1 = "tool-2";
	String str;

	@Test
	public void testMain(){
		WebDriver driver = new FirefoxDriver();
		try{
			driver.get(url);
			driver.manage().window().maximize();
			testText(driver);
			testRadio(driver);
			testCheckBox(driver);
			testDropDown(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void testText(WebDriver driver){
		try{
			sbase.enterToTextbox(driver, fname, fnameValue);
			sbase.enterToTextbox(driver, lname, lnameValue);
			str = sbase.printTextbox(driver, fname, fnameValue);
			System.out.println(str);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testRadio(WebDriver driver){
		try{
			sbase.clickRadio(driver, rvalue);
			sbase.clickRadio(driver, rvalue1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testCheckBox(WebDriver driver){
		try{
			sbase.checkBox(driver, cvalue);
			sbase.checkBox(driver, cvalue1);
			sbase.checkBox(driver, qvalue);
			sbase.checkBox(driver, qvalue1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testDropDown(WebDriver driver){
		try{
			sbase.dropDown(driver, dvalue, dvalue1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
