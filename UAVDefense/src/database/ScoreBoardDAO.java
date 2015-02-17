package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import authentification.User;

public class ScoreBoardDAO {
	Connection connection = null; 
	PreparedStatement stmt = null; 
	ResultSet result = null; 
	
	Datasource ds = null; 
	public ScoreBoardDAO(Datasource ds) {
		this.ds = ds; 
	}
	private Connection getConnection() throws SQLException {
		Connection conn; 
		conn = ds.getConnection(); 
		return conn; 
	}
	public void getScoreBoard(){
		  PreparedStatement psGetScoreBoard = null;
          ResultSet rsGetScoreBoard = null;
          try{
        	  //this is where you need to do your coding
        	  //insert the query to get the scoreboard where User
        	  String queryString = "[INSERT QUERY HERE]";
              connection = getConnection(); 
              psGetScoreBoard = connection.prepareStatement(queryString);
          }catch(Exception eee)
          {
              eee.printStackTrace();
          }finally{
              try{
                      if(stmt != null)
                              stmt.close(); 
                      if(connection != null)
                              connection.close();
                      if(psGetScoreBoard != null)
                              psGetScoreBoard.close(); 
                      if(rsGetScoreBoard != null)
                              rsGetScoreBoard.close(); 
                      
              }catch (SQLException e){
                      e.printStackTrace(); 
              }catch(Exception e){
                      e.printStackTrace( );
              }
         }
	}

}
