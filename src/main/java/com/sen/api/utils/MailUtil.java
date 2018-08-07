package com.sen.api.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * 
 * @author fs
 * @version 1.0.0
 * @description  邮件发送工具
 * @date 2018年7月31日 下午2:33:50
 */
public class MailUtil {
	private static String host;  
    private static String username;  
    private static String password;  
    private static String from;  
    private static String nick;  
  
    static {  
        try {  
            // Test Data  
            host = "smtp.163.com";  
            username = "m18868196139_3@163.com";  
            password = "78LXlx";  
            from = "m18868196139_3@163.com";  
            nick = "ZDHinfo";  
            // nick + from 组成邮箱的发件人信息  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    
    
  
    /** 
     * 发送邮件 
     *  
     * @param to 
     *            收件人列表，以","分割 
     * @param subject 
     *            标题 
     * @param body 
     *            内容 
     * @param filepath 
     *            附件列表,无附件传递null 
     * @return 
     * @throws MessagingException 
     * @throws AddressException 
     * @throws UnsupportedEncodingException 
     */  
    public static boolean sendMail(String to, String subject, String body,  
            List<String> filepath) throws AddressException, MessagingException,  
            UnsupportedEncodingException {  
        // 参数修饰  
        if (body == null) {  
            body = "";  
        }  
        if (subject == null) {  
            subject = "无主题";  
        }  
        // 创建Properties对象  
        Properties props = System.getProperties();  
        // 创建信件服务器  
        props.put("mail.smtp.host", host);  
        props.put("mail.smtp.auth", "true"); // 通过验证  
        props.put("mail.smtp.port", "465");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.ssl.enable", "true");
       //props.put("mail.debug", "true");
        // 得到默认的对话对象  
        Session session = Session.getDefaultInstance(props, null);  
        // 创建一个消息，并初始化该消息的各项元素  
        MimeMessage msg = new MimeMessage(session);  
        nick = MimeUtility.encodeText(nick);  
        msg.setFrom(new InternetAddress(nick + "<" + from + ">"));  
        // 创建收件人列表  
        if (to != null && to.trim().length() > 0) {  
            String[] arr = to.split(",");  
            int receiverCount = arr.length;  
            if (receiverCount > 0) {  
                InternetAddress[] address = new InternetAddress[receiverCount];  
                for (int i = 0; i < receiverCount; i++) {  
                    address[i] = new InternetAddress(arr[i]);  
                }  
                msg.addRecipients(Message.RecipientType.TO, address);  
                msg.setSubject(subject);  
                // 后面的BodyPart将加入到此处创建的Multipart中  
                Multipart mp = new MimeMultipart();  
                // 附件操作  
                if (filepath != null && filepath.size() > 0) {  
                    for (String filename : filepath) {  
                        MimeBodyPart mbp = new MimeBodyPart();  
                        // 得到数据源  
                        FileDataSource fds = new FileDataSource(filename);  
                        // 得到附件本身并至入BodyPart  
                        mbp.setDataHandler(new DataHandler(fds));  
                        // 得到文件名同样至入BodyPart  
                        mbp.setFileName(fds.getName());  
                        mp.addBodyPart(mbp);  
                    }  
                    MimeBodyPart mbp = new MimeBodyPart();  
                    mbp.setText(body);  
                    mp.addBodyPart(mbp);  
                    // 移走集合中的所有元素  
                    filepath.clear();  
                    // Multipart加入到信件  
                    msg.setContent(mp);  
                } else {  
                    // 设置邮件正文  
                    msg.setText(body);  
                }  
                // 设置信件头的发送日期  
                msg.setSentDate(new Date());  
                msg.saveChanges();  
                // 发送信件  
                Transport transport = session.getTransport("smtp");  
                transport.connect(username, password);
                transport.sendMessage(msg,  
                        msg.getRecipients(Message.RecipientType.TO));  
                transport.close();  
                return true;  
            } else {  
                System.out.println("None receiver!");  
                return false;  
            }  
        } else {  
            System.out.println("None receiver!");  
            return false;  
        }  
    }  
  
    /*public static void main(String[] args) throws AddressException,  
            UnsupportedEncodingException, MessagingException {  
    	List<String> sendPath = new ArrayList<String>();
    	System.out.println(System.getProperty("user.dir"));
    	sendPath.add(System.getProperty("user.dir")+"\\target\\test-output\\index.html");
    	System.out.println(System.getProperty("user.dir")+"\\target\\test-output\\index.html");
        sendMail("1029830946@qq.com", DateUtil.getDate()+"cps东经接口测试报告", "自动化测试报告，请下载后查看！", sendPath);
        System.out.println(DateUtil.getDate()+"sendMail success!");
    }  */

}
