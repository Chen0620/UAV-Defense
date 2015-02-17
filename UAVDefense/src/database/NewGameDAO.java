package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class NewGameDAO {
	Connection connection = null; 
	PreparedStatement ps = null; 
	PreparedStatement psGetGame = null; 
	ResultSet result = null; 
	Datasource ds = null; 
	public NewGameDAO(Datasource ds) {
		this.ds = ds; 
	}
	private Connection getConnection() throws SQLException {
		Connection conn; 
		conn = ds.getConnection(); 
		return conn; 
	}

	public int[] createGame(String gameName, int numPlayers, int bestOf, int xMapSize, int yMapSize,
			 int subRoundDuration, int numTargets) {
		System.out.println("Creating Game!");
		try {
			connection = getConnection();
			String queryString = "INSERT INTO Game (GameName, NumPlayers, XMapSize, YMapSize, BestOf, SubRoundDuration, NumTargets)"
							   + "VALUES(?, ?, ?, ?, ?, ?, ?)"; 
			ps = connection.prepareStatement(queryString);
			ps.setString(1, gameName);
			ps.setInt(2,numPlayers);
			ps.setInt(3, xMapSize);
			ps.setInt(4, yMapSize);
			ps.setInt(5, bestOf);
			ps.setInt(6, subRoundDuration);
			ps.setInt(7, numTargets);
			 
			if(ps.executeUpdate() == 1){
				System.out.println("We have created the game successfully");
				queryString = "SELECT * FROM Game WHERE GameName = ?";
				psGetGame = connection.prepareStatement(queryString); 
				psGetGame.setString(1, gameName);
				result = psGetGame.executeQuery(); 
				if(result.next()){
					int[] gameInfo = new int[2];
							gameInfo[0] =result.getInt("GameID");
							gameInfo[1] =result.getInt("NumPlayers"); 
							return gameInfo; 
				}
			}else System.out.println("We have not been able to create the game"); 
			return null; 
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
		return null;
	}
	public void createTeams(String teamName, int gameID, int numPlayers) {
		try {
			connection = getConnection();
			String queryString = "INSERT INTO Team (TeamName, TeamGameId, TeamNumPlayers) VALUES (?,?,?)"; 
			ps = connection.prepareStatement(queryString);
			ps.setString(1, teamName);
			ps.setInt(2,gameID);
			ps.setInt(3, numPlayers);
			if(ps.executeUpdate() == 1){
				System.out.println("We have created the team successfully");
			}else System.out.println("We have not been able to create the team");
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
