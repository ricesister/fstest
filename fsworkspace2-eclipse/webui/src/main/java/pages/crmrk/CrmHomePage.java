package pages.crmrk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.LoggerUtil;
import pages.BasePage;

/**
 * 
 * @description crm主页面
 * @author fs
 * @2018年8月14日
 *
 */
public class CrmHomePage extends BasePage{
	
	/**
	 * 导航
	 */
	private String homeTtitle = "//*[@id=\"first\"]/div/div/h1";
	
	private String ddgl = "//*[@id=\"header\"]/ul/li[4]";
	
	private String yygl = "//*[@id=\"header\"]/ul/li[6]";
	
	
	/**
	 * 运营管理子菜单
	 */
	private String gggl = "//*[@id=\"menu\"]/div/ul/li[6]/div";
	private String hdzx = "//*[@id=\"menu\"]/div/ul/li[13]/div";
	private String yhgl = "//*[@id=\"menu\"]/div/ul/li[1]";
	private String wlycdd = "//*[@id=\"menu\"]/div/ul/li[9]";
	private String xxzx = "//*[@id=\"menu\"]/div/ul/li[12]/div";
	private String kfycdd = "//*[@id=\"menu\"]/div/ul/li[11]";
	
	/**
	 * 活动中心子菜单
	 */
	private String hdgl = "//*[@id=\"menu\"]/div/ul/li[13]/ul/li[2]";
	
	/**
	 * 进入运营管理
	 * @throws InterruptedException
	 */
	public void toYYGL() throws InterruptedException {
		//等待动画结束
		//wait(10000, "//*[@id=\"first\"]/div/div/h1", "x");
		sleep(8000);
		click(getYYGL());
		click(getYYGL());
		LoggerUtil.info("点击运营管理");
		sleep(2000);
		//判断元素是否可见
		if(!driver.findElement(By.xpath("//*[@id=\"menu\"]/div/ul/li[6]/ul/li[1]")).isDisplayed()) {
			LoggerUtil.info("进入运营管理菜单");
		}
	}
	
	/**
	 * 进入广告管理
	 * @throws InterruptedException 
	 */
	public void toGGGL() throws InterruptedException {
		toYYGL();
		if(!checkVisable(getElement("//*[@id=\"menu\"]/div/ul/li[6]/ul/li[1]", "x"))) {
			click(getGGGL());
		}
		
		LoggerUtil.info("进入广告管理菜单");
	}
	
	/**
	 * 进入活动中心
	 * @throws InterruptedException
	 */
	public void toHDZX() throws InterruptedException {
		toYYGL();
		moveMenu(getYhgl(), getGGGL());
		sleep(3000);
		moveMenu(getGGGL(), getKfycdd());
		//moveMenu(getWlycdd(), getXxzx());
		sleep(8000);
		if(!checkVisable(getHdgl())) {
			click(getHdzx());
			sleep(8000);
		}
		LoggerUtil.info("进入活动中心菜单");
	}
	
	private WebElement getYYGL() {
		return getElement(yygl, "x");
	}
	
	private WebElement getGGGL() {
		return getElement(gggl, "x");
	}

	public WebElement getHdzx() {
		return getElement(hdzx, "x");
	}

	public WebElement getHdgl() {
		return getElement(hdgl, "x");
	}

	public WebElement getYhgl() {
		return getElement(yhgl, "x");
	}

	public WebElement getWlycdd() {
		return getElement(wlycdd, "x");
	}

	public WebElement getXxzx() {
		return getElement(xxzx, "x");
	}

	public WebElement getKfycdd() {
		return getElement(kfycdd, "x");
	}

	
	
	
	
	 
	
	

}
