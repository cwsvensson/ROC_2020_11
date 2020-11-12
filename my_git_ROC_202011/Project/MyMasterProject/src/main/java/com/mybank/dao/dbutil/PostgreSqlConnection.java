package com.mybank.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mybank.service.Sv;

public class PostgreSqlConnection {

	private static Connection connection;

	private PostgreSqlConnection() {
		// Can't be called
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		//Sv.log.info("DbUtilProps.DRIVER = " + DbUtilProps.DRIVER);
		Class.forName(DbUtilProps.DRIVER);
		
		String url=DbUtilProps.URL;			
		String username=System.getenv("postgreSQLusername");
		String password=System.getenv("postgreSQLpassword");
		connection=DriverManager.getConnection(url, username, password);
		return connection;
	}
}
// Singleton Java CLass - Only one instance possible, used to connect to the database