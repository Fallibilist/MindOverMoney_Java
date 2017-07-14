package mindovermoney.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

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
	protected boolean addObjectToTable(Income income) throws Exception {
		String query = "INSERT INTO myfinancesproductiondb.income (id, title, amount, frequency, last_occurence_date, finance_user_id) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, income.getId());
			statement.setString(2, income.getTitle());
			statement.setDouble(3, income.getAmount());
			statement.setString(4, income.getFrequency());
			statement.setTimestamp(5, Timestamp.valueOf(income.getLastOccurence()));
			statement.setInt(6, userID);
			
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
	protected boolean addObjectToTable(Income income, int idToReplace) throws Exception {
		String query = "UPDATE myfinancesproductiondb.expense SET title=?, amount=?, frequency=?, last_occurence_date=?, finance_user_id=? where id=?";
		PreparedStatement statement;

		// Not certain if this works as intended or if the setXXX methods refer directly to the index of the column rather than the query
		// Further testing required
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, income.getTitle());
			statement.setDouble(2, income.getAmount());
			statement.setString(3, income.getFrequency());
			statement.setTimestamp(4, Timestamp.valueOf(income.getLastOccurence()));
			statement.setInt(5, userID);
			statement.setInt(6, idToReplace);
			
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
