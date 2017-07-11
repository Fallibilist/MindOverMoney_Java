package mindovermoney.db;

import java.sql.Connection;

import mindovermoney.business.Income;

public class DBIncomeDAO extends DBGenericDAO<Income> {
	public DBIncomeDAO(Connection connection, int userID) {
		super(connection, "income", userID);
	}
	
	@Override
	protected Income convertTableToObject() throws Exception {
		return new Income(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDouble("balance"), resultSet.getString("frequency"), resultSet.getTimestamp("last_occurence_date"));
	}

	@Override
	protected void storeObjectInTable(Income income) {
		
	}
}
