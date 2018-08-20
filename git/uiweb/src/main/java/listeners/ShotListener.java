package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;


import common.LoggerUtil;


public class ShotListener extends TestListenerAdapter{
	private static String jenkins_path = "";
	public static WebDriver driver;
	
	 
	


	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		Reporter.setEscapeHtml(false);
		try {
			takeScreenShot(tr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 截图方法
	 * @param tr
	 * @throws IOException
	 */
	public void takeScreenShot(ITestResult tr) throws IOException {
		 
		
		String url = "screens/"+common.DateUtil.getDateDay()+"/";
		SimpleDateFormat smf = new SimpleDateFormat("MMddHHmmss") ;
        String curTime = smf.format(new java.util.Date());
        String fileName = tr.getName()+"_"+curTime+".png";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //把截图拷贝到自定义的目录
        FileUtils.copyFile(srcFile, new File(url+fileName));
		LoggerUtil.info("失败截图"+fileName+"已保存");
		
		/**
		 * 清空3天(不一定是天，3个文件夹)以前的截图文件夹
		 * 
		 */
		if(!checkFileNum(3)) {
			LoggerUtil.info("请确认截图文件夹下保存数量过多，请及时删除！");
		}
		/**
		 * 写入报告
		 */
		sendReport(fileName,url);
	}
	
	
	
	/**
	 * 发送报告
	 * @param fileName
	 */
	private static void sendReport(String fileName,String url) {
		
       String sreenShotLink = "错误截图链接<p><a href=\"../"+url+fileName+"\"  target=\"_blank\">点击查看高清大图</a><p>";
       String sreenShotImg = "<p>错误截图预览:<img id=\"img\" src=\"../"+url+fileName+"\" alt=\"error shot\" width=\"600\" height=\"300\"></p>";
       Reporter.log(sreenShotLink);
       Reporter.log(sreenShotImg);
    }
	
	
	public static void main(String[] args) {
		checkFileNum(3);
	}
	
	
	/**
	 * 确认保留几个文件夹数据
	 * @param num
	 * @return
	 */
	private static boolean checkFileNum(int num) {
		List<File> dirPaths = new ArrayList<File>();
		File[] fileNames = new File("screens").listFiles();
		for(File file:fileNames) {
			if(file.isDirectory()) {
				dirPaths.add(file);
			}
			
		}
		if(dirPaths.size()>num) {
			//删除第一个文件夹
			if(!deleteDir(dirPaths.get(0))) {
				System.out.println("删除最老一天的目录文件夹失败！");
				return false;
			}
			
		}
		System.out.println("删除最老一天的目录文件夹成功！");
		return true;
	}
	
	
	/**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
	
	
	
}
