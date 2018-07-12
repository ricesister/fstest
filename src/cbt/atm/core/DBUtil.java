package cbt.atm.core;

import java.sql.*;

//数据库工具类：加载驱动、连接数据库、关闭数据库
public class DBUtil {
	//连接数据库的参数
	public static final String URL = "jdbc:mysql://localhost:3306/school4";
	public static final String USER = "root";
	public static final String PASSWORD = "mysql";
	//加载驱动
	//注意，静态代码块在类第一次使用的时候运行一次
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			System.err.println("加载驱动失败！"); 
			e.printStackTrace();
		}		
	}	
	//连接数据库
	public static Connection getConn() throws SQLException{
		Connection conn = null;		
		conn = DriverManager.getConnection(URL, USER, PASSWORD); 
		System.out.println("连接成功"); 
		return conn;
	}	
	//关闭数据
	public static void close(ResultSet rs,Statement stat,Connection conn){
		try {
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(stat!=null){
				stat.close();
				stat=null;
			}
			if(conn!=null){
				conn.close();
				conn = null;
			}
			System.out.println("数据库关闭成功！");
		} catch (SQLException e) {
			System.err.println("数据库关闭失败！"); 
			e.printStackTrace();
		}
	}

}
