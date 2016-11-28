package sampletestdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFlipkart {

	SeleniumBase sbase = new SeleniumBase();
	String url = "https://www.flipkart.com/";
	String function = "LM6RPg";
	String value = "pendrive";
	String search = "/html/body/div[1]/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[2]/button";

	// String selectProduct =
	// "//*[@id=\"container\"]/div/div[2]/div[2]/div/div[1]/div/div/div[4]/section/div[2]/div[1]/div[2]/div/div/label/div[1]";
	String selectProduct = "Strontium";
	String brand = "//*[@id=\"container\"]/div/div[2]/div[2]/div/div[1]/div/div/div[4]/section/div[1]/div";
	String pval = "//*[@id=\"container\"]/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div[1]/div[1]/div/a[2]";

	String addCart = "//*[@id=\"container\"]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/ul/li[1]/button";

	String cart = "//*[@id=\"container\"]/div/header/div[1]/div[2]/div/div/a";

	String placeOrder = "//*[@id=\"view-cart-form\"]/button";

	String continueOrder = "//*[@id=\"cartpage-cart-tab-content\"]/div[1]/div[2]/div[2]/div[1]/button";

	String value1 = "Watch";

	@Test
	public void testMethod() {
		WebDriver driver = new FirefoxDriver();
		try {
			driver.get(url);
			driver.manage().window().maximize();
			textBoxMethod(driver);
			clickMethod(driver);
			// testText(driver);
			// testClick(driver);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}finally{
			driver.close();
		}
	}

	public void textBoxMethod(WebDriver driver) {
		try {
			sbase.enterToTextbox(driver, function, value);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	public void clickMethod(WebDriver driver) {
		try {
			sbase.click(driver, search);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			// sbase.click(driver, selectProduct);
			testClickButton(driver, selectProduct);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			sbase.click(driver, pval);
			sbase.click(driver, addCart);
			sbase.click(driver, cart);
			// sbase.click(driver, continueOrder);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	public void testClickButton(WebDriver driver, String pval) {
		try {
			WebElement scroll = driver.findElement(By.xpath(brand));
			scroll.sendKeys(Keys.PAGE_DOWN);
			for (int i = 2; i <= 15; i++) {
				// System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div[4]/section/div[2]/div[1]/div["+
				// i + "]/div/div/label/div[2]")).getText());
				if (driver.findElement(By
								.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div[4]/section/div[2]/div[1]/div["
										+ i + "]/div/div/label/div[2]"))
						.getText().trim().equalsIgnoreCase(pval.trim())) {
					driver.findElement(By
							.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div[4]/section/div[2]/div[1]/div["
									+ i + "]/div/div/label/div[2]"))
							.click();
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	/*
	 * public void testText(WebDriver driver){ try{
	 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 * sbase.enterToTextbox(driver, function, value1); }catch(Exception e){
	 * e.printStackTrace(); } }
	 * 
	 * public void testClick(WebDriver driver){ try{ sbase.click(driver, val);
	 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 * sbase.click(driver, selectProduct);
	 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 * sbase.click(driver, pval); sbase.click(driver, addCart);
	 * sbase.click(driver, cart); sbase.click(driver, placeOrder);
	 * }catch(Exception e){ e.printStackTrace(); } }
	 */

}
