package myfinancespackage.business;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Budget {
	private int id;
	private String title;
	private double balance;
	private double limit;
	private String frequency;
	private LocalDateTime lastReset;
	
	public Budget(int idInput, String titleInput, double balanceInput, double limitInput, String frequencyInput, Timestamp lastResetInput) {
		id = idInput;
		title = titleInput;
		balance = balanceInput;
		limit = limitInput;
		frequency = frequencyInput;
		lastReset = lastResetInput.toLocalDateTime();
	}
	
	public void diplayBudget() {
		System.out.println(" | " + title + " | " + balance + "/" + limit + " | " + frequency + " | " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(lastReset) + " | ");
	}
	
	public char spendInBudget(double expenseAmount) {
		balance += expenseAmount;
		
		// Checks how close the user is to exceeding their budget
		if(balance > limit) {
			// Exceeds budget
			return 'E';
		} else if(balance > (limit * .75)) {
			// Within 25% of the limit of the budget
			return 'C';
		} else {
			// Is not within 25% of the limit or exceeding
			return 'F';
		}
	}
	
	public String getBudgetType() {
		return title;
	}

	public String getBudgetBalance() {
		return (balance + "/" + limit);
	}
}
