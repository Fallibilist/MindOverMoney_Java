package myfinancespackage.menumanagement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import myfinancespackage.objects.Budget;
import myfinancespackage.objects.Expense;
import myfinancespackage.objects.Income;

public class User {
	private static String username;
	private static String firstName;
	private static String lastName;
	private static int id;
	private static Double balance;
	private static List<Income> listOfAllIncome;
	private static List<Expense> listOfAllExpenses;
	private static List<Budget> listOfAllBudgets;
	
	private User() {}
	
	public static void defineUser(String createUsername, String createFirstName, String createLastName, Double createBalance, int createID) {
		username = createUsername;
		firstName = createFirstName;
		lastName = createLastName;
		balance = createBalance;
		id = createID;
		listOfAllIncome = new LinkedList<>();
		listOfAllExpenses = new LinkedList<>();
		listOfAllBudgets = new ArrayList<>();
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static String getFirstName() {
		return firstName;
	}
	
	public static String getLastName() {
		return lastName;
	}
	
	public static String getName() {
		return (firstName + " " + lastName);
	}
	
	public static int getID() {
		return id;
	}
	
	public static double getBalance() {
		return balance;
	}
	
	public static void setBalance(double balanceInput) {
		balance = balanceInput;
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
