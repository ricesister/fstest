package cbt.atm.test;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import cbt.atm.core.Common;
import cbt.atm.core.DDL;
import cbt.atm.core.SeleniumDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	private Common common = new Common();
	
	private SeleniumDriver seld = new SeleniumDriver("firefox");
	private WebDriver driver = seld.getWebDriver();
	  
	@DataProvider(name="findkey")
	public Object[] data(){
		String[][] s =  new DDL().readExcel("C:\\Users\\admin\\Desktop\\fs\\ddl\\findkey.xls", 
				"Sheet1");
				
		return s;
		
	}
	
	@Test
	public void testJie(){
		
	}
	
	
	@Test(dataProvider="findkey")
	  public void f(String findkey) {
		  System.out.println(findkey);
		  driver.findElement(By.id("kw")).clear();
		  driver.findElement(By.id("kw")).sendKeys(findkey);
		  driver.findElement(By.id("su")).click();
		  common.sleepRandom(2, 5);
		  
	  }
	

	//@Parameter({"browser",""})
	  @BeforeClass
	  public void beforeClass(String browser) {
		  driver.navigate().to("https:\\www.baidu.com");
	  }
	
	  @AfterClass
	  public void afterClass() {
		  
		  seld.closeBrowser(); 
	  }

}
