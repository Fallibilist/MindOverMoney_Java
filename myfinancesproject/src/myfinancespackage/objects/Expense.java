package myfinancespackage.objects;

import java.time.LocalDate;

import myfinancespackage.menumanagement.User;

public class Expense extends Transaction {
	private String typeOfExpense;
	
	public Expense(String nameInput, int idInput, double amountInput, String typeOfExpenseInput, String frequencyInput, LocalDate recentSubmissionInput, int userIDInput) {
		super(nameInput, idInput, amountInput, frequencyInput, recentSubmissionInput, userIDInput);
		typeOfExpense = typeOfExpenseInput;
	}

	public Expense(String nameInput, int idInput, double amountInput, String typeOfExpenseInput, String frequencyInput, LocalDate recentSubmissionInput, int userIDInput, int numberOfTimesSubmittedInput) {
		super(nameInput, idInput, amountInput, frequencyInput, recentSubmissionInput, userIDInput, numberOfTimesSubmittedInput);
		typeOfExpense = typeOfExpenseInput;
	}
	
	public void submitTransaction() {
		User.setBalance(User.getBalance() - amount);
		incrementDate();
		User.modifyBudget(typeOfExpense, amount);
	}
}
