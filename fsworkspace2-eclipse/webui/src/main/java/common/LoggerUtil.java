package common;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import pages.BasePage;

/**
 * 
 * @description 日志记录类
 * @author fs
 * @2018年8月13日
 *
 */
public class LoggerUtil {
	
	private static String reportName = "cps-东经科技ui自动化测试报告";
	private static String splitTimeAndMsg = "===";
	private static Logger logger = Logger.getLogger(LoggerUtil.class);
	
	
	public static void info(String msg) {
		logger.info(msg);
		Reporter.log(msg);
	}
	
	public static void debug(String msg) {
		logger.debug(msg);
		Reporter.log(msg);
	}
	
	public static void error(String msg) {
		logger.error(msg);
		Reporter.log(msg);
	}
	
	
	public static String getReportName() {
		return reportName;
	}

	public static String getSpiltTimeAndMsg() {
		return splitTimeAndMsg;
	}

	public static void setReportName(String reportName) {
		if(reportName != null && reportName.length() != 0){
			LoggerUtil.reportName = reportName;
		}
	}
	
}
