package mindovermoney.ui;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import mindovermoney.business.User;
import mindovermoney.db.DBManager;

public class UIControl extends JFrame {
	private DBManager dbManager;
	private User user;
	
	private UILogin dialogLogin;
	
	private UIMenu panelMenu;
	private UIDisplay panelDisplay;
	private UIIncome panelIncome;
	private UIExpense panelExpense;
	private UIBudget panelBudget;
	
    public UIControl(DBManager dbManager, User user) {
    	setSettings();
    	
    	this.dbManager = dbManager;
    	this.user = user;
    	
    	dialogLogin = new UILogin(this, dbManager);
    	panelMenu = new UIMenu(this);
    	panelMenu.setOpaque(true);
    	panelDisplay = new UIDisplay(this, dbManager, user);
    	panelDisplay.setOpaque(true);
    	panelIncome = new UIIncome(this, dbManager, user);
    	panelIncome.setOpaque(true);
    	panelExpense = new UIExpense(this, dbManager, user);
    	panelExpense.setOpaque(true);
    	panelBudget = new UIBudget(this, dbManager, user);
    	panelBudget.setOpaque(true);
    	
    	this.add(panelMenu);
    	this.add(panelDisplay);
    	this.add(panelIncome);
    	this.add(panelExpense);
    	this.add(panelBudget);
    }
	
	private void setSettings() {
		this.setTitle("Mind Over Money");
		this.setLocationByPlatform(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Sets the look and feel of the frame to the default for the operating system
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	public void loginScreen() {
		dialogLogin.display();
	}
	
	public void menuScreen() {
		this.setVisible(true);
		panelMenu.display();
	}
	
	public void displayScreen() {
		panelDisplay.display();
	}
	
	public void incomeScreen() {
		panelIncome.display();
	}
	
	public void expenseScreen() {
		panelExpense.display();
	}
	
	public void budgetScreen() {
		panelBudget.display();
	}
	
	public void close() {
		dispose();
		System.exit(0);
	}
}