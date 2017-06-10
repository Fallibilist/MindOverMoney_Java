package myfinancespackage.menumanagement;

import java.util.Scanner;

public class MainMenu {
	private static int menuSelection;
	private static boolean invalidMenuInput;
	private static boolean returnToMain;
	private static Scanner scan;
	
	private MainMenu() {}
	
	public static void runMainMenu(String usersName) {
		returnToMain = false;
		do {
			menuSelection = -1;
			invalidMenuInput = true;
			
			System.out.println("\nWelcome " + usersName + "!\n\nMain Menu\n0 - Display Finances\n1 - Input Income\n2 - Input Expense\n3 - Edit Budgets\n4 - Loans\n");
			System.out.print("Please enter the number corresponding to your menu selection: ");
			
			while(invalidMenuInput) {
				scan = new Scanner(System.in);
				while(!scan.hasNextInt()) {
					System.out.println("Please enter a number(0-4): ");
					scan = new Scanner(System.in);
				}
				menuSelection = scan.nextInt();
				
				if(menuSelection >= 0 && menuSelection <= 4) {
					System.out.println("Please enter a number(0-4): ");
					invalidMenuInput = false;
				}
			}
			
			switch(menuSelection) {
				case 0:
					displayFinances();
					break;
				case 1:
					inputIncome();
					break;
				case 2:
					inputExpenses();
					break;
				case 3:
					editBudgets();
					break;
				case 4:
					loans();
					break;
				default:
					break;
			}
			
		}while(returnToMain);
	}
	
	public static void displayFinances() {
		
		backToMain();
	}
	
	public static void inputIncome() {
		System.out.println("Please enter ");
		backToMain();
	}
	
	public static void inputExpenses() {
		
		backToMain();
	}
	
	public static void editBudgets() {
		
		backToMain();
	}
	
	public static void loans() {
		
		backToMain();
	}
	
	// Determines if the user would like to return to the main menu
	// If so, then it sets the global variable returnToMain = true
	public static void backToMain() {
		String userInput;
		boolean invalidResponse = true;
		
		while(invalidResponse)
		{
			System.out.println("\nReturn to the main menu? (y/n): ");
			scan = new Scanner(System.in);
			while(!scan.hasNext())
			{
				System.out.print("Please try again: ");
				scan = new Scanner(System.in);
			}
			userInput = scan.next();
			if(userInput.charAt(0) == 'n' || userInput.charAt(0) == 'N' )
			{
				returnToMain = false;
				invalidResponse = false;
			}
			else if(userInput.charAt(0) == 'y' || userInput.charAt(0) == 'Y' )
			{
				returnToMain = true;
				invalidResponse = false;
			}
			else
			{
				System.out.println("Please enter a valid response.");
			}
		}
	}
}
