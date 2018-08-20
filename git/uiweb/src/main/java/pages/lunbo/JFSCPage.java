package pages.lunbo;


import org.openqa.selenium.WebElement;

import common.AssertUtil;
import common.LoggerUtil;

/**
 * 
 * @description 积分商城page类
 * @author fs
 * @2018年8月14日
 *
 */
public class JFSCPage extends SYLBPage{
	
	private String jfsc = "//*[@id=\"menu\"]/div/ul/li[6]/ul/li[3]";
	
	public void addJFSC() throws InterruptedException {
		sleep(2000);
		click(getJfsc());
		sleep(2000);
		AssertUtil.assertEquals(getSylbTitle().getText(), "积分商城轮播图管理", "进入纸板团购轮播图失败");
		LoggerUtil.info("积分商城团购轮播图管理页面");
		
		checkPicNum();
		click(getAdd());
		wait(2000, addWindowTtitle, "x");
		AssertUtil.assertEquals(getAddWindowTtitle().getText(), "编辑图片", "打开窗口标题与实际不符");
		LoggerUtil.info("打开新增窗口，测试标题与需求一致");
		//TODO 绝对路径
		addPic("C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\image\\jfsc.png",getInput());
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
	public WebElement getJfsc() {
		return getElement(jfsc, "x");
	}

}
