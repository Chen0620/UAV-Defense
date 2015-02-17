package game_components;

public class Game {
	private int ID; 
	private String gameName; 
	private int numPlayers;
	private int xMapSize;
	private int yMapSize; 
	private int bestOf; 
	private int subRoundDuration; //in seconds
	private int runningTime; 
	private int numTargets; 
	private Team[] team = new Team[2];
	//subround stuff : private SubRound sub;
	private int gameScoreBoardID; 
	
	public Game (int ID, String gameName, int numPlayers, int xMapSize, 
			    int yMapSize, int bestOf, int subRoundDuration, int numTargets, Team fstTeam, Team scdTeam){
		this.ID = ID; 
	    this.gameName = gameName; 
		this.numPlayers = numPlayers;
		this.xMapSize = xMapSize; 
		this.yMapSize = yMapSize;
		this.bestOf = bestOf; 
		this.subRoundDuration = subRoundDuration; 
		this.numTargets = numTargets; 
		this.team[0] = fstTeam; 
		this.team[1] = scdTeam; 
	}
	
	public int getTeamID(int whichTeam){
		return team[whichTeam].getTeamID();
	}
	
	public Team[] getTeam() {
		return team;
	}

	public void setTeam(Team[] team) {
		this.team = team;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	public void setBestOf(int bestOf) {
		this.bestOf = bestOf;
	}
	public int getID() {
		return ID;
	}
	public int getBestOf() {
		return bestOf;
	}
	public String getGameName() {
		return gameName;
	}
	public int getNumPlayers() {
		return numPlayers;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public void setxMapSize(int xMapSize) {
		this.xMapSize = xMapSize;
	}

	public void setyMapSize(int yMapSize) {
		this.yMapSize = yMapSize;
	}

	public void setSubRoundDuration(int subRoundDuration) {
		this.subRoundDuration = subRoundDuration;
	}

	public void setNumTargets(int numTargets) {
		this.numTargets = numTargets;
	}

	public int getxMapSize() {
		return xMapSize;
	}
	public int getyMapSize() {
		return yMapSize;
	}
	public int getSubRoundDuration() {
		return subRoundDuration;
	}
	public int getNumTargets() {
		return numTargets;
	}
	public int getRunningTime() {
		return runningTime;
	}

	public int getGameScoreBoardID() {
		return gameScoreBoardID;
	}

	public void setGameScoreBoardID(int gameScoreBoardID) {
		this.gameScoreBoardID = gameScoreBoardID;
	}
	
	public void updateDBGameTable(){
		
	}
}
