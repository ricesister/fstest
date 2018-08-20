package test;

import org.testng.annotations.Test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import common.AssertUtil;
import common.LoggerUtil;
import listeners.ShotListener;
import pages.crmrk.CrmHomePage;
import pages.crmrk.CrmLoginPage;
import pages.lunbo.APPPage;
import pages.lunbo.JFSCPage;
import pages.lunbo.JFSCRKPage;
import pages.lunbo.JFTGRKPage;
import pages.lunbo.SYLBPage;
import pages.lunbo.ZBTGPage;

public class LunBoTest {
	CrmLoginPage loginPage = null;
	CrmHomePage homePage = null;
	SYLBPage sylbPage = null;
	ZBTGPage zbtgPage = null;
	JFSCPage jfscPage = null;
	JFTGRKPage tgrkPage = null;
	JFSCRKPage jfscrkPage = null;
	APPPage appPage = null;
	
	@BeforeClass
	public void init() throws InterruptedException {
		loginPage = new CrmLoginPage();
		ShotListener.driver = loginPage.driver;
		homePage = new CrmHomePage();
		sylbPage = new SYLBPage();
		zbtgPage = new ZBTGPage();
		jfscPage = new JFSCPage();
		tgrkPage = new JFTGRKPage();
		jfscrkPage = new JFSCRKPage();
		appPage = new APPPage();
		//登录系统
		loginPage.login();
	}
	
	@Test(priority=0)
	public void addSYLB() {
		LoggerUtil.info("添加首页轮播图脚本开始");
		try {
			
			homePage.toGGGL();
			sylbPage.addSYLB();
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}
	
	@Test(priority=1)
	public void addZBTG() {
		LoggerUtil.info("添加纸板团购轮播图脚本开始");
		try {
			homePage.toGGGL();
			zbtgPage.addZBTG();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=2)
	public void addJFSC() {
		LoggerUtil.info("添加积分商城轮播图脚本开始");
		try {
			homePage.toGGGL();
			jfscPage.addJFSC();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=3)
	public void addZBRK() {
		LoggerUtil.info("编辑纸板团购入口轮播图脚本开始");
		try {
			homePage.toGGGL();
			tgrkPage.addJFRK();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=4)
	public void addJFRK() {
		try {
			homePage.toGGGL();
			jfscrkPage.addJFRK();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=5)
	public void addApp() {
		try {
			homePage.toGGGL();
			appPage.editAPP();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@AfterTest
	public void destory() {
		loginPage.quit();
	}

}
