package game_components;

public class Team {
	private int teamID; 
	private int numPlayers; 
	private int teamGameID; 
	private String teamName; 
	private Player[] playerArr;
	
	public Team (int teamID, int teamGameID, String teamName, int numPlayers){
		this.teamName = teamName; 
		this.teamID = teamID;
		this.setTeamGameID(teamGameID); 
		this.setNumPlayers(numPlayers); 
		Player[] player = new Player[numPlayers]; 
		playerArr = player; 
	}

	public Player[] getUserArr() {
		return playerArr;
	}

	public void setUserArr(Player[] teamOnePlayers) {
		this.playerArr = teamOnePlayers;
	}

	public Player[] getPlayerArr() {
		return playerArr;
	}

	public void setPlayerArr(Player[] playerArr) {
		this.playerArr = playerArr;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamGameID() {
		return teamGameID;
	}

	public void setTeamGameID(int teamGameID) {
		this.teamGameID = teamGameID;
	}
	 
}
