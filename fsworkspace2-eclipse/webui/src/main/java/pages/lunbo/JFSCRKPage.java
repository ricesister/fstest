package pages.lunbo;

import org.openqa.selenium.WebElement;

import common.AssertUtil;
import common.LoggerUtil;

/**
 * 
 * @description 积分商城入口类
 * @author fs
 * @2018年8月14日
 *
 */
public class JFSCRKPage extends JFTGRKPage{
	
	private String jfrk = "//*[@id=\"menu\"]/div/ul/li[6]/ul/li[6]";
	
	public void editJFRK() throws InterruptedException {
		LoggerUtil.info("编辑积分商城入口图片脚本开始");
		sleep(2000);
		moveMenu(getElement("//*[@id=\"menu\"]/div/ul/li[1]", "x"), 
				getElement("//*[@id=\"menu\"]/div/ul/li[8]/div/span", "x"));
		click(getJfrk());
		sleep(2000);
		click(getEdit());
		LoggerUtil.info("点击第二行编辑按钮");
		AssertUtil.assertEquals(getShowTitle().getText(), "编辑图片", "打开窗口标题与实际不符");
		LoggerUtil.info("打开编辑窗口，测试标题与需求一致");
		addPic("C:\\Users\\admin\\fsworkspace2-eclipse\\webui\\image\\jfscrk.jpg", getInput());
		click(getSubmit());
		LoggerUtil.info("图片编辑成功");
	}

	public WebElement getJfrk() {
		return getElement(jfrk, "x");
	}
	
	
	

}
