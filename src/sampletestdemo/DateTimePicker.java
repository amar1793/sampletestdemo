package sampletestdemo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DateTimePicker {
	private String demosite = "http://jqueryui.com/datepicker/";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void startTest() {
		// Launch the demo site to handle date time picker.
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
	}

	@Test
	public void SelectDateFromJQueryCalendar() throws InterruptedException {
		// Start the date time picker demo website.
		driver.navigate().to(demosite);
		// click to open the date time picker calendar.
		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement);
		By dtp = By.xpath(".//*[@id='datepicker']");
		wait.until(ExpectedConditions.presenceOfElementLocated(dtp));
		driver.findElement(dtp).click();
		// Provide the day of the month to select the date.
		HandleJQueryDateTimePicker("22");
	}

	// Function to select the day of the month in the date picker.
	public void HandleJQueryDateTimePicker(String day) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-datepicker-div")));
		WebElement table = driver.findElement(By.className("ui-datepicker-calendar"));
		System.out.println("JQuery Calendar Dates");
		List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.xpath("td"));
			for (WebElement cell : cells) {
				if (cell.getText().equals(day)) {
					driver.findElement(By.linkText(day)).click();
				}
			}
		}
		// Switch back to the default screen again and scroll up by using
		// the negative y-coordinates.
		driver.switchTo().defaultContent();
		((JavascriptExecutor) driver).executeScript("scroll(0, -250);");
		// Intentional pause for 2 seconds.
		Thread.sleep(2000);
	}
}