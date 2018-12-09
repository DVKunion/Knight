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
	 * ���ò����붯̬�������Խ���ɾ�ķ�װ��һ������
	 * @param sql----��дsql��䣬����ִ��ʲô����
	 * @param params---��̬���������ݲ�ͬ��Ӵ��벻ͬ�����Ĳ���
	 * ��̬�����ײ�������
	 */
	public static void executeUpdate(String sql,Object...params){
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL,USER,PWD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//��������
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
				//��������
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


