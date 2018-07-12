package cbt.atm.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DDL {
	
	/*public static void main(String[] args) {
		String[][] s =  new DDL().readExcel("C:\\Users\\admin\\Desktop\\fs\\ddl\\findkey.xls", 
				"Sheet1");
		System.out.println(s[2][0]);
	}*/
	
	//使用数组实现
	public String getRandomByArray(String[] myString){
		int ranindex = Math.abs(new Random().nextInt(myString.length));
		return myString[ranindex];
	}
	
	//随机数
	//指定随机数
	public int getRandomByInt(int min,int max){
		return new Random().nextInt(min)+(max-min)+1;
	}
	
	//返回数量众多的随机字符串
	
	
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
			System.out.println(rowCount+"----->"+colCount);
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
	
	//实现jdbc返回值

}
