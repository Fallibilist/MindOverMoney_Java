package mindovermoney.ui;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import mindovermoney.business.User;
import mindovermoney.db.DBException;
import mindovermoney.db.DBManager;

import com.jgoodies.forms.layout.FormSpecs;

public class UILogin extends JDialog implements UIPanelDisplayInterface {
	private UIControl uiControl;
	private DBManager dbManager;

	private String username;
	private String password;
	private boolean loginSuccess;

	public UILogin(UIControl uiControl, DBManager dbManager) {
		super(uiControl, "Mind Over Money", true);
		
		this.uiControl = uiControl;
		this.dbManager = dbManager;

		buildPanel();
	}

	private void buildPanel() {
		getContentPane().setBackground(new Color(0, 0, 0));
		
		loginSuccess = false;
		
		// Component Declarations
		JPanel panelLoginGrid, panelButtonInput, panelLoginPrimary, panelButtonGrid, panelLoginInput, panelLoginAndButton;
		JLabel labelTitle, labelUsername, labelPassword;
		Component strutPrimaryNorth, strutPrimaryEast, strutPrimaryWest, strutPrimarySouth, strutButtonWest, strutLoginWest, strutLoginEast, strutButtonEast;
		JTextField textFieldUsername;
		JPasswordField passwordFieldPassword;
		JButton buttonLogin, buttonCreateAccount, buttonCancel;
		

		// Panels
		panelLoginPrimary = new JPanel();
    	panelLoginPrimary.setOpaque(false);
    	panelLoginPrimary.setLayout(new GridLayout(2, 1, 0, 0));
    	
    	panelLoginAndButton = new JPanel();
    	panelLoginAndButton.setLayout(new GridLayout(2, 1, 0, 10));
    	panelLoginAndButton.setOpaque(false);
    	
    	panelLoginGrid = new JPanel(new GridLayout(1, 3, 0, 4));
    	panelLoginGrid.setOpaque(false);
    	
    	panelLoginInput = new JPanel();
    	panelLoginInput.setLayout(new GridLayout(4, 1, 0, 0));
    	panelLoginInput.setOpaque(false);
    	
    	panelButtonGrid = new JPanel();
    	panelButtonGrid.setLayout(new GridLayout(0, 3, 0, 5));
    	panelButtonGrid.setOpaque(false);
    	
    	panelButtonInput = new JPanel();
    	panelButtonInput.setLayout(new GridLayout(0, 1, 0, 8));
    	panelButtonInput.setOpaque(false);
    	
		// Struts
    	strutPrimaryWest = Box.createHorizontalStrut(10);
    	strutPrimaryEast = Box.createHorizontalStrut(10);
    	strutPrimaryNorth = Box.createVerticalStrut(10);
    	strutPrimarySouth = Box.createVerticalStrut(20);
    	
    	strutButtonWest = Box.createHorizontalStrut(20);
    	strutButtonEast = Box.createHorizontalStrut(20);
    	
    	strutLoginWest = Box.createHorizontalStrut(20);
    	strutLoginEast = Box.createHorizontalStrut(20);

    	// Labels
    	labelTitle = new JLabel(new ImageIcon(UILogin.class.getResource("/resources/loginTitle.png")), SwingConstants.CENTER);
    	
    	labelUsername = new JLabel("Username: ");
    	labelUsername.setForeground(new Color(255, 255, 255));
    	labelUsername.setFont(new Font("TimesRoman", Font.BOLD, 15));
    	
    	labelPassword = new JLabel("Password: ");
    	labelPassword.setForeground(new Color(255, 255, 255));
    	labelPassword.setFont(new Font("TimesRoman", Font.BOLD, 15));
    	
    	// Text Fields
    	textFieldUsername = new JTextField(15);
    	passwordFieldPassword = new JPasswordField(15);
    	
    	//Buttons
    	buttonLogin = new JButton("Login");
    	buttonLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
    	buttonLogin.setOpaque(false);

    	buttonCreateAccount = new JButton("Create Account");
    	buttonCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
    	buttonCreateAccount.setOpaque(false);

    	buttonCancel = new JButton("Cancel");
    	buttonCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	buttonCancel.setOpaque(false);
    	
    	// Button Action Listeners
    	buttonLogin.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			username = textFieldUsername.getText().trim();
    			password = new String(passwordFieldPassword.getPassword());
    			try {
    				if(dbManager.validateUser(username, password)) {
    					loginSuccess = true;
    					// Close login window
    					dispose();
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(UILogin.this, "Invalid Login Credentials", "Login", JOptionPane.ERROR_MESSAGE);
    					textFieldUsername.setText("");
    					passwordFieldPassword.setText("");
    					loginSuccess = false;
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	});
    	
    	buttonCreateAccount.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			uiControl.createAccountScreen();
    		}
    	});
    	
    	buttonCancel.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			// Close login window
    			dispose();
    			System.exit(0);
    		}
    	});
    	
    	// Ends the program when the Dialog Box is closed
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(!loginSuccess) {
					System.exit(0);
				}
			}
		});
    	
    	// Adds all components to the pane
    	getContentPane().add(strutPrimaryWest, BorderLayout.WEST);
    	getContentPane().add(strutPrimaryEast, BorderLayout.EAST);
    	getContentPane().add(strutPrimaryNorth, BorderLayout.NORTH);
    	getContentPane().add(strutPrimarySouth, BorderLayout.SOUTH);
    	getContentPane().add(panelLoginPrimary, BorderLayout.CENTER);

    	panelLoginPrimary.add(labelTitle);
    	panelLoginPrimary.add(panelLoginAndButton);
    	
    	panelLoginAndButton.add(panelLoginGrid);
    	panelLoginAndButton.add(panelButtonGrid);
    	
    	panelLoginGrid.add(strutLoginWest);
    	panelLoginGrid.add(panelLoginInput);
    	panelLoginGrid.add(strutLoginEast);
    	
    	panelLoginInput.add(labelUsername);
    	panelLoginInput.add(textFieldUsername);
    	panelLoginInput.add(labelPassword);
    	panelLoginInput.add(passwordFieldPassword);
    	
    	panelButtonGrid.add(strutButtonWest);
    	panelButtonGrid.add(panelButtonInput);
    	panelButtonGrid.add(strutButtonEast);
    	
    	panelButtonInput.add(buttonLogin);
    	panelButtonInput.add(buttonCreateAccount);
    	panelButtonInput.add(buttonCancel);

    	// Sets the default selected button to be the Login Button
    	SwingUtilities.getRootPane(buttonLogin).setDefaultButton(buttonLogin);

    	pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	@Override
	public void display() {
		setVisible(true);
	}
	
	public boolean isLoginSuccess() {
		return loginSuccess;
	}
}
