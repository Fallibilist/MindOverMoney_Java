package myfinancespackage.objects;

import java.time.LocalDate;

import myfinancespackage.menumanagement.User;

public class Income extends Transaction {
	public Income(String nameInput, int idInput, double amountInput, String frequencyInput, LocalDate recentSubmissionInput, int userIDInput) {
		super(nameInput, idInput, amountInput, frequencyInput, recentSubmissionInput, userIDInput);
	}

	public Income(String nameInput, int idInput, double amountInput, String frequencyInput, LocalDate recentSubmissionInput, int userIDInput, int numberOfTimesSubmittedInput) {
		super(nameInput, idInput, amountInput, frequencyInput, recentSubmissionInput, userIDInput, numberOfTimesSubmittedInput);
	}

	public void submitTransaction() {
		User.setBalance(User.getBalance() + amount);
		incrementDate();
	}
}
