package pages.lunbo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.AssertUtil;
import common.LoggerUtil;

/**
 * 
 * @description 纸板团购page
 * @author fs
 * @2018年8月14日
 *
 */
public class ZBTGPage extends SYLBPage{
	
	private String zbdg = "//*[@id=\"menu\"]/div/ul/li[6]/ul/li[2]";
	
	
	
	public void addZBTG() throws InterruptedException {
		sleep(2000);
		click(getZbdg());
		sleep(2000);
		AssertUtil.assertEquals(getSylbTitle().getText(), "纸板团购轮播图管理", "进入纸板团购轮播图失败");
		LoggerUtil.info("进入纸板团购轮播图管理页面");
		
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



	public WebElement getZbdg() {
		return getElement(zbdg, "x");
	}
	
	
	
	

}
