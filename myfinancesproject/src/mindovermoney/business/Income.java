package mindovermoney.business;

import java.sql.Timestamp;

public class Income extends Transaction {
	public Income(int idInput, String titleInput, double amountInput, String frequencyInput, Timestamp lastOccurenceInput) {
		super(idInput, titleInput, amountInput, frequencyInput, lastOccurenceInput);
	}

	public double submitTransaction(double balance) {
		balance += amount;
		incrementDate();
		
		return balance;
	}
}
