package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import functions.RegisterModel;
import gui.RegisterFrame;



	public class RegisterControl implements ActionListener {
		RegisterModel model; 
		RegisterFrame view; 
		
		public RegisterControl(RegisterModel model, RegisterFrame view){
			this.model = model; 
			this.view = view;
			//add action listener from control to view. 
			view.buttonActionListeners(this);
		}
		
		//action performed by view
		public void actionPerformed(ActionEvent ae){
			String action = ae.getActionCommand(); 
			System.out.println("something happened");
			if(action.equals("Register")){
				try {
					model.attemptRegister(view.getUsername(), view.getPassword(), view.getPasswordConfirm() , 
							              view.getEmail(), view.getFirstName(), view.getLastName(), view.getAddress());
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} 
			}
			
		}
	}
