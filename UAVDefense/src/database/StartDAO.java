package database;

import game_components.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StartDAO {
	Connection connection;
	Datasource ds = null; 
	PreparedStatement psGetInfo = null; 
	PreparedStatement psCount = null; 
	ResultSet  rsCount = null;
	ResultSet rsGetInfo = null; 
	Game[] games; 
	public StartDAO(Datasource ds) {
		this.ds = ds; 
	}
	private Connection getConnection() throws SQLException {
		Connection conn; 
		conn = ds.getConnection(); 
		return conn; 
	}
	public int getGameCount() {
		int count = 0;
		try {
			connection = getConnection();
			String queryString = "SELECT COUNT(*) FROM Game WHERE IsEnded=0"; 
			psCount = connection.prepareStatement(queryString);
			rsCount = psCount.executeQuery(); 
			if(rsCount.next()){
				count = rsCount.getInt("Count(*)");
				return count;
			} else return 0; 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(psCount != null)
					psCount.close(); 
				if(psGetInfo != null)
					psGetInfo.close(); 
				if(connection != null)
					connection.close();
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
			
		}
		return count;
	}
	public Game[] getGameInfo() {
		int count = getGameCount(); 
		Game[] games = new Game[count];
		try {
			connection = getConnection();
			String queryString = "SELECT * FROM Game WHERE IsEnded=0"; 
			psGetInfo = connection.prepareStatement(queryString);
			rsGetInfo = psGetInfo.executeQuery(); 
				for(int index = 0 ; index < 100 ; index++){
					if(rsGetInfo.next()){
						Game game = new Game(rsGetInfo.getInt("GameID"), rsGetInfo.getString("GameName"), rsGetInfo.getInt("NumPlayers"), rsGetInfo.getInt("XMapSize"), 
								rsGetInfo.getInt("YMapSize"), rsGetInfo.getInt("BestOf"),rsGetInfo.getInt("SubroundDuration"), rsGetInfo.getInt("NumTargets"), null, null); 
						games[index] = game; 
					}else{
						break; 
					}
				}
			return games;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(psCount != null)
					psCount.close(); 
				if(psGetInfo != null)
					psGetInfo.close(); 
				if(connection != null)
					connection.close();
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return games; 
	}
}
