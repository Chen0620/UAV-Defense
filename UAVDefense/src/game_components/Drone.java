package game_components;
import java.util.concurrent.TimeUnit;

/*
 * Rules:
 * weapon cool down: offense: 8s 20 shots
 * 					defense: 5s 25 shots
 * deactivate: offense: fly back+10s
 * 			   defense: 5s
 * score: offense: hit drone +1; hit target +2; get shot -+0;
 * 		  defense: hit drone +1; get shot -+0;
 */


public class Drone 
{
	private int droneID;
	protected String droneName;
	private int teamID,playerID;
	protected int shotCount,hitCount;
	protected int droneScore;
	protected double xCoord,yCoord,zCoord;
	
	//default values
	protected boolean isActive=true;
	protected boolean isWepCooldown=false;
	
	
	Drone(int id, String droneName, int playerid)//constructor
	{
		this.droneID=id;
		this.droneName=droneName;
		this.playerID=playerid;
	}
		
	public int getDroneID() {
		return droneID;
	}

	public void setDroneID(int droneID) {
		this.droneID = droneID;
	}

	public String getDroneName() {
		return droneName;
	}

	public void setDroneName(String droneName) {
		this.droneName = droneName;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public int getPlayerID() {
		return playerID;
	}
	
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getShotCount() {
		return shotCount;
	}

	public void setShotCount(int shotCount) {
		this.shotCount = shotCount;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getDroneScore() {
		return droneScore;
	}

	public void setDroneScore(int droneScore) {
		this.droneScore = droneScore;
	}

	public double getxCoord() {
		return xCoord;
	}

	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	public double getzCoord() {
		return zCoord;
	}

	public void setzCoord(double zCoord) {
		this.zCoord = zCoord;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isWepCooldown() {
		return isWepCooldown;
	}

	public void setWepCooldown(boolean isWepCooldown) {
		this.isWepCooldown = isWepCooldown;
	}


	//Classes below will be overridden in subclasses
	public void shoot(Drone droneA,Drone droneB,char[] isMiss)
	{
			
	}
	
	public void getShot()
	{
			
	}

	protected void startWepCooldown()
	{
		
	}
	
	public void deactivate()
	{
		
	}	
}
