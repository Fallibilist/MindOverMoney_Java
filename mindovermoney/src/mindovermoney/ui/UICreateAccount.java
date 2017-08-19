package mindovermoney.ui;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import mindovermoney.business.User;
import mindovermoney.db.DBException;
import mindovermoney.db.DBManager;

public class UICreateAccount extends JDialog implements UIPanelDisplayInterface {
	private UIControl uiControl;
	private DBManager dbManager;

	private String username;
	private String password;
	private boolean creationSuccess;

	public UICreateAccount(UIControl uiControl, DBManager dbManager) {
		super(uiControl, "Mind Over Money", true);
		
		this.uiControl = uiControl;
		this.dbManager = dbManager;

		buildPanel();
	}

	private void buildPanel() {
		getContentPane().setBackground(new Color(0, 0, 0));
		
		creationSuccess = false;
		
		// Component Declarations
		JPanel panelFormattingContainer, panelBorderSpacing, panelAccountCreation, panelInputFields, panelButtons;
		Component strutPrimaryNorth, strutPrimaryEast, strutPrimaryWest, strutPrimarySouth, strutSecondaryWest, strutSecondaryEast, strutSecondaryNorth, strutSecondarySouth, strutMiddleSpace;
		JLabel labelTitle, labelUsername, labelPassword, labelConfirmPassword;
		JTextField textFieldUsername;
		JPasswordField passwordFieldPassword, passwordFieldConfirmPassword;
		JButton buttonCreateAccount, buttonCancel;
		

		// Panels
    	panelFormattingContainer = new JPanel();
    	panelFormattingContainer.setLayout(new BorderLayout());
    	panelFormattingContainer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    	panelFormattingContainer.setOpaque(false);
    	
    	panelBorderSpacing = new JPanel();
    	panelBorderSpacing.setLayout(new FlowLayout());
    	panelBorderSpacing.setOpaque(false);
    	
    	panelAccountCreation = new JPanel();
    	panelAccountCreation.setLayout(new BoxLayout(panelAccountCreation, BoxLayout.Y_AXIS));
    	panelAccountCreation.setOpaque(false);
    	
    	panelInputFields = new JPanel();
    	panelInputFields.setLayout(new GridLayout(7, 1, 0, 0));
    	panelInputFields.setOpaque(false);
    	
    	panelButtons = new JPanel();
    	panelButtons.setLayout(new GridLayout(2, 1, 0, 5));
    	panelButtons.setOpaque(false);

    	// Struts
    	strutPrimaryWest = Box.createHorizontalStrut(20);
    	strutPrimaryEast = Box.createHorizontalStrut(20);
    	strutPrimaryNorth = Box.createVerticalStrut(20);
    	strutPrimarySouth = Box.createVerticalStrut(20);

    	strutSecondaryWest = Box.createHorizontalStrut(10);
    	strutSecondaryEast = Box.createHorizontalStrut(10);
    	strutSecondaryNorth = Box.createVerticalStrut(10);
    	strutSecondarySouth = Box.createVerticalStrut(10);

    	strutMiddleSpace = Box.createVerticalStrut(20);
    	
    	// Labels
    	labelTitle = new JLabel("Account Creation");
    	labelTitle.setForeground(Color.WHITE);
    	labelTitle.setFont(new Font("TimesRoman", Font.BOLD, 30));
    	
    	labelUsername = new JLabel("Username: ");
    	labelUsername.setForeground(Color.WHITE);
    	labelUsername.setFont(new Font("TimesRoman", Font.BOLD, 15));
    	
    	labelPassword = new JLabel("Password: ");
    	labelPassword.setForeground(Color.WHITE);
    	labelPassword.setFont(new Font("TimesRoman", Font.BOLD, 15));
    	
    	labelConfirmPassword = new JLabel("Confirm Password: ");
    	labelConfirmPassword.setForeground(Color.WHITE);
    	labelConfirmPassword.setFont(new Font("TimesRoman", Font.BOLD, 15));
    	
    	// Text Fields
    	textFieldUsername = new JTextField(15);
    	passwordFieldPassword = new JPasswordField(15);
    	passwordFieldConfirmPassword = new JPasswordField(15);
    	
    	//Buttons
    	buttonCreateAccount = new JButton("Create Account");
    	buttonCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
    	buttonCreateAccount.setPreferredSize(new Dimension(0, 40));
    	buttonCreateAccount.setOpaque(false);

    	buttonCancel = new JButton("Cancel");
    	buttonCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
    	buttonCancel.setOpaque(false);
    	
    	// Button Action Listeners
    	buttonCreateAccount.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			// Account Creation Logic Here
    		}
    	});
    	
    	buttonCancel.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			dispose();
    		}
    	});
    	
    	// Adds all components to the pane
    	this.getContentPane().add(strutPrimaryWest, BorderLayout.WEST);
    	this.getContentPane().add(strutPrimaryEast, BorderLayout.EAST);
    	this.getContentPane().add(strutPrimaryNorth, BorderLayout.NORTH);
    	this.getContentPane().add(strutPrimarySouth, BorderLayout.SOUTH);
    	this.getContentPane().add(panelFormattingContainer, BorderLayout.CENTER);

    	panelFormattingContainer.add(strutSecondaryWest, BorderLayout.WEST);
    	panelFormattingContainer.add(strutSecondaryEast, BorderLayout.EAST);
    	panelFormattingContainer.add(strutSecondaryNorth, BorderLayout.NORTH);
    	panelFormattingContainer.add(strutSecondarySouth, BorderLayout.SOUTH);
    	panelFormattingContainer.add(panelBorderSpacing, BorderLayout.CENTER);
    	
    	panelBorderSpacing.add(panelAccountCreation);

    	panelAccountCreation.add(panelInputFields);
    	panelAccountCreation.add(strutMiddleSpace);
    	panelAccountCreation.add(panelButtons);
    	
    	panelInputFields.add(labelTitle);
    	panelInputFields.add(labelUsername);
    	panelInputFields.add(textFieldUsername);
    	panelInputFields.add(labelPassword);
    	panelInputFields.add(passwordFieldPassword);
    	panelInputFields.add(labelConfirmPassword);
    	panelInputFields.add(passwordFieldConfirmPassword);
    	panelButtons.add(buttonCreateAccount);
    	panelButtons.add(buttonCancel);

    	// Sets the default selected button to be the Login Button
    	SwingUtilities.getRootPane(buttonCreateAccount).setDefaultButton(buttonCreateAccount);

		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}
	
	public boolean isCreationSuccess() {
		return this.creationSuccess;
	}
}
