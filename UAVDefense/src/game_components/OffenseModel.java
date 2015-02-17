package game_components;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import database.DefenseDAO;
import database.OffenseDAO;
import functions.Drone;
import functions.Target;

public class OffenseModel extends Drone
{
	private static final int DEACTIVATE_COOLDOWN=10;
	private static final int WEAPON_COOLDOWN=8;
	private static final float HALFWAYLINE=0;//static? final?
	private int targetHitCount;
	private int ammoLeft=20;
	private int droneID;
	
	//DAO
	OffenseDAO offenseDao;
	
	public OffenseModel(int id, String name, int playerid, OffenseDAO oDAO)//constructor 
	{
		super(id,name,playerid);
		this.droneID=id;
		this.offenseDao=oDAO;
	}

	
	@Override
	public void deactivate()
	{
		super.isActive=false;
		offenseDao.changeIsActive(droneID, 0);
		offenseDao.writeDroneDowntime(droneID,DEACTIVATE_COOLDOWN);
		try 
		{
			TimeUnit.SECONDS.sleep(DEACTIVATE_COOLDOWN);//deactivated for 30 seconds
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		super.isActive=true;
		offenseDao.changeIsActive(droneID, 1);
	}
	
	@Override
	public void getShot()
	{
		super.shotCount++;
		offenseDao.changeShotCount(droneID, shotCount);
		long beforeMid=new Date().getTime();
		coordCheck();//wait until drone fly back to offense side
		long afterMid=new Date().getTime();
		int difference=(int)(afterMid-beforeMid)/1000;
		offenseDao.writeDroneDowntime(droneID, difference);
		deactivate();
	}
	
	public void hitTarget(Target targetA)
	{
		targetHitCount++;
		offenseDao.changeTargetHitCount(droneID,targetHitCount);
		super.hitCount++;
		offenseDao.changeHitCount(droneID, hitCount);
		ammoLeft--;
		offenseDao.changeAmmoLeft(droneID, ammoLeft);
		super.droneScore=super.droneScore+2;
		offenseDao.changeDroneScore(droneID, droneScore);
		/*update score in team table*/
		startWepCooldown();
	}
	
	public void coordCheck()
	{
		/*
		 * get xCoord, yCoord, zCoord from database, refresh every second
		 * assume offense side is on the right side of the middle line
		 */
		while(offenseDao.getXCoord(droneID)<=HALFWAYLINE)
		{
			
		}
	}
	
	@Override
	public void startWepCooldown()
	{
		isWepCooldown=true;
		offenseDao.changeIsWeaponCooldown(droneID,1);
		try 
		{
			TimeUnit.SECONDS.sleep(WEAPON_COOLDOWN);//deactivated for 5 seconds
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		isWepCooldown=false;
		offenseDao.changeIsWeaponCooldown(droneID,0);
	}
	
	@Override
	public void shoot(Drone droneA, Drone droneB)
	{
		if(droneA.getDroneName().equals(super.droneName))
		{
			ammoLeft--;
			offenseDao.changeAmmoLeft(droneID,ammoLeft);
			//super.droneScore++;
			/*update score in team table*/
			super.hitCount++;
			offenseDao.changeHitCount(droneID, hitCount);
			startWepCooldown();
		}
		else if(droneB.getDroneName().equals(super.droneName))
		{
			getShot();
		}
	}
}
