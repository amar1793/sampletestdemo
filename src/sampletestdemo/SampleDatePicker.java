package sampletestdemo;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleDatePicker {

	String url = "http://jqueryui.com/resources/demos/datepicker/other-months.html";
	String id = "//*[@id=\"datepicker\"]";
	List<String> Month = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December");
	int expMonth;
	int expYear;
	String expDate = null;
	String reqMonth = null;
	String reqYear = null;
	boolean isDateFound;
	String date = "3-8-2015";

	@Test
	public void launchPage() throws InterruptedException {
		WebDriver driver = launchBrowser(url);
		driver.findElement(By.xpath(id)).click();

		String date1[] = date.split("-");

		expDate = date1[0];
		expMonth = Integer.parseInt(date1[1]);
		expYear = Integer.parseInt(date1[2]);
		 //expDate = "3";
		 //expMonth = 8;
		 //expYear = 2006;
		isDateFound = true;

		while (isDateFound) {
			reqMonth = driver.findElement(By.className("ui-datepicker-month")).getText();

			reqYear = driver.findElement(By.className("ui-datepicker-year")).getText();

			if (Month.indexOf(reqMonth) + 1 == expMonth && (expYear == Integer.parseInt(reqYear))) {
				selectDate(driver, expDate);
				isDateFound = false;
			} else if (Month.indexOf(reqMonth) + 1 < expMonth && (expYear == Integer.parseInt(reqYear))|| expYear > Integer.parseInt(reqYear)) {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			} else if (Month.indexOf(reqMonth) + 1 > expMonth && (expYear == Integer.parseInt(reqYear))|| expYear < Integer.parseInt(reqYear)) {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
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
