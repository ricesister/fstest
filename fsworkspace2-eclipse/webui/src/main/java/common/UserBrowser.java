package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @description 驱动类
 * @author fs
 * @2018年8月13日
 *
 */
public class UserBrowser {
	
	private static WebDriver driver;
	
	public static WebDriver getChrome() {
		//TODO 初始化失败，需要断言
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\src\\main\\resources\\chromedriver.exe");
		UserBrowser.driver = new ChromeDriver();
		LoggerUtil.info("初始化chromedriver成功！");
		return driver;
	}
	
	
	public static WebDriver getFireFox() {
		System.setProperty("webdriver.geckodriver.driver", 
				"C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\src\\main\\resources\\geckodriver.exe");
		UserBrowser.driver = new FirefoxDriver();
		LoggerUtil.info("初始化firefoxdriver成功！");
		return driver;
	}
	
	
	//TODO ie
	public static WebDriver getIE() {
		System.setProperty("webdriver.geckodriver.driver", 
				"C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\src\\main\\resources\\geckodriver.exe");
		UserBrowser.driver = new FirefoxDriver();
		LoggerUtil.info("初始化iedriver成功！");
		return driver;
	}
	

}
