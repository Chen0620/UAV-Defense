package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class subroundDAO
{
	Connection connection = null; 
	PreparedStatement stmt = null; 
	ResultSet result = null;
	Datasource ds = null; 
	
	public subroundDAO(Datasource ds)//constructor
	{
		this.ds=ds;
	}
	
	private Connection getConnection() throws SQLException
	{
		Connection conn;
		conn = ds.getConnection();
		return conn;
	}
	
	public void calTargetHit(int subroundID)
	{
		try
		{
			//get all the TargetHitCount from each drone in DroneSubroundStat table
			String qs="SELECT TargetHitCount FROM DroneSubroundStat INNER JOIN SubRound ON SubRound.SubRoundID=DroneSubroundStat.DroneSubroundID WHERE SubRound.SubRoundID="+subroundID;
			connection = getConnection();
			PreparedStatement ps=connection.prepareStatement(qs);
			ResultSet rs=ps.executeQuery();
			int totalTargetHit=0;
			do
			{
				totalTargetHit=totalTargetHit+rs.getInt("TargetHitCount");
			}while(rs.next());
			this.changeTargetsHit(subroundID,totalTargetHit);			
		}
		catch (Exception e)
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
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return;
	}
	
	public void calSubRoundWinner(int subroundID)
	{
		try
		{
			String qs="SELECT DefenseScore,OffenseScore FROM SubRound WHERE SubroundID="+subroundID;
			connection = getConnection();
			PreparedStatement ps=connection.prepareStatement(qs);
			ResultSet rs=ps.executeQuery(qs);
			int defenseScore=rs.getInt("DefenseScore");
			int offenseScore=rs.getInt("OffenseScore");
			
			if(defenseScore>offenseScore)
			{
				this.changeSubroundWinner(subroundID, "Defense");
			}
			else if(defenseScore<offenseScore)
			{
				this.changeSubroundWinner(subroundID, "Offense");
			}
			else if (defenseScore==offenseScore)
			{
				this.changeSubroundWinner(subroundID, "Tie");
			}
		}
		catch(SQLException e)
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
				
			}catch (SQLException e){
				e.printStackTrace(); 
			}catch(Exception e){
				e.printStackTrace( );
			}
		}
		return;
	}
	
	public int getTargetsHit(int subroundID)
	{
		try
		{
			String queryString = "SELECT TargetHit FROM SubRound WHERE SubRoundID="+subroundID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("TargetHit");
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
	
	public void changeTargetsHit(int subroundID,int newValue)
	{
		try
		{
			String queryString = "UPDATE SubRound SET TargetHit="+newValue+" WHERE SubRoundID="+subroundID;
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
	
	public String getSubroundWinner(int subroundID)
	{
		try
		{
			String queryString = "SELECT SubRoundWinner FROM SubRound WHERE SubRoundID="+subroundID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getString("SubRoundWinner");
			else
			{
				System.out.println("Failed");
				rs.close(); 
				ps.close();
				connection.close();
				return "Null"; 
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
		return "Null";
	}
	
	public void changeSubroundWinner (int subroundID, String winner)
	{
		try
		{
			String queryString = "UPDATE SubRound SET SubRoundWinner="+winner+" WHERE SubRoundID="+subroundID;
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
	
	public int getDefenseScore (int subroundID)
	{
		try
		{
			String queryString = "SELECT DefenseSocre FROM SubRound WHERE SubRoundID="+subroundID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("DefenseScore");
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
	
	public void changeDefenseScore(int subroundID,int newScore)
	{
		try
		{
			String queryString = "UPDATE SubRound SET DefenseScore="+newScore+" WHERE SubRoundID="+subroundID;
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
	
	public int getOffenseScore (int subroundID)
	{
		try
		{
			String queryString = "SELECT OffenseSocre FROM SubRound WHERE SubRoundID="+subroundID;
			connection = getConnection(); 
			PreparedStatement ps=connection.prepareStatement(queryString);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt("OffenseScore");
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
	
	public void changeOffenseScore(int subroundID,int newScore)
	{
		try
		{
			String queryString = "UPDATE SubRound SET OffenseScore="+newScore+" WHERE SubRoundID="+subroundID;
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
}
