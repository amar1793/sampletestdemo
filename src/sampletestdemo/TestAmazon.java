package seleniumBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAmazon {

	SeleniumBase sbase = new SeleniumBase();
	String url = "https://www.amazon.in/";
	String function = "twotabsearchtextbox";
	String value = "Watch";
	String search = "//*[@id=\"nav-search\"]/form/div[2]/div/input";
	//String selectProduct = "//*[@id=\"result_0\"]/div/div[3]/div[1]/a/h2";
	String brand = "//*[@id=\"refinements\"]/h2[7]";
	String selectBrand = "Timex";
	String productValue = "//*[@id=\"result_0\"]/div/div/div/div[2]/div[2]/a/h2";
	String addCart = "//*[@id=\"add-to-cart-button\"]";
	String viewCart = "//*[@id=\"nav-cart\"]/span[2]";
	
	@Test
	public void testMethod(){
		WebDriver driver = new FirefoxDriver();
		try{
			driver.get(url);
			driver.manage().window().maximize();
			textBoxMethod(driver);
			clickMethod(driver);
		}catch(Exception e){
			Assert.fail();
			e.printStackTrace();
		}
	}

	public void textBoxMethod(WebDriver driver){
		try{
			sbase.enterToTextbox(driver, function, value);
		}catch(Exception e){
			Assert.fail();
			e.printStackTrace();
		}
	}
		
	public void clickMethod(WebDriver driver){
		try{
			sbase.click(driver, search);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//sbase.click(driver, selectBrand);
			testClickButton(driver, selectBrand);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			sbase.click(driver, productValue);
			for(String winHandle : driver.getWindowHandles()){
			       driver.switchTo().window(winHandle);
			   }
			sbase.click(driver, addCart);
			sbase.click(driver, viewCart);
		}catch(Exception e){
			Assert.fail();
			e.printStackTrace();
		}
	}
		
	public void testClickButton(WebDriver driver, String productName) {
		try {
			WebElement scroll = driver.findElement(By.xpath(brand));
			scroll.sendKeys(Keys.PAGE_DOWN);
			for (int i = 2; i <= 15; i++) {
				if (driver.findElement(By
								.xpath("//*[@id=\"ref_3837712031\"]/li["+i+"]/a/span"))
						.getText().trim().equalsIgnoreCase(productName.trim())) {
					driver.findElement(By
							.xpath("//*[@id=\"ref_3837712031\"]/li["+i+"]/a/span"))
							.click();
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	

}
