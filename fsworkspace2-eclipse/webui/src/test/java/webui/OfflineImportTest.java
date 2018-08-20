package webui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import common.DateUtil;
import common.PageExecutor;

/**
 * 
 * @description 线下导入纸板订单
 * @author fs
 * @2018年8月13日
 *
 */
public class OfflineImportTest {
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
		pageor.getWebElement("//*[@id=\"header\"]/ul/li[4]").click();
		pageor.getWebElement("//*[@id=\"header\"]/ul/li[4]").click();
		System.out.println(DateUtil.getDate()+symbolSpilt+"点击订单管理");
		Thread.sleep(2000);
		pageor.getWebElement("//*[@id=\"menu\"]/div/ul/li[3]").click();
		Thread.sleep(3000);
		if(pageor.getWebElement("//*[@id=\"tHeader\"]").getText()
					.contains("线下纸板订单")) {
			System.out.println(DateUtil.getDate()+symbolSpilt+"进入菜单：线下纸板订单！");
		}
		
		//设置查询条件
		try {
		pageor.getWebElement("//*[@id=\"OmsOrderHeader\"]/ul[1]/li[1]/div/div[1]/div/div[1]/i").click();
		Thread.sleep(1000);
		
		//TODO 查询框下拉列表无法定位
		WebElement provice = driver.findElement(By.cssSelector("body > div.el-select-dropdown > div > div.el-select-dropdown__wrap.el-scrollbar__wrap > ul > li.el-select-dropdown__item.hover > span"));
		
		System.out.println(DateUtil.getDate()+symbolSpilt+"设置查询条件！");
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(DateUtil.getDate()+symbolSpilt+"查询条件添加失败！");
		}
	}
}
