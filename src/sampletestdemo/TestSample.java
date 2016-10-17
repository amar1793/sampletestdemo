package sampletestdemo;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestSample {

		@SuppressWarnings("rawtypes")
		private static AndroidDriver driver;
		@SuppressWarnings("rawtypes")
		public static void main(String[] args) throws MalformedURLException, InterruptedException {

			File appDir = new File( "F:\\Project Softwares");
			File app = new File(appDir, "com.android.chrome.apk");

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", "emulator-5554");
			capabilities.setCapability("platformVersion", "5.1.1");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.android.chrome");
			capabilities.setCapability("appActivity", "com.android.chrome.HomeActivity");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			Thread.sleep(10000);
			driver.quit();

	}

}