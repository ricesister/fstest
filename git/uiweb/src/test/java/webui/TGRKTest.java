package webui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.DateUtil;
import common.PageExecutor;

/**
 * 
 * @description 纸板团购修改
 * @author fs
 * @2018年8月13日
 *
 */
public class TGRKTest {
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
		pageor.getWebElement("//*[@id=\"menu\"]/div/ul/li[6]/div/span").click();
		Thread.sleep(1000);
		pageor.getWebElement("//*[@id=\"menu\"]/div/ul/li[6]/ul/li[4]").click();
		Thread.sleep(2000);
		//验证进入首页轮播图页面
		if(pageor.getWebElement("//*[@id=\"tHeader\"]").getText().contains("纸板团购入口")) {
			System.out.println(DateUtil.getDate()+symbolSpilt+"进入纸板团购入口界面");
		}
		
		Thread.sleep(2000);
		
		//有两种尺寸规格
		pageor.getWebElement("//*[@id=\"home\"]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[3]/table/tbody/tr[2]/td[5]/div/button").click();
		System.out.println(DateUtil.getDate()+symbolSpilt+"打开编辑入口图片界面");
		try {
		driver.findElement(By.className("el-upload__input")).sendKeys("C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\image\\tgrk.jpg");
			System.out.println(DateUtil.getDate()+symbolSpilt+"添加入口图片成功");
		}catch (Exception e) {
			System.err.println(DateUtil.getDate()+symbolSpilt+"添加入口图片失败");
			return;
		}
		
		pageor.getWebElement("//*[@id=\"home\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[5]/button[2]")
			.click();
		System.out.println(DateUtil.getDate()+symbolSpilt+"入口图片编辑成功");
	}
}