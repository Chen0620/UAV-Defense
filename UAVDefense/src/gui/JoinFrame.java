package gui;

import game_components.Player;
import game_components.Team;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JoinFrame {

	private JPanel contentPane;
	private JTable teamTwoTable;
	private JTable teamOneTable;
	private JButton btnLeaveGame;
	private JButton btnLockInSelection; 
	private JComboBox cmbSelectDrone;
	private JButton btnTeamOne;
	private JButton btnTeamTwo; 
	private JFrame frame;
	public JoinFrame() { 
		createAndShowGui(); 
	}
	public void createAndShowGui(){
		frame = new JFrame(); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 551, 430);
		frame.setContentPane(createContentPane());
		frame.setVisible(true); 
		
	}
	
	public JPanel createContentPane() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{29, 192, 51, 50, 189, 21, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		teamOneTable = new JTable();
		teamOneTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Player", "Drone", "Status"
			}
		));
		teamOneTable.setFillsViewportHeight(true);
		teamOneTable.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(teamOneTable);
		
		btnTeamOne = new JButton("Join Team");
		btnTeamOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 6;
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 1;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		teamTwoTable = new JTable();
		teamTwoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Player", "Drone", "Status"
			}
		));
		teamTwoTable.setBackground(Color.LIGHT_GRAY);
		teamTwoTable.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(teamTwoTable);
		GridBagConstraints gbc_btnTeamOne = new GridBagConstraints();
		gbc_btnTeamOne.anchor = GridBagConstraints.WEST;
		gbc_btnTeamOne.insets = new Insets(0, 0, 5, 5);
		gbc_btnTeamOne.gridx = 1;
		gbc_btnTeamOne.gridy = 7;
		contentPane.add(btnTeamOne, gbc_btnTeamOne);
		
		btnTeamTwo = new JButton("Join Team");
		GridBagConstraints gbc_btnTeamTwo = new GridBagConstraints();
		gbc_btnTeamTwo.anchor = GridBagConstraints.EAST;
		gbc_btnTeamTwo.insets = new Insets(0, 0, 5, 5);
		gbc_btnTeamTwo.gridx = 4;
		gbc_btnTeamTwo.gridy = 7;
		contentPane.add(btnTeamTwo, gbc_btnTeamTwo);
		
		JLabel lblSelectDrone = new JLabel(" Select Drone ");
		lblSelectDrone.setForeground(Color.LIGHT_GRAY);
		lblSelectDrone.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblSelectDrone = new GridBagConstraints();
		gbc_lblSelectDrone.anchor = GridBagConstraints.WEST;
		gbc_lblSelectDrone.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectDrone.gridx = 1;
		gbc_lblSelectDrone.gridy = 8;
		contentPane.add(lblSelectDrone, gbc_lblSelectDrone);
		
		JPanel panelChatbox = new JPanel();
		panelChatbox.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panelChatbox = new GridBagConstraints();
		gbc_panelChatbox.gridwidth = 3;
		gbc_panelChatbox.gridheight = 4;
		gbc_panelChatbox.insets = new Insets(0, 0, 5, 5);
		gbc_panelChatbox.fill = GridBagConstraints.BOTH;
		gbc_panelChatbox.gridx = 2;
		gbc_panelChatbox.gridy = 8;
		contentPane.add(panelChatbox, gbc_panelChatbox);
		
		cmbSelectDrone = new JComboBox();
		GridBagConstraints gbc_cmbSelectDrone = new GridBagConstraints();
		gbc_cmbSelectDrone.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSelectDrone.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSelectDrone.gridx = 1;
		gbc_cmbSelectDrone.gridy = 9;
		contentPane.add(cmbSelectDrone, gbc_cmbSelectDrone);
		
		btnLockInSelection = new JButton("Lock In Selection");
		GridBagConstraints gbc_btnLockInSelection = new GridBagConstraints();
		gbc_btnLockInSelection.anchor = GridBagConstraints.WEST;
		gbc_btnLockInSelection.insets = new Insets(0, 0, 5, 5);
		gbc_btnLockInSelection.gridx = 1;
		gbc_btnLockInSelection.gridy = 10;
		contentPane.add(btnLockInSelection, gbc_btnLockInSelection);
		
		btnLeaveGame = new JButton("Leave Game");
		GridBagConstraints gbc_btnLeaveGame = new GridBagConstraints();
		gbc_btnLeaveGame.anchor = GridBagConstraints.WEST;
		gbc_btnLeaveGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnLeaveGame.gridx = 1;
		gbc_btnLeaveGame.gridy = 11;
		contentPane.add(btnLeaveGame, gbc_btnLeaveGame);
		return contentPane; 
	}
	public void buttonActionListeners(ActionListener al) {
		btnLockInSelection.setActionCommand("lockIn");
		btnLockInSelection.addActionListener(al); 
		btnLeaveGame.setActionCommand("leaveGame");
		btnLeaveGame.addActionListener(al); 
		btnTeamOne.setActionCommand("joinTeamOne");
		btnTeamOne.addActionListener(al); 
		btnTeamTwo.setActionCommand("joinTeamTwo");
		btnTeamTwo.addActionListener(al); 
	}
	public void dispose() {
		frame.dispose();
	}

	public void updateTables(Team[] teams) {
		DefaultTableModel teamOneModel = (DefaultTableModel) teamOneTable.getModel();
		//DO FOR LOOP TO ADD EVERY PLAYER TO THE TABLE
		Player[] players;
		players = teams[0].getPlayerArr(); 
		teamOneModel.setRowCount(0);
		for(int index = 0; index < teams[0].getNumPlayers(); index++){
			if(players[index] != null){
				teamOneModel.addRow(new Object[]{players[index].getPlayerName(),"NotFin", players[index].getPlayerStatus()});
			}else{
				break; 
			}
		}
		DefaultTableModel teamTwoModel = (DefaultTableModel) teamTwoTable.getModel();
		//DO FOR LOOP TO ADD EVERY PLAYER TO THE TABLE
		players = teams[1].getPlayerArr(); 
		teamTwoModel.setRowCount(0);
		for(int index = 0; index < teams[0].getNumPlayers(); index++){
			if(players[index] != null){
				teamTwoModel.addRow(new Object[]{players[index].getPlayerName(),"NotFin", players[index].getPlayerStatus()});
			}else{
				break; 
			}
		}
		
		
	}
	public void changeLockInButton(int status) {
		if(status == 1){ //if locking in
		btnLockInSelection.setText("Cancel Lock-in");
		}
		if(status == 0){//if canceling lockin
		btnLockInSelection.setText("Lock-in");
		}
		if(status == 2){
		btnLockInSelection.setText("Locked In"); 
		btnLockInSelection.setEnabled(false);
		}
	}
	
}
