package database;

import game_components.Drone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import authentification.User;



public class CreateDroneDAO {
	
	Connection connection = null; 
	PreparedStatement ps = null; 
	ResultSet result = null; 
	Datasource ds = null; 
	public CreateDroneDAO(Datasource ds) {
		this.ds = ds; 
	}
	private Connection getConnection() throws SQLException {
		Connection conn; 
		conn = ds.getConnection(); 
		return conn; 
	}

	public void createDrone(Drone drone, User user) {
		try {
			connection = getConnection();
			String queryString = "INSERT INTO Drone (DroneName, PlayerDroneID) VALUES (?, ?)";
			ps = connection.prepareStatement(queryString);
			ps.setString(1, user.getFirstName());//change this for drone class. 
			ps.setInt(2, user.getID() ); 
			 
			if(ps.executeUpdate() == 1){
				System.out.println("We have created the drone successfully");
			}else System.out.println("We could not create the drone"); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(ps != null)
					ps.close(); 
				if(connection != null)
					connection.close();
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
	}
	
}
	
