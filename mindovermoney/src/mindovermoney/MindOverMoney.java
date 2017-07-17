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
	private static UIControl uiControl;
	private static DBManager dbManager;
	private static User user;
	
	public static void main(String[] args) throws IOException {
		user = new User();
		dbManager = new DBManager(user);
		
		uiControl = new UIControl(dbManager, user);
		
		uiControl.loginScreen();
		uiControl.menuScreen();
	}
}
