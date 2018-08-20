package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.AssertUtil;
import common.LoggerUtil;
import common.UserBrowser;

/**
 * 
 * @description 封装page基类
 * @author fs
 * @2018年8月13日
 *
 */
public class BasePage {
	
	/**
	 * 控制全局
	 */
	private boolean assertSymbol = true;
	private boolean clickSymbol = true;
	private boolean sendSymbol = true;
	private boolean cleanSymbol = true;
	
	
	public static WebDriver driver;
	protected static String rootUrl = "http://192.168.23.161/";
	
	/**
	 * driver初始化
	 */
	public BasePage() {
		if(driver == null) {
			driver = UserBrowser.getChrome();
		}
		
	}
	
	/**
	 * driver初始化
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * 打开页面
	 * @param toUrl
	 */
	public void open(String toUrl) {
		if(toUrl == null || toUrl.equals(rootUrl)) {
			driver.get(rootUrl);
			LoggerUtil.info("打开网页："+rootUrl);
			
		}
		else {
			driver.get(toUrl);
			LoggerUtil.info("打开网页："+toUrl);
		}
		
		driver.manage().window().maximize();
		LoggerUtil.info("将网页最大化");
	}
	
	/**
	 * 确认元素是否可见
	 * @param element
	 * @return
	 */
	public boolean checkVisable(WebElement element) {
		return element.isDisplayed();
	}
	/**
	 * 移动
	 * @param from
	 * @param to
	 */
	protected void moveMenu(WebElement from,WebElement to) {
		//使下菜单可见
		Actions action = new Actions(driver);
		action.clickAndHold(from).moveToElement(to)	.release();
		action.build().perform();
		LoggerUtil.info(String.format("页面从%s移动到%s", from.toString(),to.toString()));
	}
	
	/**
	 * 点击元素
	 * @param element
	 */
	protected void click(WebElement element) {
		clickSymbol = true;
		try {
			if (element.isEnabled()) {
				element.click();
				LoggerUtil.info(element.toString().trim()+"元素被点击");
			} 
		} catch (Exception e) {
			clickSymbol = false;
			e.printStackTrace();
			LoggerUtil.error("元素点击出现异常："+e.getMessage());
			AssertUtil.assertEquals(clickSymbol, true, "元素无法点击");
		}
	}
	
	/**
	 * 批量发送文本
	 * @param elements
	 * @param values
	 */
	protected void sendKeys(List<WebElement> elements,String[] values) {
		int i=0;
		for(WebElement element: elements) {
			sendKeys(element, values[i]);
			i++;
		}
	}
	
	/**
	 * 发送文本
	 * @param element
	 * @param value
	 */
	protected void sendKeys(WebElement element,String value) {
		sendSymbol = true;
		try {
			if (element.isEnabled()) {
				element.clear();
				element.sendKeys(value);
				LoggerUtil.info(element.toString().trim()+"元素被赋值："+value);
			} 
		} catch (Exception e) {
			sendSymbol = false;
			e.printStackTrace();
			LoggerUtil.error("元素赋值出现异常：\n"+e.getMessage());
			AssertUtil.assertEquals(sendSymbol, true, "元素无法被赋值！");
		}
	}
	
	/**
	 * 清空
	 * @param element
	 */
	protected void clean(WebElement element) {
		cleanSymbol = true;
		try {
			if (element.isEnabled()) {
				element.clear();
				LoggerUtil.info(element.toString().trim()+"元素内容被清空");
			} 
		} catch (Exception e) {
			cleanSymbol = false;
			e.printStackTrace();
			LoggerUtil.error("元素清空出现异常：\n"+e.getMessage());
			AssertUtil.assertEquals(sendSymbol, true, "元素无法被清空！");
		}
	}
	
	/**
	 * 判断元素显示在当前页面
	 * @param element
	 */
	protected void verifyELEIsPresent(WebElement element) {
		try {
			if(element.isDisplayed()) {
				LoggerUtil.info(element.toString().trim()+"元素在页面上显示");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.error("元素显示异常：\n"+e.getMessage());
		}
	}
	
	/**
	 * 获取当前titie
	 * @return
	 */
	public String getCurrentTitle() {
		String pageTitle = driver.getTitle();
		LoggerUtil.info("当前页面title："+pageTitle);
		return pageTitle;
	}
	
	/**
	 * 获取当前url
	 * @return
	 */
	public String getCurrentUrl() {
		String pageUrl = driver.getCurrentUrl();
		LoggerUtil.info("当前页面url是："+pageUrl);
		return pageUrl;
	}
	
	/**
	 * 确认路径与期望路径
	 * @param expectUrl
	 */
	public void checkUrl(String expectUrl) {
		LoggerUtil.info("确认脚本运行当前路径与期盼路径"+expectUrl+"一致");
		AssertUtil.assertEquals(getCurrentUrl(), expectUrl, "脚本运行当前路径与期盼路径不一致");
	}
	
	public void containUrl(String expectUrl) {
		LoggerUtil.info("确认脚本运行当前路径与期盼路径"+expectUrl+"是否为包含关系");
		AssertUtil.assertContains(getCurrentUrl(), expectUrl);
	}
	
	
	/**
	 * 确认文本正确
	 * @param ele
	 * @param expectText
	 */
	public void checkText(WebElement ele,String expectText) {
		AssertUtil.assertEquals(ele.getText(), expectText, "节点"+ele.toString()+"的内容"
				+ "与期盼文本"+expectText+"不一致");
	}
	
	
	/**
	 * 强制等待
	 * @param timeout
	 * @throws InterruptedException
	 */
	public void sleep(int timeout) throws InterruptedException {
		LoggerUtil.info("页面强制等待："+timeout+"毫秒");
		Thread.sleep(timeout);
	}
	
	/**
	 * 隐士
	 * @param timeout
	 */
	protected void waitImp(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		LoggerUtil.info("全局隐士等待："+timeout+"秒");
	}
	
	
	/**
	 * 显示等待
	 * @param timeout
	 * @param locator
	 * @param method
	 */
	protected void wait(int timeout,String locator,String method) {
		LoggerUtil.info(String.format("显式等待%s秒路径为%s的元素", timeout, locator));
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if(method.equalsIgnoreCase("x")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		}
		if(method.equalsIgnoreCase("c")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		}
		if(method.equalsIgnoreCase("tag")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locator)));
		}
		if(method.equalsIgnoreCase("class")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
		}
		
	}
	
/*	public static void main(String[] args) {
		 BasePage base = new BasePage(UserBrowser.getChrome());
		base.driver.get("https://www.baidu.com");
		base.driver.findElement(By.xpath("sss"));
		base.waitImp(10);
	}*/
	
	
	/**
	 * 获取一系列element,比如密码输入框，存在联系关系的
	 * @param path
	 * @param method 
	 * @return
	 */
	public List<WebElement> getSortsElement(String[] path,String method){
		AssertUtil.assertNotEquals(path.length, 0, "获取同系列联系关系的元素的Path数组不能为空");
		List<WebElement> elements = new ArrayList<WebElement>();
		for(int i=0;i<path.length;i++) {
			elements.add(getElement(path[i], method));
		}
		return elements;
	}
	
	public void quit() {
		try {
			driver.quit();
			LoggerUtil.info("退出浏览器，退出驱动");
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.error("退出浏览器，退出驱动失败！");
		}
	}
	
	
	/**
	 * 获取元素
	 * @param locate
	 * @param method
	 * @return
	 */
	protected WebElement getElement(String locate,String method) {
		
		assertSymbol = true;
		try {
			if(method.equalsIgnoreCase("css")) {
				return driver.findElement(By.cssSelector(locate));
			}
			if(method.equalsIgnoreCase("class")) {
				return driver.findElement(By.className(locate));
			}
			if(method.equalsIgnoreCase("tag")) {
				return driver.findElement(By.tagName(locate));
			}
			if(method.equalsIgnoreCase("id")) {
				return driver.findElement(By.id(locate));
			}
			if(method.equalsIgnoreCase("name")) {
				return driver.findElement(By.name(locate));
			}
			if(method.equalsIgnoreCase("link")) {
				return driver.findElement(By.linkText(locate));
			}
			if(method.equalsIgnoreCase("part")){
				return driver.findElement(By.partialLinkText(locate));
			}
			LoggerUtil.info(String.format("%s获取网页元素成功，元素定位：%s", method,locate));
			
			return driver.findElement(By.xpath(locate));
		} catch (Exception e) {
			assertSymbol = false;
			e.printStackTrace();
			LoggerUtil.error(String.format("%s获取网页元素失败，元素定位：%s", method,locate));
			AssertUtil.assertEquals(assertSymbol, true, "元素定位失败！");
		}
		return null;
	}
	
	
	
	
	

}
