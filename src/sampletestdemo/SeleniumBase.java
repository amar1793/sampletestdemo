package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBase {
	
	/*		Launch the Browser		*/
	public void launchBrowser(WebDriver driver, String url){
		try{
			driver = new FirefoxDriver();	// launch the firefox browser
			//System.setProperty("webdriver.chrome.driver", "path to chromedriver.exe");
			//driver = new ChromeDriver();	// launch the chrome browser
			driver.get(url);	// enter the url
		} catch (Exception e){
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
	public void clickEvent(WebDriver driver, String elementFunction){
		try{
			driver.findElement(By.id(elementFunction)).click();
		}catch(Exception e){
			e.printStackTrace();
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
	
	
	
}
