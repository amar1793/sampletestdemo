package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBase {
	
	
	/*		Launch the Browser		*/
	public void launchBrowser(WebDriver driver, String url, String browserType){
		try{
		if(browserType.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();	// launch the firefox browser
			driver.get(url);	// enter the url
		} else{
			System.setProperty("webdriver.chrome.driver", "path to chromedriver.exe");	//set the path to chromedriver.exe
			driver = new ChromeDriver();	// launch the chrome browser
			driver.get(url);	// enter the url
		}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			driver.close();
		}
	}
	
	/*		Enter the value to Textbox		*/
	public void enterToTextbox(WebDriver driver, String elementFunction, String elementValue){
		try{
			driver.findElement(By.id(elementFunction)).sendKeys(elementValue);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*		Click the Radio Button		*/
	public void clickRadio(WebDriver driver, String elementFunction){
		try{
			driver.findElement(By.id(elementFunction)).isSelected();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*		Select from Dropdown		*/
	public boolean dropDown(WebDriver driver, String elementFunction, String elementValue ){
    	try{
    		new Select(driver.findElement(By.id(elementFunction))).selectByVisibleText(elementValue);
    		return equals(null);
    	}catch (Exception e){
    		e.printStackTrace();  
    		return false;
    	}
    }
	
	/*		Select from Listbox		*/
	public void listDown(WebDriver driver, String elementFunction, String elementValue ){
    	try{
    		 Select dataDropDown = new Select(driver.findElement(By.xpath(elementFunction)));
    	     dataDropDown.selectByVisibleText(elementValue);
    	}catch (Exception e){
    		e.printStackTrace();  
    	}
    }
	
	/*		Select from Checkbox		*/
	public boolean isChecked(WebDriver driver, String elementFunction){
    	try{
    		return driver.findElement(By.id(elementFunction)).isSelected();
    	}catch (Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    
	
	/*		Click the Submit Button		*/
	 public boolean submitButton(WebDriver driver, String elementFunction)
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
	
	/*		Get the Table Data		*/
	public void tableData(WebDriver driver, String elementFunction){
		try{
			driver.findElement(By.xpath(elementFunction)).getText();
			// String str = driver.findElement(By.xpath(elementFunction)).getText(); 
			// System.out.println(str);			// method to print the table value
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/*		Accessing the Link		*/
	public void linkData(WebDriver driver, String elementFunction){
		try{
			driver.findElement(By.linkText(elementFunction)).click();
			//driver.findElement(By.partialLinkText(elementFunction)).click();	//partial values (e.g click here = here)
			//driver.findElement(By.cssSelector(elementFunction)).click();	//while using image links (e.g google logo), or by xpath();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*		Read the Label		*/
	public String labelRead(WebDriver driver, String elementFunction, String label){
		try{
			WebElement element = driver.findElement(By.id(elementFunction));
			label = element.getText();
		}catch(Exception e){
			e.printStackTrace();
		}
		return label;
	} 

	/*		Image		*/
	public void Image(WebDriver driver, String elementFunction) {
		try{
		driver.findElement(By.xpath(elementFunction));
		}catch(Exception e){
			e.printStackTrace();
		}
}
}