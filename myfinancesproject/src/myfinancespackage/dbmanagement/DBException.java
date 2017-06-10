package myfinancespackage.dbmanagement;

import java.sql.SQLException;

public class DBException extends Exception {
	public DBException(){}
	
	public DBException(String message){
		super(message);
	}
	
	public DBException(SQLException exception){
		for(Throwable t : exception){
			System.out.println(t);
		}
	}
}
