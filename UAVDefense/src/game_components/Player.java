package game_components;

public class Player {
	private int playerID; 
	private String playerName; 
	private String playerStatus; 
	public Player (int id, String username, String playerStatus){
		this.playerID = id; 
		this.playerName = username; 
		this.playerStatus = playerStatus; 
	}
	public String getPlayerStatus() {
		return playerStatus;
	}
	public void setPlayerStatus(String playerStatus) {
		this.playerStatus = playerStatus;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	
	
}
