package ihm.controller;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bll.AnimalManager;
import bll.BLLException;
import bll.ClientManager;
import bll.PersonnelManager;
import bll.RdvManager;
import bo.Animal;
import bo.Client;
import bo.Personnel;
import ihm.view.AnimalView;

public class AnimalController {
	private static AnimalManager animalManager;
	private static ClientManager clientManager;
	private static RdvManager rdvManager;
	private static AnimalView view;
	public static String[] espece = {"Chien", "Chat"};
	public static String[] races = {"Berger allemand", "Berger australien", "Caniche"};
	public static String[] sexe = {"Male", "Femelle", "Hermaphrodite"};
	public static Client client;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalController controller = new AnimalController(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public AnimalController() {
		clientManager = ClientManager.getInstance();
		animalManager = AnimalManager.getInstance();
		rdvManager = RdvManager.getInstance();
	}
	
	public AnimalController(int idClient) {
		client = clientManager.getClient(idClient);
		view = new AnimalView(false);
		view.getLblClient().setText("Client :" + client.getNomClient() + " " +client.getPrenomClient());
		try {
			view.getCode().setText(String.valueOf(Integer.valueOf(animalManager.getNextId())));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public AnimalController(int idClient, int idAnimal) {
		client = clientManager.getClient(idClient);
		Animal anm = animalManager.getAnimal(idAnimal);
		view = new AnimalView(true);
		view.getLblClient().setText("Client :" + client.getNomClient() + " " +client.getPrenomClient());
		view.getCode().setText(String.valueOf(idAnimal));
		view.getNomTextField().setText(anm.getNomAnimal());
		view.getSexeComboBox().setSelectedItem(anm.getNomAnimal());
		view.getCouleurTextField().setText(anm.getCouleur());
		view.getEspeceComboBox().setSelectedItem(anm.getEspece());
		view.getRaceComboBox().setSelectedItem(anm.getRace());
		view.getTatouageTextField().setText(anm.getTatouage());
	}

	private static Animal getCurrentAnimal() {
		Animal anm = new Animal();
		
		anm.setCodeAnimal(Integer.valueOf(view.getCode().getText()));
		anm.setArchive(false);
		anm.setAntecedents(null);
		anm.setCodeClient(client.getCodeClient());
		anm.setCouleur(view.getCouleurTextField().getText());
		anm.setEspece(espece[view.getEspeceComboBox().getSelectedIndex()]);
		anm.setNomAnimal(view.getNomTextField().getText());
		anm.setRace(races[view.getRaceComboBox().getSelectedIndex()]);
		anm.setSexe(view.getSexeComboBox().getSelectedItem() == sexe[0] ? "M" : view.getSexeComboBox().getSelectedItem() == sexe[1] ? "F" : "H");
		anm.setTatouage(view.getTatouageTextField().getText());
		
		return anm;
	}
	
	public static void add() {
		Animal anm = getCurrentAnimal();
		try {
			animalManager.addAnimal(anm);
			JOptionPane.showMessageDialog(null, anm.getNomAnimal() + " a bien été ajouté aux animaux !");
			ClientsController.miseAJourDesDonnees(client.getCodeClient());
			view.dispose();
		} catch (BLLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Informations invalides, merci de bien compléter les champs !");
		}
	}
	
	public static void edit() {
		Animal anm = getCurrentAnimal();
		try {
			animalManager.updateAnimal(anm);
			JOptionPane.showMessageDialog(null, anm.getNomAnimal() + " a bien été modifié !");
			ClientsController.miseAJourDesDonnees(client.getCodeClient());
			view.dispose();
		} catch (BLLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Informations invalides, merci de bien compléter les champs !");
		}
	}


	public static void removeAnimal() {
		if(!ClientsController.view.getTable(animalManager.getAnimauxOfClient(client.getCodeClient())).getSelectionModel().isSelectionEmpty()) {
			int selectedRow = ClientsController.view.getTable(animalManager.getAnimauxOfClient(client.getCodeClient())).getSelectedRow();
			int choice = JOptionPane.showConfirmDialog(null, "Êtes vous sûr de vouloir supprimer " + animalManager.getAnimaux().get(selectedRow).getNomAnimal() + " ?");
			if(choice == 0) {
				int codeAnimal = animalManager.getAnimauxOfClient(client.getCodeClient()).get(selectedRow).getCodeAnimal();
				rdvManager.removeRdv(codeAnimal, true);;
				animalManager.removeAnimal(codeAnimal);
				ClientsController.miseAJourDesDonnees(client.getCodeClient());
			}	
		}
	}
	public static void cancel() {
		view.dispose();
	}
}
