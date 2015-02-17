import functions.LoginModel;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import authentification.User;
import controller.LoginControl;
import database.Datasource;
import database.LoginDAO;
import gui.JoinFrame;
import gui.LoginFrame;

import java.sql.Connection;

public class Main {
	
	public static void main(String[] args) throws IOException, SQLException {
		//start the connection pool
		Datasource ds = Datasource.getInstance();
		//get a connection 
		System.out.println("get a connection");
	    Connection connection = ds.getConnection();
	    System.out.println("close the connection/return the connection to the pool");
	    connection.close(); 
	    
	    //start the main GUI and get a User from the database or register the user. 
		LoginFrame view = new LoginFrame(); 
		LoginDAO loginDao = new LoginDAO(ds); 
		LoginModel model = new LoginModel(loginDao,ds);
		LoginControl controller = new LoginControl(model, view); 	
	}
	
}
