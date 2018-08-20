package pages.crmrk;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.AssertUtil;
import common.LoggerUtil;
import pages.BasePage;

/**
 * 
 * @description 线下crm登录页面
 * @author fs
 * @2018年8月13日
 *
 */
public class CrmLoginPage extends BasePage{
	
	/**
	 * 路径
	 */
	private String x_crm = "/html/body/div[10]/div[2]/div[3]/ul/li[1]";
	
	private String x_username = "//*[@id=\"username\"]";
	
	private String x_password = "//*[@id=\"password\"]";
	
	private String x_submit = "//*[@id=\"login-zhanghao\"]/div[7]/button";
	
	
	public void setUserName(String name) {
		sendKeys(getUserName(), name);
	}
	
	public void setPassWord(String pwd) {
		sendKeys(getPwd(), pwd);
	}
	
	
	public void login() throws InterruptedException {
		open(null);
		sleep(2000);
		click(getCrm());
		sleep(2000);
		setUserName("1000000");
		setPassWord("dj123456");
		click(getSumbit());
		sleep(5000);
		
		//断言
		AssertUtil.assertEquals(getCurrentUrl().substring(0, 23), "http://192.168.23.163/?","登录验证当前路径失败");
		LoggerUtil.info("登录crm系统成功");
		//sleep(7000);
		
	}
	
	public static void main(String[] args) {
		try {
			new CrmLoginPage().login();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private WebElement getCrm() {
		return getElement(x_crm, "x");
	}
	
	private WebElement getUserName() {
		return getElement(x_username, "x");
	}
	
	private WebElement getPwd() {
		return getElement(x_password, "x");
	}
	
	private WebElement getSumbit() {
		return getElement(x_submit, "x");
	}

}
