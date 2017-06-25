package myfinancespackage.objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

// Exists to be extended by Income and Expense classes to reduce redundancy
public abstract class Transaction {
	protected String name;
	protected int id;
	protected double amount;
	protected String frequency;
	protected LocalDate mostRecentSubmission;
	protected int numberOfTimesSubmitted;
	protected int userID;
	
	public Transaction(String nameInput, int idInput, double amountInput, String frequencyInput, LocalDate recentSubmissionInput, int userIDInput) {
		name = nameInput;
		id = idInput;
		amount = amountInput;
		frequency = frequencyInput;
		mostRecentSubmission = recentSubmissionInput;
		userID = userIDInput;
		numberOfTimesSubmitted = 0;
	}
	
	public Transaction(String nameInput, int idInput, double amountInput, String frequencyInput, LocalDate recentSubmissionInput, int userIDInput, int numberOfTimesSubmittedInput) {
		name = nameInput;
		id = idInput;
		amount = amountInput;
		frequency = frequencyInput;
		mostRecentSubmission = recentSubmissionInput;
		userID = userIDInput;
		numberOfTimesSubmitted = numberOfTimesSubmittedInput;
	}
	
	public void diplayTransaction() {
		System.out.println(" | " + name + " | " + amount + " | " + frequency + " | " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(mostRecentSubmission) + " | " + numberOfTimesSubmitted + " | ");
	}
	
	public void incrementDate() {
		numberOfTimesSubmitted++;
		switch(frequency) {
			case "once":
				break;
			case "daily":
				mostRecentSubmission = mostRecentSubmission.plusDays(1);
				break;
			case "weekly":
				mostRecentSubmission = mostRecentSubmission.plusWeeks(1);
				break;
			case "monthly":
				mostRecentSubmission = mostRecentSubmission.plusMonths(1);
				break;
			case "anually":
				mostRecentSubmission = mostRecentSubmission.plusYears(1);
				break;
			default:
				break;
		}
	}
}
