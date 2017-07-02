package myfinancespackage.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
	
	private static Connection connection;
	
	private DBHandler(){}
	
	public static synchronized Connection getConnection() throws DBException {
		if(connection != null) {
			return connection;
		}
		else {
			try {
				String url = "jdbc:mysql://localhost:3306/myfinancesproductiondb";
				String username = "gManager";
				String password = "Manager|1378|";
				
				// Gets connection to db server
				connection = DriverManager.getConnection(url, username, password);
				return connection;
			} catch(SQLException e) {
				throw new DBException(e);
			}
		}
	}
	
	public static synchronized void closeConnection() throws DBException {
		if(connection != null) {
			try {
				connection.close();
			} catch(SQLException e) {
				throw new DBException(e);
			} finally {
				connection = null;
			}
		}
	}
}
