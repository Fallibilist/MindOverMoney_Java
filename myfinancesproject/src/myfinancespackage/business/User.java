package myfinancespackage.business;

import java.util.ArrayList;

public class User {
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private double balance;
	private ArrayList<Income> listOfAllIncome;
	private ArrayList<Expense> listOfAllExpenses;
	private ArrayList<Budget> listOfAllBudgets;
	
	public User() {}
	
	public void defineUser(int id, String username, String firstName, String lastName, double balance) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return (firstName + " " + lastName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public ArrayList<Income> getListOfAllIncome() {
		return listOfAllIncome;
	}

	public void setListOfAllIncome(ArrayList<Income> listOfAllIncome) {
		this.listOfAllIncome = listOfAllIncome;
	}

	public ArrayList<Expense> getListOfAllExpenses() {
		return listOfAllExpenses;
	}

	public void setListOfAllExpenses(ArrayList<Expense> listOfAllExpenses) {
		this.listOfAllExpenses = listOfAllExpenses;
	}

	public ArrayList<Budget> getListOfAllBudgets() {
		return listOfAllBudgets;
	}

	public void setListOfAllBudgets(ArrayList<Budget> listOfAllBudgets) {
		this.listOfAllBudgets = listOfAllBudgets;
	}

	public void modifyBudget(int budgetId, double amountInput) {
		switch(budgetId) {
			case 0:
				checkBudgetStatus(listOfAllBudgets.get(0), amountInput);
				break;
			case 1:
				checkBudgetStatus(listOfAllBudgets.get(1), amountInput);
				break;
			case 2:
				checkBudgetStatus(listOfAllBudgets.get(2), amountInput);
				break;
			case 3:
				checkBudgetStatus(listOfAllBudgets.get(3), amountInput);
				break;
			case 4:
				checkBudgetStatus(listOfAllBudgets.get(4), amountInput);
				break;
			default:
				break;
		}
	}
	
	public void checkBudgetStatus(Budget budgetToCheck, double amountInput) {
		switch(budgetToCheck.spendInBudget(amountInput)) {
			// Exceeds budget
			case 'E':
				System.out.println("\nThe " + budgetToCheck.getBudgetTitle() + " budget has been exceeded! It is at " + budgetToCheck.getBudgetBalance());
				break;
			// Within 25% of the limit of the budget
			case 'C':
				System.out.println("\nThe " + budgetToCheck.getBudgetTitle() + " budget is within 25% of its limit! It is at " + budgetToCheck.getBudgetBalance());
				break;
			// Is not within 25% of the limit or exceeding
			case 'F':
				System.out.println("\nThe " + budgetToCheck.getBudgetTitle() + " is at " + budgetToCheck.getBudgetBalance());
				break;
			default:
				break;
		}
	}
}
