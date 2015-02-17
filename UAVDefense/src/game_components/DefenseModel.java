package game_components;

import java.util.concurrent.TimeUnit;
import database.DefenseDAO;
import functions.Drone;

public class DefenseModel extends Drone
{
	private static final int DEACTIVATE_COOLDOWN=5;
	private static final int WEAPON_COOLDOWN=5;
	private int ammoLeft=25;
	private int droneID;
	
	//DAO
	DefenseDAO defenseDao;
	
	public DefenseModel(int id, String name, int playerid,DefenseDAO dfDAO)//constructor 
	{
		super(id,name,playerid);
		droneID=id;
		this.defenseDao=dfDAO;
	}

	@Override
	public void deactivate()
	{
		super.isActive=false;
		defenseDao.changeIsActive(droneID,0);
		defenseDao.writeDroneDowntime(droneID, DEACTIVATE_COOLDOWN);//add one cooldown time to drone downtime
		//DefenseControl.
		try 
		{
			TimeUnit.SECONDS.sleep(DEACTIVATE_COOLDOWN);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		super.isActive=true;
		defenseDao.changeIsActive(droneID,1);
	}
	
	@Override
	public void getShot()
	{
		super.shotCount++;
		defenseDao.changeShotCount(droneID,shotCount);
		deactivate();
		//update view to tell drone deactivate it------------------------------------------? 
	}
		
	@Override
	public void startWepCooldown()
	{
		isWepCooldown=true;
		defenseDao.changeIsWeaponCooldown(droneID,1);
		//update view to tell drone deactivate it------------------------------------------? 
		try 
		{
			TimeUnit.SECONDS.sleep(WEAPON_COOLDOWN);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		isWepCooldown=false;
		defenseDao.changeIsWeaponCooldown(droneID,0);
	}
	
	@Override
	public void shoot(Drone droneA, Drone droneB)
	{
			if(droneA.getDroneName().equals(super.droneName))
			{
				ammoLeft--;
				defenseDao.changeAmmoLeft(droneID,ammoLeft);
				//super.droneScore++;//update score in team table------------------------?
				super.hitCount++;
				defenseDao.changeHitCount(droneID,hitCount);
				startWepCooldown();
			}
			else if(droneB.getDroneName().equals(super.droneName))
			{
				getShot();
			}
	}
}
