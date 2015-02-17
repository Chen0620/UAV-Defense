package functions;


import authentification.User;
import controller.RegisterControl;
import controller.StartControl;
import gui.RegisterFrame;
import gui.StartFrame;
import database.Datasource;
import database.LoginDAO;
import database.RegisterDAO;
import database.StartDAO;

public class LoginModel {
	LoginDAO loginDao; 
	Datasource ds; 
	private User user; 
	
	public LoginModel(LoginDAO loginDao, Datasource ds){
		this.loginDao = loginDao;
		this.ds = ds;
	}
	public boolean attemptLogin(String username, char[] password) {
		this.user = loginDao.attemptLogin(username, password); 
		if(this.user != null)
		{
			System.out.println("we have a user here"); 
			StartFrame view = new StartFrame(this.user);
			StartDAO startDao = new StartDAO(this.ds); 
			StartModel model = new StartModel(startDao, this.ds, this.user); 
			StartControl controller = new StartControl(model,view); 
			return true; 
		}else return false;	 
	}
	public User getUser(){
		return user; 
	}
	public void attemptRegister()
	{
		RegisterFrame frame = new RegisterFrame(); 
		RegisterDAO registerDao = new RegisterDAO(); 
		RegisterModel registerModel = new RegisterModel(registerDao); 
		RegisterControl registerControl = new RegisterControl(registerModel, frame); 
	}

}
