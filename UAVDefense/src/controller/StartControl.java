package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import functions.StartModel;
import game_components.Game;
import gui.StartFrame;


public class StartControl implements ActionListener {

	StartModel model; 
	StartFrame view; 
	Timer timer;
	public StartControl (StartModel model, StartFrame view){
		this.model = model; 
		this.view = view;
		view.buttonActionListeners(this); 
		long myLong = 10000; //adjust this for main game table refresh rate.
		timer = new Timer();
		timer.schedule(new TimerTask(){ public void run(){doStuff();}}, 0, myLong);
	}
	public void doStuff(){
		Game[] games = model.getGames(); 
		view.updateGameTable(games); 
	}
	//action performed by view
	public void actionPerformed(ActionEvent ae){
		String action = ae.getActionCommand(); 
		if(action.equals("create")){
		    model.createGame(); 
		}
		if(action.equals("join")){
			String getRow = view.tableGameProgress.getValueAt(view.tableGameProgress.getSelectedRow(), 0).toString(); 
			int gameID = Integer.parseInt(getRow); 
			model.joinGame(gameID); 
		}
		if(action.equals("exit")){
	        model.exit(); 
		}
		if(action.equals("refresh")){
			model.refreshTable(); 
		}
	}
	
}
