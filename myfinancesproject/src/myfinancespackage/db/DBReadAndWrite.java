// TODO: Work on Read/Write functionality inside methods. pg 521 has basics.

package myfinancespackage.db;

import java.sql.*;
import java.util.ArrayList;

import javax.security.auth.login.FailedLoginException;

import myfinancespackage.business.Budget;
import myfinancespackage.business.Expense;
import myfinancespackage.business.Income;
import myfinancespackage.business.User;

public class DBReadAndWrite {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet workingRS;
	
	private DBReadAndWrite() {}
	
	public static boolean populateUserFromDBInfo(String username, String password) throws DBException {
		getConnection();
		createStatement();
		return locateAndPullUser(username, password);
	}
	
	public static void populateDBFromUserInfo() throws DBException {
		getConnection();
		createStatement();
		
		// Uses the methods below to write the List and balance info back to the DB
	}
	
	public static void getConnection() throws DBException {
		try {
			connection = DBHandler.getConnection();
		} catch (DBException e) {
			throw e;
		}
	}
	
	public static void createStatement() throws DBException {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}
	
	public static void pullAllUsers() throws DBException {
		try {
			workingRS = statement.executeQuery("select * from finance_user");
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}
	
	public static boolean locateAndPullUser(String username, String password) throws DBException {
		pullAllUsers();
		try {
			// Iterates through each user in the result set to find a match
			while(workingRS.next()) {
				if(workingRS.getString(1).equals(username)) {
					if(workingRS.getString(2).equals(password)) {
						// Populates static User class from the database
						User.defineUser(workingRS.getInt(0), username, workingRS.getString(3), workingRS.getString(4), workingRS.getDouble(5));
						User.setListOfAllIncome(readAllIncomeFromDB());
						User.setListOfAllExpenses(readAllExpenseFromDB());
						User.setListOfAllBudgets(readAllBudgetFromDB());
						return true;
					}
					else {
						// Throws a FailedLoginException if the user enters an incorrect password
						throw new DBException(new FailedLoginException());
					}
				}
			}
			return false;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}
	
	private static ArrayList<Income> readAllIncomeFromDB() throws DBException {
		ArrayList<Income> listOfIncomeTransactions = new ArrayList<Income>();
		try {
			workingRS = statement.executeQuery("select * from income");
		
			while(workingRS.next()) {
				// Checks if it is the current user's transaction
				if(workingRS.getInt(5) == User.getId()) {
					listOfIncomeTransactions.add(new Income(workingRS.getInt(0), workingRS.getString(1), workingRS.getDouble(2), workingRS.getString(3), workingRS.getTimestamp(4)));
				}
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		return listOfIncomeTransactions;
	}
	
	private static ArrayList<Expense> readAllExpenseFromDB() throws DBException {
		ArrayList<Expense> listOfExpenseTransactions = new ArrayList<Expense>();
		try {
			workingRS = statement.executeQuery("select * from expense");
		
			while(workingRS.next()) {
				// Checks if it is the current user's transaction
				if(workingRS.getInt(6) == User.getId()) {
					listOfExpenseTransactions.add(new Expense(workingRS.getInt(0), workingRS.getString(1), workingRS.getDouble(2), workingRS.getString(3), workingRS.getTimestamp(4), workingRS.getString(5)));
				}
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		return listOfExpenseTransactions;
	}
	
	private static ArrayList<Budget> readAllBudgetFromDB() throws DBException {
		ArrayList<Budget> listOfBudgetTransactions = new ArrayList<Budget>();
		try {
			workingRS = statement.executeQuery("select * from expense");
		
			while(workingRS.next()) {
				// Checks if it is the current user's transaction
				if(workingRS.getInt(6) == User.getId()) {
					listOfBudgetTransactions.add(new Budget(workingRS.getInt(0), workingRS.getString(1), workingRS.getDouble(2), workingRS.getDouble(3), workingRS.getString(4), workingRS.getTimestamp(5)));
				}
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		return listOfBudgetTransactions;
	}
	
	public static void writeAllIncomeToDB(ArrayList<Income> listOfIncome) {
		
	}
	
	public static void writeAllExpenseToDB(ArrayList<Expense> listOfExpense) {
		
	}
	
	public static void writeAllBudgetToDB(ArrayList<Budget> listOfBudget) {
		
	}
}
