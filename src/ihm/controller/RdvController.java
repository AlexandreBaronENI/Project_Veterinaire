package ihm.controller;

import java.awt.EventQueue;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import bll.AnimalManager;
import bll.BLLException;
import bll.ClientManager;
import bll.PersonnelManager;
import bll.RdvManager;
import bo.Animal;
import bo.Client;
import bo.Personnel;
import bo.Rdv;
import ihm.view.RdvView;
import ihm.view.component.TableAllRdvModel;

public class RdvController {
	static RdvView view;
	private static PersonnelManager personnelManager;
	private static ClientManager clientManager;
	private static AnimalManager animalManager;
	private static RdvManager rdvManager;
	private static List<Rdv> allrdv;
	private static List<Client> allClients;
	private static List<Animal> allAnimaux;
	private static List<Personnel> allPersonnel;
	
	public static String[] hours = {"07","08","09","10","11","12","13","14","15","16","17","18","19"};
	public static String[] minutes = {"00","15","30","45"};
			
	public RdvController(List<Rdv> listRdv) {
		personnelManager = PersonnelManager.getInstance();
		clientManager = ClientManager.getInstance();
		animalManager = AnimalManager.getInstance();
		rdvManager = RdvManager.getInstance();

		allPersonnel = personnelManager.getAllPersonnel().stream().filter(p -> p.getRole().equals("vet")).collect(Collectors.toList());
		
		listRdv.forEach(r -> r.setClient(clientManager.getClient(animalManager.getAnimal(r.getCodeAnimal()).getCodeClient())));
		listRdv.forEach(r -> r.setAnimal(animalManager.getAnimal(r.getCodeAnimal())));
		listRdv.forEach(r -> r.setVeto(personnelManager.getPersonnel(r.getCodePersonnel())));
		view = new RdvView(listRdv);
		allrdv = listRdv;
	}

	public static String[] getVetoList() {
		List<String> vetos = allPersonnel.stream().map(v -> v.getNom()).collect(Collectors.toList());
		vetos.removeAll(Collections.singleton(null));
		String[] vetosArray = new String[vetos.size()];
		int i = 0;
		for(Personnel pers: allPersonnel) {
			if(pers.getRole().equals("vet")) {
				vetosArray[i] = pers.getNom();
				i++;
			}
		}
		return vetosArray;
	}

	public static String[] getClientList() {
		allClients = clientManager.getAllClient();
		String[] clientsArray = new String[allClients.size()];
		int i = 0;
		for(Client cli: allClients) {
			clientsArray[i] = cli.getPrenomClient() + " " +cli.getNomClient();
			i++;
		}
		return clientsArray;
	}

	public static String[] getAnimauxList() {
		allAnimaux = animalManager.getAnimaux();
		String[] animauxArray = new String[allAnimaux.size()];
		int i = 0;
		for(Animal anm: allAnimaux) {
			animauxArray[i] = anm.getNomAnimal();
			i++;
		}
		return animauxArray;
	}
	
	private static void miseAJourDesDonnees(List<Rdv> listRdv) {
		listRdv.forEach(r -> r.setClient(clientManager.getClient(animalManager.getAnimal(r.getCodeAnimal()).getCodeClient())));
		listRdv.forEach(r -> r.setAnimal(animalManager.getAnimal(r.getCodeAnimal())));
		listRdv.forEach(r -> r.setVeto(personnelManager.getPersonnel(r.getCodePersonnel())));
		allrdv = listRdv;
		view.getTable(allrdv).setModel(new TableAllRdvModel(listRdv));
	}

	public static void addAnimal() {
		new AnimalController(clientManager.getClient(allClients.get(view.getComboBoxClient().getSelectedIndex()).getCodeClient()).getCodeClient());
		miseAJourDesDonnees(allrdv);
	}

	public static void addClient() {
		new ClientsController().add();
		miseAJourDesDonnees(allrdv);
	}

	public static void addRdv() {
		String date = view.getTextFielDate().getText() + " " + view.getComboBoxHour().getSelectedItem() + ":" + view.getComboBoxMinutes().getSelectedItem() + ":00";
		System.out.println(allPersonnel.get(view.getComboBoxClient().getSelectedIndex()).getCodePers());
		Rdv rdv = new Rdv(
				date,
				animalManager.getAnimal(allAnimaux.get(view.getComboBoxAnimaux().getSelectedIndex()).getCodeAnimal()).getCodeAnimal(),
				personnelManager.getPersonnel(allPersonnel.get(view.getComboBoxClient().getSelectedIndex()).getCodePers()).getCodePers());
		System.out.println(rdv);
		System.out.println(allPersonnel);
		if(date.matches("[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]")) {
			try {
				rdvManager.addRdv(rdv);
				allrdv.add(rdv);
			}catch (BLLException e) {
				e.printStackTrace();
			}
			miseAJourDesDonnees(allrdv);
		}else {
			JOptionPane.showMessageDialog(null, "Informations invalides, merci de bien compléter les champs, la date doit être au format YYYY-MM-DD !");
		}
	}

	public static void remove() {
		if(!view.getTable(allrdv).getSelectionModel().isSelectionEmpty()) {
			int selectedRow = view.getTable(allrdv).getSelectedRow();
			int choice = JOptionPane.showConfirmDialog(null, "Êtes vous sûr de vouloir supprimer ce rendez vous ?");
			if(choice == 0) {
				rdvManager.removeRdv(allrdv.get(selectedRow));
				allrdv.remove(selectedRow);
				miseAJourDesDonnees(allrdv);
			}	
		}
	}
	
	

}
