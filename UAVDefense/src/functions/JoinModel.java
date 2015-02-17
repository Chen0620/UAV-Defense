package functions;

import game_components.Game;
import game_components.MultithreadClient;
import game_components.Player;
import game_components.Team;
import authentification.User;
import database.Datasource;
import database.JoinDAO;


public class JoinModel {

		JoinDAO joinDao; 
		Datasource ds; 
		Game game; 
		Team[] team; 
		Player[] teamOnePlayers;
		Player[] teamTwoPlayers; 
		private User user; //the user that is logged in 
		
		
		public JoinModel(JoinDAO joinDao, Datasource ds, User user, int gameID){
			this.joinDao = joinDao;
			this.ds = ds;
			this.user = user;
			this.game = getGameInfo(gameID); 
			this.game.setTeam(getTeams()); 
		}
		private Game getGameInfo(int gameID) {
			Game getGame = joinDao.getGameInfo(gameID);
			return getGame; 
		}
		//implement Join Functions. 
		//Retrieve Teams 1 and Teams 2
		public Team[] getTeams(){ 
			this.team = joinDao.getTeams(this.game);
			//get all players per team
			teamOnePlayers = joinDao.getPlayers(team[0]);
			teamTwoPlayers = joinDao.getPlayers(team[1]);
			team[0].setUserArr(teamOnePlayers);
			team[1].setUserArr(teamTwoPlayers);
			return team; 
		}
		public void joinTeam(int whichTeam) { 
			joinDao.joinTeam(whichTeam, user.getID(), game.getID(), game.getTeamID(whichTeam)); 
		}
		public void lockIn() {
			// TODO Auto-generated method stub
			joinDao.lockIn(user.getID()); 
		}
}
