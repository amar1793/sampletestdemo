package sampletestdemo;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClearTrip {

	SeleniumBase sbase = new SeleniumBase();

	String url = "https://www.cleartrip.com/flights";
	String fpath = "//*[@id=\"FromTag\"]";
	String fvalue = "MAA";
	String tpath = "//*[@id=\"ToTag\"]";
	String tvalue = "IXM";
	String str;
	String selectSeat = "Adults";
	String selectValue = "4";
	String selectChildSeat = "Childrens";
	String selectChildValue = "2";
	String submitButton = "SearchBtn";

	String id = "//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i";
	List<String> Month = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", 
				"October", "November", "December");
	int expectedMonth = 6;
	int expectedYear = 2017;
	String expectedDate = "26";
	String currentMonth = null;
	String currentYear = null;
	boolean isDateFound;

	@Test
	public void testMain() {
		WebDriver driver = new FirefoxDriver();
		try {
			driver.get(url);
			driver.manage().window().maximize();
			getText(driver);
			testDropDown(driver);
			clickDate(driver, expectedDate);
			//testClick(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getText(WebDriver driver) {
		try {
			sbase.enterToTextbox(driver, fpath, fvalue);
			sbase.enterToTextbox(driver, tpath, tvalue);
			str = sbase.printTextbox(driver, fpath, fvalue);
			System.out.println(str);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	public void testDropDown(WebDriver driver) {
		try {
			sbase.dropDown(driver, selectSeat, selectValue);
			sbase.dropDown(driver, selectChildSeat, selectChildValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testClick(WebDriver driver) {
		try {
			sbase.click(driver, submitButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDate(WebDriver driver, String str) {
		List<WebElement> value;
		WebElement datepicker;
		try {
			datepicker = driver.findElement(By.id("ui-datepicker-div"));
			value = datepicker.findElements(By.tagName("td"));
			for (WebElement cell : value) {
				if (cell.getText().equalsIgnoreCase(str)) {
					cell.findElement(By.linkText(str)).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickDate(WebDriver driver, String a) {
		driver.findElement(By.xpath(id)).click();

		isDateFound = true;
		int mode = 1;

		while (isDateFound) {
			while (mode <= 2) {
				currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();

				currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

				if (Month.indexOf(currentMonth) + 1 == expectedMonth && (expectedYear == Integer.parseInt(currentYear))) {
					selectDate(driver, expectedDate);
					isDateFound = false;
				} else if (Month.indexOf(currentMonth) + 1 > expectedMonth && (expectedYear == Integer.parseInt(currentYear))
						|| expectedYear < Integer.parseInt(currentYear)) {
					if (driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[" + mode + "]/table/tbody/tr[3]/td[4]/a"))
							.getText().trim().equalsIgnoreCase(a.trim())) {
						driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[" + mode + "]/table/tbody/tr[3]/td[4]/a"))
							.click();
					}	
				}
				driver.findElement(By.className("nextMonth")).click();
			}
		}
	}
}