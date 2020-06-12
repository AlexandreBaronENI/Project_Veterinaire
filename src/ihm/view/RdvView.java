package ihm.view;

import javax.swing.JFrame;

import java.util.Calendar;
import java.util.List;

import bo.Rdv;
import ihm.controller.AnimalController;
import ihm.controller.DossierMedicalController;
import ihm.controller.RdvController;
import ihm.controller.SearchClientController;
import ihm.view.component.TableAllRdv;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class RdvView extends CommonView{
	private JTextField textFieldDate;
	private JTable table;
	private JComboBox<String> comboBoxHour, comboBoxMinutes;
	private JComboBox<String> comboBoxClient, comboBoxVeto, comboBoxAnimaux;
	private JButton btnAddAnimal, btnAddClient;
	private JButton btnNewButtonValidate;
	private JButton btnNewButtonRemove;
	private JButton btnSearchClient;

	public RdvView(List<Rdv> allRdv) {
		super("Rendez-vous");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblClient = new JLabel("Client");
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.anchor = GridBagConstraints.WEST;
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 0;
		gbc_lblClient.gridy = 0;
		getContentPane().add(lblClient, gbc_lblClient);
		
		JLabel lblVeterinaire = new JLabel("V\u00E9t\u00E9rinaire");
		lblVeterinaire.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblVeterinaire = new GridBagConstraints();
		gbc_lblVeterinaire.anchor = GridBagConstraints.WEST;
		gbc_lblVeterinaire.insets = new Insets(0, 0, 5, 5);
		gbc_lblVeterinaire.gridx = 3;
		gbc_lblVeterinaire.gridy = 0;
		getContentPane().add(lblVeterinaire, gbc_lblVeterinaire);
		
		JLabel lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblDate.gridx = 4;
		gbc_lblDate.gridy = 0;
		getContentPane().add(lblDate, gbc_lblDate);
		
		GridBagConstraints gbc_comboBoxClient = new GridBagConstraints();
		gbc_comboBoxClient.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxClient.gridx = 0;
		gbc_comboBoxClient.gridy = 1;
		getContentPane().add(getComboBoxClient(), gbc_comboBoxClient);
		
		GridBagConstraints gbc_btnAddClient = new GridBagConstraints();
		gbc_btnAddClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddClient.gridx = 1;
		gbc_btnAddClient.gridy = 1;
		getContentPane().add(getBtnAddClient(), gbc_btnAddClient);
		
		GridBagConstraints gbc_btnSearchClient = new GridBagConstraints();
		gbc_btnSearchClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchClient.gridx = 2;
		gbc_btnSearchClient.gridy = 1;
		getContentPane().add(getBtnSearchClient(), gbc_btnSearchClient);
		
		GridBagConstraints gbc_comboBoxVeto = new GridBagConstraints();
		gbc_comboBoxVeto.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxVeto.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxVeto.gridx = 3;
		gbc_comboBoxVeto.gridy = 1;
		getContentPane().add(getComboBoxVeto(), gbc_comboBoxVeto);
		
		GridBagConstraints gbc_textFieldDate = new GridBagConstraints();
		gbc_textFieldDate.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDate.gridx = 4;
		gbc_textFieldDate.gridy = 1;
		getContentPane().add(getTextFielDate(), gbc_textFieldDate);
		
		JLabel lblAnimal = new JLabel("Animal");
		GridBagConstraints gbc_lblAnimal = new GridBagConstraints();
		gbc_lblAnimal.anchor = GridBagConstraints.WEST;
		gbc_lblAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnimal.gridx = 0;
		gbc_lblAnimal.gridy = 2;
		getContentPane().add(lblAnimal, gbc_lblAnimal);
		
		JLabel lblHeure = new JLabel("Heure");
		lblHeure.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHeure = new GridBagConstraints();
		gbc_lblHeure.anchor = GridBagConstraints.WEST;
		gbc_lblHeure.insets = new Insets(0, 0, 5, 0);
		gbc_lblHeure.gridx = 4;
		gbc_lblHeure.gridy = 2;
		getContentPane().add(lblHeure, gbc_lblHeure);
		
		GridBagConstraints gbc_comboBoxAnimaux = new GridBagConstraints();
		gbc_comboBoxAnimaux.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAnimaux.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAnimaux.gridx = 0;
		gbc_comboBoxAnimaux.gridy = 3;
		getContentPane().add(getComboBoxAnimaux(), gbc_comboBoxAnimaux);
		
		GridBagConstraints gbc_btnAddAnimal = new GridBagConstraints();
		gbc_btnAddAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddAnimal.gridx = 1;
		gbc_btnAddAnimal.gridy = 3;
		getContentPane().add(getBtnAddAnimal(), gbc_btnAddAnimal);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 3;
		getContentPane().add(panel, gbc_panel);
		
		panel.add(getComboBoxHour());
		
		JLabel lblh = new JLabel("h");
		panel.add(lblh);
		
		panel.add(getComboBoxMinutes());
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridwidth = 5;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 5;
		getContentPane().add(getTable(allRdv), gbc_table);
		
		GridBagConstraints gbc_btnNewButtonRemove = new GridBagConstraints();
		gbc_btnNewButtonRemove.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButtonRemove.gridx = 3;
		gbc_btnNewButtonRemove.gridy = 6;
		getContentPane().add(getBtnRemove(), gbc_btnNewButtonRemove);
		
		GridBagConstraints gbc_btnNewButtonValidate = new GridBagConstraints();
		gbc_btnNewButtonValidate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButtonValidate.gridx = 4;
		gbc_btnNewButtonValidate.gridy = 6;
		getContentPane().add(getBtnValidate(), gbc_btnNewButtonValidate);
		pack();
	}
	
	public JTextField getTextFielDate(){
		if(textFieldDate == null) {
			textFieldDate = new JTextField();
			textFieldDate.setText(String.valueOf(new java.sql.Date(Calendar.getInstance().getTime().getTime())));
			textFieldDate.setColumns(10);
		}
		return textFieldDate;
	}
	
	public JButton getBtnRemove(){
		if(btnNewButtonRemove == null) {		
			btnNewButtonRemove = new JButton("Supprimer");
		}
		btnNewButtonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RdvController.remove();
			}
		});
		return btnNewButtonRemove;
	}
	
	public JButton getBtnValidate(){
		if(btnNewButtonValidate == null) {		
			btnNewButtonValidate = new JButton("Valider");
		}
		btnNewButtonValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RdvController.addRdv();
			}
		});
		return btnNewButtonValidate;
	}
	
	public JButton getBtnAddAnimal(){
		if(btnAddAnimal == null) {		
			btnAddAnimal = new JButton("");
			btnAddAnimal.setIcon(new ImageIcon(new ImageIcon(RdvView.class.getResource("/resources/plus.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		}
		btnAddAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RdvController.addAnimal();
			}
		});
		return btnAddAnimal;
	}
	
	public JButton getBtnAddClient(){
		if(btnAddClient == null) {		
			btnAddClient = new JButton("");
			btnAddClient.setIcon(new ImageIcon(new ImageIcon(RdvView.class.getResource("/resources/plus.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		}
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RdvController.addClient();
			}
		});
		return btnAddClient;
	}
	
	public JButton getBtnSearchClient(){
		if(btnSearchClient == null) {		
			btnSearchClient = new JButton("");
			btnSearchClient.setIcon(new ImageIcon(new ImageIcon(RdvView.class.getResource("/resources/search.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		}
		btnSearchClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchClientController();
			}
		});
		return btnSearchClient;
	}
	
	public JComboBox<String> getComboBoxAnimaux(){
		if(comboBoxAnimaux == null) {
			comboBoxAnimaux = new JComboBox<String>(RdvController.getAnimauxList());
		}
		return comboBoxAnimaux;
	}
	
	public JComboBox<String> getComboBoxVeto(){
		if(comboBoxVeto == null) {
			comboBoxVeto = new JComboBox<String>(RdvController.getVetoList());
		}
		return comboBoxVeto;
	}
	
	public JComboBox<String> getComboBoxClient(){
		if(comboBoxClient == null) {
			comboBoxClient = new JComboBox<String>(RdvController.getClientList());
		}
		return comboBoxClient;
	}
	
	public JComboBox<String> getComboBoxHour(){
		if(comboBoxHour == null) {
			comboBoxHour = new JComboBox<String>(RdvController.hours);
		}
		return comboBoxHour;
	}

	public JComboBox<String> getComboBoxMinutes(){
		if(comboBoxMinutes == null) {
			comboBoxMinutes = new JComboBox<String>(RdvController.minutes);
		}
		return comboBoxMinutes;
	}
	
	public JTable getTable(List<Rdv> allRdv) {
		if (table == null) {
			table = new TableAllRdv(allRdv);
		}
		return table;
	}
	
}
