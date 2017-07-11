package mindovermoney.db;

import java.sql.Connection;

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
	protected void storeObjectInTable(Budget budget) {
		
	}
}
