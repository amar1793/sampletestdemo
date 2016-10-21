package sampletestdemo;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class sample {
	
	public static WebDriver driver;

	@SuppressWarnings({ "rawtypes" })
	public static void main(String [] args) throws Exception {

		// set up appium and tell from where it can install the apk file from
		// computer to device
		File appDir = new File("F:\\Project Softwares");
		File app = new File(appDir, "org.mozilla.firefox.apk");
		// Very important properties you need for Appium to work, change as per
		// SDK and device name
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.PLATFORM, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "5.1.1");
		capabilities.setCapability("deviceName", "ZuciTest");
		capabilities.setCapability("autoLaunch",true);
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("app", app.getAbsolutePath());
		
		capabilities.setCapability("appPackage", "org.mozilla.firefox");
		capabilities.setCapability("appActivity", "org.mozilla.gecko.BrowserApp");
		// The URL where the hub will start
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.close();
	}
	}
