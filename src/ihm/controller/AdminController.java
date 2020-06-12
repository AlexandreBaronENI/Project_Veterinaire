package ihm.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bll.BLLException;
import bll.PersonnelManager;
import bo.Personnel;
import ihm.view.AddPersonnelView;
import ihm.view.AdminView;
import ihm.view.component.TableAllPersonnelModel;

public class AdminController {

	private static AdminView view;
	private static AddPersonnelView addPersonnelView;
	private static PersonnelManager personnelManager;
    private static List < Personnel > allPersonnel;
    private static int selectedRow;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminController controller = new AdminController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    */
	public AdminController() {
    	personnelManager = PersonnelManager.getInstance();
        allPersonnel = personnelManager.getAllPersonnel();
		view = new AdminView(allPersonnel);
	}

	public static void addPersonnelScreen() {
        addPersonnelView = new AddPersonnelView();
	}
	

	public static void removePersonnel() {
		if(!view.getTable(allPersonnel).getSelectionModel().isSelectionEmpty()) {
			int choice = JOptionPane.showConfirmDialog(null, "Êtes vous sûr de vouloir supprimer " + allPersonnel.get(selectedRow).getNom() + " ?");
			if(choice == 0) {
				personnelManager.removePersonnel(allPersonnel.get(selectedRow).getCodePers());
				miseAJourDesDonnees();
			}	
		}
	}
	
	
	public static void miseAJourDesDonnees() {
		allPersonnel = personnelManager.getAllPersonnel();
		view.getTable(allPersonnel).setModel(new TableAllPersonnelModel(personnelManager.getAllPersonnel()));
	}

	public static void nouveau() {
		Personnel pers = getCurrentPersonnel();
		try {
			personnelManager.addPersonnel(pers);
			JOptionPane.showMessageDialog(null, pers.getNom() + " a bien été ajouté au personnel !");
			miseAJourDesDonnees();
			addPersonnelView.dispose();
		} catch (BLLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Informations invalides, merci de bien compléter les champs !");
		}
	}

	private static Personnel getCurrentPersonnel() {
		Personnel pers = new Personnel();
		
		pers.setArchive(addPersonnelView.getArchiveChckbx().isSelected());
		pers.setMotPasse(addPersonnelView.getPasswordField().getText());
		pers.setNom(addPersonnelView.getNomTextField().getText());
		System.out.println();
		pers.setRole(addPersonnelView.getAdminRdbtn().isSelected() ? "adm" : addPersonnelView.getSecretaireRdbtn().isSelected() ? "sec" : "vet");
		
		return pers;
	}

	public static void reinitPasswordPersonnel() {
		if(!view.getTable(allPersonnel).getSelectionModel().isSelectionEmpty()) {
		    JFrame f=new JFrame();   
		    String password=JOptionPane.showInputDialog(f,"Réinitialisez le mot de passe de " + allPersonnel.get(selectedRow).getNom() + ".");   
			if(password != null && !password.chars().allMatch(Character::isWhitespace)) {
				Personnel pers = allPersonnel.get(selectedRow);
				pers.setMotPasse(password);
				try {
					personnelManager.updatePersonnel(pers);
				} catch (BLLException e1) {
					JOptionPane.showMessageDialog(null, "Erreur lors de la modification du mot de passe !");
				}
				miseAJourDesDonnees();
			}	
		}		
	}

	public static void changeSelectPersonnel() {
        selectedRow = view.getTable(allPersonnel).getSelectedRow();
	}
	
}
