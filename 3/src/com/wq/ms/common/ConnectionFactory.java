package com.wq.ms.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		driver="com.mysql.jdbc.driver";
		url="jdbc:mysql://127.0.0.1:3306/ms";
		username="root";
		password="root";
	}
	
	public static void  close(ResultSet rs,Connection conn,PreparedStatement pstmt)throws Exception {
		if(conn!=null){
			conn.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(rs!=null){
			rs.close();
		}

	}
	
	public static Connection getconn() throws Exception{
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url);//DriverManager 类是 JDBC 的管理层，作用于用户和驱动程序之间
		
		return conn;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
