package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import functions.NewGameModel;
import gui.NewGameFrame;


public class NewGameControl implements ActionListener {

	NewGameModel model; 
	NewGameFrame view; 
	
	public NewGameControl(NewGameModel model, NewGameFrame view){
		this.model = model; 
		this.view = view;
		//add action listener from control to view. 
		view.buttonActionListeners(this); 
	}
	
	//action performed by view
	public void actionPerformed(ActionEvent ae){
		String action = ae.getActionCommand(); 
		if(action.equals("create")){
			int[] gameInfo = new int[2];  //gameInfo[1] = game ID gameInfo[2] = num of Players in game. A little bit hacky, but we are short on time. 
			gameInfo = model.createGame(view.getGameName(), view.getNumPlayers(),view.getBestOf(), view.getXMapSize(), view.getYMapSize(),view.getGameDuration(), view.getNumTargets());
			model.createTeams(view.getFstTeamName(),gameInfo[0], gameInfo[1]); 
			model.createTeams(view.getScdTeamName(),gameInfo[0], gameInfo[1]);
		}
	
	}
}
