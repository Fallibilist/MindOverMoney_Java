package myfinancespackage.menumanagement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import myfinancespackage.objects.Budget;
import myfinancespackage.objects.Expense;
import myfinancespackage.objects.Income;
import myfinancespackage.objects.Loan;

public class User {
	private static String username;
	private static String firstName;
	private static String lastName;
	private static int id;
	private static Double balance;
	private static ArrayList<Income> listOfAllIncome;
	private static ArrayList<Expense> listOfAllExpenses;
	private static ArrayList<Budget> listOfAllBudgets;
	private static ArrayList<Loan> listOfAllLoans;
	
	private User() {}
	
	public static void defineUser(String createUsername, String createFirstName, String createLastName, int createID) {
		username = createUsername;
		firstName = createFirstName;
		lastName = createLastName;
		id = createID;
		listOfAllIncome = new ArrayList<>();
		listOfAllExpenses = new ArrayList<>();
		listOfAllBudgets = new ArrayList<>();
		listOfAllLoans = new ArrayList<>();
	}
	
	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		User.username = username;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		User.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		User.lastName = lastName;
	}

	public static String getName() {
		return (firstName + " " + lastName);
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		User.id = id;
	}

	public static Double getBalance() {
		return balance;
	}

	public static void setBalance(Double balance) {
		User.balance = balance;
	}

	public static ArrayList<Income> getListOfAllIncome() {
		return listOfAllIncome;
	}

	public static void setListOfAllIncome(ArrayList<Income> listOfAllIncome) {
		User.listOfAllIncome = listOfAllIncome;
	}

	public static ArrayList<Expense> getListOfAllExpenses() {
		return listOfAllExpenses;
	}

	public static void setListOfAllExpenses(ArrayList<Expense> listOfAllExpenses) {
		User.listOfAllExpenses = listOfAllExpenses;
	}

	public static ArrayList<Budget> getListOfAllBudgets() {
		return listOfAllBudgets;
	}

	public static void setListOfAllBudgets(ArrayList<Budget> listOfAllBudgets) {
		User.listOfAllBudgets = listOfAllBudgets;
	}

	public static ArrayList<Loan> getListOfAllLoans() {
		return listOfAllLoans;
	}

	public static void setListOfAllLoans(ArrayList<Loan> listOfAllLoans) {
		User.listOfAllLoans = listOfAllLoans;
	}

	public static void modifyBudget(String typeOfExpenseInput, double amountInput) {
		switch(typeOfExpenseInput) {
			case "Groceries":
				checkBudgetStatus(listOfAllBudgets.get(0), amountInput);
				break;
			case "Eating Out":
				checkBudgetStatus(listOfAllBudgets.get(1), amountInput);
				break;
			case "Gasoline":
				checkBudgetStatus(listOfAllBudgets.get(2), amountInput);
				break;
			case "Clothing":
				checkBudgetStatus(listOfAllBudgets.get(3), amountInput);
				break;
			case "Gifts":
				checkBudgetStatus(listOfAllBudgets.get(4), amountInput);
				break;
			default:
				break;
		}
	}
	
	public static void checkBudgetStatus(Budget budgetToCheck, double amountInput) {
		switch(budgetToCheck.spendInBudget(amountInput)) {
			// Exceeds budget
			case 'E':
				System.out.println("\nThe " + budgetToCheck.getBudgetType() + " budget has been exceeded! It is at " + budgetToCheck.getBudgetBalance());
				break;
			// Within 25% of the limit of the budget
			case 'C':
				System.out.println("\nThe " + budgetToCheck.getBudgetType() + " budget is within 25% of its limit! It is at " + budgetToCheck.getBudgetBalance());
				break;
			// Is not within 25% of the limit or exceeding
			case 'F':
				System.out.println("\nThe " + budgetToCheck.getBudgetType() + " is at " + budgetToCheck.getBudgetBalance());
				break;
			default:
				break;
		}
	}
}
