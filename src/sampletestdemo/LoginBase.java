package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
			//driver.close();
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
	
	public String tabledemo(String elementFunction4){
		String value = null;
		try{
			WebElement element = driver.findElement(By.xpath(elementFunction4));
			value = element.getText();
		} catch (Exception e){
			e.printStackTrace();
		}
		return value;
	}
	
	public void imagedemo(String elementFunction5){
		try{
			driver.findElement(By.cssSelector(elementFunction5)).click();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/*		Select from Dropdown		*/
	public void dropDown(String elementFunction, String elementValue ){
    	try{
    		new Select(driver.findElement(By.id(elementFunction))).selectByVisibleText(elementValue);
    	}catch (Exception e){
    		e.printStackTrace();  
    	}
    }
	
	/*		Select from Checkbox		*/
	public void isChecked(String elementFunction){
    	try{
    		driver.findElement(By.cssSelector(elementFunction)).click();
    	}catch (Exception e){
    		e.printStackTrace();
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
	 
	 public void listDown(String elementFunction, String elementValue, String elementValue1, String elementValue2 ){
	    	try{
	    		 Select se = new Select(driver.findElement(By.id(elementFunction)));
	    	     se.selectByVisibleText(elementValue);
	    	     se.selectByVisibleText(elementValue1);
	    	     se.selectByVisibleText(elementValue2);
	    	}catch (Exception e){
	    		e.printStackTrace();  
	    	}
	    }
	 
	 public void draganddrop(String elementFunction, String elementValue){
		 try{
			 WebElement drag = driver.findElement(By.xpath(elementFunction));
				WebElement drop = driver.findElement(By.xpath(elementValue));
				Actions action = new Actions(driver);
				action.dragAndDrop(drag, drop).build().perform();
			
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	 
	 public void linkData(String elementFunction){
			try{
				driver.findElement(By.xpath(elementFunction)).click();
				}catch(Exception e){
				e.printStackTrace();
			}
		}
}
