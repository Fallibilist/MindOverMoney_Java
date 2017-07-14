package mindovermoney.business;

import java.sql.Timestamp;

public class Expense extends Transaction {
	private int relatedBudget;

	public Expense(int id, String title, double amount, String frequency, Timestamp lastOccurence, int relatedBudgetId) {
		super(id, title, amount, frequency, lastOccurence);
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
	
	public int getRelatedBudget() {
		return this.relatedBudget;
	}
}
