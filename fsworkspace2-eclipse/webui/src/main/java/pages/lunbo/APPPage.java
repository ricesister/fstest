package pages.lunbo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import common.LoggerUtil;

/**
 * 
 * @description app启动页page
 * @author fs
 * @2018年8月14日
 *
 */
public class APPPage extends SYLBPage{
	
	private String app = "//*[@id=\"menu\"]/div/ul/li[6]/ul/li[6]";
	private String input = "//*[@id=\"home\"]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/input";
	private String submit = "//*[@id=\"home\"]/div[2]/div/div/div[2]/div[3]/div[3]/button";
	
	public void editAPP() throws InterruptedException {
		LoggerUtil.info("开始编辑app启动页");
		sleep(2000);
		moveMenu(getElement("//*[@id=\"menu\"]/div/ul/li[1]", "x"), 
				getElement("//*[@id=\"menu\"]/div/ul/li[8]/div/span", "x"));
		click(getApp());
		sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		LoggerUtil.info("下移屏幕");
		addPic("C:\\\\Users\\\\admin\\\\fsworkspace2-eclipse\\\\webui\\\\image\\\\app.jpg", 
				getInput());
		click(getSubmit());
	}
	
	public WebElement getApp() {
		return getElement(app, "x");
	}
	public WebElement getInput() {
		return getElement(input, "x");
	}
	public WebElement getSubmit() {
		return getElement(submit,"x");
	}
	
	
	
	

}
