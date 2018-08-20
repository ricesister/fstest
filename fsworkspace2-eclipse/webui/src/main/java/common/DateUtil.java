package common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author fs
 * @version 1.0.0
 * @description  时间类
 * @date 2018年7月31日 下午4:21:05
 */
public class DateUtil {
	
	private static String nowDate = "";
	
	static {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 nowDate = df.format(new Date());// new Date()为获取当前系统时间
	}
	
	public static String getDate() {
		return nowDate;
	}
	
	public static String getDateDay() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		 nowDate = df.format(new Date());
		 return nowDate;
	}
	
	

}
