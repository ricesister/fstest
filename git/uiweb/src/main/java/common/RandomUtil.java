package common;

import java.util.Random;

/**
 * 
 * @description 随机生成字符串、数字等
 * @author fs
 * @2018年8月13日
 *
 */
public class RandomUtil {
	private static final String SOURCES =
	            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	
	/**
	 * 返回随机字符串
	 * @param ran
	 * @param number
	 * @return
	 */
	public static String getString(Random ran,int number) {
		char[] c = new char[number];
		for(int i=0;i<number;i++) {
			int num = ran.nextInt(SOURCES.length());
			c[i] = SOURCES.charAt(num);
		}
		
		return "www.fs"+new String(c)+".com";
	}

}
