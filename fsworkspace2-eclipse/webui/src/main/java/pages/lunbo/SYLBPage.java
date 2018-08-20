package pages.lunbo;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.AssertUtil;
import common.LoggerUtil;
import common.RandomUtil;
import pages.BasePage;

/**
 * 
 * @description 首页轮播图管理
 * @author fs
 * @2018年8月14日
 *
 */
public class SYLBPage extends BasePage{
	protected String webAddress = RandomUtil.getString(new Random(), 7);
	//TODO 查询框切换
	
	private String sylb = "//*[@id=\"menu\"]/div/ul/li[6]/ul/li[1]";
	private String title = "//*[@id=\"tHeader\"]";
	private String add = "//*[@id=\"home\"]/div[2]/div/div/div/div[2]/div[5]/button[1]";
	private String input = "//*[@id=\"home\"]/div[2]/div/div/div/div[3]/div[1]/div[1]/div/div[2]/div[1]/div/div/input";
	
	private String webType = "//*[@id=\"home\"]/div[2]/div/div/div/div[3]/div[1]/div[1]/div/div[2]/div[3]/div/div[1]/i";
	private String choice = "body > div.el-select-dropdown > div > div.el-select-dropdown__wrap.el-scrollbar__wrap > ul > li";
	private String web = "#home > div.box > div > div > div > div:nth-child(3) > div.carouse-uoloadImg > div.el-dialog__wrapper > div > div.el-dialog__body > div.carouse-uoloadImg-input > div > input";
	private String submit = "//*[@id=\"home\"]/div[2]/div/div/div/div[3]/div[1]/div[1]/div/div[2]/div[5]/button[2]";
	protected String addWindowTtitle = "//*[@id=\"home\"]/div[2]/div/div/div/div[3]/div[1]/div[1]/div/div[1]/span";
	/**
	 * classname
	 */
	private String showTable = "el-table__body";
	
	
	public void addSYLB() throws InterruptedException {
		sleep(2000);
		click(getSylb());
		sleep(2000);
		AssertUtil.assertEquals(getSylbTitle().getText(), "首页轮播图管理", "进入首页轮播图失败");
		LoggerUtil.info("进入首页轮播图管理页面");
		
		checkPicNum();
		click(getAdd());
		wait(2000, addWindowTtitle, "x");
		AssertUtil.assertEquals(getAddWindowTtitle().getText(), "编辑图片", "打开窗口标题与实际不符");
		LoggerUtil.info("打开新增窗口，测试标题与需求一致");
		//TODO 绝对路径
		addPic("C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\image\\lunbo.jpg",getInput());
		click(getWebType());
		LoggerUtil.info("打开网页类型选择框");
		WebElement webChoice = getChoice();
		click(webChoice);
		setWebSite(webAddress, getWeb());
		click(getSubmit());
		LoggerUtil.info("点击提交");
		sleep(2000);
		checkSubmit();
	}
	
	
	
	
	/**
	 * 验证添加断言
	 */
	protected void checkSubmit() {
		List<WebElement> rows = getShowTable().findElements(By.tagName("tr"));
		WebElement lastRow = rows.get(rows.size()-1);
		List<WebElement> lcols = lastRow.findElements(By.tagName("td"));
		AssertUtil.assertEquals(lcols.get(3).getText(), "普通网页-"+webAddress, "轮播图加入网页路径与实际不一致！");
		LoggerUtil.info("轮播图添加成功！");
	}
	/**
	 * 写入网页(input元素)
	 * @param webAddress
	 */
	protected void setWebSite(String webAddress,WebElement ele) {
		sendKeys(ele, webAddress);
		LoggerUtil.info(String.format("写入普通网页：%s", webAddress));
	}
	
	protected List<WebElement> checkPicNum() {
		List<WebElement> rows = getShowTable().findElements(By.tagName("tr"));
		if(rows.size() == 5) {
			LoggerUtil.info("轮播图位置已满，测试结束");
		}
		AssertUtil.assertNotEquals(rows.size(), 5, "轮播图位置已满，请先删除广告位！");
		return rows;
	}
	/**
	 * 传图片
	 * @param path
	 */
	protected void addPic(String path,WebElement input) {
		input.sendKeys(path);
		LoggerUtil.info("图片添加成功");
	}
	public WebElement getSylb() {
		return getElement(sylb, "x");
	}
	public WebElement getAdd() {
		return getElement(add, "x");
	}
	public WebElement getInput() {
		return getElement(input, "x");
	}
	public WebElement getWebType() {
		return getElement(webType, "x");
	}
	public WebElement getChoice() {
		return getElement(choice, "css");
	}
	public WebElement getWeb() {
		return getElement(web, "css");
	}
	public WebElement getSubmit() {
		return getElement(submit, "x");
	}
	public WebElement getAddWindowTtitle() {
		return getElement(addWindowTtitle, "x");
	}
	public WebElement getShowTable() {
		return getElement(showTable, "class");
	}



	public WebElement getSylbTitle() {
		return getElement(title, "x");
	}



	
	
	

}
