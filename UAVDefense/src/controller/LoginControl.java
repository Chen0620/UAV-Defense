package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import functions.LoginModel;
import gui.LoginFrame;


public class LoginControl implements ActionListener {

	LoginModel model; 
	LoginFrame view; 
	
	public LoginControl(LoginModel model, LoginFrame view){
		this.model = model; 
		this.view = view;
		//add action listener from control to view. 
		view.buttonActionListeners(this); 
	}
	//action performed by view
	public void actionPerformed(ActionEvent ae){
		String action = ae.getActionCommand(); 
		if(action.equals("login")){
			if(model.attemptLogin(view.getUsername(),view.getPassword()))
			  view.closeFrame(); 
		}
		if(action.equals("register")){
			model.attemptRegister(); 
		}
	}
}
