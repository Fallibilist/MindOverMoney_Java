package mindovermoney;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mindovermoney.business.User;
import mindovermoney.db.DBManager;
import mindovermoney.ui.UIControl;
import mindovermoney.ui.UILogin;

public class MindOverMoney {
	private static JFrame applicationUI;
	private static DBManager dbManager;
	
	public static void main(String[] args) throws IOException {
		User user = new User();
		
		applicationUI = new JFrame();
		setFrameSettings();
        
		dbManager = new DBManager(user);
		
		// Checks the user's credentials before the rest of the program runs
		UILogin loginDialog = new UILogin(applicationUI, dbManager);
		
		// Create the main application window if login is successful
		UIControl mainDisplay = new UIControl(applicationUI, dbManager, user);
	}
	
	private static void setFrameSettings() {
		applicationUI.setTitle("Mind Over Money");
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
	}
}
