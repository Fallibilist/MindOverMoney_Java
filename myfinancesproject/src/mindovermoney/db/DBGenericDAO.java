package mindovermoney.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DBGenericDAO<T> {
	protected Connection connection;
	protected String tableName;
	protected Statement statement;
	protected ResultSet resultSet;
	protected int userID;

	protected DBGenericDAO(Connection connection, String tableName) {
		this.connection = connection;
		this.tableName = tableName;
		this.statement = null;
		this.resultSet = null;
		this.userID = 0;
	}
	
	protected DBGenericDAO(Connection connection, String tableName, int userID) {
		this.connection = connection;
		this.tableName = tableName;
		this.statement = null;
		this.resultSet = null;
		this.userID = userID;
	}
	
	protected ArrayList<T> getTable() throws Exception {
		ArrayList<T> itemsInTable = new ArrayList<T>();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from " + this.tableName);
			
			while(resultSet.next()) {
				if(resultSet.getInt("finance_user_id") == userID) {
					itemsInTable.add(convertTableToObject());
				}
			}
		} finally {
			closeStatementAndResultSet();
		}
		
		return itemsInTable;
	}

//	Change this to a setter implementation
//	protected void setTable(ArrayList<Object> listToConvert) throws Exception {
//		try {
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery("select * from " + this.tableName);
//			
//			while(resultSet.next()) {
//				itemsInTable.add(convertTableToObject());
//			}
//		} finally {
//			closeStatementAndResultSet();
//		}
//		
//		return itemsInTable;
//	}
	
	protected void closeStatementAndResultSet() throws Exception {
		statement.close();
		resultSet.close();
	}
	
	// Classes inheriting DBGeneric DAO will override these methods
	protected T convertTableToObject() throws Exception {
		return (T) new Object();
	}

	protected void storeObjectInTable(T objectToParse) throws Exception {}
}
