package ihm.view;

import javax.swing.JFrame;

import ihm.controller.AnimalController;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bo.Client;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class AnimalView extends CommonView {
	private JTextField nomTextField;
	private JTextField couleurTextField;
	private JTextField tatouageTextField;
	private JLabel lblCodeSet;
	private JComboBox<String> comboBoxSexe;
	private JComboBox<String> comboBoxRace;
	private JComboBox<String> comboBoxEspece;
	private JLabel lblClient;
	private JButton btnSubmit;
	public AnimalView(boolean edit) {
		super(!edit?"Ajout d'un animal":"Modification de l'animal");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.anchor = GridBagConstraints.EAST;
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 1;
		gbc_lblClient.gridy = 0;
		getContentPane().add(getLblClient(), gbc_lblClient);
		
		JLabel lblCode = new JLabel("Code");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 1;
		getContentPane().add(lblCode, gbc_lblCode);
		
		GridBagConstraints gbc_lblCodeSet = new GridBagConstraints();
		gbc_lblCodeSet.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeSet.gridx = 1;
		gbc_lblCodeSet.gridy = 1;
		getContentPane().add(getCode(), gbc_lblCodeSet);
		
		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 2;
		getContentPane().add(lblNom, gbc_lblNom);
		
		GridBagConstraints gbc_nomTextField = new GridBagConstraints();
		gbc_nomTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomTextField.gridx = 1;
		gbc_nomTextField.gridy = 2;
		getContentPane().add(getNomTextField(), gbc_nomTextField);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		getContentPane().add(getSexeComboBox(), gbc_comboBox);
		
		JLabel lblCouleur = new JLabel("Couleur");
		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleur.anchor = GridBagConstraints.EAST;
		gbc_lblCouleur.gridx = 0;
		gbc_lblCouleur.gridy = 3;
		getContentPane().add(lblCouleur, gbc_lblCouleur);
		
		GridBagConstraints gbc_couleurTextField = new GridBagConstraints();
		gbc_couleurTextField.insets = new Insets(0, 0, 5, 5);
		gbc_couleurTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_couleurTextField.gridx = 1;
		gbc_couleurTextField.gridy = 3;
		getContentPane().add(getCouleurTextField(), gbc_couleurTextField);
		
		JLabel lblEspece = new JLabel("Esp\u00E8ce");
		GridBagConstraints gbc_lblEspece = new GridBagConstraints();
		gbc_lblEspece.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspece.anchor = GridBagConstraints.EAST;
		gbc_lblEspece.gridx = 0;
		gbc_lblEspece.gridy = 4;
		getContentPane().add(lblEspece, gbc_lblEspece);
		
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 4;
		getContentPane().add(getEspeceComboBox(), gbc_comboBox_1);
		
		JLabel lblRace = new JLabel("Race");
		GridBagConstraints gbc_lblRace = new GridBagConstraints();
		gbc_lblRace.anchor = GridBagConstraints.EAST;
		gbc_lblRace.insets = new Insets(0, 0, 5, 5);
		gbc_lblRace.gridx = 2;
		gbc_lblRace.gridy = 4;
		getContentPane().add(lblRace, gbc_lblRace);
		
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 4;
		getContentPane().add(getRaceComboBox(), gbc_comboBox_2);
		
		JLabel lblTatouage = new JLabel("Tatouage");
		GridBagConstraints gbc_lblTatouage = new GridBagConstraints();
		gbc_lblTatouage.anchor = GridBagConstraints.EAST;
		gbc_lblTatouage.insets = new Insets(0, 0, 5, 5);
		gbc_lblTatouage.gridx = 0;
		gbc_lblTatouage.gridy = 5;
		getContentPane().add(lblTatouage, gbc_lblTatouage);
		
		GridBagConstraints gbc_tatouageTextField = new GridBagConstraints();
		gbc_tatouageTextField.insets = new Insets(0, 0, 5, 5);
		gbc_tatouageTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_tatouageTextField.gridx = 1;
		gbc_tatouageTextField.gridy = 5;
		getContentPane().add(getTatouageTextField(), gbc_tatouageTextField);
		
		if(edit) {
			btnSubmit = new JButton("Modifier");
			btnSubmit.setHorizontalAlignment(SwingConstants.RIGHT);
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AnimalController.edit();
				}
			});
		}else {
			btnSubmit = new JButton("Ajouter");
			btnSubmit.setHorizontalAlignment(SwingConstants.RIGHT);
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AnimalController.add();
				}
			});	
		}
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalController.cancel();
			}
		});
		
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 6;
		getContentPane().add(btnCancel, gbc_btnCancel);
		
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 3;
		gbc_btnAdd.gridy = 6;
		getContentPane().add(btnSubmit, gbc_btnAdd);
		pack();
	}
	
	public JLabel getLblClient() {
		if(lblClient == null) {
			lblClient = new JLabel();
		}
		return lblClient;
	}
	
	public JComboBox<String> getSexeComboBox(){
		if(comboBoxSexe == null) {
			comboBoxSexe = new JComboBox<String>(AnimalController.sexe);
		}
		return comboBoxSexe;
	}
	
	public JComboBox<String> getEspeceComboBox(){
		if(comboBoxEspece == null) {
			comboBoxEspece = new JComboBox<String>(AnimalController.espece);
		}
		return comboBoxEspece;
	}
	
	public JComboBox<String> getRaceComboBox(){
		if(comboBoxRace == null) {
			comboBoxRace = new JComboBox<String>(AnimalController.races);
		}
		return comboBoxRace;
	}
	
	public JLabel getCode() {
		if(lblCodeSet == null) {
			lblCodeSet = new JLabel();
		}
		return lblCodeSet;
	}
	
	public JTextField getNomTextField(){
		if(nomTextField == null) {
			nomTextField = new JTextField();
			nomTextField.setColumns(10);
		}
		return nomTextField;
	}
	
	public JTextField getCouleurTextField(){
		if(couleurTextField == null) {
			couleurTextField = new JTextField();
			couleurTextField.setColumns(10);
		}
		return couleurTextField;
	}
	
	public JTextField getTatouageTextField(){
		if(tatouageTextField == null) {
			tatouageTextField = new JTextField();
			tatouageTextField.setColumns(10);
		}
		return tatouageTextField;
	}

}
