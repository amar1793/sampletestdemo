package sampletestdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.android.AndroidDriver;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;

public class sample {

	@SuppressWarnings({ "rawtypes" })
	public static void main(String [] args) throws Exception {
		
		BrowserMobProxyServer server = new BrowserMobProxyServer();
		DesiredCapabilities capabilities = null;
		RemoteWebDriver driver = null;
		
		try{
			server.start();

			Proxy proxy = ClientUtil.createSeleniumProxy(server);
		
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability(CapabilityType.PLATFORM, "Android");
		capabilities.setCapability(CapabilityType.PROXY, proxy);
		capabilities.setCapability(CapabilityType.VERSION, "4.4.1");
		capabilities.setCapability("deviceName", "Zu");
		capabilities.setCapability("appPackage", "com.android.browser");
		capabilities.setCapability("appActivity", "com.android.browser.BrowserActivity");
		capabilities.setCapability("noReset", false);
		
		server.newHar("facebook.com");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
		try{
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Har har = server.getHar();
			
			File file = new File("Sample.har");
			FileOutputStream fos = new FileOutputStream(file);
			har.writeTo(fos);
		
		} catch (Exception e){
			e.printStackTrace();
		} 
		} finally {
			server.stop();
			driver.close();
		}
	}
}