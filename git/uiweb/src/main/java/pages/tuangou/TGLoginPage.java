package pages.tuangou;

import org.openqa.selenium.WebElement;

import common.LoggerUtil;
import pages.BasePage;

/**
 * 
 * @description 团购登录页面
 * @author fs
 * @2018年8月16日
 *
 */
public class TGLoginPage extends BasePage{
	
	private String login_name = "//*[@id=\"username\"]";
	private String login_pwd = "//*[@id=\"password\"]";
	private String login_click = "/html/body/div[1]/div[1]/div/div[2]/div[2]/div[1]";
	private String login_submit = "//*[@id=\"login-button\"]";
	private String username_check = "/html/body/div[1]/div[1]/div/div[2]/div[2]/div[2]/div[1]/span[1]";
	
	private String username = "18868196139";
	private String pwd = "dj123456";
	
	/**
	 * 团购登录脚本
	 * @throws InterruptedException 
	 */
	public void tgLogin() throws InterruptedException {
		open("http://192.168.10.202/group/grouponHome.html");
		sleep(2000);
		click(getLogin_click());
		checkUrl("http://192.168.10.202/login.html?redirectURL=http%3A%2F%2F192.168.10.202%2Fgroup%2FgrouponHome.html");
		sendKeys(getLogin_name(), username);
		sendKeys(getLogin_pwd(), pwd);
		click(getLogin_submit());
		sleep(2000);
		//checkUrl("http://192.168.10.202/group/grouponHome.html");
		checkText(getUsername_check(), "fsss果实企业");
		LoggerUtil.info("成功登录团购平台，用户名："+username);
	}
	
	
	public WebElement getLogin_name() {
		return getElement(login_name, "x");
	}
	public WebElement getLogin_pwd() {
		return getElement(login_pwd, "x");
	}
	public WebElement getLogin_click() {
		return getElement(login_click, "x");
	}
	public WebElement getLogin_submit() {
		return getElement(login_submit, "x");
	}


	public WebElement getUsername_check() {
		return getElement(username_check, "x");
	}
	
	
	
	
	
	

}
