package cbt.atm.core;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumDriver {

	//各模块使用统一的driver
	private static WebDriver driver = null;
	public static boolean isInitiated;
	
	
	public SeleniumDriver(String browserType){
		if(!isInitiated){
			if(browserType.equals("ie")){
				System.setProperty("webdriver.ie.driver", 
						".\\Tools\\IEDriverServer.exe");
				DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings",
						true);
				driver = new InternetExplorerDriver(DesiredCapabilities.internetExplorer());
			}else if(browserType.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", 
						".\\Tools\\chromedriver.exe");
				driver = new ChromeDriver();
			}else{
				System.setProperty("webdriver.firefox.bin", 
						"C:\\Program Files\\Mozilla Firefox\\firefox.exe");
				System.setProperty("webdriver.gecko.driver", 
						".\\Tools\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		isInitiated = true;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	//返回
	public WebDriver getWebDriver(){
		return driver;
	}
	
	//查找元素等待方法
	public void waitForElementPresent(By by){
		for(int i=1;i<=10;i++){
			try {
				Thread.sleep(1000);
				driver.findElement(by);
				break;
			} catch (InterruptedException e) {
				System.out.println("正在寻找元素，第"+i+"遍。。。");
				e.printStackTrace();
			}
			
		}
	}
	
	//判断元素是否存在
	public boolean isElementPresent(By by){
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//清除浏览器缓存
	public void deleteCookies(){
		if(driver == null) return;
		driver.manage().deleteAllCookies();
	}
	
	
	//关闭浏览器
	public void closeBrowser(){
		try {
			driver.quit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
}
