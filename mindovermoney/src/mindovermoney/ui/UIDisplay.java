package mindovermoney.ui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mindovermoney.business.User;
import mindovermoney.db.DBManager;

public class UIDisplay extends JPanel implements UIPanelDisplayInterface {
	private UIControl uiControl;
	private DBManager dbManager;
	private User user;
	
	public UIDisplay(UIControl uiControl, DBManager dbManager, User user) {
		super(new GridLayout(6, 1, 0, 5));
		
		this.uiControl = uiControl;
		this.dbManager = dbManager;
		this.user = user;
		
		buildPanel();
	}
	
	private void buildPanel() {
    	JPanel panelBalance = new JPanel();
    	JPanel panelBudget = new JPanel();
    	JPanel panelIncome = new JPanel();
    	JPanel panelExpense = new JPanel();
    	JPanel panelLoan = new JPanel();
    	
    	// Populate Screen from here

    	JScrollPane scrollBudget = new JScrollPane(panelBudget);
    	JScrollPane scrollIncome = new JScrollPane(panelIncome);
    	JScrollPane scrollExpense = new JScrollPane(panelExpense);
    	JScrollPane scrollLoan = new JScrollPane(panelLoan);
    	
    	this.add(panelBalance);
    	this.add(scrollBudget);
    	this.add(scrollIncome);
    	this.add(scrollExpense);
    	this.add(scrollLoan);
	}

	@Override
	public void display() {
    	this.setVisible(true);
		uiControl.setContentPane(this);
		uiControl.pack();
		uiControl.setLocationRelativeTo(null);
	}
}
