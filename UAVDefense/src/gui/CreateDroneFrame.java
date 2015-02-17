package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class CreateDroneFrame {
	private JPanel contentPane;
	private JTextField textDroneName;
	private JButton btnCreate;
    private JComboBox cmbDroneSelect;
    private JComboBox comboArchSelect;
    private JButton btnDone;
    private JButton btnDelete; 
	public CreateDroneFrame() {
        createAndShowGUI();
	}

	private void createAndShowGUI(){
		JFrame frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 459, 326); 
		frame.setContentPane(createContentPane());
		frame.setVisible(true);
	}
	
	public JPanel createContentPane(){
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 98, 0, 106, 19, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblManageUav = new JLabel("Manage UAV");
		lblManageUav.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblManageUav.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblManageUav = new GridBagConstraints();
		gbc_lblManageUav.insets = new Insets(0, 0, 5, 5);
		gbc_lblManageUav.gridx = 1;
		gbc_lblManageUav.gridy = 1;
		contentPane.add(lblManageUav, gbc_lblManageUav);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridheight = 8;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
		btnCreate = new JButton("Create New");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		cmbDroneSelect = new JComboBox();
		GridBagConstraints gbc_cmbDroneSelect = new GridBagConstraints();
		gbc_cmbDroneSelect.insets = new Insets(0, 0, 5, 5);
		gbc_cmbDroneSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDroneSelect.gridx = 1;
		gbc_cmbDroneSelect.gridy = 2;
		contentPane.add(cmbDroneSelect, gbc_cmbDroneSelect);
		
		btnDelete = new JButton("Delete");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 3;
		contentPane.add(btnDelete, gbc_btnDelete);
		
		JLabel lblDroneName = new JLabel("New UAV Name");
		lblDroneName.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblDroneName.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblDroneName = new GridBagConstraints();
		gbc_lblDroneName.insets = new Insets(0, 0, 5, 5); 
		gbc_lblDroneName.gridx = 1;
		gbc_lblDroneName.gridy = 4;
		contentPane.add(lblDroneName, gbc_lblDroneName);
		
		textDroneName = new JTextField();
		GridBagConstraints gbc_textDroneName = new GridBagConstraints();
		gbc_textDroneName.insets = new Insets(0, 0, 5, 5);
		gbc_textDroneName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDroneName.gridx = 1;
		gbc_textDroneName.gridy = 5;
		contentPane.add(textDroneName, gbc_textDroneName);
		textDroneName.setColumns(10);
		
		JLabel lblArchitecture = new JLabel("Architecture");
		lblArchitecture.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblArchitecture.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblArchitecture = new GridBagConstraints();
		gbc_lblArchitecture.insets = new Insets(0, 0, 5, 5);
		gbc_lblArchitecture.gridx = 1;
		gbc_lblArchitecture.gridy = 6;
		contentPane.add(lblArchitecture, gbc_lblArchitecture);
		
		comboArchSelect = new JComboBox();
		GridBagConstraints gbc_comboArchSelect = new GridBagConstraints();
		gbc_comboArchSelect.insets = new Insets(0, 0, 5, 5);
		gbc_comboArchSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboArchSelect.gridx = 1;
		gbc_comboArchSelect.gridy = 7;
		contentPane.add(comboArchSelect, gbc_comboArchSelect);
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreate.gridx = 1;
		gbc_btnCreate.gridy = 8;
		contentPane.add(btnCreate, gbc_btnCreate);
		
		btnDone = new JButton("Done");
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.anchor = GridBagConstraints.EAST;
		gbc_btnDone.insets = new Insets(0, 0, 0, 5);
		gbc_btnDone.gridx = 5;
		gbc_btnDone.gridy = 9;
		contentPane.add(btnDone, gbc_btnDone);
		
		return contentPane;
	}
	
}
