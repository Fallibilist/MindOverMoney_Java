// TODO: Work on Read/Write functionality inside methods. pg 521 has basics.

package myfinancespackage.dbmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import myfinancespackage.menumanagement.User;
import myfinancespackage.objects.Budget;
import myfinancespackage.objects.Expense;
import myfinancespackage.objects.Income;
import myfinancespackage.objects.Loan;

public class DBReadAndWrite {
	
	private static Connection connection;
	private static Statement statement;
	
	private DBReadAndWrite() {}
	
	public static boolean populateUserFromDBInfo(String username, String password) throws DBException {
		String firstName;
		String lastName;
		double balance;
		int id;
		
		getConnection();
		createStatement();
		
		// Find the user in the db and validate credentials
		// i.e. check(username, password)
		firstName = "Greg";
		lastName = "Hill";
		id = 42;
		
		balance = 10.11;
		
		// return false; if it is an invalid login
		
		// Define the basics of the user
		User.defineUser(username, firstName, lastName, id);
		
		// Populates the Arrays of data for the user
		User.setBalance(balance);
		User.setListOfAllIncome(readAllIncomeFromDB());
		User.setListOfAllExpenses(readAllExpenseFromDB());
		User.setListOfAllBudgets(readAllBudgetFromDB());
		User.setListOfAllLoans(readAllLoanFromDB());
		return true;
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
	
	public static void populateDBFromUserInfo() throws DBException {
		try {
			connection = DBHandler.getConnection();
		} catch (DBException e) {
			throw e;
		}
		
		// Uses the methods below to write the List and balance info back to the DB
	}
	
	private static ArrayList<Income> readAllIncomeFromDB() {
		return new ArrayList();
	}
	
	private static ArrayList<Expense> readAllExpenseFromDB() {
		return new ArrayList();
	}
	
	private static ArrayList<Budget> readAllBudgetFromDB() {
		return new ArrayList();
	}
	
	private static ArrayList<Loan> readAllLoanFromDB() {
		return new ArrayList();
	}
	
	public static void writeAllIncomeToDB(ArrayList<Income> listOfIncome) {
		
	}
	
	public static void writeAllExpenseToDB(ArrayList<Expense> listOfExpense) {
		
	}
	
	public static void writeAllBudgetToDB(ArrayList<Budget> listOfBudget) {
		
	}
	
	public static void writeAllLoanToDB(ArrayList<Loan> listOfLoan) {
		
	}
}
