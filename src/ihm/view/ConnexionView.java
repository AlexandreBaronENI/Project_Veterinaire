package ihm.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ihm.controller.ConnexionController;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ConnexionView extends CommonView{
	public ConnexionView() {
		super("Connexion");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_passwordLabel.anchor = GridBagConstraints.EAST;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 1;
		getContentPane().add(getPasswordLabel(), gbc_passwordLabel);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		getContentPane().add(getPasswordField(), gbc_passwordField);
		GridBagConstraints gbc_validateButton = new GridBagConstraints();
		gbc_validateButton.gridx = 1;
		gbc_validateButton.gridy = 2;
		getContentPane().add(getValidateButton(), gbc_validateButton);
		pack();
	}

	private JLabel nomLabel;
	private JTextField nomTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton validateButton;
	

	public JLabel getNomLabel() {
		if (nomLabel == null) {
			nomLabel = new JLabel("Nom");
		}
		return nomLabel;
	}
	public JTextField getNomTextField() {
		if (nomTextField == null) {
			nomTextField = new JTextField();
			nomTextField.setColumns(10);
		}
		return nomTextField;
	}
	public JLabel getPasswordLabel() {
		if (passwordLabel == null) {
			passwordLabel = new JLabel("Mot de passe");
		}
		return passwordLabel;
	}
	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
		}
		return passwordField;
	}
	public JButton getValidateButton() {
		if (validateButton == null) {
			validateButton = new JButton("Valider");
			validateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConnexionController.login();
				}
			});
		}
		return validateButton;
	}
}
