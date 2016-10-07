package sampletestdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;

public class SampleSauceTest {

  public static final String USERNAME = "amarnath.m@zucisystems.com";
  public static final String ACCESS_KEY = "Zuci@456";
  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

  public static void main(String[] args) throws Exception {

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
    capabilities.setCapability("platformVersion", "4.4");
    capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
    capabilities.setCapability("browserName", "");
    capabilities.setCapability("deviceOrientation", "portrait");
    capabilities.setCapability("appiumVersion", "3.1.0");

    WebDriver driver = new AndroidDriver<>(new URL(URL), capabilities);

    /**
     * Test Actions here...
     */

    driver.quit();
  }
}