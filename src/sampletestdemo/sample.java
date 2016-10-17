package sampletestdemo;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class sample {
	
	private WebDriver driver;

	@SuppressWarnings("rawtypes")
	@BeforeMethod
	public void setUp() throws Exception {

		// set up appium and tell from where it can install the apk file from
		// computer to device
		File appDir = new File("F:\\Project Softwares");
		File app = new File(appDir, "com.whatsapp.apk");
		// Very important properties you need for Appium to work, change as per
		// SDK and device name
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName", "Zuci");
		capabilities.setCapability("platformName", "Android");
		// You need to have this sdk installed for Appium to work
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("app", app.getAbsolutePath());
		// The URL where the hub will start
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
		@AfterMethod
		public void tearDown() throws Exception {
			driver.quit();
		}

		@Test
		public void whatsAppinstall() {
			// Find and click the accept button
			WebElement accept = driver.findElement(By
					.id("com.whatsapp:id/eula_accept"));
			accept.click();
			// Verify nect page title after you click accept button
			Assert.assertEquals("Verify your phone number",
					driver.findElement(By.id("android:id/action_bar_title"))
							.getText());
		}
}