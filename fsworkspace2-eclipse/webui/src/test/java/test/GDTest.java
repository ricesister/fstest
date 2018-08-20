package test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import listeners.ShotListener;
import pages.crmrk.CrmHomePage;
import pages.crmrk.CrmLoginPage;
import yunying.HDGLPage;

/**
 * 
 * @description 活动管理单元测试
 * @author fs
 * @2018年8月17日
 *
 */
public class GDTest {
	CrmLoginPage loginPage = null;
	CrmHomePage homePage = null;
	HDGLPage hdglPage = null;
	
	@BeforeClass
	public void init() throws InterruptedException {
		String url = "Report\\FailureScreenShot\\";
        boolean bol = FileUtils.deleteQuietly(new File(url));
        System.out.println("错误截图文件是否已经删除："+bol);
		loginPage = new CrmLoginPage();
		hdglPage = new HDGLPage();
		ShotListener.driver = loginPage.driver;
		homePage = new CrmHomePage();
		//登录系统
		loginPage.login();
	}
	
	@Test
	public void addActivity() {
		try {
			homePage.toHDZX();
			hdglPage.addActivity();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public void quit() {
		homePage.quit();
	}

}
