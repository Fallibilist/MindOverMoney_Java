package myfinancespackage.menumanagement;

import java.util.Scanner;

// Deprecated class after Swing GUI was developed for the application
public class Login {
	private static Scanner scan;
	private static int menuSelection;
	private static boolean invalidMenuInput;
	
	private Login() {}
	
	public static void runLogin() {
		switch(welcomeScreen()) {
			case 0:
				userAndPassPrompt();
				break;
			case 1:
				createAccount();
				break;
			default:
				break;
		}
	}
	
	private static int welcomeScreen() {
		menuSelection = -1;
		invalidMenuInput = true;
		
		System.out.println("Welcome to My Finances\n\nLogin Menu\n0 - Login\n1 - Create Account\n");
		System.out.print("Please enter the number corresponding to your menu selection: ");
		
		while(invalidMenuInput) {
			scan = new Scanner(System.in);
			while(!scan.hasNextInt()) {
				System.out.println("Please enter your selection(0-1): ");
				scan = new Scanner(System.in);
			}
			menuSelection = scan.nextInt();
			
			if(menuSelection == 0 || menuSelection == 1) {
				invalidMenuInput = false;
			}
		}
		
		return menuSelection;
	}
	
	private static void userAndPassPrompt() {
		boolean loginSuccess = false;
		
		while(!loginSuccess) {
			
			String username;
			String password;
			
			System.out.println("\nPlease enter your login information");
			System.out.print("Username: ");
			scan = new Scanner(System.in);
			while(!scan.hasNextLine()) {
				System.out.println("Please enter a valid Username: ");
				scan = new Scanner(System.in);
			}
			username = scan.nextLine();
			
			System.out.print("Password: ");
			scan = new Scanner(System.in);
			while(!scan.hasNextLine()) {
				System.out.println("Please enter a valid Password: ");
				scan = new Scanner(System.in);
			}
			password = scan.nextLine();
			
			loginSuccess = validateLogin(username, password);
			
			if(!loginSuccess) {
				System.out.println("\nInvalid username or password.");
			}
		}
	}
	
	public static boolean validateLogin(String valUsername, String valPassword) {
		// If the user's input is valid then set a value to user and return true
		if(valUsername.equals("user") && valPassword.equals("pass")) {
			// We need to populate the user object from the database here
			User.defineUser(valUsername, "First", "Last", 1);
			return true;
		}
		// If the user's input is invalid then return false
		else {
			return false;
		}
	}
	
	private static void createAccount() {
		
	}
}
