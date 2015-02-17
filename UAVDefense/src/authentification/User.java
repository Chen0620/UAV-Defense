package authentification;

public class User {
	private int ID; 
	private String userName; 
	private String firstName;
	private String lastName;
	private String email; 
	private String userStatus;
	private String address;
	
	public User (int id, String username, String newFirstName, String newLastName, 
			    String newEmail, String newAddress, String newStatus){
		userName = username; 
		firstName = newFirstName; 
		lastName = newLastName; 
		email = newEmail; 
		address = newAddress; 
		ID = id; 
		userStatus = newStatus; 
	}
	public void setUserStatus(String newStatus){
		userStatus = newStatus; 
	}
	public void setFirstName(String newFirstName){
		firstName = newFirstName;
	}
	public void setLastName(String newLastName){
		lastName = newLastName;
	}
	public void setEmail(String newEmail){
		email = newEmail;
	}
	public void setAddress(String newAddress){
		address = newAddress; 
	}
	public String getUserStatus(){
		return userStatus; 
	}
	public String getUserName(){
		return userName; 
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName; 
	}
	public String getEmail(){
		return email; 
	}
	public int getID(){
		return ID; 
	}
	public String getAddress() {
		return address;
	}
}
