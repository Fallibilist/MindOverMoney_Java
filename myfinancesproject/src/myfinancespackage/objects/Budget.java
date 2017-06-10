package myfinancespackage.objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Budget {
	private String typeOfBudget;
	private double spent;
	private double limit;
	private String frequency;
	private LocalDate mostRecentReset;
	
	public Budget(String typeInput, double spentInput, double limitInput, String frequencyInput, LocalDate mostRecentResetInput) {
		typeOfBudget = typeInput;
		spent = spentInput;
		limit = limitInput;
		frequency = frequencyInput;
		mostRecentReset = mostRecentResetInput;
	}
	
	public void diplayBudget() {
		System.out.println(" | " + typeOfBudget + " | " + spent + "/" + limit + " | " + frequency + " | " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(mostRecentReset) + " | ");
	}
	
	public char spendInBudget(double expenseAmount) {
		spent += expenseAmount;
		
		// Checks how close the user is to exceeding their budget
		if(spent > limit) {
			// Exceeds budget
			return 'E';
		} else if(spent > (limit * .75)) {
			// Within 25% of the limit of the budget
			return 'C';
		} else {
			// Is not within 25% of the limit or exceeding
			return 'F';
		}
	}
	
	public String getBudgetType() {
		return typeOfBudget;
	}

	public String getBudgetBalance() {
		return (spent + "/" + limit);
	}
}
