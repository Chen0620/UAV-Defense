package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JPasswordField textPasswordConfirm;
	private JTextField textEmail;
	private JButton btnRegister; 
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textAddress;

	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		        createAndShowGUI();
	}

	private void createAndShowGUI(){
		JFrame frame = new JFrame(); 
		frame.setTitle("Register"); 
		frame.setContentPane(createContentPane());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 502, 324);
		frame.setVisible(true); 
	}

	private JPanel createContentPane(){ 
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{40, 85, 135, 94, 0, 41, 0};
		gbl_contentPane.rowHeights = new int[]{56, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Helvetica", Font.BOLD, 16));
		lblRegister.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblRegister = new GridBagConstraints();
		gbc_lblRegister.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblRegister.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegister.gridx = 1;
		gbc_lblRegister.gridy = 0;
		contentPane.add(lblRegister, gbc_lblRegister);
		
		JLabel lblUsername = new JLabel(" Username");
		lblUsername.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblUsername.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 1;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		JLabel lblEmailAddress = new JLabel(" Email Address");
		lblEmailAddress.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblEmailAddress.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblEmailAddress = new GridBagConstraints();
		gbc_lblEmailAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailAddress.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblEmailAddress.gridx = 3;
		gbc_lblEmailAddress.gridy = 1;
		contentPane.add(lblEmailAddress, gbc_lblEmailAddress);
		
		textUsername = new JTextField();
		GridBagConstraints gbc_textUsername = new GridBagConstraints();
		gbc_textUsername.gridwidth = 2;
		gbc_textUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsername.gridx = 1;
		gbc_textUsername.gridy = 2;
		contentPane.add(textUsername, gbc_textUsername);
		textUsername.setColumns(10);
		
		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.gridwidth = 2;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 3;
		gbc_textEmail.gridy = 2;
		contentPane.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel(" Password");
		lblPassword.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblPassword.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		JLabel lblConfirmPassword = new JLabel(" Confirm Password");
		lblConfirmPassword.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblConfirmPassword.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmPassword.gridx = 3;
		gbc_lblConfirmPassword.gridy = 3;
		contentPane.add(lblConfirmPassword, gbc_lblConfirmPassword);
		
		textPassword = new JPasswordField();
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.gridwidth = 2;
		gbc_textPassword.anchor = GridBagConstraints.NORTH;
		gbc_textPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPassword.gridx = 1;
		gbc_textPassword.gridy = 4;
		contentPane.add(textPassword, gbc_textPassword);
		
		textPasswordConfirm = new JPasswordField();
		GridBagConstraints gbc_textPasswordConfirm = new GridBagConstraints();
		gbc_textPasswordConfirm.gridwidth = 2;
		gbc_textPasswordConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_textPasswordConfirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPasswordConfirm.gridx = 3;
		gbc_textPasswordConfirm.gridy = 4;
		contentPane.add(textPasswordConfirm, gbc_textPasswordConfirm);
		
		JLabel lblFirstName = new JLabel(" First Name");
		lblFirstName.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblFirstName.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 5;
		contentPane.add(lblFirstName, gbc_lblFirstName);
		
		JLabel lblLastName = new JLabel(" Last Name");
		lblLastName.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblLastName.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.WEST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 3;
		gbc_lblLastName.gridy = 5;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		textFirstName = new JTextField();
		GridBagConstraints gbc_textFirstName = new GridBagConstraints();
		gbc_textFirstName.gridwidth = 2;
		gbc_textFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_textFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFirstName.gridx = 1;
		gbc_textFirstName.gridy = 6;
		contentPane.add(textFirstName, gbc_textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		GridBagConstraints gbc_textLastName = new GridBagConstraints();
		gbc_textLastName.gridwidth = 2;
		gbc_textLastName.insets = new Insets(0, 0, 5, 5);
		gbc_textLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLastName.gridx = 3;
		gbc_textLastName.gridy = 6;
		contentPane.add(textLastName, gbc_textLastName);
		textLastName.setColumns(10);
		
		JLabel lblAddress = new JLabel(" Address");
		lblAddress.setForeground(Color.LIGHT_GRAY);
		lblAddress.setFont(new Font("Helvetica", Font.PLAIN, 12));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 7;
		contentPane.add(lblAddress, gbc_lblAddress);
		
		textAddress = new JTextField();
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.gridwidth = 4;
		gbc_textAddress.insets = new Insets(0, 0, 5, 5);
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 8;
		contentPane.add(textAddress, gbc_textAddress);
		textAddress.setColumns(10);
		
		btnRegister = new JButton("Register");
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegister.anchor = GridBagConstraints.EAST;
		gbc_btnRegister.gridx = 4;
		gbc_btnRegister.gridy = 9;
		contentPane.add(btnRegister, gbc_btnRegister);
		
		return contentPane; 

	}
	public void buttonActionListeners(ActionListener al){
		btnRegister.setActionCommand("Register");
		btnRegister.addActionListener(al);
	}
	
	public String getAddress(){
		return textAddress.getText();
	}
	public String getFirstName(){
		return textFirstName.getText(); 
	}
	public String getLastName(){
		return textLastName.getText(); 
	}
	public String getUsername(){
		return textUsername.getText();
	}
	public char[] getPassword(){
		return textPassword.getPassword(); 
	}
	public char[] getPasswordConfirm(){
		return textPasswordConfirm.getPassword(); 
	}
	public String getEmail(){
		return textEmail.getText(); 
	}
}