package database;


import game_components.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GameInfoDAO {
	Connection connection = null; 
	PreparedStatement psCount = null; 
	ResultSet rsCount = null; 
	PreparedStatement psGetInfo = null; 
	ResultSet rsGetInfo = null; 
	Datasource ds = null; 
	Game game[]; 
	public GameInfoDAO(Datasource ds) {
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
		Game game[] = new Game[count];  
		try {
			connection = getConnection();
			String queryString = "SELECT * FROM Game WHERE IsEnded=0"; 
			psGetInfo = connection.prepareStatement(queryString);
			rsGetInfo = psGetInfo.executeQuery(); 
			if(rsGetInfo.next()){
				for(int index = 0 ; index < count ; index++){
					game[index].setID(rsGetInfo.getInt("ID"));
					game[index].setBestOf(rsGetInfo.getInt("BestOf"));
					game[index].setNumPlayers(rsGetInfo.getInt("NumPlayers"));
					game[index].setxMapSize(rsGetInfo.getInt("XMapSize"));
					game[index].setyMapSize(rsGetInfo.getInt("YMapSize"));
					game[index].setSubRoundDuration(rsGetInfo.getInt("SubRoundDuration"));
					game[index].setNumTargets(rsGetInfo.getInt("NumTargets"));
				}
			}  
			return game;
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
		return game; 
	}
}
