package mindovermoney.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import mindovermoney.business.Budget;

public class DBBudgetDAO extends DBGenericDAO<Budget> {
	public DBBudgetDAO(Connection connection, int userID) {
		super(connection, "budget", userID);
	}
	
	@Override
	protected Budget convertTableToObject() throws Exception {
		return new Budget(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDouble("balance"), resultSet.getDouble("limit"), resultSet.getString("frequency"), resultSet.getTimestamp("last_occurence_date"));
	}
	
	@Override
	protected boolean addObjectToTable(Budget budget) throws Exception {
		String query = "INSERT INTO myfinancesproductiondb.budget (id, title, balance, limit, frequency, last_occurence_date, finance_user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, budget.getId());
			statement.setString(2, budget.getTitle());
			statement.setDouble(3, budget.getBalance());
			statement.setDouble(4, budget.getLimit());
			statement.setString(5, budget.getFrequency());
			statement.setTimestamp(6, Timestamp.valueOf(budget.getLastOccurence()));
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
	protected boolean addObjectToTable(Budget budget, int idToReplace) throws Exception {
		String query = "UPDATE myfinancesproductiondb.budget SET title=?, balance=?, limit=?, frequency=?, last_occurence_date=?, finance_user_id=? where id=?";
		PreparedStatement statement;

		// Not certain if this works as intended or if the setXXX methods refer directly to the index of the column rather than the query
		// Further testing required
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, budget.getTitle());
			statement.setDouble(2, budget.getBalance());
			statement.setDouble(3, budget.getLimit());
			statement.setString(4, budget.getFrequency());
			statement.setTimestamp(5, Timestamp.valueOf(budget.getLastOccurence()));
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