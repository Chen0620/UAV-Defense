package functions;

import java.sql.*;
import java.io.*;
import java.util.Scanner;
import java.lang.System;

public class dbConnection 
{
	static Connection conn=null;
	public static void main(String[] args)
	{
		System.out.println("in DBManager");
		
		//Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://babbage.cs.missouri.edu:22";  // Connect to this server
		String dbName="cs4970sp13grp2";//database name
		String driver = "com.mysql.jdbc.Driver";
		String userName="cs4970sp13grp2";
		String passwd="4vmYGtTQVw";

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection(url, userName, passwd);
		    System.out.println("Connected to the database " + dbName + " as user " + userName);
		    System.out.println();
		}	
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
		
	}
}
