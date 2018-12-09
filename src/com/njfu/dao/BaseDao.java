package com.njfu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/knight?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static String USER = "root";
	private static String PWD = "root";
	public static ResultSet rs;
	/**
	 * 利用参数与动态参数可以将增删改封装成一个方法
	 * @param sql----编写sql语句，告诉执行什么操作
	 * @param params---动态参数，根据不同添加传入不同个数的参数
	 * 动态参数底层是数组
	 */
	public static void executeUpdate(String sql,Object...params){
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL,USER,PWD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//遍历数组
			for(int i = 0; i<params.length;i++){
				pstmt.setObject((i+1), params[i]);
			}
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void executeQuery(String sql,Object...params){
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL,USER,PWD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if(null != params){
				//遍历数组
				for(int i = 0; i<params.length;i++){
					pstmt.setObject((i+1), params[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


