package myfinancespackage;

import myfinancespackage.menumanagement.*;
import myfinancespackage.objects.*;

import java.io.IOException;

import myfinancespackage.dbmanagement.*;

public class MyFinances {
	public static void main(String[] args) throws IOException {
		// Allows the user to login or create an account
		Login.runLogin();
		
		// Displays the Main Menu of the program
		MainMenu.runMainMenu(User.getName());
	}
}
