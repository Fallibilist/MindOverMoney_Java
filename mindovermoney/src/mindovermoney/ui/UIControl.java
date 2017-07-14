package mindovermoney.ui;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import mindovermoney.business.User;
import mindovermoney.db.DBManager;

public class UIControl {
	private JFrame parentFrame;
	private DBManager dbManager;
	private User user;
	
	private JPanel mainPanel, menuScreen, displayScreen, transactionScreen, editBudgetScreen, loansScreen;
	private JLabel menuScreenTitleLabel;
	private JButton displayFinancesButton, inputIncomeButton, inputExpensesButton, editBudgetsButton, loansButton;
	
    public UIControl(JFrame parentFrame, DBManager dbManager, User user) {
		this.parentFrame = parentFrame;
		this.dbManager = dbManager;
		this.user = user;
		
    	mainPanel = new JPanel();
    	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    	
        createMainScreen();
        createDisplayScreen();
        createTransactionScreen();
        createEditBudgetScreen();
        createLoansScreen();
        
        parentFrame.add(mainPanel);
        parentFrame.setVisible(true);
    }
    
    private void createMainScreen() {
    	menuScreen = new JPanel();
    	menuScreen.setLayout(new GridLayout(6, 1, 0, 5));
        
        menuScreenTitleLabel = new JLabel("Welcome to My Finances!", SwingConstants.CENTER);
        menuScreenTitleLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));;
        
        displayFinancesButton = new JButton("Display Finances");
        displayFinancesButton.setToolTipText("Displays your financial information");
        displayFinancesButton.setFocusable(false);
        displayFinancesButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// Refresh Data
        		menuScreen.setVisible(false);
        		displayScreen.setVisible(true);
        		//MainMenu.displayFinances();
        	}
        });
        
        inputIncomeButton = new JButton("Input Income");
        inputIncomeButton.setToolTipText("Allows you to input a new instance of income or edit a recurring income");
        inputIncomeButton.setFocusable(false);
        inputIncomeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// Refresh Data
        		menuScreen.setVisible(false);
        		transactionScreen.setVisible(true);
        		
        		// Here we need to set some value for Transaction screen to denote Income
        		
        		//MainMenu.inputIncome();
        	}
        });
        
        inputExpensesButton = new JButton("Input Expenses");
        inputExpensesButton.setToolTipText("Allows you to input a new expense or edit a recurring expense");
        inputExpensesButton.setFocusable(false);
        inputExpensesButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// Refresh Data
        		menuScreen.setVisible(false);
        		transactionScreen.setVisible(true);
        		
        		// Here we need to set some value for Transaction screen to denote Expense
        		
        		//MainMenu.inputExpenses();
        	}
        });
        
        editBudgetsButton = new JButton("Edit Budgets");
        editBudgetsButton.setToolTipText("Shows your budgets and allows you to modify them");
        editBudgetsButton.setFocusable(false);
        editBudgetsButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// Refresh Data
        		menuScreen.setVisible(false);
        		editBudgetScreen.setVisible(true);
        		//MainMenu.editBudgets();
        	}
        });
        
        loansButton = new JButton("Loans");
        loansButton.setToolTipText("Shows your loan information and allows you to modify it");
        loansButton.setFocusable(false);
        loansButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// Refresh Data
        		menuScreen.setVisible(false);
        		loansScreen.setVisible(true);
        		//MainMenu.loans();
        	}
        });
        
        menuScreen.add(menuScreenTitleLabel);
        menuScreen.add(displayFinancesButton);
        menuScreen.add(inputIncomeButton);
        menuScreen.add(inputExpensesButton);
        menuScreen.add(editBudgetsButton);
        menuScreen.add(loansButton);
        
        mainPanel.add(menuScreen);
    }

    private void createDisplayScreen() {
    	displayScreen = new JPanel();
    	displayScreen.setLayout(new GridLayout(6, 1, 0, 5));
    	
    	JPanel balanceDisplay = new JPanel();
    	JPanel budgetDisplay = new JPanel();
    	JPanel incomeDisplay = new JPanel();
    	JPanel expenseDisplay = new JPanel();
    	JPanel loanDisplay = new JPanel();
    	
    	// Populate Screen from here

    	JScrollPane budgetScroll = new JScrollPane(budgetDisplay);
    	JScrollPane incomeScroll = new JScrollPane(incomeDisplay);
    	JScrollPane expenseScroll = new JScrollPane(expenseDisplay);
    	JScrollPane loanScroll = new JScrollPane(loanDisplay);
    	
    	displayScreen.add(balanceDisplay);
    	displayScreen.add(budgetScroll);
    	displayScreen.add(incomeScroll);
    	displayScreen.add(expenseScroll);
    	displayScreen.add(loanScroll);
    	
    	displayScreen.setVisible(false);
    	mainPanel.add(displayScreen);
    }
    
    private void createTransactionScreen() {
    	transactionScreen = new JPanel();
    	transactionScreen.setLayout(new GridLayout(6, 1, 0, 5));
    	
    	transactionScreen.setVisible(false);
    	mainPanel.add(transactionScreen);
    }
    
    private void createEditBudgetScreen() {
    	editBudgetScreen = new JPanel();
    	editBudgetScreen.setLayout(new GridLayout(6, 1, 0, 5));
    	
    	editBudgetScreen.setVisible(false);
    	mainPanel.add(editBudgetScreen);
    }
    
    private void createLoansScreen() {
    	loansScreen = new JPanel();
    	loansScreen.setLayout(new GridLayout(6, 1, 0, 5));
    	
    	loansScreen.setVisible(false);
    	mainPanel.add(loansScreen);
    }
}