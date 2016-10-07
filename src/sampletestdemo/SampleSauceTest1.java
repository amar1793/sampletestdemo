package sampletestdemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import java.net.URL;

public class SampleSauceTest1 {

  public static final String USERNAME = "YOUR_USERNAME";
  public static final String ACCESS_KEY = "YOUR_ACCESS_KEY";
  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

  public static void main(String[] args) throws Exception {

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("deviceName", "iPhone 6");
    capabilities.setCapability("platformVersion", "8.4");
    capabilities.setCapability("app", "https://s3.amazonaws.com/appium/TestApp8.4.app.zip");
    capabilities.setCapability("browserName", "");
    capabilities.setCapability("deviceOrientation", "portrait");
    capabilities.setCapability("appiumVersion", "1.5.3");

    WebDriver driver = new IOSDriver<>(new URL("http://ondemand.saucelabs.com:80/wd/hub"), capabilities);

    /**
     * Test Actions here...
     */

    driver.quit();
  }
}