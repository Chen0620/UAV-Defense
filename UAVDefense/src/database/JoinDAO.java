package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import game_components.Game;
import game_components.Player;
import game_components.Team;

public class JoinDAO {
	Connection connection;
	Datasource ds = null; 
	Team team1; 
	Team team2; 
	Team[] teams = new Team[2]; 
	public JoinDAO(Datasource ds) {
		this.ds = ds; 
	}
	private Connection getConnection() throws SQLException {
		Connection conn; 
		conn = ds.getConnection(); 
		return conn; 
	}
	public Team[] getTeams(Game game){ 
		PreparedStatement stmt = null; 
		ResultSet result = null; 
		try {
			connection = getConnection();
			int ID = game.getID(); //use this ID in the query below
			System.out.println("The Game ID is " + ID);
			String queryString = "SELECT * FROM Team WHERE TeamGameID = ?";  //DO a query on the Team Table where GameID = ID; 
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,ID);
			result = stmt.executeQuery(); 
			if(result.next()){
				Team team1 = new Team(result.getInt("TeamID"),result.getInt("TeamGameID"), result.getString("TeamName"),result.getInt("TeamNumPlayers")); 
				teams[0] = team1; 
				result.next(); 
				Team team2 = new Team(result.getInt("TeamID"),result.getInt("TeamGameID"), result.getString("TeamName"),result.getInt("TeamNumPlayers")); 
				teams[1] = team2; 
				return teams; 
			}else System.out.println("We have not been able to get team information"); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(result != null)
					result.close(); 
				if(connection != null)
					connection.close();
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return teams;
	}
	
	public Player[] getPlayers(Team team){
		PreparedStatement stmt = null; 
		ResultSet result = null; 
		Player[] players = new Player[team.getNumPlayers()]; 
		int playerIndex = 0; 
		try {
			connection = getConnection();
			int ID = team.getTeamID(); 
			String queryString = "SELECT * FROM Player WHERE PlayerTeamID = ?"; //SELECT ALL PLAYERS WHO TEAMID = ID 
			stmt = connection.prepareStatement(queryString);
		    stmt.setInt(1, ID);
			result = stmt.executeQuery(); 
			//find the count of the result set. 
			while(result.next()){
				Player player = new Player(result.getInt("PlayerID"),result.getString("PlayerUsername"), result.getString("PlayerStatus")); //fill this shit out for the player Information, then set it into player array.  
				players[playerIndex] = player; 
				playerIndex++; 
			}
			return players; 
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(result != null)
					result.close();
				if(connection != null)
					connection.close();
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return players;
	}
	public Game getGameInfo(int gameID) { 
		PreparedStatement psGetInfo = null; 
		ResultSet rsGetInfo = null; 
		try {
			connection = getConnection();
			String queryString = "SELECT * FROM Game WHERE GameID = ?"; 
			psGetInfo = connection.prepareStatement(queryString);
			psGetInfo.setInt(1, gameID);
			rsGetInfo = psGetInfo.executeQuery(); 
			if(rsGetInfo.next()){
				Game game = new Game(rsGetInfo.getInt("GameID"), rsGetInfo.getString("GameName"), rsGetInfo.getInt("NumPlayers"), rsGetInfo.getInt("XMapSize"), 
						rsGetInfo.getInt("YMapSize"), rsGetInfo.getInt("BestOf"),rsGetInfo.getInt("SubroundDuration"), rsGetInfo.getInt("NumTargets"), null, null);
				return game;
			}  
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
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
		return null; 
	}
	public void joinTeam(int whichTeam, int userID, int gameID, int teamID) {
		PreparedStatement psJoinTeam = null; 
		try{
			connection = getConnection(); 
			String queryString = "UPDATE Player SET PlayerGameID = ?, PlayerTeamID = ? WHERE PlayerID = ?"; 
			psJoinTeam = connection.prepareStatement(queryString); 
			psJoinTeam.setInt(1, gameID);
			psJoinTeam.setInt(2, teamID);
			psJoinTeam.setInt(3, userID); 
			if(psJoinTeam.executeUpdate() == 1){
				System.out.println("We were able to join the game.");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(psJoinTeam != null)
					psJoinTeam.close(); 
				if(connection != null)
					connection.close();
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
	}
	public void lockIn(int id) {
		PreparedStatement psLockin = null; 
		try{
			connection = getConnection(); 
			String queryString = "Update Player SET PlayerStatus = ? WHERE PlayerID = ?"; 
			psLockin = connection.prepareStatement(queryString); 
			psLockin.setString(1, "locked in");
			psLockin.setInt(2, id);
			if(psLockin.executeUpdate()==1){
				System.out.println("We were able to lock in.");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(psLockin != null)
					psLockin.close(); 
				if(connection != null)
					connection.close();
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
	}
	public void unlock(int id) {
		PreparedStatement psLockin = null; 
		try{
			connection = getConnection(); 
			String queryString = "Update Player SET PlayerStatus = ? WHERE PlayerID = ?"; 
			psLockin = connection.prepareStatement(queryString); 
			psLockin.setString(1, "waiting");
			psLockin.setInt(2, id);
			if(psLockin.executeUpdate()==1){
				System.out.println("We were able to unlock.");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(psLockin != null)
					psLockin.close(); 
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

