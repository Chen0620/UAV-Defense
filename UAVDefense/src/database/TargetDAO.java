package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Datasource;
import game_components.Target;

public class TargetDAO {
	Connection connection = null; 
	PreparedStatement stmt = null; 
	ResultSet result = null; 
	
	Datasource ds = null; 
	public TargetDAO(Datasource ds) {
		this.ds = ds; 
	}
	private Connection getConnection() throws SQLException {
		Connection conn; 
		conn = ds.getConnection(); 
		return conn; 
	}
	public Target getTarget(){
		  PreparedStatement psGetTarget = null;
          ResultSet rsGetTarget = null;
         
          try{
        	  Connection connection = getConnection();
        	  String queryString = "SELECT * FROM Target VALUES(TargetID, TargetSubRoundID, TargetStatus, HitThreshold, HitCount,TotalHitCount ) where TargetID = ? ";
              psGetTarget = connection.prepareStatement(queryString);
              psGetTarget.setInt(1,1);
              rsGetTarget = psGetTarget.executeQuery();
              rsGetTarget.next();
              Target target = new Target(rsGetTarget.getInt("TargetID"), rsGetTarget.getInt("TargetSubRoundID"), rsGetTarget.getInt("TargetStatus"), rsGetTarget.getInt("HitThreshold"), rsGetTarget.getInt("HitCount"), rsGetTarget.getInt("TotalHitCount"));
              return target; 
          }catch(Exception eee)
          {
              eee.printStackTrace();
          }finally{
              try{
                      if(stmt != null)
                              stmt.close(); 
                      if(connection != null)
                              connection.close();
                      if(psGetTarget != null)
                              psGetTarget.close(); 
                      if(rsGetTarget != null)
                              rsGetTarget.close(); 
                      
              }catch (SQLException e){
                      e.printStackTrace(); 
              }catch(Exception e){
                      e.printStackTrace( );
              }
      }
      return null;
}

}
