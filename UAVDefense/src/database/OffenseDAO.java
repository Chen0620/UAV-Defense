package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * Methods:
 * get/update: isActive, isWepCooldown, ammoLeft, shotCount,droneScore,hitCount
 * get: drone information (Name, ID, player name, role, teamName, teamID...)
 * 
 * ?:
 * droneUpTime/ DroneDownTime
 */

public class OffenseDAO 
{
	Connection connection = null; 
	PreparedStatement stmt = null; 
	ResultSet result = null;
	Datasource ds = null; 
	
	public OffenseDAO(Datasource ds)//constructor
	{
		this.ds = ds;	
	}
	
	private Connection getConnection() throws SQLException 
	{
		Connection conn; 
		conn = ds.getConnection(); 
		return conn; 
	}
	
	/*public void updateDroneInfo()//TBD----------------------------------
	{
		try
		{
			String queryString = "UPDATE DroneSubroundStat SET ";
			connection = getConnection();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
			catch(Exception e)
			{
				e.printStackTrace( );
			}
		}		
	}*/
	
	public void changeIsActive (int droneID,int newStatus)//tested
	{
		try
		{
			String queryString = "UPDATE DroneSubroundStat SET IsActive="+newStatus+" WHERE DroneID="+droneID;
			connection=getConnection();
			PreparedStatement ps=connection.prepareStatement(queryString);
			int rs=ps.executeUpdate();
			//rs.close();
			ps.close();
			connection.close();
			return;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
			catch(Exception e)
			{
				e.printStackTrace( );
			}
		}
	}
	
	public boolean getIsActive (int droneID)//tested
	{
		try
		{
			String queryString = "SELECT IsActive FROM DroneSubroundStat WHERE DroneID=" +droneID;
			connection = getConnection(); 
			PreparedStatement ps; 
			ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery(queryString);
			if(rs.next())
			{
				int DroneStatus= rs.getInt("IsActive");
				//System.out.println(DroneStatus);
				if(DroneStatus==0)
					return false;
				else
					return true;
			}
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return false; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
			catch(Exception e)
			{
				e.printStackTrace( );
			}
		}
		return false;
	}
	
	public void changeIsWeaponCooldown (int droneID,int newStatus)//tested
	{
		try
		{
			String query="UPDATE DroneSubroundStat SET IsWeaponCooldown="+newStatus+" WHERE DroneID="+droneID;
			connection=getConnection();
			PreparedStatement ps=connection.prepareStatement(query);
			int rs=ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
			catch(Exception e)
			{
				e.printStackTrace( );
			}
		}
	}
	
	public boolean getIsWeaponCooldown (int droneID)//tested
	{
		try
		{
			String queryString = "SELECT IsWeaponCooldown FROM DroneSubroundStat WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				int WeaponStatus=rs.getInt("IsWeaponCoolDown");
				System.out.println(WeaponStatus);
				if(WeaponStatus==0)
					return false;
				else
					return true;
			}
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return false; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
			}
			catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		//return 0;
		return false;
	}
	
	public void changeAmmoLeft(int droneID,int newValue)//tested
	{
		try
		{
			String query="UPDATE DroneSubroundStat SET AmmoLeft="+newValue+" WHERE DroneID="+droneID;
			connection = getConnection();
			PreparedStatement ps=connection.prepareStatement(query);
			int rs=ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
			catch(Exception e)
			{
				e.printStackTrace( );
			}
		}
	}
	
	public int getAmmoLeft(int droneID)//tested
	{
		try
		{
			String queryString = "SELECT AmmoLeft FROM DroneSubroundStat WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("AmmoLeft");
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return -1; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return -1;
	}
	
	public void changeShotCount(int droneID,int newValue)
	{
		try
		{
			String query="UPDATE DroneSubroundStat SET ShotCount="+newValue+" WHERE DroneID="+droneID;
			connection = getConnection();
			PreparedStatement ps=connection.prepareStatement(query);
			int rs=ps.executeUpdate();
			return;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
			catch(Exception e)
			{
				e.printStackTrace( );
			}
		}
	}
	
	public int getShotCount(int droneID)
	{
		try
		{
			String queryString = "SELECT ShotCount FROM DroneSubroundStat WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt("ShotCount"));
				return rs.getInt("ShotCount");
			}
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return -1; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return -1;
	}
	
	public void changeHitCount(int droneID,int newValue)
	{
		try
		{
			String queryString = "UPDATE DroneSubroundStat SET HitCount="+newValue+" WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			int rs=ps.executeUpdate();
			return;
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return;
	}
	
	public int getHitCount(int droneID)
	{
		try
		{
			String queryString = "SELECT HitCount FROM DroneSubroundStat WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("HitCount");
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return -1; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return -1;
	}
	
	public void changeTargetHitCount(int droneID,int newValue)
	{
		try
		{
			String queryString = "UPDATE DroneSubroundStat SET TargetHitCount="+newValue+" WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			int rs=ps.executeUpdate();
			return;
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return;
	}
	
	public int getTargetHitCount(int droneID)
	{
		try
		{
			String queryString = "SELECT TargetHitCount FROM DroneSubroundStat WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("TargetHitCount");
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return -1; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return -1;
	}
	
	
	public void changeDroneScore(int droneID,int newValue)
	{
		try
		{
			String queryString = "UPDATE DroneSubroundStat SET DroneScore="+newValue+" WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			int rs=ps.executeUpdate();
			return;
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return;
	}
	
	public int getDroneScore(int droneID)
	{
		try
		{
			String queryString = "SELECT DroneScore FROM DroneSubroundStat WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("DroneScore");
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return -1; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return -1;
	}

	public int getXCoord(int droneID)//return 0 on exception/error
	{
		try
		{
			String queryString = "SELECT xCoord FROM DroneSubroundStat WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("xCoord");
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return 0; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return 0;
	}
	
	public void writeDroneDowntime (int droneID,int addSeconds)
	{
		try
		{
			//get old value of drone downtime from database
			String qs="SELECT DroneDowntime FROM DroneSubroundStat WHERE DroneID="+droneID;
			connection = getConnection();
			PreparedStatement ps=connection.prepareStatement(qs);
			ResultSet rs=ps.executeQuery();
			int oldValue=rs.getInt("DroneDowntime");
			
			int newValue=addSeconds+oldValue;
			String queryString = "UPDATE DroneSubroundStat SET DroneDowntime="+newValue+" WHERE DroneID="+droneID;
			connection = getConnection(); 
			ps=connection.prepareStatement(queryString);
			int rs2=ps.executeUpdate();
			return;
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return;
	}
	
	public int getDroneDowntime(int droneID)
	{
		try
		{
			String queryString = "SELECT DroneDowntime FROM  WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("DroneDowntime");
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return -1; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return -1;
	}
	
	public void writeDroneUptime(int droneID,int upSeconds)
	{
		try
		{
			//get DroneDowntime from database
			//DroneUptime=Game.SubroundDuration-DroneDowntime after each subround is over
			String qs="SELECT DroneDowntime FROM DroneSubroundStat WHERE DroneID="+droneID;
			connection = getConnection();
			PreparedStatement ps=connection.prepareStatement(qs);
			ResultSet rs=ps.executeQuery();
			int totalDowntime=rs.getInt("DroneUptime");
			
			//get subroundDuration from Game table
			qs="SELECT SubroundDuration FROM Game INNER JOIN DroneSubroundStat ON Game.GameID=DroneSubroundStat.DroneGameID WHERE DroneSubroundStat.DroneID="+droneID;
			connection = getConnection();
			ps=connection.prepareStatement(qs);
			rs=ps.executeQuery();
			int subroundDuration=rs.getInt("DroneDowntime");
			
			int totalUptime=subroundDuration-totalDowntime;
			
			String queryString = "UPDATE DroneSubroundStat SET DroneUptime="+totalUptime+" WHERE DroneID="+droneID;
			connection = getConnection(); 
			ps=connection.prepareStatement(queryString);
			int rs2=ps.executeUpdate();
			return;
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return;
	}
	
	public int getDroneUptime(int droneID)
	{
		try
		{
			String queryString = "SELECT DroneUptime FROM  WHERE DroneID="+droneID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("DroneUptime");
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return -1; 
			}
		}
		catch(Exception eee)
		{
			eee.printStackTrace();
		}finally{
			try{
				if(stmt != null)
					stmt.close(); 
				if(connection != null)
					connection.close();
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return -1;
	}

}





