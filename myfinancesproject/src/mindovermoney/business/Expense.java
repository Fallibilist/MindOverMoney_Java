package mindovermoney.business;

import java.sql.Timestamp;

public class Expense extends Transaction {
	private int relatedBudget;

	public Expense(int idInput, String titleInput, double amountInput, String frequencyInput, Timestamp lastOccurenceInput, int relatedBudgetId) {
		super(idInput, titleInput, amountInput, frequencyInput, lastOccurenceInput);
		relatedBudget = relatedBudgetId;
	}
	
//	For when we implement timed transactions
//	public void submitTransaction() {
//		User.setBalance(User.getBalance() - amount);
//		incrementDate();
//		User.modifyBudget(relatedBudget, amount);
//	}

	public double submitTransaction(double balance) {
		balance += amount;
		incrementDate();
		
		return balance;
	}
}
