package mindovermoney.ui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import mindovermoney.business.User;
import mindovermoney.db.DBManager;

public class UIBudget extends JPanel implements UIPanelDisplayInterface {
	private UIControl uiControl;
	private DBManager dbManager;
	private User user;
	
	public UIBudget(UIControl uiControl, DBManager dbManager, User user) {
		super(new GridLayout(1, 1));
		
		this.uiControl = uiControl;
		this.dbManager = dbManager;
		this.user = user;
		
		buildPanel();
	}
	
	private void buildPanel() {
		
	}

	@Override
	public void display() {
    	this.setVisible(true);
		uiControl.setContentPane(this);
		uiControl.pack();
		uiControl.setLocationRelativeTo(null);
	}
}
