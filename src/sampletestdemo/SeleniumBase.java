package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBase {
	
	/*		Launch the Browser		*/
	public void launchBrowser(WebDriver driver, String url){
		try{
			driver = new FirefoxDriver();	// launch the firefox browser
			driver.get(url);	// enter the url
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			driver.close();
		}
	}
	
	/*		Get the Table Date		*/
	public void tableData(WebDriver driver, String elementFunction){
		try{
			driver.findElement(By.xpath(elementFunction)).getText();	// for table value, the value to be specified in xpath only
			// String str = driver.findElement(By.xpath(elementFunction)).getText(); 
			// System.out.println(str);			// method to print the table value
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/*		Accessing the Link		*/
	public void linkData(WebDriver driver, String elementFunction){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	
}
