package com.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/records_db?useTimezone=true&serverTimezone=UTC";
	private static String username = "root";
	private static String password = "Palpa075#";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName(driver);
		
		//making connection to the driver
		Connection conn = DriverManager.getConnection(url,username,password);
		if(conn!= null) {
			System.out.println("Connection Successful!");
		}
		
		return conn;
	}

}
