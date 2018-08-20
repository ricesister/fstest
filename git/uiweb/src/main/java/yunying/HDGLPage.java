package yunying;

import java.util.Random;

import org.openqa.selenium.WebElement;

import common.DateUtil;
import common.LoggerUtil;
import common.RandomUtil;
import pages.crmrk.CrmHomePage;

/**
 * 
 * @description 活动管理页面
 * @author fs
 * @2018年8月17日
 *
 */
public class HDGLPage extends CrmHomePage{
	
	private String add_btn = "//*[@id=\"message-info\"]/div[1]/div[2]/div/ul/li[7]/button";
	private String acti_name = "//*[@id=\"message-add-main\"]/div[1]/div[2]/form/div[1]/div/div/input";
	private String start_time_btn = "//*[@id=\"message-add-main\"]/div[1]/div[2]/form/div[4]/div/div[1]/i";
	private String start_time_input = "/html/body/div[5]/div[1]/div/div[1]/span[1]/div/input";
	private String start_time_submit = "/html/body/div[3]/div[2]/button";
	private String end_time_btn = "//*[@id=\"message-add-main\"]/div[1]/div[2]/form/div[4]/div/div[2]/i";
	private String end_time_input = "/html/body/div[5]/div[1]/div/div[1]/span[1]/div/input";
	private String end_time_submit = "/html/body/div[3]/div[2]/button";
	private String group_btn = "//*[@id=\"message-add-main\"]/div[1]/div[2]/form/div[5]/div/div/div[1]/i";
	private String group_choice = "/html/body/div[3]/div/div[1]/ul/li";
	private String zxzq_btn = "//*[@id=\"message-add-main\"]/div[1]/div[2]/form/div[6]/div/div[1]/div[1]/i";
	//每周
	private String zxzq_choice = "/html/body/div[4]/div/div[1]/ul/li[2]";
	/**
	 * 点一下时间自动获取当前时间
	 */
	private String zxzq_time = "//*[@id=\"message-add-main\"]/div[1]/div[2]/form/div[6]/div/div[3]/i";
	private String zxzq_time_submit = "/html/body/div[5]/div[2]/button[2]";
	private String acti_submit = "//*[@id=\"message-add-main\"]/div[4]/button[2]";
	
	/**
	 * 新增消息
	 * 判断活动名称不能为空
	 */
	private String add_message = "//*[@id=\"message-add-main\"]/div[2]/div/div/button";
	private String add_title = "//*[@id=\"tHeader\"]";
	private String mess_name = "//*[@id=\"messageCenterForm\"]/div/form/div[2]/div/div/input";
	private String href_name = "//*[@id=\"messageCenterForm\"]/div/form/div[4]/div/div/input";
	private String href_address = "//*[@id=\"messageCenterForm\"]/div/form/div[5]/div/div/ul/li[1]/div/input";
	//textarea
	private String zy = "//*[@id=\"messageCenterForm\"]/div/form/div[6]/div/div/textarea";
	//div
	private String znx_content = "//*[@id=\"addCustomMessage-warp\"]/div/div/div[3]/div[2]/div[1]";
	private String mess_submit = "//*[@id=\"addCustomMessage-warp\"]/div/div/div[4]/button[2]";
	
	
	
	/**
	 * 积分响应
	 */
	private String add_jf_btn = "//*[@id=\"message-add-main\"]/div[3]/div[1]/p/button";
	private String zs_input = "//*[@id=\"message-add-main\"]/div[3]/div[2]/div/div[2]/p/input";
	private String zs_btn = "//*[@id=\"message-add-main\"]/div[3]/div[2]/div/div[2]/div/button[2]";
	
	/**
	 * 数据准备
	 */
	private static String a_name = "自动化测试，请勿删除--"+RandomUtil.getString(new Random(), 3);
	
	//private WebElement ele_activityName = getActi_name();
	
	/**
	 * 新增活动
	 */
	public void addActivity() {
		//进入活动管理
		click(getHdgl());
		containUrl("managementActivity");
		LoggerUtil.info("进入活动管理页面");
		click(getAdd_btn());
		containUrl("managementActivity/addActivity");
		LoggerUtil.info("进入新增活动页面");
		sendKeys(getActi_name(),a_name);
		click(getStart_time_btn());
		sendKeys(getStart_time_input(), "2019-08-17");
		click(getStart_time_submit());
		LoggerUtil.info("输入活动开始时间");
		click(getEnd_time_btn());
		sendKeys(getEnd_time_input(), "2019-08-17");
		click(getEnd_time_submit());
		LoggerUtil.info("输入活动结束时间");
		click(getGroup_btn());
		click(getGroup_choice());
		LoggerUtil.info("选择用户群组");
		click(getZxzq_btn());
		click(getZxzq_choice());
		LoggerUtil.info("已选择执行周期：每周");
		click(getZxzq_time());
		click(getZxzq_time_submit());
		LoggerUtil.info("已选择执行时间");
		//TODO 新增消息
		addMessage();
		add_JF();
		
		click(getActi_submit());
	}
	
	/**
	 * 新增消息
	 */
	public void addMessage() {
		click(getAdd_message());
		//判断是否添加活动名称
		if(getActi_name().getText() == null || "".equals(getActi_name().getText())) {
			LoggerUtil.info("进入失败，需要先添加活动标题");
			sendKeys(getActi_name(), a_name);
			click(getAdd_message());
		}
		checkText(getAdd_title(), "新增活动消息");
		LoggerUtil.info("进入新增活动消息页面成功");
		sendKeys(getMess_name(), "自动化测试fs"+DateUtil.getDate());
		sendKeys(getHref_name(), "链接fs"+DateUtil.getDate());
		sendKeys(getHref_address(), "www.youtube.com");
		sendKeys(getZy(), "摘要"+DateUtil.getDate());
		sendKeys(getZnx_content(), "znxfs"+DateUtil.getDate());
		click(getMess_submit());
		//TODO 消息新增判断
		
		LoggerUtil.info("新增消息成功");
	}
	
	public void add_JF() {
		click(getAdd_jf_btn());
		sendKeys(getZs_input(), "1");
		click(getZs_btn());
		LoggerUtil.info("积分策略添加成功");
	}
	


	//get方法
	public WebElement getAdd_btn() {
		return getElement(add_btn, "x");
	}




	public WebElement getActi_name() {
		return getElement(acti_name, "x");
	}




	public WebElement getStart_time_btn() {
		return getElement(start_time_btn, "x");
	}




	public WebElement getStart_time_submit() {
		return getElement(start_time_submit, "x");
	}




	public WebElement getEnd_time_btn() {
		return getElement(end_time_btn, "x");
	}




	public WebElement getEnd_time_submit() {
		return getElement(end_time_submit, "x");
	}




	public WebElement getGroup_btn() {
		return getElement(group_btn, "x");
	}




	public WebElement getGroup_choice() {
		return getElement(group_choice, "x");
	}




	public WebElement getZxzq_btn() {
		return getElement(zxzq_btn, "x");
	}




	public WebElement getZxzq_choice() {
		return getElement(zxzq_choice, "x");
	}




	public WebElement getZxzq_time() {
		return getElement(zxzq_time, "x");
	}




	public WebElement getZxzq_time_submit() {
		return getElement(zxzq_time_submit, "x");
	}




	public WebElement getActi_submit() {
		return getElement(acti_submit, "x");
	}




	public WebElement getAdd_message() {
		return getElement(add_message, "x");
	}




	public WebElement getAdd_title() {
		return getElement(add_title, "x");
	}




	public WebElement getMess_name() {
		return getElement(mess_name, "x");
	}




	public WebElement getHref_name() {
		return getElement(href_name, "x");
	}




	public WebElement getHref_address() {
		return getElement(href_address, "x");
	}




	public WebElement getZy() {
		return getElement(zy, "x");
	}




	public WebElement getZnx_content() {
		return getElement(znx_content, "x");
	}




	public WebElement getAdd_jf_btn() {
		return getElement(add_jf_btn, "x");
	}




	public WebElement getZs_input() {
		return getElement(zs_input, "x");
	}




	public WebElement getZs_btn() {
		return getElement(zs_btn, "x");
	}



	public WebElement getStart_time_input() {
		return getElement(start_time_input, "x");
	}


	public WebElement getEnd_time_input() {
		return getElement(end_time_input, "x");
	}

	public WebElement getMess_submit() {
		return getElement(mess_submit, "x");
	}


}
