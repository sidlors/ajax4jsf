package com.sidlors.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInformation {
	
	
	
	private DBInformation(){
		
	}
	
	public static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(Constant.DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(Constant.DB_CONNECTION, Constant.DB_USER, Constant.DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;

	}

}
