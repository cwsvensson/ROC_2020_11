package com.player.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostresSqlConnection {

	private static Connection connection;
	
	private PostresSqlConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DbUtilProps.DRIVER);
		System.out.println("DbUtilProps.DRIVER = "+DbUtilProps.DRIVER);
		String url=DbUtilProps.URL;
		System.out.println("DbUtilProps.URL = " + DbUtilProps.URL);
		String username=System.getenv("postgreSQLusername");
		System.out.println("username = " + username);
		String password=System.getenv("postgreSQLpassword");
		connection=DriverManager.getConnection(url, username, password);
		return connection;
	}
}
//Single Ton - Single TON Java CLass.