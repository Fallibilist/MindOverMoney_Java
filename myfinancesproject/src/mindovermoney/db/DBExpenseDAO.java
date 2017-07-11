package mindovermoney.db;

import java.sql.Connection;

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
	protected void storeObjectInTable(Expense expense) {
		
	}
}
