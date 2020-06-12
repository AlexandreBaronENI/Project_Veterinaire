package ihm.view;

import javax.swing.JFrame;

import bo.Rdv;
import ihm.controller.DossierMedicalController;
import ihm.view.component.TableAllRdv;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DossierMedView extends CommonView {

	private JLabel lblNewLabelNom;
	private JLabel lblNewLabelCodeAnimal;
	private JLabel lblNewLabelClient;
	private JLabel lblNewLabelCouleur;
	private JLabel lblNewLabelSexe;
	private JLabel lblNewLabelRace;
	private JLabel lblNewLabelTatouage;
	private JTextPane textPane;



	public DossierMedView(Rdv rdv) {
		super("Dossier médical");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButtonValider = new JButton("Valider");
		btnNewButtonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DossierMedicalController.update(rdv.getAnimal());
			}
		});
		GridBagConstraints gbc_btnNewButtonValider = new GridBagConstraints();
		gbc_btnNewButtonValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButtonValider.gridx = 4;
		gbc_btnNewButtonValider.gridy = 0;
		getContentPane().add(btnNewButtonValider, gbc_btnNewButtonValider);
		
		JButton btnNewButtonCancel = new JButton("Annuler");
		btnNewButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DossierMedicalController.cancel();
			}
		});
		GridBagConstraints gbc_btnNewButtonCancel = new GridBagConstraints();
		gbc_btnNewButtonCancel.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButtonCancel.gridx = 5;
		gbc_btnNewButtonCancel.gridy = 0;
		getContentPane().add(btnNewButtonCancel, gbc_btnNewButtonCancel);
		
		JLabel lblAntecedents = new JLabel("Ant\u00E9c\u00E9dents");
		GridBagConstraints gbc_lblAntecedents = new GridBagConstraints();
		gbc_lblAntecedents.insets = new Insets(0, 0, 5, 0);
		gbc_lblAntecedents.gridx = 3;
		gbc_lblAntecedents.gridy = 1;
		getContentPane().add(lblAntecedents, gbc_lblAntecedents);
		
		GridBagConstraints gbc_textPaneAntecedents = new GridBagConstraints();
		gbc_textPaneAntecedents.insets = new Insets(0, 0, 5, 0);
		gbc_textPaneAntecedents.fill = GridBagConstraints.BOTH;
		gbc_textPaneAntecedents.gridwidth = 3;
		gbc_textPaneAntecedents.gridheight = 7;
		gbc_textPaneAntecedents.gridx = 3;
		gbc_textPaneAntecedents.gridy = 2;
		getContentPane().add(getTextPane(rdv), gbc_textPaneAntecedents);
		
		GridBagConstraints gbc_lblNewLabelTatouage = new GridBagConstraints();
		gbc_lblNewLabelTatouage.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabelTatouage.gridx = 1;
		gbc_lblNewLabelTatouage.gridy = 6;
		getContentPane().add(getLblNewLabelTatouage(rdv), gbc_lblNewLabelTatouage);
		
		GridBagConstraints gbc_lblNewLabelRace = new GridBagConstraints();
		gbc_lblNewLabelRace.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelRace.gridx = 1;
		gbc_lblNewLabelRace.gridy = 5;
		getContentPane().add(getLblNewLabelRace(rdv), gbc_lblNewLabelRace);
		
		GridBagConstraints gbc_lblNewLabelSexe = new GridBagConstraints();
		gbc_lblNewLabelSexe.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelSexe.gridx = 2;
		gbc_lblNewLabelSexe.gridy = 4;
		getContentPane().add(getLblNewLabelSexe(rdv), gbc_lblNewLabelSexe);
		
		GridBagConstraints gbc_lblNewLabelCouleur = new GridBagConstraints();
		gbc_lblNewLabelCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelCouleur.gridx = 1;
		gbc_lblNewLabelCouleur.gridy = 4;
		getContentPane().add(getLblNewLabelCouleur(rdv), gbc_lblNewLabelCouleur);
		
		GridBagConstraints gbc_lblNewLabelClient = new GridBagConstraints();
		gbc_lblNewLabelClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelClient.gridx = 0;
		gbc_lblNewLabelClient.gridy = 1;
		getContentPane().add(getLblNewLabelClient(rdv), gbc_lblNewLabelClient);
		
		JLabel lblAnimal = new JLabel("Animal");
		GridBagConstraints gbc_lblAnimal = new GridBagConstraints();
		gbc_lblAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnimal.gridx = 0;
		gbc_lblAnimal.gridy = 2;
		getContentPane().add(lblAnimal, gbc_lblAnimal);
		
		GridBagConstraints gbc_lblNewLabelCodeAnimal = new GridBagConstraints();
		gbc_lblNewLabelCodeAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelCodeAnimal.gridx = 1;
		gbc_lblNewLabelCodeAnimal.gridy = 2;
		getContentPane().add(getLblNewLabelCodeAnimal(rdv), gbc_lblNewLabelCodeAnimal);
		
		GridBagConstraints gbc_lblNewLabelNom = new GridBagConstraints();
		gbc_lblNewLabelNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelNom.gridx = 1;
		gbc_lblNewLabelNom.gridy = 3;
		getContentPane().add(getLblNewLabelNom(rdv), gbc_lblNewLabelNom);
		pack();
	}
	
	public JTextPane getTextPane(Rdv rdv) {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setText(rdv.getAnimal().getAntecedents());
		}
		return textPane;
	}

	public JLabel getLblNewLabelTatouage(Rdv rdv) {
		if (lblNewLabelTatouage == null) {
			lblNewLabelTatouage = new JLabel(rdv.getAnimal().getTatouage());
		}
		return lblNewLabelTatouage;
	}
	
	public JLabel getLblNewLabelRace(Rdv rdv) {
		if (lblNewLabelRace == null) {
			lblNewLabelRace = new JLabel(rdv.getAnimal().getRace());
		}
		return lblNewLabelRace;
	}
	
	public JLabel getLblNewLabelSexe(Rdv rdv) {
		if (lblNewLabelSexe == null) {
			lblNewLabelSexe = new JLabel(rdv.getAnimal().getSexe());
		}
		return lblNewLabelSexe;
	}
	
	public JLabel getLblNewLabelCouleur(Rdv rdv) {
		if (lblNewLabelCouleur == null) {
			lblNewLabelCouleur = new JLabel(rdv.getAnimal().getCouleur());
		}
		return lblNewLabelCouleur;
	}
	
	public JLabel getLblNewLabelNom(Rdv rdv) {
		if (lblNewLabelNom == null) {
			lblNewLabelNom = new JLabel(rdv.getAnimal().getNomAnimal());
		}
		return lblNewLabelNom;
	}
	
	public JLabel getLblNewLabelCodeAnimal(Rdv rdv) {
		if (lblNewLabelCodeAnimal == null) {
			lblNewLabelCodeAnimal = new JLabel(String.valueOf(rdv.getAnimal().getCodeAnimal()));
		}
		return lblNewLabelCodeAnimal;
	}
	
	public JLabel getLblNewLabelClient(Rdv rdv) {
		if (lblNewLabelClient == null) {
			lblNewLabelClient = new JLabel("Client : "+ rdv.getClient().getPrenomClient() + " " + rdv.getClient().getNomClient());
		}
		return lblNewLabelClient;
	}

}
