package myfinancespackage.ui;

import java.awt.event.*;
import java.util.Arrays;
import java.awt.*;

import javax.swing.*;

import myfinancespackage.db.DBException;
import myfinancespackage.db.DBReadAndWrite;

public class UILogin extends JDialog {
	private JPanel loginPanel, buttonPanel;
	private GridBagConstraints constraints;
	private JLabel loginScreenTitleLabel, usernameLabel, passwordLabel;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JButton loginButton, cancelButton;
	
	private String username;
	private String password;
	private static boolean loginSuccess;

	public UILogin(JFrame parentFrame) {
		super(parentFrame, "My Finances Login", true);
		loginSuccess = false;
		
    	createLoginScreen();
    	
		pack();
		setResizable(false);
		setLocationRelativeTo(parentFrame);
		setVisible(true);
	}
	
	private void createLoginScreen() {
		loginPanel = new JPanel(new GridBagLayout());
		buttonPanel = new JPanel();
		constraints = new GridBagConstraints();
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridheight = 1;

		loginScreenTitleLabel = new JLabel("My Finances Login", SwingConstants.CENTER);
		loginScreenTitleLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));
		constraints.gridy = 0;
		loginPanel.add(loginScreenTitleLabel, constraints);
		
		usernameLabel = new JLabel("Username: ");
		constraints.gridy = 1;
		loginPanel.add(usernameLabel, constraints);
		
		usernameTextField = new JTextField(15);
		constraints.gridy = 2;
		loginPanel.add(usernameTextField, constraints);
		
		passwordLabel = new JLabel("Password: ");
		constraints.gridy = 3;
		loginPanel.add(passwordLabel, constraints);

		passwordTextField = new JPasswordField(15);
		constraints.gridy = 4;
		loginPanel.add(passwordTextField, constraints);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				username = usernameTextField.getText().trim();
				password = new String(passwordTextField.getPassword());
				try {
					if(DBReadAndWrite.populateUserFromDBInfo(username, password)) {
						loginSuccess = true;
						// Close login window
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(UILogin.this, "Invalid Login Credentials", "Login", JOptionPane.ERROR_MESSAGE);
						usernameTextField.setText("");
						passwordTextField.setText("");
						loginSuccess = false;
					}
				} catch (HeadlessException | DBException e) {
					e.printStackTrace();
				}
			}
		});
		buttonPanel.add(loginButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				// Close login window
				dispose();
				System.exit(0);
			}
		});
		buttonPanel.add(cancelButton);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(!loginSuccess) {
					System.exit(0);
				}
			}
		});
		
		// Add a button to create a new account
		
		getContentPane().add(loginPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
	}
	
	public boolean isLoginSuccess() {
		return loginSuccess;
	}
}
