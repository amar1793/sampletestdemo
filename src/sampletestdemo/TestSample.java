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
		public static AndroidDriver driver;
		@SuppressWarnings("rawtypes")
		public static void main(String[] args) throws MalformedURLException, InterruptedException {

			try{
			//File appDir = new File( "F:\\Project Softwares");
			File app = new File("F:\\Project Softwares\\com.android.chrome-45.0.2454.84-245408400-minAPI16.apk");

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", "ZuciTest");
			capabilities.setCapability("platformVersion", "6.0");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.android.chrome");
			capabilities.setCapability("appActivity", "com.android.chrome.MainActivity");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			Thread.sleep(10000);
			

			} catch(Exception e){
				e.printStackTrace();
			} finally{
				driver.quit();
			}
	}

}