package sampletestdemo;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SelTest {
	
	@Test
	public void launchGoogle(){
		launchWebsite("http://google.com");
	}
	
	@Test
	public void launchZuci(){
		launchWebsite("http://zucisystems.com");
	}
	
	@Test
	public void launchAspire(){
		launchWebsite("http://aspiresys.com");
	}
	
	@Test
	public void launchYahoo(){
		launchWebsite("http://yahoo.com");
	}
	
	@Test
	public void launchFlipkart(){
		launchWebsite("http://flipkart.com");
	}
	
	@Test
	public void launchAmazon(){
		launchWebsite("http://amazon.com");
	}
	
	public static void launchWebsite(String url){
	
		FirefoxDriver driver = new FirefoxDriver();	
		try{
			driver.navigate().to(url);
			System.out.println("Page Title is " + driver.getTitle());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			driver.close();
		}
	}
}
