package mindovermoney.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import mindovermoney.business.User;


public class DBManager {
	private Connection connection;
	private User user;
	private DBUserDAO userDAO;
	private DBIncomeDAO incomeDAO;
	private DBExpenseDAO expenseDAO;
	private DBBudgetDAO budgetDAO;
	
	public DBManager(User user){
		this.user = user;
	}
	
	public boolean validateUser(String username, String password) throws Exception {
		try {
			getConnection();
			userDAO = new DBUserDAO(connection, username, password, user);
			if(userDAO.getLoginSuccess()) {
				populateUserFromDB(user.getId());
			}
		} finally {
			closeConnection();
		}
		return userDAO.getLoginSuccess();
	}
	
	public void populateUserFromDB(int userID) throws Exception {
		incomeDAO = new DBIncomeDAO(connection, userID);
		expenseDAO = new DBExpenseDAO(connection, userID);
		budgetDAO = new DBBudgetDAO(connection, userID);
		
		user.setListOfAllIncome(incomeDAO.getTable());
		user.setListOfAllExpenses(expenseDAO.getTable());
		user.setListOfAllBudgets(budgetDAO.getTable());
	}
	
	public synchronized Connection getConnection() throws Exception {
		if(connection != null) {
			return connection;
		}
		else {
			try {
				Properties serverProperties = new Properties();
 				serverProperties.load(new FileInputStream("mindovermoney.properties"));
				
				String dburl = serverProperties.getProperty("dburl");
				String username = serverProperties.getProperty("username");
				String password = serverProperties.getProperty("password");
				
				// Gets connection to db server
				connection = DriverManager.getConnection(dburl, username, password);
				return connection; 
			} catch(SQLException | IOException e) {
				throw e;
			}
		}
	}
	
	public synchronized void closeConnection() throws Exception {
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
