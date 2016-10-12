package sampletestdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;

public class AppiumTest {

 // public static final String USERNAME = "amarnath.m@zucisystems.com";
 // public static final String ACCESS_KEY = "Zuci@456";
  public static final String URL = "https://127.0.0.1:4723/wd/hub";

  @SuppressWarnings("rawtypes")
public static void main(String[] args) throws Exception {

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
    capabilities.setCapability("deviceName", "Zuci");
    capabilities.setCapability("platformVersion", "5.1.1");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");

    WebDriver driver = new AndroidDriver(new URL(URL), capabilities);
    driver.quit();
  }
}