package sampletestdemo;

import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
 
public class SampleWhatsapp {
	
	WebDriver driver;
	
	@SuppressWarnings("rawtypes")
	@BeforeClass
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName", "Zuci");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //Name of mobile web browser to automate. Should be an empty string if automating an app instead.
		capabilities.setCapability(CapabilityType.VERSION, "5.1.1");
		capabilities.setCapability(CapabilityType.PLATFORM, "Windows");
		capabilities.setCapability("app-package", "com.whatsapp"); //Replace with your app's package
		capabilities.setCapability("app-activity", "com.whatsapp.Main"); //Replace with app's Activity
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void Cal(){
		driver.findElement(By.name("Weather")).click();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
 
}