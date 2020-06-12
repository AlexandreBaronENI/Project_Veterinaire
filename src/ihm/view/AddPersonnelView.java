package ihm.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ihm.controller.AdminController;

import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPersonnelView extends CommonView {
	private JTextField nomTextField;
	private JPasswordField passwordField;
	private JButton addBtn;
	private JPanel panelTypes;
	private JCheckBox archiveChckbx;
	private JLabel nomLabel, passwordLabel, roleLabel,archiveLabel;
	private JRadioButton adminRdbtn, secretaireRdbtn, veterinaireRdbtn;

	public AddPersonnelView() {
		super("Ajout d'un personnel");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_nomLabel = new GridBagConstraints();
		gbc_nomLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomLabel.anchor = GridBagConstraints.EAST;
		gbc_nomLabel.gridx = 0;
		gbc_nomLabel.gridy = 0;
		getContentPane().add(getNomLabel(), gbc_nomLabel);
		
		GridBagConstraints gbc_nomTextField = new GridBagConstraints();
		gbc_nomTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nomTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomTextField.gridx = 1;
		gbc_nomTextField.gridy = 0;
		getContentPane().add(getNomTextField(), gbc_nomTextField);
		
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.anchor = GridBagConstraints.EAST;
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 1;
		getContentPane().add(getPasswordLabel(), gbc_passwordLabel);
		
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		getContentPane().add(getPasswordField(), gbc_passwordField);
		
		GridBagConstraints gbc_roleLabel = new GridBagConstraints();
		gbc_roleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roleLabel.gridx = 0;
		gbc_roleLabel.gridy = 2;
		getContentPane().add(getRoleLabel(), gbc_roleLabel);
		
		GridBagConstraints gbc_panelTypes = new GridBagConstraints();
		gbc_panelTypes.insets = new Insets(0, 0, 5, 0);
		gbc_panelTypes.fill = GridBagConstraints.BOTH;
		gbc_panelTypes.gridx = 1;
		gbc_panelTypes.gridy = 2;
		getContentPane().add(getPanelTypes(), gbc_panelTypes);
		
		
		GridBagConstraints gbc_archiveLabel = new GridBagConstraints();
		gbc_archiveLabel.insets = new Insets(0, 0, 5, 5);
		gbc_archiveLabel.gridx = 0;
		gbc_archiveLabel.gridy = 3;
		getContentPane().add(getArchiveLabel(), gbc_archiveLabel);
		
		GridBagConstraints gbc_archiveChckbx = new GridBagConstraints();
		gbc_archiveChckbx.insets = new Insets(0, 0, 5, 0);
		gbc_archiveChckbx.gridx = 1;
		gbc_archiveChckbx.gridy = 3;
		getContentPane().add(getArchiveChckbx(), gbc_archiveChckbx);
		
		GridBagConstraints gbc_addBtn = new GridBagConstraints();
		gbc_addBtn.gridx = 1;
		gbc_addBtn.gridy = 4;
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
	
	public JTextField getNomTextField() {
		if(nomTextField == null) {
			nomTextField = new JTextField();
			nomTextField.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return nomTextField;
	}
	
	public JLabel getPasswordLabel() {
		if(passwordLabel == null) {
			passwordLabel = new JLabel("Mot de passe");
			passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return passwordLabel;
	}
	
	public JPasswordField getPasswordField() {
		if(passwordField == null) {			
			passwordField = new JPasswordField();
			passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return passwordField;
	}
	
	public JLabel getRoleLabel() {
		if(roleLabel == null) {
			roleLabel = new JLabel("Rôle");
			roleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return roleLabel;
	}
	
	public JPanel getPanelTypes() {
		if(panelTypes==null) {
			panelTypes = new JPanel();
			ButtonGroup btnGroup = new ButtonGroup();
			btnGroup.add(getAdminRdbtn());
			btnGroup.add(getSecretaireRdbtn());
			btnGroup.add(getVeterinaireRdbtn());
			panelTypes.add(getAdminRdbtn());
			panelTypes.add(getSecretaireRdbtn());
			panelTypes.add(getVeterinaireRdbtn());
		}
		return panelTypes;
	}
	
	public JRadioButton getAdminRdbtn() {
		if(adminRdbtn == null) {
			adminRdbtn = new JRadioButton("Admin");
			adminRdbtn.setSelected(true);
		}
		return adminRdbtn;
	}
	
	public JRadioButton getVeterinaireRdbtn() {
		if(veterinaireRdbtn == null) {
			veterinaireRdbtn = new JRadioButton("Vétérinaire");
		}
		return veterinaireRdbtn;
	}
	
	public JRadioButton getSecretaireRdbtn() {
		if(secretaireRdbtn == null) {
			secretaireRdbtn = new JRadioButton("Secrétaire");
		}
		return secretaireRdbtn;
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
					AdminController.nouveau();
				}
			});
		}
		return addBtn;
	}
	
	public JCheckBox getArchiveChckbx() {
		if(archiveChckbx == null) {
			archiveChckbx = new JCheckBox("");
			archiveChckbx.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return archiveChckbx;
	}
	
	
	
}
