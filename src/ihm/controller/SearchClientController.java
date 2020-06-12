package ihm.controller;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bll.AnimalManager;
import bll.BLLException;
import bll.ClientManager;
import bll.PersonnelManager;
import bo.Animal;
import bo.Client;
import bo.Personnel;
import ihm.view.AddPersonnelView;
import ihm.view.AdminView;
import ihm.view.SearchClientView;
import ihm.view.component.TableAllClientsModel;
import ihm.view.component.TableAllPersonnelModel;

public class SearchClientController {
	private static SearchClientView view;
	private static ClientManager clientManager;
	private static AnimalManager animalManager;
    private static List < Client > clients;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchClientController controller = new SearchClientController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
    
	public SearchClientController() {
    	clientManager = ClientManager.getInstance();
        clients = clientManager.getAllClient();
        animalManager = AnimalManager.getInstance();
		view = new SearchClientView(clients);
	}

	public static void miseAJourDesDonnees(List<Client> listClients) {
		view.getTableClients(clients).setModel(new TableAllClientsModel(listClients));
	}
	
	public static void search() {
		String name = view.getNameTextField().getText();
		if(name != null && !name.chars().allMatch(Character::isWhitespace)) {
			List<Client> listClients = clientManager.getClient(name);
			miseAJourDesDonnees(listClients);
		}		
	}
	
	public static void select() {
		int idClient;
		if(!view.getTableClients(clients).getSelectionModel().isSelectionEmpty()) {
		    idClient = (int)view.getTableClients(clients).getValueAt(view.getTableClients(clients).getSelectedRow(), 0);
		    new ClientsController().show(idClient);
		    view.dispose();
		}		
	}
}
