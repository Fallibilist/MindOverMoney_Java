package mindovermoney.business;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

// Exists to be extended by Income and Expense classes to reduce redundancy
public class Transaction {
	protected String title;
	protected int id;
	protected double amount;
	protected String frequency;
	protected LocalDateTime lastOccurence;
	
	public Transaction(int idInput, String titleInput, double amountInput, String frequencyInput, Timestamp lastOccurenceInput) {
		title = titleInput;
		id = idInput;
		amount = amountInput;
		frequency = frequencyInput;
		lastOccurence = lastOccurenceInput.toLocalDateTime();
	}
	
	public void diplayTransaction() {
		System.out.println(" | " + title + " | " + amount + " | " + frequency + " | " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(lastOccurence) + " | ");
	}
	
	public void incrementDate() {
		switch(frequency) {
			case "once":
				break;
			case "daily":
				lastOccurence = lastOccurence.plusDays(1);
				break;
			case "weekly":
				lastOccurence = lastOccurence.plusWeeks(1);
				break;
			case "monthly":
				lastOccurence = lastOccurence.plusMonths(1);
				break;
			case "anually":
				lastOccurence = lastOccurence.plusYears(1);
				break;
			default:
				break;
		}
	}
}
