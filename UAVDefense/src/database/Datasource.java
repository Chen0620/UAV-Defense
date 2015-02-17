package database;
import com.mchange.v2.c3p0.*;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Statement;
import java.sql.ResultSet; 
public class Datasource {
    private ComboPooledDataSource cpds;
    private static Datasource datasource;
    
    private Datasource() throws IOException, SQLException {
 
        cpds = new ComboPooledDataSource();
    	
    	try {
    		cpds.setDriverClass("com.mysql.jdbc.Driver");
    	} catch (PropertyVetoException e) {
    		e.printStackTrace();
    	}
    	
    	cpds.setJdbcUrl("jdbc:mysql://54.200.170.30/uavTest");
    	cpds.setUser("cs4970sp13grp2");
    	cpds.setPassword("4vmYGtTQVw");
    	cpds.setMinPoolSize(5);
    	cpds.setAcquireIncrement(5);
    	cpds.setMaxPoolSize(10);
    	cpds.setMaxStatementsPerConnection(180);
    	

        Connection testConnection = null;
        Statement testStatement = null;
        ResultSet rs = null; 
        // test connectivity and initialize pool
        try {
               testConnection = cpds.getConnection();
               testStatement = testConnection.createStatement();
               rs = testStatement.executeQuery("SELECT * From TeamScoreboard");
               while (rs.next()) {
   				 String id = rs.getString("TeamScoreboardID");
   				 System.out.println("ID: " + id);
   			}
            } catch (SQLException e) {
                throw e;
            } finally {
                testStatement.close();
                testConnection.close();
        }

    }

    public static Datasource getInstance() throws IOException, SQLException {
        if (datasource == null) {
              datasource = new Datasource();
              return datasource;
            } else {
              return datasource;
            }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }
}
