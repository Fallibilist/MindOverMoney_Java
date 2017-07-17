# MindOverMoney

## Synopsis

A Budgeting Application Utilizing JDBC and Java Swing. The application interfaces with a MySQL server that I currently host locally.

## Code Example

An example of code from my Generic Data Access Object Superclass 
```
public abstract class DBGenericDAO<T> {

  ...
  
 	protected ArrayList<T> getTable() throws Exception {
		ArrayList<T> itemsInTable = new ArrayList<T>();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from " + this.tableName);
			
			while(resultSet.next()) {
				if(resultSet.getInt("finance_user_id") == userID) {
					itemsInTable.add(convertTableToObject());
				}
			}
		} finally {
			closeStatementAndResultSet();
		}
		
		return itemsInTable;
	}
}
```

## Motivation

My Intention with this project is to display my understanding of the fundamentals of Java and Object Oriented Programming, as well as my experience with a variety of ubiquitous frameworks and APIs.

## Installation

The current iteration of the project requires a local database for full functionality. A future version will access the database remotely.

## Future Versions

My intention is to release three versions of the application.
- A version that remotely accesses the database for use anywhere.
- A version that runs as an applet and doesn't needed to be downloaded and run locally. 
- An Android port that runs on mobile devices and accesses the same database through a different UI.

## License

Released under the GNU General Public License
