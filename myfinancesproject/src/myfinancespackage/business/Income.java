package myfinancespackage.business;

import java.sql.Timestamp;

public class Income extends Transaction {
	public Income(int idInput, String titleInput, double amountInput, String frequencyInput, Timestamp lastOccurenceInput) {
		super(idInput, titleInput, amountInput, frequencyInput, lastOccurenceInput);
	}

	public void submitTransaction() {
		User.setBalance(User.getBalance() + amount);
		incrementDate();
	}
}
