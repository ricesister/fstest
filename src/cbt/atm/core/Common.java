package cbt.atm.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Common {
	
	//读取整个excel
	public String[][] readExcel(String fileName,String sheetName){
		File file = new File(fileName);
		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			Workbook rwb = Workbook.getWorkbook(fis);
			Sheet sheet = rwb.getSheet(sheetName);
			//获取总的行列
			int rowCount = sheet.getRows();
			int colCount = sheet.getColumns();
			data = new String[rowCount-1][colCount];
			
			//遍历
			for(int i=1;i<rowCount;i++){
				Cell[] cells = sheet.getRow(i);
				for(int j=0;j<cells.length;j++){
					data[i-1][j] = cells[j].getContents();
				}
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static String getFormatter(String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = new Date();
		return sdf.format(date.getTime());
	}
	
	//暂停脚本
	public void sleepRandom(int min,int max){
		Random myrand = new Random();
		int temp = myrand.nextInt(min);
		int time = temp+(max-min)+1;
		System.out.println("暂停时间："+time);
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
		
		
	//指定随机数
	public int getRandom(int min,int max){
		return new Random().nextInt(min)+(max-min)+1;
	}
	
	//获取配置信息
	public String getConfigData(String dataName,String key){
		Properties props = new Properties();
		String value="";
		String file = System.getProperty("user.dir")+"\\data\\"+dataName;
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			props.load(bis);
			value = props.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	
	//根据左右边界查找单挑内容
	public String findSingleData(String source,String left,String right){
		String data="";
		String regex="("+left+")(.+?)("+right+")";
		
		Pattern p = Pattern.compile(regex,Pattern.DOTALL);
		Matcher m = p.matcher(source);
		if(m.find()){
			data = m.group(2);
		}
		return data;
	}
	
	//根据左右边界查找单挑内容
	public List<String> findListData(String source,String left,String right){
		List<String> data = new ArrayList<String>();
		String regex="("+left+")(.+?)("+right+")";
		
		Pattern p = Pattern.compile(regex,Pattern.DOTALL);
		Matcher m = p.matcher(source);
		while(m.find()){
			data.add(m.group(2));
		}
		return data;
	}
	
	
	/*public List<Map<String,String>> getJsonList(String source){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		ja = new jsona
	}*/

}
