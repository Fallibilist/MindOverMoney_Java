package myfinancespackage;

import myfinancespackage.ui.UIControl;
import myfinancespackage.ui.UILogin;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyFinances {
	private static JFrame applicationUI;
	
	public static void main(String[] args) throws IOException {
		applicationUI = new JFrame();
		
		applicationUI.setTitle("My Finances");
		applicationUI.setLocationByPlatform(true);
		applicationUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		applicationUI.setSize(270, 400);
        
        // Sets the look and feel of the frame to the default for the operating system
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		// Checks the user's credentials before the rest of the program runs
		UILogin loginDialog = new UILogin(applicationUI);
		
		// Create the main application window if login is successful
		UIControl mainDisplay = new UIControl(applicationUI);
		
		/* Old code for terminal execution
		 
		// Allows the user to login or create an account
		Login.runLogin();
		
		// Displays the Main Menu of the program
		MainMenu.runMainMenu(User.getName());
		
		*/
	}
}
