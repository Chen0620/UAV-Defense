package database;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import authentification.*;  
public class RegisterDAO {
	Connection connection = null; 
	PreparedStatement stmt = null; 
	ResultSet result = null; 
	PreparedStatement playerStmt = null; 
	ResultSet playerResult = null; 
	public RegisterDAO(){
		
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn; 
		conn = DBConnection.getInstance().getConnection(); 
		return conn; 
	}
	
	/* Function takes in as an input the registration field
	 * Does a form validation
	 * Checks to see if the username is already registered
	 * Checks to see if the email address is already registered
	 * returns an int: 1 if successful registration
	 * 				   0 if unsuccessful registration 
	 */
	public int attemptRegister(String username, char[] password, char[] passwordConfirm,
			String email, String first, String last, String address) throws NoSuchAlgorithmException{
		try{
				connection = getConnection(); 
				String pass = new String(password);
				String confirmPass = new String(passwordConfirm);
				// form validation in the if-statement. I'll come back to this later and make it more professional
				// also need to check minimum length of password/username, validate email 
			if(username!=null && pass!=null && pass.equals(confirmPass)==true && email!=null){	
				PreparedStatement ps;
				ResultSet rs;
				
				String queryString = "SELECT AuthID FROM Authenticate WHERE Username=?";
				
				ps = connection.prepareStatement(queryString);
				System.out.println(ps);
				ps.setString(1, username); 
				ps.toString(); 
				rs = ps.executeQuery();
				if(rs.next()){
					System.out.println("Register Unsuccesful");
					return 1; 
				}else{
					
					//register the user
					String salt = PasswordSalts.getSalt(); 
				    String securePassword = null;
					try {
						securePassword = PasswordSalts.get_SecurePassword(pass, salt);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					queryString = "INSERT INTO Authenticate (Username, Password, Salt, Email, Role) VALUES (?,?,?,?,?);";
					ps = connection.prepareStatement(queryString); 
					ps.setString(1, username);
					ps.setString(2, securePassword);
					ps.setString(3, salt);
					ps.setString(4, email);
					ps.setString(5, "Player");
					System.out.println(ps); 
					ps.executeUpdate();
					
					//get the user's ID so that we can create a row in the player table for that user
					queryString = "SELECT AuthID FROM Authenticate WHERE Username=?";
					ps = connection.prepareStatement(queryString); 
					ps.setString(1,username);
					rs = ps.executeQuery(); 
					if(rs.next()){
					int ID = rs.getInt("AuthID"); 
						queryString = "INSERT INTO UserInfo (UserID, FirstName,LastName, Address) Values (?,?,?,?)"; 
						ps = connection.prepareStatement(queryString); 
						ps.setInt(1, ID);
						ps.setString(2, first);
						ps.setString(3, last);
						ps.setString(4, address);
						if(ps.executeUpdate() == 1){
							System.out.println("User info successfully created");
							queryString = "INSERT INTO Player (PlayerID, PlayerUsername) VALUES(?,?);";
							playerStmt = connection.prepareStatement(queryString); 
							playerStmt.setInt(1, ID);
							playerStmt.setString(2, username);
							playerStmt.executeUpdate(); 
						}else System.out.println("User info not created successfully");
					}
					System.out.println("Register Successful");
				}
			}
			else{
				System.out.println("Error:Check form again");
				return 0;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(playerStmt != null){
					playerStmt.close();
				}
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return 1;
		//do query to get new player values and place them into user
	}
}
