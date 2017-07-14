package mindovermoney.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import mindovermoney.business.Expense;

public class DBExpenseDAO extends DBGenericDAO<Expense> {
	public DBExpenseDAO(Connection connection, int userID) {
		super(connection, "expense", userID);
	}
	
	@Override
	protected Expense convertTableToObject() throws Exception {
		return new Expense(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDouble("amount"), resultSet.getString("frequency"), resultSet.getTimestamp("last_occurence_date"), resultSet.getInt("budget_id"));
	}
	
	@Override
	protected boolean addObjectToTable(Expense expense) throws Exception {
		String query = "INSERT INTO myfinancesproductiondb.expense (id, title, amount, frequency, last_occurence_date, budget_id, finance_user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, expense.getId());
			statement.setString(2, expense.getTitle());
			statement.setDouble(3, expense.getAmount());
			statement.setString(4, expense.getFrequency());
			statement.setTimestamp(5, Timestamp.valueOf(expense.getLastOccurence()));
			statement.setInt(6, expense.getRelatedBudget());
			statement.setInt(7, userID);
			
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted > 0) {
				return true;
			}
			else {
				return false;
			}
		} finally {
			closeStatementAndResultSet();
		}
	}
	
	@Override
	protected boolean addObjectToTable(Expense expense, int idToReplace) throws Exception {
		String query = "UPDATE myfinancesproductiondb.expense SET title=?, amount=?, frequency=?, budget_id=?, last_occurence_date=?, finance_user_id=? where id=?";
		PreparedStatement statement;

		// Not certain if this works as intended or if the setXXX methods refer directly to the index of the column rather than the query
		// Further testing required
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, expense.getTitle());
			statement.setDouble(2, expense.getAmount());
			statement.setString(3, expense.getFrequency());
			statement.setTimestamp(4, Timestamp.valueOf(expense.getLastOccurence()));
			statement.setInt(5, expense.getRelatedBudget());
			statement.setInt(6, userID);
			statement.setInt(7, idToReplace);
			
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted > 0) {
				return true;
			}
			else {
				return false;
			}
		} finally {
			closeStatementAndResultSet();
		}
	}
}
