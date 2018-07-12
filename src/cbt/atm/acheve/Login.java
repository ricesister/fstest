package cbt.atm.acheve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cbt.atm.core.Common;
import cbt.atm.core.SeleniumDriver;

public class Login {
	
	private Common common = new Common();
	
	private SeleniumDriver seld = new SeleniumDriver("firefox");
	private WebDriver driver = seld.getWebDriver();
	
	//测试前准备
	private void prepare(){
		driver.navigate().to("https:\\www.baidu.com");
	}
	
	//测试首尾
	private void finish(){
		seld.closeBrowser();  //后续有测试，此处不关闭
	}
	
	//action组件实现登录
	private void doLogin(String username,String pwd){
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_10__userName\"]")).sendKeys(username);
		driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys(pwd);
		driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
		common.sleepRandom(3, 5);
	}
	
	//test组件测试登录失败情况
	public void testLoginFail(){
		this.doLogin("admin", "123");
		
	}

}
