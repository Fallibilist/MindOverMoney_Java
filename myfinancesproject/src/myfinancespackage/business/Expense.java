package myfinancespackage.business;

import java.sql.Timestamp;

public class Expense extends Transaction {
	private String relatedBudget;

	public Expense(int idInput, String titleInput, double amountInput, String frequencyInput, Timestamp lastOccurenceInput, String relatedBudgetInput) {
		super(idInput, titleInput, amountInput, frequencyInput, lastOccurenceInput);
		relatedBudget = relatedBudgetInput;
	}
	
	public void submitTransaction() {
		User.setBalance(User.getBalance() - amount);
		incrementDate();
		User.modifyBudget(relatedBudget, amount);
	}
}
