package mindovermoney.db;

import java.sql.Connection;

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

	@Override
	protected void storeObjectInTable(User user) {
		
	}
}
