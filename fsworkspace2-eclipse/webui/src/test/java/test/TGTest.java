package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.LoggerUtil;
import listeners.ShotListener;
import pages.tuangou.TGHomePage;
import pages.tuangou.TGLoginPage;

/**
 * 
 * @description 团购平台测试脚本：用于接口测试订单管理有关订单操作的数据准备
 * @author fs
 * @2018年8月16日
 *
 */
public class TGTest {
	private TGLoginPage tgLoginPage = null;
	private TGHomePage tgHomePage = null;
	
	
	@BeforeClass
	public void init() {
		tgLoginPage = new TGLoginPage();
		tgHomePage = new TGHomePage();
		ShotListener.driver = tgLoginPage.driver;
		try {
			tgLoginPage.tgLogin();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void tuangou_xiadan() {
		LoggerUtil.info("团购下单脚本开始");
		try {
			tgHomePage.toDDAgain();
			tgHomePage.dd_again();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void destory() {
		tgHomePage.quit();
	}

}
