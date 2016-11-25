package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBase {

	/* Launch the Browser */
	public void launchBrowser(WebDriver driver, String url) {
		try {
			driver = new FirefoxDriver();
			//System.setProperty("webdriver.ie.driver", "F:\\Project Softwares\\IEDriverServer.exe");
			//driver = new InternetExplorerDriver();
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// driver.close();
		}
	}

	/* Enter the value to Textbox */
	public void enterToTextbox(WebDriver driver, String elementFunction, String elementValue) {
		try {
			if (driver.findElement(By.xpath(elementFunction)).isDisplayed()) {
				if (driver.findElement(By.xpath(elementFunction)).isEnabled()) {
					WebElement element = driver.findElement(By.xpath(elementFunction));
					element.sendKeys(elementValue);
				} // Assert.fail("Not Enabled");
			} // Assert.fail("Not Displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String printTextbox(WebDriver driver, String elementFunction, String elementValue) {
		String str = null;
		try {
			if (driver.findElement(By.xpath(elementFunction)).isDisplayed()) {
				if (driver.findElement(By.xpath(elementFunction)).isEnabled()) {
					str = driver.findElement(By.xpath(elementFunction)).getAttribute("value");

				} // Assert.fail("Not Enabled");
			} // Assert.fail("Not Displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public void checkTextbox(WebDriver driver, String elementFunction, String elementValue) {
		try {
			if (driver.findElement(By.id(elementFunction)).isDisplayed()) {
				if (driver.findElement(By.id(elementFunction)).isEnabled()) {
					if (driver.findElement(By.id(elementFunction)).equals(null)) {
						WebElement element = driver.findElement(By.name(elementFunction));
						element.sendKeys(elementValue);
					} else {
						driver.findElement(By.id(elementFunction)).clear();
						driver.findElement(By.id(elementFunction)).sendKeys(elementValue);
					}
				} // Assert.fail("Not Enabled");
			} // Assert.fail("Not Displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Click the Radio Button */
	public void clickRadio(WebDriver driver, String elementFunction) {
		try {
			if (driver.findElement(By.id(elementFunction)).isDisplayed()) {
				if (driver.findElement(By.id(elementFunction)).isEnabled()) {
					WebElement element = driver.findElement(By.id(elementFunction));
					element.click();
				} // Assert.fail("Not Enabled");
			} // Assert.fail("Not Displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*		Click the Check Box		*/
	public void checkBox(WebDriver driver, String elementFunction){
		try{
			//if (driver.findElement(By.xpath(elementFunction)).isDisplayed()) {
				//if (driver.findElement(By.xpath(elementFunction)).isEnabled()) {
						driver.findElement(By.id(elementFunction)).click();
				//}
			//}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*		Select the Dropdown		*/
	public void dropDown(WebDriver driver, String elementFunction, String elementValue ){
    	try{
    		Select select = new Select(driver.findElement(By.id(elementFunction)));
    		select.selectByVisibleText(elementValue);
    	}catch (Exception e){
    		e.printStackTrace();  
    	}
    }
	
	public boolean isRadioSelected(WebDriver driver, String elementFunction) {
		try {
			if (driver.findElement(By.id(elementFunction)).isSelected()) {
				return true;
			} else {
				driver.findElement(By.id(elementFunction)).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// check whether radio is selected
	/*
	 * if(driver.findElement(By.id(elementFunction)).isSelected()){
	 * Assert.assertFalse(true); }else{ Assert.assertFalse(true); }
	 */

/*	public boolean isSelected(WebDriver driver, String elementFunction) {
		try {
			driver.findElement(By.id(elementFunction)).isSelected();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	*/

	public boolean isEnabled(WebDriver driver, String elementFunction) {
		try {
			return driver.findElement(By.id(elementFunction)).isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isDisplayed(WebDriver driver, String elementFunction) {
		try {
			return driver.findElement(By.id(elementFunction)).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*		Drag and Drop		*/
	public void DragnDrop(WebDriver driver, String elementFunction, String elementFunction1) {
		try {
			WebElement dragval = driver.findElement(By.xpath(elementFunction));
			WebElement dropval = driver.findElement(By.xpath(elementFunction1));
			Actions action = new Actions(driver);
			action.dragAndDrop(dragval, dropval).build().perform();
			// action.keyDown(Keys.CONTROL).click(dragval).dragAndDrop(dragval, dropval).keyUp(Keys.CONTROL).build().perform();
			// action.clickAndHold(dragval).moveToElement(dropval).release(dropval).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Click the Button */
	public void click(WebDriver driver, String elementFunction) {
		try {
			driver.findElement(By.id(elementFunction)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Click the Link Text */
	 public void linkData(WebDriver driver, String elementFunction){
			try{
				driver.findElement(By.linkText(elementFunction)).click();
				}catch(Exception e){
				e.printStackTrace();
			}
		}
}