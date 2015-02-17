package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;

public class LoginFrame{

	private JPanel contentPane;
	private final JLabel credentialsLabel = new JLabel("Credentials");
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnRegister; 
	JFrame frame;  
	
	/**
	 * Create the frame.
	 */
	public LoginFrame()  {
		createAndShowGUI();
	}

	private void createAndShowGUI(){
					frame = new JFrame();
					frame.setTitle("Login");
					frame.setContentPane(createContentPane());
					frame.setBounds(100, 100, 480, 237);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
	
	}


	//A function that sets up the basic structure of the GUI.
	private JPanel createContentPane() {
	
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{106, 0, 0, 153, 0};
		gbl_contentPane.rowHeights = new int[]{65, 27, 39, 36, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		//username text field
		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.gridwidth = 2;
		gbc_usernameField.insets = new Insets(0, 0, 5, 0);
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridx = 2;
		gbc_usernameField.gridy = 1;
		contentPane.add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
				

		//password text field
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);

		//login label
		JLabel loginLabel = new JLabel("UAVDefense");
		loginLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
		loginLabel.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_loginLabel = new GridBagConstraints();
		gbc_loginLabel.gridwidth = 4;
		gbc_loginLabel.insets = new Insets(0, 0, 5, 0);
		gbc_loginLabel.gridx = 0;
		gbc_loginLabel.gridy = 0;
		contentPane.add(loginLabel, gbc_loginLabel);
		GridBagConstraints gbc_credentialsLabel = new GridBagConstraints();
		gbc_credentialsLabel.fill = GridBagConstraints.VERTICAL;
		gbc_credentialsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_credentialsLabel.gridx = 0;
		gbc_credentialsLabel.gridy = 1;
		credentialsLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		credentialsLabel.setForeground(Color.LIGHT_GRAY);
		contentPane.add(credentialsLabel, gbc_credentialsLabel);
		
		//username label
		JLabel usernameLabel = new JLabel("username");
		usernameLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		usernameLabel.setForeground(Color.LIGHT_GRAY);
		usernameLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.WEST;
		gbc_usernameLabel.fill = GridBagConstraints.VERTICAL;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 1;
		gbc_usernameLabel.gridy = 1;
		contentPane.add(usernameLabel, gbc_usernameLabel);
				
		//password label
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		passwordLabel.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.WEST;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 1;
		gbc_passwordLabel.gridy = 2;
		contentPane.add(passwordLabel, gbc_passwordLabel);

		//login button
		btnLogin = new JButton("login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.WEST;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 3;
		contentPane.add(btnLogin, gbc_btnLogin);
				
		//register button 
		btnRegister = new JButton("register");
		btnRegister.setFont(new Font("Helvetica", Font.PLAIN, 13));
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.anchor = GridBagConstraints.WEST;
		gbc_btnRegister.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegister.gridx = 3;
		gbc_btnRegister.gridy = 3;
		contentPane.add(btnRegister, gbc_btnRegister);
		return contentPane; 
	}

	//the Action Listener for the Login Button passed by controller
	public void buttonActionListeners(ActionListener al) {
		btnLogin.setActionCommand("login");
		btnLogin.addActionListener(al); 
		btnRegister.setActionCommand("register");
		btnRegister.addActionListener(al); 
	}
	
	//method to get the username for login control
	public String getUsername() {
		return usernameField.getText();
	}
	
	//method to get the password for login control 
	public char[] getPassword() {
		return passwordField.getPassword(); 
	}
	
	public void closeFrame(){
		frame.dispose();
	}

}
