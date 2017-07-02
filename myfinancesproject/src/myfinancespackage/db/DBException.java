package myfinancespackage.db;

import java.sql.SQLException;

import javax.security.auth.login.FailedLoginException;

public class DBException extends Exception {
	private Exception exception;
	
	public DBException(){}
	
	public DBException(String message) {
		super(message);
	}
	
	public DBException(SQLException inputException) {
		exception = inputException;
		/**
		for(Throwable t : exception){
			System.out.println(t);
		}
		*/
	}
	
	public DBException(FailedLoginException inputException) {
		exception = inputException;
	}
}
