// TODO: Work on Read/Write functionality inside methods. pg 521 has basics.

package myfinancespackage.dbmanagement;

import java.sql.*;
import java.util.List;

import myfinancespackage.objects.Budget;
import myfinancespackage.objects.Expense;
import myfinancespackage.objects.Income;
import myfinancespackage.objects.Loan;

public class DBReadAndWriteToObject {
	
	private DBReadAndWriteToObject(){}
	
	public static List<Income> readAllIncomeFromDB() throws DBException {
		try {
			DBHandler.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Expense> readAllExpenseFromDB() throws DBException {
		try {
			DBHandler.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Budget> readAllBudgetFromDB() throws DBException {
		try {
			DBHandler.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Loan> readAllLoanFromDB() throws DBException {
		try {
			DBHandler.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeAllIncomeToDB(List<Income> listOfIncome) throws DBException {
		try {
			DBHandler.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeAllExpenseToDB(List<Expense> listOfExpense) throws DBException {
		try {
			DBHandler.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeAllBudgetToDB(List<Budget> listOfBudget) throws DBException {
		try {
			DBHandler.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeAllLoanToDB(List<Loan> listOfLoan) throws DBException {
		try {
			DBHandler.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
