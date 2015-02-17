package controller;

import functions.JoinModel;
import game_components.MultithreadClient;
import game_components.Team;
import gui.JoinFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;  
public class JoinControl implements ActionListener{

	JoinModel model; 
	JoinFrame view; 
	Timer timer;
	Timer lockinTimer; 
	TimerTask tt;
	int lockinFlag = 0; 
	public JoinControl(JoinModel model, JoinFrame view){
		this.model = model; 
		this.view = view;
		view.buttonActionListeners(this); 
		long myLong = 1700; 
		timer = new Timer();
		timer.schedule(new TimerTask(){ public void run(){doStuff();}}, 0, myLong);
			new Thread(new Runnable(){
			public void run() {
				MultithreadClient comm = new MultithreadClient(); 
			}}).start(); 
	}
	public void doStuff(){
		Team[] teams = model.getTeams(); 
		view.updateTables(teams);
	}
	public void lockIn(){
		System.out.println("You have been locked in");
		model.lockIn(); 
		view.changeLockInButton(2); 
		
		lockinTimer.cancel();
		lockinTimer.purge();
	}
	//action performed by view
	public void actionPerformed(ActionEvent ae){
		String action = ae.getActionCommand(); 
		if(action.equals("leaveGame")){
			timer.cancel(); 
			timer.purge(); 
			view.dispose(); 
		}
		if(action.equals("lockIn")){ 
			lockinTimer = new Timer(); 
			long lockinTime = 15000; 
			if(lockinFlag == 0){
				System.out.println("Your selection will be locked in fifteen seconds");
				view.changeLockInButton(1);
				lockinFlag = 1; 
				tt = new TimerTask(){
					public void run(){
						lockIn(); 
					};
				};
				timer.schedule(tt,lockinTime);
			}
			else {
				System.out.println("Cancelling lock-in");
				tt.cancel(); 
				lockinTimer.cancel();
				lockinTimer.purge(); 
		
				
				lockinFlag =0; 
				view.changeLockInButton(0);	
			}

		}
		if(action.equals("joinTeamOne")){ 
			model.joinTeam(0);
		}
		if(action.equals("joinTeamTwo")){ 
			model.joinTeam(1);
		}
	}
	
}

