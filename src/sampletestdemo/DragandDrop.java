package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragandDrop {

	WebDriver driver;
	
	@Test
	public void draganddrop(){
		 try{
			 driver = new FirefoxDriver();
			 driver.get("http://www.useragentman.com/tests/dragAndDrop/permissionForm.html");
			 WebElement drag = driver.findElement(By.xpath("//*[@id=\"unassignedUsers\"]/a[4]"));
				WebElement drop = driver.findElement(By.xpath( "//*[@id=\"powerUsers\"]"));
				Actions action = new Actions(driver);
				action.dragAndDrop(drag, drop).build().perform();
			
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	
}