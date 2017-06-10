package myfinancespackage.dbmanagement;

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
				// Sets the db url, username, and password
				String url = "jdbc:mysql://localhost:3306/CodeDBMSQLRouter"; // need to add name of server
				String username = "root";
				String password = "Onepeice";
				
				// get connection
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
