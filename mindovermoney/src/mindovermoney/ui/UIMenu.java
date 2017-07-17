package mindovermoney.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UIMenu extends JPanel implements UIPanelDisplayInterface {
	private UIControl uiControl;
	
	public UIMenu(UIControl uiControl) {
		super(new GridLayout(2, 1, 0, 20));
		
		this.uiControl = uiControl;
		
		buildPanel();
	}
	
	private void buildPanel() {
		this.setBackground(new Color(0, 0, 0));

		JPanel panelTitle, panelButtonGrid, panelButtons;
		JLabel labelTitle;
		JButton buttonDisplay, buttonIncome, buttonExpense, buttonBudget, buttonExit;
		Component strutButtonWest, strutButtonEast;

		// Panels
		panelTitle = new JPanel();
		panelTitle.setOpaque(false);
    	
		panelButtonGrid = new JPanel(new GridLayout(1, 3));
		panelButtonGrid.setOpaque(false);
    	
		panelButtons = new JPanel(new GridLayout(6, 1, 0, 15));
		panelButtons.setOpaque(false);
		
		// Labels
    	labelTitle = new JLabel(new ImageIcon(UILogin.class.getResource("/resources/loginTitle.png")), SwingConstants.CENTER);
    	
    	// Struts
    	strutButtonWest = Box.createHorizontalStrut(5);
    	strutButtonEast = Box.createHorizontalStrut(5);
        
    	// Buttons
		buttonDisplay = new JButton("Display Finances");
		buttonDisplay.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonDisplay.setOpaque(false);
        
		buttonIncome = new JButton("Input Income");
		buttonIncome.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonIncome.setOpaque(false);
        
		buttonExpense = new JButton("Input Expenses");
		buttonExpense.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonExpense.setOpaque(false);
        
		buttonBudget = new JButton("Edit Budgets");
		buttonBudget.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonBudget.setOpaque(false);
        
		buttonExit = new JButton("Exit");
		buttonExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonExit.setOpaque(false);
		
		// Button Action Listeners
		buttonDisplay.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		uiControl.displayScreen();
        	}
        });
		
		buttonIncome.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		uiControl.incomeScreen();
        	}
        });
		
		buttonExpense.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		uiControl.expenseScreen();
        	}
        });
		
		buttonBudget.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		uiControl.budgetScreen();
        	}
        });
		
		
		buttonExit.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		uiControl.close();
        	}
        });

    	// Adds all components to the panel
        panelTitle.add(labelTitle);
		
		panelButtons.add(buttonDisplay);
		panelButtons.add(buttonIncome);
		panelButtons.add(buttonExpense);
		panelButtons.add(buttonBudget);
		panelButtons.add(buttonExit);

        panelButtonGrid.add(strutButtonWest);
        panelButtonGrid.add(panelButtons);
        panelButtonGrid.add(strutButtonEast);
        
        this.add(panelTitle);
        this.add(panelButtonGrid);
	}
	
	@Override
	public void display() {
		this.setVisible(true);
		uiControl.setContentPane(this);
		uiControl.pack();
		uiControl.setLocationRelativeTo(null);
	}
}
