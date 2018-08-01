package com.sen.api.utils;

import org.apache.log4j.Logger;

/**
 * 
 * @author fs
 * @version 1.0.0
 * @description 日志记录
 * @date 2018年7月31日 下午4:36:43
 */
public class LoggerUtil {
	
	public static Logger logger = Logger.getLogger(LoggerUtil.class);
	
	/**
	 * 记录Info日志方法
	 * 
	 */
	public static void infoData(String message) {
		logger.info(message);
	}
	
}
