package mindovermoney.business;

import java.sql.Timestamp;

public class Income extends Transaction {
	public Income(int id, String title, double amount, String frequency, Timestamp lastOccurence) {
		super(id, title, amount, frequency, lastOccurence);
	}

	public double submitTransaction(double balance) {
		balance += amount;
		incrementDate();
		
		return balance;
	}
}
