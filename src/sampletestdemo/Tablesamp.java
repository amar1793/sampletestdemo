package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tablesamp {

	public static void main(String [] args){
		WebDriver driver;
		try{
				driver = new FirefoxDriver();
				driver.get("http://www.w3schools.com/html/html_tables.asp");
				String str = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[5]/td[2]")).getText();
				System.out.println(str);
		} catch (Exception e){
			e.printStackTrace();
		}
}
}