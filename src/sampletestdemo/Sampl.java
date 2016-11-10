package sampletestdemo;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Sampl {
	public static void main(String [] args) {
		FirefoxDriver driver = null;
		
		try{
			driver = new FirefoxDriver();
			driver.get("http://www.google.com");
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}