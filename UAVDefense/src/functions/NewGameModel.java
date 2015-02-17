package functions;

import database.NewGameDAO;
public class NewGameModel {
	private NewGameDAO newGameDao; 
	public NewGameModel(NewGameDAO newGameDao) {
		this.newGameDao = newGameDao; 
	}
	public int[] createGame(String gameName, int numPlayers, int bestOf, int xMapSize,
			int yMapSize, int gameDuration, int numTargets) {
		System.out.println("Make call to DAO to do the creation");	
		return newGameDao.createGame(gameName, numPlayers, bestOf, xMapSize, yMapSize, gameDuration, numTargets); 
	}
	public void createTeams(String teamName, int gameID, int numPlayers) {
		newGameDao.createTeams(teamName, gameID, numPlayers);
	}

}
