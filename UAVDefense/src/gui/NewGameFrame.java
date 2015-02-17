package gui;



import java.awt.*; 
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NewGameFrame {

	private JPanel contentPane;
	private JTextField txtGameName;
	private JTextField txtTeamName;
	private JTextField txtTeamName2;
	private JButton btnCreateGame; 
	private JSpinner spinnerNumPlayer;
	private JComboBox cmbYMapSize;
	private JComboBox cmbXMapSize;
	private JSpinner spinnerMinutes;
	private JSpinner spinnerSeconds; 
	private JSpinner spinnerNumTargets;
	private JSpinner spinnerBestOf;
	JFrame frame; 


	/**
	 * Create the frame.
	 */
	public NewGameFrame() {
		        createAndShowGUI();
	}
	private void createAndShowGUI(){
		frame = new JFrame(); 
		frame.setTitle("Create Game");
		frame.setContentPane(createContentPane());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 547, 285);
		frame.setVisible(true); 
	}
	private JPanel createContentPane(){
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 73, 22, 50, 36, 44, 62, 95, 34, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewGame = new JLabel("New Game");
		lblNewGame.setForeground(Color.LIGHT_GRAY);
		lblNewGame.setFont(new Font("Helvetica", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewGame = new GridBagConstraints();
		gbc_lblNewGame.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewGame.gridx = 1;
		gbc_lblNewGame.gridy = 1;
		contentPane.add(lblNewGame, gbc_lblNewGame);
		
		JLabel lblGameName = new JLabel("Game Name:");
		lblGameName.setForeground(Color.LIGHT_GRAY);
		lblGameName.setFont(new Font("Helvetica", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGameName = new GridBagConstraints();
		gbc_lblGameName.gridwidth = 2;
		gbc_lblGameName.insets = new Insets(0, 0, 5, 5);
		gbc_lblGameName.anchor = GridBagConstraints.EAST;
		gbc_lblGameName.gridx = 1;
		gbc_lblGameName.gridy = 2;
		contentPane.add(lblGameName, gbc_lblGameName);
		
		txtGameName = new JTextField();
		GridBagConstraints gbc_txtGameName = new GridBagConstraints();
		gbc_txtGameName.gridwidth = 5;
		gbc_txtGameName.insets = new Insets(0, 0, 5, 5);
		gbc_txtGameName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGameName.gridx = 3;
		gbc_txtGameName.gridy = 2;
		contentPane.add(txtGameName, gbc_txtGameName);
		txtGameName.setColumns(10);
		
		JLabel lblTeamName = new JLabel("Team 1 Name:");
		lblTeamName.setForeground(Color.LIGHT_GRAY);
		lblTeamName.setFont(new Font("Helvetica", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTeamName = new GridBagConstraints();
		gbc_lblTeamName.anchor = GridBagConstraints.EAST;
		gbc_lblTeamName.gridwidth = 2;
		gbc_lblTeamName.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeamName.gridx = 1;
		gbc_lblTeamName.gridy = 3;
		contentPane.add(lblTeamName, gbc_lblTeamName);
		
		txtTeamName = new JTextField();
		GridBagConstraints gbc_txtTeamName = new GridBagConstraints();
		gbc_txtTeamName.gridwidth = 5;
		gbc_txtTeamName.insets = new Insets(0, 0, 5, 5);
		gbc_txtTeamName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTeamName.gridx = 3;
		gbc_txtTeamName.gridy = 3;
		contentPane.add(txtTeamName, gbc_txtTeamName);
		txtTeamName.setColumns(10);
		
		JLabel lblTeamName2 = new JLabel("Team 2 Name:");
		lblTeamName2.setForeground(Color.LIGHT_GRAY);
		lblTeamName2.setFont(new Font("Helvetica", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTeamName2 = new GridBagConstraints();
		gbc_lblTeamName2.anchor = GridBagConstraints.EAST;
		gbc_lblTeamName2.gridwidth = 2;
		gbc_lblTeamName2.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeamName2.gridx = 1;
		gbc_lblTeamName2.gridy = 4;
		contentPane.add(lblTeamName2, gbc_lblTeamName2);
		
		txtTeamName2 = new JTextField();
		GridBagConstraints gbc_txtTeamName2 = new GridBagConstraints();
		gbc_txtTeamName2.gridwidth = 5;
		gbc_txtTeamName2.insets = new Insets(0, 0, 5, 5);
		gbc_txtTeamName2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTeamName2.gridx = 3;
		gbc_txtTeamName2.gridy = 4;
		contentPane.add(txtTeamName2, gbc_txtTeamName2);
		txtTeamName2.setColumns(10);
		
		JLabel lblNumberPlayers = new JLabel("Players Per Team:");
		lblNumberPlayers.setForeground(Color.LIGHT_GRAY);
		lblNumberPlayers.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNumberPlayers.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblNumberPlayers = new GridBagConstraints();
		gbc_lblNumberPlayers.gridwidth = 2;
		gbc_lblNumberPlayers.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberPlayers.gridx = 1;
		gbc_lblNumberPlayers.gridy = 5;
		contentPane.add(lblNumberPlayers, gbc_lblNumberPlayers);
		
		spinnerNumPlayer = new JSpinner();
		spinnerNumPlayer.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_numPlayerSpinner = new GridBagConstraints();
		gbc_numPlayerSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_numPlayerSpinner.gridx = 3;
		gbc_numPlayerSpinner.gridy = 5;
		contentPane.add(spinnerNumPlayer, gbc_numPlayerSpinner);
		
		JLabel lblTargets = new JLabel("Targets");
		lblTargets.setForeground(Color.LIGHT_GRAY);
		lblTargets.setFont(new Font("Helvetica", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTargets = new GridBagConstraints();
		gbc_lblTargets.insets = new Insets(0, 0, 5, 5);
		gbc_lblTargets.gridx = 4;
		gbc_lblTargets.gridy = 5;
		contentPane.add(lblTargets, gbc_lblTargets);
		
		spinnerNumTargets = new JSpinner();
		spinnerNumTargets.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_spinnerNumTargets = new GridBagConstraints();
		gbc_spinnerNumTargets.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNumTargets.gridx = 5;
		gbc_spinnerNumTargets.gridy = 5;
		contentPane.add(spinnerNumTargets, gbc_spinnerNumTargets);
		
		JLabel lblRounds = new JLabel("Best of:");
		lblRounds.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblRounds.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblRounds = new GridBagConstraints();
		gbc_lblRounds.insets = new Insets(0, 0, 5, 5);
		gbc_lblRounds.gridx = 6;
		gbc_lblRounds.gridy = 5;
		contentPane.add(lblRounds, gbc_lblRounds);
		
		spinnerBestOf = new JSpinner();
		spinnerBestOf.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(1)));
		GridBagConstraints gbc_spinnerBestOf = new GridBagConstraints();
		gbc_spinnerBestOf.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerBestOf.gridx = 7;
		gbc_spinnerBestOf.gridy = 5;
		contentPane.add(spinnerBestOf, gbc_spinnerBestOf);
		
		JLabel lblMapSize = new JLabel("Map Size:");
		lblMapSize.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblMapSize.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblMapSize = new GridBagConstraints();
		gbc_lblMapSize.anchor = GridBagConstraints.EAST;
		gbc_lblMapSize.gridwidth = 2;
		gbc_lblMapSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblMapSize.gridx = 1;
		gbc_lblMapSize.gridy = 6;
		contentPane.add(lblMapSize, gbc_lblMapSize);
		
		cmbXMapSize = new JComboBox();
		cmbXMapSize.setModel(new DefaultComboBoxModel(new String[] {"100", "200", "300", "400", "500"}));
		GridBagConstraints gbc_cmbXMapSize = new GridBagConstraints();
		gbc_cmbXMapSize.insets = new Insets(0, 0, 5, 5);
		gbc_cmbXMapSize.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbXMapSize.gridx = 3;
		gbc_cmbXMapSize.gridy = 6;
		contentPane.add(cmbXMapSize, gbc_cmbXMapSize);
		
		JLabel lblX = new JLabel("x");
		lblX.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 4;
		gbc_lblX.gridy = 6;
		contentPane.add(lblX, gbc_lblX);
		
		cmbYMapSize = new JComboBox();
		cmbYMapSize.setModel(new DefaultComboBoxModel(new String[] {"100", "200", "300", "400", "500"}));
		GridBagConstraints gbc_cmbYMapSize = new GridBagConstraints();
		gbc_cmbYMapSize.insets = new Insets(0, 0, 5, 5);
		gbc_cmbYMapSize.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbYMapSize.gridx = 5;
		gbc_cmbYMapSize.gridy = 6;
		contentPane.add(cmbYMapSize, gbc_cmbYMapSize);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setForeground(Color.LIGHT_GRAY);
		lblDuration.setFont(new Font("Helvetica", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDuration = new GridBagConstraints();
		gbc_lblDuration.anchor = GridBagConstraints.EAST;
		gbc_lblDuration.gridwidth = 2;
		gbc_lblDuration.insets = new Insets(0, 0, 0, 5);
		gbc_lblDuration.gridx = 1;
		gbc_lblDuration.gridy = 7;
		contentPane.add(lblDuration, gbc_lblDuration);
		
		spinnerMinutes = new JSpinner();
		spinnerMinutes.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		GridBagConstraints gbc_minSpinner = new GridBagConstraints();
		gbc_minSpinner.anchor = GridBagConstraints.EAST;
		gbc_minSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_minSpinner.gridx = 3;
		gbc_minSpinner.gridy = 7;
		contentPane.add(spinnerMinutes, gbc_minSpinner);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblMin = new GridBagConstraints();
		gbc_lblMin.anchor = GridBagConstraints.WEST;
		gbc_lblMin.insets = new Insets(0, 0, 0, 5);
		gbc_lblMin.gridx = 4;
		gbc_lblMin.gridy = 7;
		contentPane.add(lblMin, gbc_lblMin);
		
		spinnerSeconds = new JSpinner();
		spinnerSeconds.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		GridBagConstraints gbc_spinnerSeconds = new GridBagConstraints();
		gbc_spinnerSeconds.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerSeconds.insets = new Insets(0, 0, 0, 5);
		gbc_spinnerSeconds.gridx = 5;
		gbc_spinnerSeconds.gridy = 7;
		contentPane.add(spinnerSeconds, gbc_spinnerSeconds);
		
		JLabel lblSec = new JLabel("sec");
		lblSec.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblSec = new GridBagConstraints();
		gbc_lblSec.anchor = GridBagConstraints.WEST;
		gbc_lblSec.insets = new Insets(0, 0, 0, 5);
		gbc_lblSec.gridx = 6;
		gbc_lblSec.gridy = 7;
		contentPane.add(lblSec, gbc_lblSec);
		
		btnCreateGame = new JButton("Create Game");
		GridBagConstraints gbc_btnCreateGame = new GridBagConstraints();
		gbc_btnCreateGame.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreateGame.gridx = 7;
		gbc_btnCreateGame.gridy = 7;
		contentPane.add(btnCreateGame, gbc_btnCreateGame);
		return contentPane;
	}
	public void buttonActionListeners(ActionListener al){
		btnCreateGame.setActionCommand("create");
		btnCreateGame.addActionListener(al); 
	}
	public String getGameName() {
		return txtGameName.getText(); 
	}
	public String getFstTeamName(){
		return txtTeamName.getText(); 
	}
	public String getScdTeamName(){
		return txtTeamName2.getText(); 
	}
	public int getNumPlayers(){
		return ((Integer) spinnerNumPlayer.getValue());
	}
	public int getXMapSize(){
		return Integer.parseInt((String)cmbXMapSize.getSelectedItem()); 
		
	}
	public int getYMapSize(){
		return Integer.parseInt((String)cmbYMapSize.getSelectedItem()); 
	}
	public int getGameDuration(){
		int min = (Integer)spinnerMinutes.getValue(); 
		int sec = (Integer)spinnerSeconds.getValue(); 
		return (sec + (min*60)); 
	}
	public int getNumTargets(){
		return (Integer) spinnerNumTargets.getValue();
	}
	public int getBestOf(){
		return (Integer) spinnerBestOf.getValue(); 
	}
	
}
