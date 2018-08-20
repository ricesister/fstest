package webui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import common.DateUtil;
import common.PageExecutor;
/**
 * 
 * @description  前置条件，轮播图少于5张
 *
 * @author fs
 * @2018年8月13日
 *
 */
public class SYLBTest {
	//TODO 写入网页字符串随机,close方法封装，查找元素添加catch
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
		pageor.getWebElement("//*[@id=\"menu\"]/div/ul/li[6]/ul/li[1]/span").click();
		Thread.sleep(2000);
		//验证进入首页轮播图页面
		if(pageor.getWebElement("//*[@id=\"tHeader\"]").getText().contains("首页轮播图")) {
			System.out.println(DateUtil.getDate()+symbolSpilt+"进入首页轮播图界面");
		}
		
		Thread.sleep(2000);
		//先判断个数是否超过5个，如果超过了，退出
		List<WebElement> rows = driver.findElement(By.className("el-table__body")).findElements(By.tagName("tr"));
		if(rows.size()==5) {
			System.out.println(DateUtil.getDate()+symbolSpilt+"首页轮播图位置已满，请先删除广告位！");
			driver.close();
			driver.quit();
			return;
		}
		//点击新增按钮
		pageor.getWebElement("//*[@id=\"home\"]/div[2]/div/div/div/div[2]/div[5]/button[1]").click();
		//验证首页轮播图新增窗口
		Thread.sleep(1000);
		if(pageor.getWebElement("//*[@id=\"home\"]/div[2]/div/div/div/div[3]/div[1]/div[1]/div/div[1]/span").getText()
				.startsWith("编辑图片")){
			System.out.println(DateUtil.getDate()+symbolSpilt+"打开新增轮播图窗口");
		}
		
		
		//新增首页轮播图脚本
		try {
			pageor.getWebElement("//*[@id=\"home\"]/div[2]/div/div/div/div[3]/div[1]/div[1]/div/div[2]/div[1]/div/div/input")
				.sendKeys("C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\image\\lunbo.jpg");
			System.out.println(DateUtil.getDate()+symbolSpilt+"上传首页轮播图附件成功！");
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(DateUtil.getDate()+symbolSpilt+"上传首页轮播图附件失败！");
		}
		
		try {
		
		//加入网页
		pageor.getWebElement("//*[@id=\"home\"]/div[2]/div/div/div/div[3]/div[1]/div[1]/div/div[2]/div[3]/div/div[1]/i")
			.click();
		System.out.println(DateUtil.getDate()+symbolSpilt+"打开网页选择下拉列表");
		WebElement choiceEle = driver.findElement(By.cssSelector("body > div.el-select-dropdown > div > div.el-select-dropdown__wrap.el-scrollbar__wrap > ul > li"));
		choiceEle.click();
		System.out.println(DateUtil.getDate()+symbolSpilt+"选择普通网页");
		driver.findElement(By.cssSelector("#home > div.box > div > div > div > div:nth-child(3) > div.carouse-uoloadImg > div.el-dialog__wrapper > div > div.el-dialog__body > div.carouse-uoloadImg-input > div > input"))
			.sendKeys("www.baidu.com");
		System.out.println(DateUtil.getDate()+symbolSpilt+"写入普通网页：www.baidu.com");
		
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(DateUtil.getDate()+symbolSpilt+"写入网页地址失败！");
		}
		
		pageor.getWebElement("//*[@id=\"home\"]/div[2]/div/div/div/div[3]/div[1]/div[1]/div/div[2]/div[5]/button[2]").click();
		System.out.println(DateUtil.getDate()+symbolSpilt+"点击保存首页轮播图！");
		
		//遍历轮播图
		List<WebElement> rows1 = driver.findElement(By.className("el-table__body")).findElements(By.tagName("tr"));
		WebElement lastRow = rows1.get(rows.size() - 1);
		List<WebElement> lcols = lastRow.findElements(By.tagName("td"));
		if(lcols.get(3).getText().contains("baidu")) {
			System.out.println(DateUtil.getDate()+symbolSpilt+"成功保存首页轮播图！");
		}
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
		
		
	
	}
	
	
	

}