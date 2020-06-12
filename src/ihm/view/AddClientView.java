package ihm.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ihm.controller.AdminController;
import ihm.controller.ClientsController;

import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddClientView extends CommonView {
	private JTextField textFieldPrenom;
	private JButton addBtn;
	private JPanel panelTypes;
	private JCheckBox archiveChckbx;
	private JLabel nomLabel, lblPrenom, lblAdresse,archiveLabel;
	private JRadioButton adminRdbtn, secretaireRdbtn, veterinaireRdbtn;
	private JLabel lblCode;
	private JLabel lblCodeClient;
	private JTextField textFieldNom;
	private JLabel lblCP;
	private JLabel lblVille;
	private JTextField textFieldAdresse2;
	private JTextField textFieldAdresse1;
	private JTextField textFieldCP;
	private JTextField textFieldVille;
	private JButton btnCancel;
	private JCheckBox chckbxIsArchive;
	private JLabel lblArchive;
	private JLabel lblEmail;
	private JLabel lblNumTel;
	private JLabel lblRemarque;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;
	private JTextField textFieldRemarque;
	private JLabel lblAssurance;
	private JTextField textFieldAssurance;

	public AddClientView() {
		super("Ajout d'un client");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 0;
		getContentPane().add(getLblCode(), gbc_lblCode);
		GridBagConstraints gbc_lblCodeClient = new GridBagConstraints();
		gbc_lblCodeClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeClient.gridx = 1;
		gbc_lblCodeClient.gridy = 0;
		getContentPane().add(getLblCodeClient(), gbc_lblCodeClient);
		
		GridBagConstraints gbc_nomLabel = new GridBagConstraints();
		gbc_nomLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomLabel.anchor = GridBagConstraints.EAST;
		gbc_nomLabel.gridx = 0;
		gbc_nomLabel.gridy = 1;
		getContentPane().add(getNomLabel(), gbc_nomLabel);
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.gridx = 1;
		gbc_textFieldNom.gridy = 1;
		getContentPane().add(getTextFieldNom(), gbc_textFieldNom);
		
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.anchor = GridBagConstraints.EAST;
		gbc_lblPrenom.gridx = 0;
		gbc_lblPrenom.gridy = 2;
		getContentPane().add(getLblPrenom(), gbc_lblPrenom);
		
		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenom.gridx = 1;
		gbc_textFieldPrenom.gridy = 2;
		getContentPane().add(getTextFieldPrenom(), gbc_textFieldPrenom);
		
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 0;
		gbc_lblAdresse.gridy = 3;
		getContentPane().add(getLblAdresse(), gbc_lblAdresse);
		GridBagConstraints gbc_textFieldAdresse1 = new GridBagConstraints();
		gbc_textFieldAdresse1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse1.gridx = 1;
		gbc_textFieldAdresse1.gridy = 3;
		getContentPane().add(getTextFieldAdresse1(), gbc_textFieldAdresse1);
		GridBagConstraints gbc_textFieldAdresse2 = new GridBagConstraints();
		gbc_textFieldAdresse2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse2.gridx = 1;
		gbc_textFieldAdresse2.gridy = 4;
		getContentPane().add(getTextFieldAdresse2(), gbc_textFieldAdresse2);
		GridBagConstraints gbc_lblCP = new GridBagConstraints();
		gbc_lblCP.anchor = GridBagConstraints.EAST;
		gbc_lblCP.insets = new Insets(0, 0, 5, 5);
		gbc_lblCP.gridx = 0;
		gbc_lblCP.gridy = 5;
		getContentPane().add(getLblCP(), gbc_lblCP);
		GridBagConstraints gbc_textFieldCP = new GridBagConstraints();
		gbc_textFieldCP.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCP.gridx = 1;
		gbc_textFieldCP.gridy = 5;
		getContentPane().add(getTextFieldCP(), gbc_textFieldCP);
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.anchor = GridBagConstraints.EAST;
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 0;
		gbc_lblVille.gridy = 6;
		getContentPane().add(getLblVille(), gbc_lblVille);
		GridBagConstraints gbc_textFieldVille = new GridBagConstraints();
		gbc_textFieldVille.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVille.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVille.gridx = 1;
		gbc_textFieldVille.gridy = 6;
		getContentPane().add(getTextFieldVille(), gbc_textFieldVille);
		GridBagConstraints gbc_lblArchive = new GridBagConstraints();
		gbc_lblArchive.insets = new Insets(0, 0, 5, 5);
		gbc_lblArchive.gridx = 0;
		gbc_lblArchive.gridy = 7;
		getContentPane().add(getLblArchive(), gbc_lblArchive);
		GridBagConstraints gbc_chckbxIsArchive = new GridBagConstraints();
		gbc_chckbxIsArchive.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxIsArchive.gridx = 1;
		gbc_chckbxIsArchive.gridy = 7;
		getContentPane().add(getChckbxIsArchive(), gbc_chckbxIsArchive);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 8;
		getContentPane().add(getLblEmail(), gbc_lblEmail);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 8;
		getContentPane().add(getTextFieldEmail(), gbc_textFieldEmail);
		GridBagConstraints gbc_lblNumTel = new GridBagConstraints();
		gbc_lblNumTel.anchor = GridBagConstraints.EAST;
		gbc_lblNumTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumTel.gridx = 0;
		gbc_lblNumTel.gridy = 9;
		getContentPane().add(getLblNumTel(), gbc_lblNumTel);
		GridBagConstraints gbc_textFieldTel = new GridBagConstraints();
		gbc_textFieldTel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTel.gridx = 1;
		gbc_textFieldTel.gridy = 9;
		getContentPane().add(getTextFieldTel(), gbc_textFieldTel);
		GridBagConstraints gbc_lblRemarque = new GridBagConstraints();
		gbc_lblRemarque.anchor = GridBagConstraints.EAST;
		gbc_lblRemarque.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemarque.gridx = 0;
		gbc_lblRemarque.gridy = 10;
		getContentPane().add(getLblRemarque(), gbc_lblRemarque);
		GridBagConstraints gbc_textFieldRemarque = new GridBagConstraints();
		gbc_textFieldRemarque.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRemarque.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRemarque.gridx = 1;
		gbc_textFieldRemarque.gridy = 10;
		getContentPane().add(getTextFieldRemarque(), gbc_textFieldRemarque);
		GridBagConstraints gbc_lblAssurance = new GridBagConstraints();
		gbc_lblAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssurance.gridx = 0;
		gbc_lblAssurance.gridy = 11;
		getContentPane().add(getLblAssurance(), gbc_lblAssurance);
		GridBagConstraints gbc_textFieldAssurance = new GridBagConstraints();
		gbc_textFieldAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAssurance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAssurance.gridx = 1;
		gbc_textFieldAssurance.gridy = 11;
		getContentPane().add(getTextFieldAssurance(), gbc_textFieldAssurance);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 12;
		getContentPane().add(getBtnCancel(), gbc_btnCancel);
		
		GridBagConstraints gbc_addBtn = new GridBagConstraints();
		gbc_addBtn.insets = new Insets(0, 0, 5, 0);
		gbc_addBtn.gridx = 2;
		gbc_addBtn.gridy = 12;
		getContentPane().add(getAddBtn(), gbc_addBtn);
		pack();
	}
	
	public JLabel getNomLabel() {
		if(nomLabel == null) {
			nomLabel = new JLabel("Nom");
			nomLabel.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return nomLabel;
	}
	
	public JTextField getTextFieldPrenom() {
		if(textFieldPrenom == null) {
			textFieldPrenom = new JTextField();
			textFieldPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return textFieldPrenom;
	}
	
	public JLabel getLblPrenom() {
		if(lblPrenom == null) {
			lblPrenom = new JLabel("Pr\u00E9nom");
			lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblPrenom;
	}
	
	public JLabel getLblAdresse() {
		if(lblAdresse == null) {
			lblAdresse = new JLabel("Adresse");
			lblAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblAdresse;
	}
	
	public JLabel getArchiveLabel() {
		if(archiveLabel == null) {
			archiveLabel = new JLabel("Archive");
			archiveLabel.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return archiveLabel;
	}
	
	public JButton getAddBtn() {
		if(addBtn == null) {
			addBtn = new JButton("Ajouter");
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClientsController.nouveau();
				}
			});
		}
		return addBtn;
	}
	
	private JLabel getLblCode() {
		if (lblCode == null) {
			lblCode = new JLabel("Code");
		}
		return lblCode;
	}
	public JLabel getLblCodeClient() {
		if (lblCodeClient == null) {
			lblCodeClient = new JLabel("");
		}
		return lblCodeClient;
	}
	public JTextField getTextFieldNom() {
		if (textFieldNom == null) {
			textFieldNom = new JTextField();
			textFieldNom.setColumns(10);
		}
		return textFieldNom;
	}
	private JLabel getLblCP() {
		if (lblCP == null) {
			lblCP = new JLabel("Code Postal");
		}
		return lblCP;
	}
	private JLabel getLblVille() {
		if (lblVille == null) {
			lblVille = new JLabel("Ville");
		}
		return lblVille;
	}
	public JTextField getTextFieldAdresse2() {
		if (textFieldAdresse2 == null) {
			textFieldAdresse2 = new JTextField();
			textFieldAdresse2.setColumns(10);
		}
		return textFieldAdresse2;
	}
	public JTextField getTextFieldAdresse1() {
		if (textFieldAdresse1 == null) {
			textFieldAdresse1 = new JTextField();
			textFieldAdresse1.setColumns(10);
		}
		return textFieldAdresse1;
	}
	public JTextField getTextFieldCP() {
		if (textFieldCP == null) {
			textFieldCP = new JTextField();
			textFieldCP.setColumns(10);
		}
		return textFieldCP;
	}
	public JTextField getTextFieldVille() {
		if (textFieldVille == null) {
			textFieldVille = new JTextField();
			textFieldVille.setColumns(10);
		}
		return textFieldVille;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Annuler");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClientsController.cancel(true);
				}
			});
		}
		return btnCancel;
	}
	public JCheckBox getChckbxIsArchive() {
		if (chckbxIsArchive == null) {
			chckbxIsArchive = new JCheckBox("");
		}
		return chckbxIsArchive;
	}
	private JLabel getLblArchive() {
		if (lblArchive == null) {
			lblArchive = new JLabel("Archive");
		}
		return lblArchive;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
		}
		return lblEmail;
	}
	private JLabel getLblNumTel() {
		if (lblNumTel == null) {
			lblNumTel = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone");
		}
		return lblNumTel;
	}
	private JLabel getLblRemarque() {
		if (lblRemarque == null) {
			lblRemarque = new JLabel("Remarque");
		}
		return lblRemarque;
	}
	public JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setColumns(10);
		}
		return textFieldEmail;
	}
	public JTextField getTextFieldTel() {
		if (textFieldTel == null) {
			textFieldTel = new JTextField();
			textFieldTel.setColumns(10);
		}
		return textFieldTel;
	}
	public JTextField getTextFieldRemarque() {
		if (textFieldRemarque == null) {
			textFieldRemarque = new JTextField();
			textFieldRemarque.setColumns(10);
		}
		return textFieldRemarque;
	}
	private JLabel getLblAssurance() {
		if (lblAssurance == null) {
			lblAssurance = new JLabel("Assurance");
		}
		return lblAssurance;
	}
	public JTextField getTextFieldAssurance() {
		if (textFieldAssurance == null) {
			textFieldAssurance = new JTextField();
			textFieldAssurance.setColumns(10);
		}
		return textFieldAssurance;
	}
}
