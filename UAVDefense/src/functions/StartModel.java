package functions;


import controller.JoinControl;
import controller.NewGameControl;
import game_components.Game;
import gui.JoinFrame;
import gui.NewGameFrame;
import database.Datasource;
import database.GameInfoDAO;
import database.JoinDAO;
import database.NewGameDAO;
import database.StartDAO;
import authentification.User;


public class StartModel {
	StartDAO startDao; 
	Datasource ds; 
	private User user; 
	
	public StartModel(StartDAO startDao, Datasource ds, User user){
		this.startDao = startDao;
		this.ds = ds; 
		this.user = user; 
	}
	
	public void exit() {
		//display "Are you sure?" dialogue
		System.exit(0);
	}
	/*
    btnNewGame.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			NewGameFrame newGame = new NewGameFrame();
			newGame.setVisible(true);
		}
	});
	btnJoinGame.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JoinFrame join = new JoinFrame();
			join.setVisible(true);
		}
	});
	//Exit button in menu closes the entire program.
	mntmExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	*/

	public void createGame() {
		NewGameFrame createGameView = new NewGameFrame(); 
		NewGameDAO newGameDao = new NewGameDAO(this.ds); 
		NewGameModel createGameModel = new NewGameModel(newGameDao); 
		NewGameControl createGameControl = new NewGameControl(createGameModel, createGameView); 
	}

	public void joinGame(int gameID) {
		System.out.println("I am calling from Start Model, your user ID is " + user.getID());
		JoinFrame joinView = new JoinFrame(); 
		JoinDAO joinDao = new JoinDAO(this.ds); 
		JoinModel joinModel = new JoinModel(joinDao, this.ds, this.user, gameID); //needs to pass in that game. 
		JoinControl joinControl = new JoinControl(joinModel, joinView);		
	}

	/*private Game getGame(int ID){
		Game game;
		//this function gets a single game and then passes it to the join model. 
		return game; 
	}*/
	//this function is used to fill out that table in the startFrame. 
	public Game[] getGames() {
		Game[] game = startDao.getGameInfo();
		return game; 
	}

	public Game[] refreshTable() {
		GameInfoDAO gameInfoDao = new GameInfoDAO(this.ds);
		Game[] game;
		game = gameInfoDao.getGameInfo(); 
		return game; 
	}


}
