package sampletestdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMethod {
	SeleniumBase sbase = new SeleniumBase();
	String elementFunction = "u_0_i";
	String url3 = "https://www.facebook.com";
	String str;
	
	String path = "//*[@id=\"email\"]";
	String url4 = "http://signup.live.com";
	String func1 = "iOptinEmail";
			
	String func = "email";
	String val = "zuci";
	
	String dragva = "//*[@id=\"draggable\"]";
	String dropva = "//*[@id=\"droppable\"]";
	String url = "http://jqueryui.com/resources/demos/droppable/default.html";

	String url1 = "http://interface.eyecon.ro/demos/drag.html";
	String dragva1 = "//*[@id=\"drag2\"]";
	String dropva1 = "//*[@id=\"parentElem\"]";
	
	String url2 = "https://dhtmlx.com/docs/products/dhtmlxTree/samples/05_drag_n_drop/12_tree_drag.html";
	String dragva2 = "/html/body/div/div[1]/div[2]/div[2]/div/table/tbody/tr/td[1]/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr[5]/td[2]/table/tbody/tr/td[4]/span";
	String dropva2 = "/html/body/div/div[1]/div[2]/div[2]/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/table/tbody/tr[1]/td[4]/span";
	
	/*
	 * public void testMethod(){ WebDriver driver = new FirefoxDriver();
	 * driver.get("https://www.facebook.com/");
	 * 
	 * WebElement element = driver.findElement(By.id("email"));
	 * element.sendKeys("Pen Drive"); str =
	 * driver.findElement(By.id(elementFunction)).getText();
	 * System.out.println(str);
	 * //driver.findElement(By.className("nav-input")).click();
	 * //sbase.click(driver, "nav-input"); try{
	 * if(driver.findElement(By.id(elementFunction)).isDisplayed()){
	 * if(driver.findElement(By.id(elementFunction)).isEnabled()){
	 * driver.findElement(By.id(elementFunction)).click(); }
	 * //Assert.fail("Not Enabled"); }//Assert.fail("Not Displayed");
	 * 
	 * if(driver.findElement(By.id(elementFunction)).isSelected()){ //
	 * Assert.assertFalse(true); }else{ Assert.assertFalse(false); }
	 * }catch(Exception e){ e.printStackTrace(); } } }
	 */
	
	/*	public void isChecked() {
		try {
			WebDriver driver = new FirefoxDriver();
			driver.get(url);
			WebElement name = driver.findElement(By.id(elementFunction));

			Assert.assertEquals(name.isSelected(),true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/*	public void check(){
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		sbase.isChecked(driver, elementFunction);
	}	*/
	
/*	@Test
	public void checkBox(WebDriver driver){
		try{
			driver = new FirefoxDriver();
			driver.get(url4);
			driver.manage().window().maximize();
			sbase.checkBox(driver, func1);
		}catch(Exception e){
			Assert.fail();
			e.printStackTrace();
		}
	}		*/
	@Test
	public void getText() {
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.ie.driver", "F:\\Project Softwares\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		try {
			driver.get(url3);
			driver.manage().window().maximize();
			sbase.enterToTextbox(driver, path, val);
			str = sbase.printTextbox(driver, path, val);
			System.out.println(str);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	} 
/*	@Test
	public void checkRadio(WebDriver driver){
		try{
			driver = new FirefoxDriver();
			driver.get(url3);
			driver.manage().window().maximize();
			sbase.clickRadio(driver, elementFunction);
			sbase.isSelected(driver, elementFunction);
		}catch(Exception e){
			Assert.fail();
			e.printStackTrace();
		}
	}	
	@Test
	public void dragndrop(WebDriver driver){
		try{
			driver = new FirefoxDriver();
			driver.get(url2);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			sbase.DragnDrop(driver, dragva2, dropva2);
		}catch(Exception e){
			Assert.fail();
			e.printStackTrace();
		}
	}	
	@Test
	public void draganddrop(WebDriver driver){
		try{
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			sbase.DragnDrop(driver, dragva, dropva);
		}catch(Exception e){
			Assert.fail();
			e.printStackTrace();
		}
	}
	@Test
	public void dragdrop(WebDriver driver){
		try{
			driver = new FirefoxDriver();
			driver.get(url1);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			sbase.DragnDrop(driver, dragva1, dropva1);
		}catch(Exception e){
			Assert.fail();
			e.printStackTrace();
		}
	}		*/
}