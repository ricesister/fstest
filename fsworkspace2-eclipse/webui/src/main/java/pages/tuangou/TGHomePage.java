package pages.tuangou;

import java.util.List;

import org.openqa.selenium.WebElement;

import common.AssertUtil;
import common.LoggerUtil;
import pages.BasePage;

/**
 * 
 * @description 团购主页
 * @author fs
 * @2018年8月16日
 *
 */
public class TGHomePage extends BasePage{
	private String zbtg_btn = "/html/body/div[1]/div[1]/div/div[1]/div[2]/ul/li[2]/a";
	private String personal = "/html/body/div[1]/div[1]/div/div[2]/div[2]/div[2]/div[1]/span[2]";
	private String zbtg_dd = "/html/body/div[2]/div/div[1]/ul/li[1]/ul/li[1]/a";
	private String dd_again = "/html/body/div[2]/div[5]/div[1]/div/div[2]/ul[2]/li[6]/a[2]";
	private String dd_all = "/html/body/div[2]/div[1]/ul/li[1]/a";
	
	private String check_did = "/html/body/div[2]/div[5]/div[1]/div/div[1]/p[1]/span[2]";
	/**
	 * 订单页面
	 */
	private String pro_name = "/html/body/div[2]/h2/span";
	private String buy = "/html/body/div[2]/div[4]/a[2]";
	private String submit_dd = "//*[@id=\"submidOrder\"]";
	/**
	 * 支付订单
	 */
	private String pay_title = "//*[@id=\"pay\"]/div[1]/div[1]/p";
	private String fin_qr = "//*[@id=\"paymentBtn\"]";
	private String payPwd1 = "//*[@id=\"paymentPassword\"]/div[1]/div[1]/input";
	private String payPwd2 = "//*[@id=\"paymentPassword\"]/div[1]/div[2]/input";
	private String payPwd3 = "//*[@id=\"paymentPassword\"]/div[1]/div[3]/input";
	private String payPwd4 = "//*[@id=\"paymentPassword\"]/div[1]/div[4]/input";
	private String payPwd5 = "//*[@id=\"paymentPassword\"]/div[1]/div[5]/input";
	private String payPwd6 = "//*[@id=\"paymentPassword\"]/div[1]/div[6]/input";
	private String[] pwd_inputs = {payPwd1,payPwd2,payPwd3,payPwd4,payPwd5,payPwd6};
	private String pay_submit = "//*[@id=\"paymentPassword\"]/div[3]/button[2]";
	private String pay_success = "//*[@id=\"successful\"]/p";
	
	
	/**
	 * 用户名密码等，后期从外部读入
	 */
	private String[] payPwd = {"1","2","1","2","1","2"};
	
	/**
	 * 去再下一单的地方
	 * @throws InterruptedException 
	 */
	public void toDDAgain() throws InterruptedException {
		click(getPersonal());
		checkUrl("http://192.168.10.202/personalCenter.html");
		LoggerUtil.info("进入我的中心页面");
		click(getZbtg_dd());
		checkUrl("http://192.168.10.202/personalCenter.html#!paperboardOrder");
		LoggerUtil.info("进入纸板团购订单页面");
		sleep(2000);
		//click(getDd_all());
		LoggerUtil.info("进入纸板团购全部订单页面");
	}
	
	/**
	 * 在下一单
	 * @throws InterruptedException 
	 */
	public void dd_again() throws InterruptedException {
		sleep(2000);
		//切换frame
		driver.switchTo().frame("ifram");
		click(getDd_again());
		sleep(2000);
		//driver.switchTo().defaultContent();
		sleep(2000);
		LoggerUtil.info("进入订单详情页面");
		
		driver.switchTo().frame(0);
		checkText(getPro_name(), "方舒一日游");
		LoggerUtil.info("进入再下一单界面，产品名称是<方舒一日游>");
		click(getBuy());
		sleep(3000);
		containUrl("http://192.168.10.202/group/submitOrder.html?type=edit");
		LoggerUtil.info("进入确认订单信息页面");
		click(getSubmit_dd());
		sleep(5000);
		checkText(getPay_title(), "支付订单");
		LoggerUtil.info("进入订单支付页面");
		click(getFin_qr());
		LoggerUtil.info("打开支付界面");
		//保存订单编号
		String did = getElement("//*[@id=\"orderId\"]", "x").getText();
		sendKeys(getPwd_inputs(), payPwd);
		LoggerUtil.info("支付密码填写成功");
		click(getPay_submit());
		//checkText(getPay_success(), "支付成功");
		driver.get("http://192.168.10.202/personalCenter.html#!paperboardOrder");
		LoggerUtil.info("回到团购订单页面");
		driver.switchTo().frame("ifram");
		sleep(3000);
		checkText(getCheck_did(), "订单号："+did);
		LoggerUtil.info("团购下单成功");
	}
	
	
	public WebElement getZbtg_btn() {
		return getElement(zbtg_btn, "x");
	}
	public WebElement getPersonal() {
		return getElement(personal, "x");
	}
	public WebElement getZbtg_dd() {
		return getElement(zbtg_dd, "x");
	}
	public WebElement getDd_again() {
		return getElement(dd_again, "x");
	}
	public WebElement getDd_all() {
		return getElement(dd_all, "x");
	}

	
	/**
	 * 订单相关
	 */
	
	
	public WebElement getPro_name() {
		return getElement(pro_name, "x");
	}

	public WebElement getBuy() {
		return getElement(buy, "x");
	}

	public WebElement getSubmit_dd() {
		return getElement(submit_dd, "x");
	}

	public WebElement getPay_title() {
		return getElement(pay_title, "x");
	}

	public WebElement getFin_qr() {
		return getElement(fin_qr, "x");
	}

	public List<WebElement> getPwd_inputs() {
		return getSortsElement(pwd_inputs, "x");
	}

	public WebElement getPay_submit() {
		return getElement(pay_submit, "x");
	}

	public WebElement getPay_success() {
		return getElement(pay_success, "x");
	}

	public WebElement getCheck_did() {
		return getElement(check_did, "x");
	}

	
	
	
	
	
	
	
	

}
