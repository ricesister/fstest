package pages.lunbo;

import org.openqa.selenium.WebElement;

import common.AssertUtil;
import common.LoggerUtil;

/**
 * 
 * @description 纸板团购入扣
 * @author fs
 * @2018年8月14日
 *
 */
public class JFTGRKPage extends SYLBPage{
	
	private String jftgrk = "//*[@id=\"menu\"]/div/ul/li[6]/ul/li[4]";
	private String edit = "//*[@id=\"home\"]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[3]/table/tbody/tr[2]/td[5]/div/button";
	private String showTitle = "//*[@id=\"home\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/span";
	private String input = "//*[@id=\"home\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div/input";
	private String submit = "//*[@id=\"home\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[5]/button[2]";
	
	
	public void addJFRK() throws InterruptedException {
		sleep(2000);
		moveMenu(getElement("//*[@id=\"menu\"]/div/ul/li[1]", "x"), 
				getElement("//*[@id=\"menu\"]/div/ul/li[8]/div/span", "x"));
		click(getJftgrk());
		sleep(2000);
		click(getEdit());
		LoggerUtil.info("点击第二行编辑按钮");
		AssertUtil.assertEquals(getShowTitle().getText(), "编辑图片", "打开窗口标题与实际不符");
		LoggerUtil.info("打开编辑窗口，测试标题与需求一致");
		addPic("C:\\\\Users\\\\admin\\\\fsworkspace2-eclipse\\\\webui\\\\image\\\\jfscrk.jpg", getInput());
		click(getSubmit());
		LoggerUtil.info("图片编辑成功");
		
	}
	
	
	public WebElement getJftgrk() {
		return getElement(jftgrk, "x");
	}
	public WebElement getEdit() {
		return getElement(edit, "x");
	}
	public WebElement getShowTitle() {
		return getElement(showTitle, "x");
	}
	public WebElement getInput() {
		return getElement(input, "x");
	}
	public WebElement getSubmit() {
		return getElement(submit, "x");
	}
	
	
	
	
}
