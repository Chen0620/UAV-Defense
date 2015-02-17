package functions;



import java.sql.*;


public class ScoreBoardModel 
{
	private static final int START_TIME=180;
	public final int hit = 1;
	
	private int currentTime;
	private int timeRemaining;
	private int playerNum;
	private String winner;
	private int max;
	private int teamNum;
	
	public teaminfo[] allteams;
	
	
	public ScoreBoardModel()
	{
		currentTime = 0;
		playerNum = 2;
		winner = "Team";
		allteams = new teaminfo[playerNum];
		
		start();
	}
	
	public void start()
	{
		for(int i=0;i<playerNum;i++)
		{
			allteams[i].startgame();	
		}
	}	
	
	public void end()
	{
		timeRemaining = START_TIME - currentTime;
		max = allteams[0].score;
		teamNum =0;
		for(int i=1;i<playerNum;i++)
		{
			if(max < allteams[i].score)
			{
				max = allteams[i].score;
				teamNum = i;
			}
		}
		winner += Integer.toString(teamNum);
		//open database
		insertCourse("AwesomeGame","Red",allteams[0].score,allteams[1].score,timeRemaining);
		//close
	}	
	
	public void updateBoard(int team)
	{
		allteams[team].score +=1;
	}
	
	//check this is round over 
	private boolean checkRoundOver()
	{
		
		if(currentTime < 180)
			return false;
		else
		{
			max = allteams[0].score;
			teamNum =0;
			for(int i=1;i<playerNum;i++)
			{
				if(max < allteams[i].score)
				{
					max = allteams[i].score;
					teamNum = i;
				}
			}
			winner += Integer.toString(teamNum);
			
			//open database
			insertCourse("AwesomeGame","Red",allteams[0].score,allteams[1].score,0.0);
			//close
			return true;
		}
		
	}
	
	
	public void insertCourse(String GameName,String TeamName,int TeamAFinalScore,int TeamBFinalScore, double TimeRemaining)
	{
		Connection conn=null;
		
		String url = "jdbc:mysql://babbage.cs.missouri.edu:22";  // Connect to this server
		String dbName="cs4970sp13grp2";//database name
		String driver = "com.mysql.jdbc.Driver";
		String userName="cs4970sp13grp2";
		String passwd="4vmYGtTQVw";

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection(url, userName, passwd);
		    Statement statement = conn.createStatement();
		    statement.executeUpdate("INSERT INTO Customers VALUES (" + GameName+ ", " + TeamName +", "+ Integer.toString(TeamAFinalScore) +", "+ Integer.toString(TeamBFinalScore) + ", " + Double.toString(TimeRemaining)+ ")"); 
		}	
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
        
	}
	
	class teaminfo
	{
		public int score;
		public boolean isstart;
		
		public void startgame()
		{
			isstart = true;
			score = 0;
		}
		
		//public String name; 	
		/*public start(String teamname)
		{
			isstart = true;
			score = 0;
			name = teamname;
		}*/
	}
	
}

