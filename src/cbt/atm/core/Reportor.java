package cbt.atm.core;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class Reportor {
	
	public static String version="1.0.0";
	public static String module="oms";
	public static String folder = "20180708";
	
	//统一测试结果表达
	public static final String PASS="成功";
	public static final String FAIL="失败";
	public static final String ERROR="错误";
	public static final String IGNORE="忽略";
	
	//输出字段根据实际定义插入数据库
	public void writeLog(String sql,String caseid,String result,String error,String screenshot){
		String runtime = Common.getFormatter("yyyy-MM-dd HH:mm:ss");
		
		try {
			Connection conn = DBUtil.getConn();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, version);
			//根据实际完成
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	static{
		
	}
	
	public static void createFolder(){
		String folder = Common.getFormatter("yyyyMMdd");
		
		String userDir = System.getProperty("user.dir");
		File file = new File(userDir+"\\report"+folder);
		if(!file.exists()){
			file.mkdir();
			System.out.println(folder+"截图报告文件夹创建成功！");
		}else{
			System.out.println(folder+"截图报告文件夹已经存在！");
		}
		
		Reportor.folder = folder;
	}
	
	//代码异常时现场截图
	public String captureScreen(){
		String image = Common.getFormatter("HHmmss")+".png";
		String userDir = System.getProperty("user.dir");
		String path = userDir+"\\report\\"+folder+"\\"+image;
		
		//利用java截图
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) dim.getWidth();
		int height = (int) dim.getHeight();
		File file = new File(path);
		
		try {
			Robot robot = new Robot();
			BufferedImage screen = robot.createScreenCapture(new Rectangle(0, 0, width, height));
			ImageIO.write(screen, "png", file);
		} catch (AWTException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return image;
	}
	
	

}
