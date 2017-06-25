package myfinancespackage.ui;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import myfinancespackage.menumanagement.MainMenu;

public class UIControl extends JFrame {
	private JPanel mainPanel, menuScreen, displayScreen, transactionScreen, editBudgetScreen, loansScreen;
	private JLabel menuScreenTitle;
	private JButton displayFinancesButton, inputIncomeButton, inputExpensesButton, editBudgetsButton, loansButton;
	
    public UIControl() {
        this.setTitle("My Finances");
        this.setLocationByPlatform(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(270, 400);
        
        // Sets the look and feel of the frame to the default for the operating system
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

    	mainPanel = new JPanel();
    	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    	
        createMainScreen();
        createDisplayScreen();
        createTransactionScreen();
        createEditBudgetScreen();
        createLoansScreen();
        
        this.add(mainPanel);
        this.setVisible(true);
    }
    
    private void createMainScreen() {
    	menuScreen = new JPanel();
    	menuScreen.setLayout(new GridLayout(6, 1, 0, 5));
        
        menuScreenTitle = new JLabel("Welcome to My Finances!", SwingConstants.CENTER);
        menuScreenTitle.setFont(new Font("TimesRoman", Font.BOLD, 20));;
        
        displayFinancesButton = new JButton("Display Finances");
        displayFinancesButton.setToolTipText("Displays your financial information");
        displayFinancesButton.setFocusable(false);
        displayFinancesButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		menuScreen.setVisible(false);
        		displayScreen.setVisible(true);
        		MainMenu.displayFinances();
        	}
        });
        
        inputIncomeButton = new JButton("Input Income");
        inputIncomeButton.setToolTipText("Allows you to input a new instance of income or edit a recurring income");
        inputIncomeButton.setFocusable(false);
        inputIncomeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		menuScreen.setVisible(false);
        		transactionScreen.setVisible(true);
        		
        		// Here we need to set some value for Transaction screen to denote Income
        		
        		MainMenu.inputIncome();
        	}
        });
        
        inputExpensesButton = new JButton("Input Expenses");
        inputExpensesButton.setToolTipText("Allows you to input a new expense or edit a recurring expense");
        inputExpensesButton.setFocusable(false);
        inputExpensesButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		menuScreen.setVisible(false);
        		transactionScreen.setVisible(true);
        		
        		// Here we need to set some value for Transaction screen to denote Expense
        		
        		MainMenu.inputExpenses();
        	}
        });
        
        editBudgetsButton = new JButton("Edit Budgets");
        editBudgetsButton.setToolTipText("Shows your budgets and allows you to modify them");
        editBudgetsButton.setFocusable(false);
        editBudgetsButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		menuScreen.setVisible(false);
        		editBudgetScreen.setVisible(true);
        		MainMenu.editBudgets();
        	}
        });
        
        loansButton = new JButton("Loans");
        loansButton.setToolTipText("Shows your loan information and allows you to modify it");
        loansButton.setFocusable(false);
        loansButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		menuScreen.setVisible(false);
        		loansScreen.setVisible(true);
        		MainMenu.loans();
        	}
        });
        
        menuScreen.add(menuScreenTitle);
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