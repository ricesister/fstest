package webui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import common.DateUtil;
import common.PageExecutor;

/**
 * 
 * @description app启动页
 * @author fs
 * @2018年8月13日
 *
 */
public class AppTest {
	private static final String symbolSpilt = "=================";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		PageExecutor pageor = new PageExecutor(driver,"xpath");
		driver.get("http://192.168.10.170/");
		driver.manage().window().maximize();
		
		//登录过程
		pageor.getWebElement("/html/body/div[10]/div[2]/div[3]/ul/li[1]").click();
		pageor.getWebElement("//*[@id=\"username\"]").sendKeys("1000000");
		pageor.getWebElement("//*[@id=\"password\"]").sendKeys("dj123456");
		pageor.getWebElement("//*[@id=\"login-zhanghao\"]/div[7]/button").click();
		
		
		Thread.sleep(3000);
		//判断路径则为正确
		if(driver.getCurrentUrl().startsWith("http://192.168.10.201/?oncetoken=")) {
			System.out.println(DateUtil.getDate()+symbolSpilt+"登录线下crm成功，进入菜单界面");
		}
		
		
		//等待动画
		Thread.sleep(8000);
		
		//点击运营管理
		pageor.getWebElement("//*[@id=\"header\"]/ul/li[6]").click();
		pageor.getWebElement("//*[@id=\"header\"]/ul/li[6]").click();
		
		
		//点击广告管理
		try {
			pageor.getWebElement("//*[@id=\"menu\"]/div/ul/li[6]/div/span").click();
			Thread.sleep(5000);
			//使下菜单可见
			Actions action = new Actions(driver);
			action.clickAndHold(pageor.getWebElement("//*[@id=\"menu\"]/div/ul/li[1]"))
				.moveToElement(pageor.getWebElement("//*[@id=\"menu\"]/div/ul/li[8]/div/span"))	
					.release();
			action.build().perform();
			
			pageor.getWebElement("//*[@id=\"menu\"]/div/ul/li[6]/ul/li[6]").click();
			Thread.sleep(2000);
			System.out.println(DateUtil.getDate()+symbolSpilt+"点击app启动页菜单");
		}catch (Exception e) {
			
			e.printStackTrace();
			System.err.println(DateUtil.getDate()+symbolSpilt+"无法进入app启动页菜单");
			return;
		}	
		//验证进入首页轮播图页面
		if(pageor.getWebElement("//*[@id=\"tHeader\"]").getText().contains("APP启动页")) {
			System.out.println(DateUtil.getDate()+symbolSpilt+"进入app启动页界面");
		}
		
		Thread.sleep(2000);
		
		//下移页面
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		try {
		driver.findElement(By.className("el-upload__input")).sendKeys("C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\image\\app.jpg");
			System.out.println(DateUtil.getDate()+symbolSpilt+"添加APP图片成功");
		}catch (Exception e) {
			System.err.println(DateUtil.getDate()+symbolSpilt+"添加APP图片失败");
			return;
		}
		
		pageor.getWebElement("//*[@id=\"home\"]/div[2]/div/div/div[2]/div[3]/div[3]/button")
			.click();
		System.out.println(driver.findElement(By.className("el-upload__input")).getText());
		System.out.println(DateUtil.getDate()+symbolSpilt+"APP启动页编辑成功");
	}
}
