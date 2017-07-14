package mindovermoney.business;

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
	private LocalDateTime lastOccurence;
	
	public Budget(int id, String title, double balance, double limit, String frequency, Timestamp lastOccurence) {
		this.id = id;
		this.title = title;
		this.balance = balance;
		this.limit = limit;
		this.frequency = frequency;
		this.lastOccurence = lastOccurence.toLocalDateTime();
	}
	
	public void diplayBudget() {
		System.out.println(" | " + title + " | " + balance + "/" + limit + " | " + frequency + " | " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(lastOccurence) + " | ");
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
	
	public String getTitle() {
		return this.title;
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getLimit() {
		return this.limit;
	}
	
	public String getFrequency() {
		return this.frequency;
	}
	
	public LocalDateTime getLastOccurence() {
		return this.lastOccurence;
	}
}
