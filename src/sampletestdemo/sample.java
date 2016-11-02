package sampletestdemo;

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

	@SuppressWarnings({ "rawtypes", "static-access" })
	public static void main(String [] args) throws Exception {
		
		BrowserMobProxyServer server = new BrowserMobProxyServer();
		DesiredCapabilities capabilities = null;
		RemoteWebDriver driver = null;
		
		try{
			server.start();
			/*			Get the Selenium Proxy Object			*/
			Proxy proxy = ClientUtil.createSeleniumProxy(server);
		
		/*	capabilities = new DesiredCapabilities().android();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
			capabilities.setCapability("automationName", "Appium");
			capabilities.setCapability(CapabilityType.PLATFORM, "Android");
			capabilities.setCapability(CapabilityType.PROXY, proxy);
			capabilities.setCapability(CapabilityType.VERSION, "4.4.1");
			capabilities.setCapability("deviceName", "Zu");
			capabilities.setCapability("appPackage", "com.android.browser");
			capabilities.setCapability("appActivity", "com.android.browser.BrowserActivity");
			capabilities.setCapability("noReset", false); */
			
			capabilities = new DesiredCapabilities().android();
			capabilities.setCapability(CapabilityType.PROXY, proxy);
			capabilities.setCapability("automationName", "Appium");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "5.1.1");
			capabilities.setCapability("deviceName", "emulator-5558");
			capabilities.setCapability("browserName", "");
			capabilities.setCapability("newCommandTimeout", 60);
			capabilities.setCapability("appPackage", "org.mozilla.fennec");
			capabilities.setCapability("appActivity", "org.mozilla.gecko.BrowserApp");
		
			//driver = new RemoteWebDriver(capabilities);
			//server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
			
		server.newHar("http://www.rediff.com");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		driver.get("http://www.rediff.com");
		try{
			driver.manage().timeouts().implicitlyWait(60000,TimeUnit.SECONDS);
			Har har = server.getHar();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			FileOutputStream fos = new FileOutputStream("Sample.har");
			har.writeTo(fos);
		} catch (Exception e){
			e.printStackTrace();
		} 
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			server.stop();
			driver.close();
		}
	}
}