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
	
	public Transaction(int id, String title, double amount, String frequency, Timestamp lastOccurence) {
		this.title = title;
		this.id = id;
		this.amount = amount;
		this.frequency = frequency;
		this.lastOccurence = lastOccurence.toLocalDateTime();
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
	
	public String getTitle() {
		return this.title;
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getFrequency() {
		return this.frequency;
	}
	
	public LocalDateTime getLastOccurence() {
		return this.lastOccurence;
	}
}
