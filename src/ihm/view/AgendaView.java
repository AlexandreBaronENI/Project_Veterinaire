package ihm.view;

import javax.swing.JFrame;

import bo.Animal;
import bo.Personnel;
import bo.Rdv;
import ihm.controller.AnimalController;
import ihm.controller.ClientsController;
import ihm.controller.AgendaController;
import ihm.view.component.TableAllRdv;
import ihm.view.component.TableAnimaux;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class AgendaView extends CommonView{
	private JTextField textFieldDate;
	private JTable table;
	private JComboBox<String> comboBoxVeterinaires;
	private JButton btnSearch;

	public AgendaView(List<Rdv> allRdv, Personnel veto) {
		super("Agenda");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblVétérinaire = new JLabel("V\u00E9t\u00E9rinaire");
		GridBagConstraints gbc_lblVétérinaire = new GridBagConstraints();
		gbc_lblVétérinaire.insets = new Insets(0, 0, 0, 5);
		gbc_lblVétérinaire.anchor = GridBagConstraints.EAST;
		gbc_lblVétérinaire.gridx = 0;
		gbc_lblVétérinaire.gridy = 0;
		getContentPane().add(lblVétérinaire, gbc_lblVétérinaire);
		
		GridBagConstraints gbc_comboBoxVeterinaires = new GridBagConstraints();
		gbc_comboBoxVeterinaires.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxVeterinaires.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxVeterinaires.gridx = 1;
		gbc_comboBoxVeterinaires.gridy = 0;
		getContentPane().add(getComboBoxVeterinaires(), gbc_comboBoxVeterinaires);
		
		JLabel lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 2;
		gbc_lblDate.gridy = 0;
		getContentPane().add(lblDate, gbc_lblDate);
		
		GridBagConstraints gbc_textFieldDate = new GridBagConstraints();
		gbc_textFieldDate.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDate.gridx = 3;
		gbc_textFieldDate.gridy = 0;
		getContentPane().add(getTextFieldDate(allRdv), gbc_textFieldDate);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridwidth = 5;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		getContentPane().add(getTable(allRdv), gbc_table);
		
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridwidth = 4;
		gbc_btnSearch.fill = GridBagConstraints.BOTH;
		gbc_btnSearch.gridx = 4;
		gbc_btnSearch.gridy = 0;
		
		getContentPane().add(getBtnSearch(veto), gbc_btnSearch);
				
		JButton btnNewButtonDossier = new JButton("Dossier m\u00E9dical");
		btnNewButtonDossier.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AgendaController.folder();
        	}
        });
		GridBagConstraints gbc_btnNewButtonDossier = new GridBagConstraints();
		gbc_btnNewButtonDossier.gridx = 4;
		gbc_btnNewButtonDossier.gridy = 2;
		getContentPane().add(new JLabel("salut bb"));
		getContentPane().add(btnNewButtonDossier, gbc_btnNewButtonDossier);
		pack();
	}
	
	public JButton getBtnSearch(Personnel veto) {
		if(btnSearch == null) {
			btnSearch = new JButton("Rechercher");
		}
		btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AgendaController.search(veto);
        	}
        });
		return btnSearch;
	}
	
	public JTextField getTextFieldDate(List<Rdv> allRdv) {
		if(textFieldDate == null) {
			textFieldDate = new JTextField();
			textFieldDate.setColumns(10);
			textFieldDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		return textFieldDate;
	}
	
	public JTable getTable(List<Rdv> allRdv) {
		if (table == null) {
			table = new TableAllRdv(allRdv);
		}
		return table;
	}
	
	public JComboBox<String> getComboBoxVeterinaires(){
		if(comboBoxVeterinaires == null) {
			comboBoxVeterinaires = new JComboBox<String>(AgendaController.getVetoList());
		}
		return comboBoxVeterinaires;
	}

}
