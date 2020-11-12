package my.app.jdbc.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import my.app.jdbc.dao.dbutil.DbUtilProps;

public class MyPostresSqlConnection {

	private static Connection connection;

	private MyPostresSqlConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws
	                                         ClassNotFoundException,
	                                         SQLException {
		Class.forName(DbUtilProps.DRIVER);
		
		String url = DbUtilProps.URL;
		//  System.out.println("postgreSQLusername ="+System.getenv("postgreSQLusername")); - Debugging Line
		String userName = System.getenv("postgreSQLusername");
		String password = System.getenv("postgreSQLpassword");
		
		connection = DriverManager.getConnection(url, userName, password);
		
		return connection;
	}

	
	
	
	
	
	
	
	
}