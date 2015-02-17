package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import authentification.PasswordSalts;
import authentification.User;

public class LoginDAO {
	Connection connection = null; 
	PreparedStatement stmt = null; 
	ResultSet result = null; 
	Datasource ds = null; 
	public LoginDAO(Datasource ds) {
		this.ds = ds; 
	}
	private Connection getConnection() throws SQLException {
		Connection conn; 
		conn = ds.getConnection(); 
		return conn; 
	}
	
	/*Input: Username and password for user
	 *Output: A User class
	 *A null user class indicates unsuccessful login. 
	 */
	public User attemptLogin(String username, char[] password){
		PreparedStatement psFindUser = null;
		ResultSet rsFindUser = null;
		PreparedStatement psAuthUser =null;
		ResultSet rsAuthUser = null;
		PreparedStatement psUserInfo = null; 
		ResultSet rsUserInfo = null; 
		try{
			String queryString = "SELECT * FROM Authenticate where Username=?";
			connection = getConnection(); 
			psFindUser = connection.prepareStatement(queryString);
			String pass = new String(password);
			if(password!=null)
			{	
					psFindUser.setString(1, username);
					System.out.println(psFindUser);
					rsFindUser= psFindUser.executeQuery();
					if(rsFindUser.next()){
						int ID = rsFindUser.getInt("AuthID"); 
						String salt = rsFindUser.getString("Salt");
						String securePassword = PasswordSalts.get_SecurePassword(pass, salt);
						queryString = "SELECT * FROM Authenticate where AuthID = ? AND Password = ?";
						psFindUser.close();
						rsFindUser.close(); 
						psAuthUser = connection.prepareStatement(queryString);
						psAuthUser.setInt(1, ID);
						psAuthUser.setString(2,securePassword); 
						rsAuthUser = psAuthUser.executeQuery(); 
						if (rsAuthUser.next())
						{
							System.out.println(rsAuthUser.getInt("AuthID"));
							User user = new User(ID, rsAuthUser.getString("Username"), "player", "player", "player", "status", "address");
							queryString = "SELECT * From UserInfo where UserID = ?"; 
							psUserInfo = connection.prepareStatement(queryString); 
							psUserInfo.setInt(1,ID); 
							rsUserInfo = psUserInfo.executeQuery(); 
							if(rsUserInfo.next()){
								user.setAddress(rsUserInfo.getString("Address"));
								user.setFirstName(rsUserInfo.getString("FirstName"));
								user.setLastName(rsUserInfo.getString("LastName"));
								return user;
							}else System.out.println("Error fetching user");
						}
						else{
							System.out.println("Wrong password/username");
							return null;
						}
					}
					else{
						System.out.println("Authentification failed");
						System.out.println("Could not find user or password associated with that user");
						return null; 
					}
			
				
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				if(psFindUser != null)
					psFindUser.close(); 
				if(psAuthUser != null)
					psAuthUser.close(); 
				if(rsFindUser != null)
					rsFindUser.close(); 
				if(rsAuthUser != null)
					rsAuthUser.close();
				if(rsUserInfo !=null)
					rsUserInfo.close(); 
				if(psUserInfo !=null)
					psUserInfo.close(); 
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return null;
	}
	
}
