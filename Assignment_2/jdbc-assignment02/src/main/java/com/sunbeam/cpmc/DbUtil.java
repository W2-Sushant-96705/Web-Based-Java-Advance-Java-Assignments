package com.sunbeam.cpmc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/Adjava";
	public static final String DB_USER = "adjava";
	public static final String DB_PASSWD = "sunbeam";
	
	static {
		try {
			Class.forName(DB_Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection connect() throws Exception{
		Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
		return con;
	}
}
