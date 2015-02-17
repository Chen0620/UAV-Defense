package functions;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import database.Datasource;
import database.subroundDAO;

/*
 * subround info? scoreboard?
 */


public class subroundModel
{
	private int droneID,subroundID;
	subroundDAO subDAO;
	
	public subroundModel(int subID,int dID)//constructor
	{
		this.droneID=dID;
		this.subroundID=subID;
	}
	
	public void subroundInfo()
	{
		int targetsHit=subDAO.getTargetsHit(subroundID);
		//String subroundWinner=subDAO.getSubroundWinner(subroundID);
		int offenseScore=subDAO.getOffenseScore(subroundID);
		int denfeseScore=subDAO.getDefenseScore(subroundID);
	}
	
	//update info in background
	public void endSubround()
	{
		subDAO.getSubroundWinner(subroundID);
		subroundInfo();
	}
}
