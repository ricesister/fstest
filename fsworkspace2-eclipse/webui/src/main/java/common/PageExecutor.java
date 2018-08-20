package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageExecutor {
	private WebDriver driver;
	private String locmethod;
	
	/**
	 * 
	 * @param driver
	 * @param locmethod xpath等方式
	 */
	public PageExecutor(WebDriver driver,String locmethod) {
		this.driver = driver;
		this.locmethod = locmethod;
	}
	
	/*
	 * 默认使用xpath
	 */
	public  WebElement getWebElement(String locate) {
		if(locmethod.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locate));
		}
		if(locmethod.equalsIgnoreCase("linkText")) {
			return driver.findElement(By.linkText(locate));
		}
		if(locmethod.equalsIgnoreCase("cssSelector")) {
			return driver.findElement(By.cssSelector(locate));
		}
		return null;
	}
	
	
	/*
	 *自定义定位方式 
	 */
	public WebElement getElementByWay(String locate,String locmethod) {
		if(locmethod.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locate));
		}
		if(locmethod.equalsIgnoreCase("linkText")) {
			return driver.findElement(By.linkText(locate));
		}
		if(locmethod.equalsIgnoreCase("cssSelector")) {
			return driver.findElement(By.cssSelector(locate));
		}
		return null;
	}


	public void setLocmethod(String locmethod) {
		this.locmethod = locmethod;
	}
	
	
	

}
