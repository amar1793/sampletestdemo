package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SampleDatePicker1 {

	String url = "https://www.icicilombard.com/registration?returl=/manage-your-policy/dashboard";
	String element = "//*[@id=\"innerPg_C009_Col01\"]/div/div/div/div/div/div[2]/div/div[3]/div/div[2]/img";
	String path = "//*[@id=\"ui-datepicker-div\"]/div/div/select[1]";
	String value = "Aug";
	String path1 = "//*[@id=\"ui-datepicker-div\"]/div/div/select[2]";
	String value1 = "1998";
	String value2 = "3";

	@Test
	public void launchPage() {
		try {
			WebDriver driver = launchBrowser(url);
			clickValue(driver, element);
			dropDown(driver, path, value);
			dropDown(driver, path1, value1);
			//System.out.println(driver.findElement(By.xpath(path)).getText());
			dateValue(driver, value2);
			// driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickValue(WebDriver driver, String element) {
		try {
			driver.findElement(By.xpath(element)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dropDown(WebDriver driver, String path, String value) {
		try {
			new Select(driver.findElement(By.xpath(path))).selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public boolean isElementPresent(WebDriver driver, String elementLocator) {

		boolean returnValue = false;
		try {
			if (driver.findElement(By.xpath(elementLocator)).isEnabled()) {
				returnValue = true;
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return returnValue;
	}

	public void dateValue(WebDriver driver, String a) {
		int rowCounter = 1;
		int columnCounter = 1;
		
			while (rowCounter <= 5) {
				columnCounter = 1;
				while (columnCounter <= 7) {
					if (isElementPresent(driver, "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[" + rowCounter + "]/td["
							+ columnCounter + "]/a")) {
						if (driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[" + rowCounter
										+ "]/td[" + columnCounter + "]/a")).getText().trim().equalsIgnoreCase(a.trim())) {
							driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[" + rowCounter
									+ "]/td[" + columnCounter + "]/a")).click();
							return;
						}
					}
				}
				columnCounter++;
			}
			rowCounter++;
	}	

	public WebDriver launchBrowser(String url) {
		WebDriver driver = null;
		try {
			driver = new FirefoxDriver();
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
