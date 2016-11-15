package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginBase {
	WebDriver driver;
	
	public void launchTest(String url){
		try{
			driver = new FirefoxDriver();
			driver.get(url);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			driver.close();
		}
	}
	
	public void enterData(String elementFuntion, String elementFunction2){
		try{
			driver.findElement(By.id(elementFuntion)).sendKeys(elementFunction2);;
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean clickData(String elementFuntion3){
		try{
			driver.findElement(By.name(elementFuntion3)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void tabledemo(String elementFunction4){
		try{
			driver.findElement(By.xpath(elementFunction4)).getText();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void imagedemo(String elementFunction5){
		try{
			driver.findElement(By.cssSelector(elementFunction5)).click();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/*		Select from Dropdown		*/
	public boolean dropDown(String elementFunction, String elementValue ){
    	try{
    		new Select(driver.findElement(By.id(elementFunction))).selectByVisibleText(elementValue);
    		return equals(null);
    	}catch (Exception e){
    		e.printStackTrace();  
    		return false;
    	}
    }
	
	/*		Select from Checkbox		*/
	public boolean isChecked(String elementFunction){
    	try{
    		return driver.findElement(By.id(elementFunction)).isSelected();
    	}catch (Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    
	
	/*		Click the Submit Button		*/
	 public boolean submitButton(String elementFunction)
	    {
	    	try{
	    		driver.findElement(By.id(elementFunction)).click();
	    		return true;
	    	}
	    	catch (Exception e){
	    		e.printStackTrace();
	    		return false;
	    	}
	    }
}
