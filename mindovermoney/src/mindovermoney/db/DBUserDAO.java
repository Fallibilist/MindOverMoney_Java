package mindovermoney.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mindovermoney.business.User;

public class DBUserDAO extends DBGenericDAO<User> {
	private boolean loginSuccess;
	
	public DBUserDAO(Connection connection, String username, String password, User user) throws Exception {
		super(connection, "finance_user");
		
		String comparisonString = new String();
		loginSuccess = false;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from finance_user");
			
			while(resultSet.next()) {
				comparisonString = resultSet.getString("username");
				if(comparisonString.equals(username)) {
					comparisonString = resultSet.getString("password");
					if(comparisonString.equals(password)) {
						// Populates user object from the database
						user.defineUser(resultSet.getInt("id"), username, resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getDouble("balance"));
						loginSuccess = true;
					}
					else {
						loginSuccess = false;
					}
				}
			}
		} finally {
			closeStatementAndResultSet();
		}
	}
	
	public boolean getLoginSuccess() {
		return loginSuccess;
	}

	protected boolean addObjectToTable(User user, String password) throws Exception {
		String query = "INSERT INTO myfinancesproductiondb.finance_user (id, username, password, first_name, last_name, balance) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, user.getId());
			statement.setString(2, user.getUsername());
			statement.setString(3, password);
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());
			statement.setDouble(6, user.getBalance());
			
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
	protected boolean addObjectToTable(User user, int idToReplace) throws Exception {
		String query = "UPDATE myfinancesproductiondb.finance_user SET username=?, first_name=?, last_name=?, balance=? where id=?";
		PreparedStatement statement;

		// Not certain if this works as intended or if the setXXX methods refer directly to the index of the column rather than the query
		// Further testing required
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setDouble(4, user.getBalance());
			statement.setInt(5, idToReplace);
			
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
