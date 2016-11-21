package sampletestdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class calculator {
	
	@Test
	public void testVerifyAddition() throws InterruptedException{
		WebDriver driver = launchBrowser("http://www.calculator.net/");
		operateOnNumbers(driver, 750, 250, "+");	
		Assert.assertTrue(fetchOutput(driver).trim().startsWith(Integer.toString(750+250)));
		driver.close();
	}
	
	@Test
	public void testVerifySymbol() throws InterruptedException{
		WebDriver driver = launchBrowser("http://www.calculator.net/");
		operateOnSymbols(driver, 45, "tan");
		//Assert.assertTrue(fetchOutput(driver).trim().startsWith(Double.toString(Math.sin(90*Math.PI/180))));
		//driver.close();
	}
	
	@Test
	public void testVerifySymbol1() throws InterruptedException{
		WebDriver driver = launchBrowser("http://www.calculator.net/");
		operateOnSymbols(driver, 6, "x2");
		//Assert.assertTrue(fetchOutput(driver).trim().startsWith(Integer.toString(6*6)));
		//driver.close();
	}
	
	public void operateOnNumbers(WebDriver driver, int number1, int number2, String operator){
		
		feedNumberToCalc(driver, number1);
		clickKeysNormalMode(driver, operator);
		feedNumberToCalc(driver, number2);
		clickKeysNormalMode(driver, "=");
	}	
	
	public void operateOnSymbols(WebDriver driver, int number3, String sym){
		feedNumberToCalc(driver, number3);
		clickKeysScientificMode(driver, sym);
		//clickKeysNormalMode(driver, "=");
	}
	
	public String fetchOutput(WebDriver driver){
		
		String returnValue = "";
		try{
			returnValue = driver.findElement(By.xpath("//table/tbody/tr[1]/td/div/div")).getText();
		}catch (Exception e) {
		}
		return returnValue;
		
	}
	
	public void feedNumberToCalc (WebDriver driver, int number){
		
		// Store number into Array
		int numberArray[] = new int[10];
		int arrayCounter = 0;
		while (number > 0){
			numberArray[arrayCounter] = number % 10;
			number = number / 10;
			arrayCounter++;
		}
		arrayCounter = arrayCounter - 1;
		
		// Type Numbers
		while (arrayCounter >= 0){
			clickKeysNormalMode(driver, Integer.toString(numberArray[arrayCounter]));
			arrayCounter--;
		}
	}
	
	public void clickKeysNormalMode(WebDriver driver, String a){
		
		int rowCounter = 1;
		int columnCounter = 1;

		
		while(rowCounter <= 5){
			columnCounter = 1;
			while(columnCounter <= 5){
				//System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText()+"("+driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText().length()+")"+"   ");
				if(driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText().trim().equalsIgnoreCase(a.trim())){
					driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/div["+rowCounter+"]/span["+columnCounter+"]")).click();
					//System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText()+"("+driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText().length()+")"+"   ");
					break;
				} 
				columnCounter++;
			}
			//System.out.println();
			rowCounter++;
		}
	}
/*		rowCounter = 1;
		while(rowCounter <= 5){
			columnCounter = 1;
			while(columnCounter <= 4){
				//System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText()+"("+driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText().length()+")"+"   ");
				if(driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText().trim().equalsIgnoreCase(a.trim())){
					driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter+"]/span["+columnCounter+"]")).click();
					break;
				} 
				columnCounter++;
			}
			//System.out.println();
			rowCounter++;
		}
		rowCounter = 2;
		while(rowCounter <= 5){
			columnCounter = 1;
			while(columnCounter <= 5){
				//System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText()+"("+driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText().length()+")"+"   ");
				if(driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter+"]/span["+columnCounter+"]")).getText().trim().equalsIgnoreCase(a.trim())){
					driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter+"]/span["+columnCounter+"]")).click();
					break;
				} 
				columnCounter++;
			}
			//System.out.println();
			rowCounter++;
		}
	}		
	
	public void clickKeysScientificMode(WebDriver driver, String a){
		
			int rowCounter1 = 1;
			int columnCounter1 = 1;

		
			while(rowCounter1 <= 5){
				columnCounter1 = 1;
				while(columnCounter1 <= 5){
					System.out.print(driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter1+"]/span["+columnCounter1+"]")).getText()+"("+driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/div["+rowCounter1+"]/span["+columnCounter1+"]")).getText().length()+")"+"   ");
				//	if(driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div[1]/span[5]")).equals(null)){
					if(driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter1+"]/span["+columnCounter1+"]")).getText().trim().equalsIgnoreCase(a.trim())){
						driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter1+"]/span["+columnCounter1+"]")).click();
						//System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div/div["+rowCounter1+"]/span["+columnCounter1+"]")).getText()+"("+driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/div["+rowCounter1+"]/span["+columnCounter1+"]")).getText().length()+")"+"   ");
						break;
					} 
				//	}
					columnCounter1++;
				}
				rowCounter1++;
			}
		}	*/
	
	public void clickKeysScientificMode(WebDriver driver, String a) {
		int rowCounter = 1;
		int columnCounter = 1;
		int modeCounter = 1;
		try {
			while (rowCounter <= 5) {
				columnCounter = 1;
				while (columnCounter <= 5) {
					modeCounter = 1;
					while (modeCounter <= 2) {
							if (isElementPresent(driver, "//table/tbody/tr[2]/td[" + modeCounter + "]/div/div[" + rowCounter
									+ "]/span[" + columnCounter + "]")) {
								if (driver
										.findElement(By.xpath("//table/tbody/tr[2]/td[" + modeCounter + "]/div/div["
												+ rowCounter + "]/span[" + columnCounter + "]"))
										.getText().trim().equalsIgnoreCase(a.trim())) {
									driver.findElement(By.xpath("//table/tbody/tr[2]/td[" + modeCounter + "]/div/div["
											+ rowCounter + "]/span[" + columnCounter + "]")).click();
									return;
								}
							}
						modeCounter++;
					}
					columnCounter++;
				}
				rowCounter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isElementPresent(WebDriver driver, String elementLocator) {

		boolean returnValue = false;
		try {
			if (driver.findElement(By.xpath(elementLocator)).isDisplayed()) {
				returnValue = true;
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}

		return returnValue;
	}

	public WebDriver launchBrowser(String url){ 
		WebDriver driver = null;
			try{
				driver = new FirefoxDriver();
				driver.get(url);
			} catch (Exception e){
				e.printStackTrace();
			} 	
			return driver;
		}
}