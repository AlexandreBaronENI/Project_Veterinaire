package ihm.controller;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import bll.AnimalManager;
import bll.BLLException;
import bll.ClientManager;
import bll.PersonnelManager;
import bll.RdvManager;
import bo.Animal;
import bo.Client;
import bo.Personnel;
import ihm.view.AddClientView;
import ihm.view.AddPersonnelView;
import ihm.view.ClientView;
import ihm.view.component.TableAllAnimalsModel;
import ihm.view.component.TableAllClientsModel;

public class ClientsController {
	static ClientView view;
	static AddClientView addClientView;
	private static RdvManager rdvManager;
	private static AnimalManager animalManager;
	private static ClientManager clientManager;
	private static List<Animal> animaux;
	private static int selectedRow;
	private static Client client;
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ClientsController().show(1);;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	public ClientsController() {
    	animalManager = AnimalManager.getInstance();
    	clientManager = ClientManager.getInstance();
    	rdvManager = RdvManager.getInstance();
	}
	
	public static void miseAJourDesDonnees(int idClient) {
		client = clientManager.getClient(idClient);
		animaux = animalManager.getAnimauxOfClient(client.getCodeClient());
    	view.client = clientManager.getClient(client.getCodeClient());		
    	view.getTable(ClientsController.animaux).setModel(new TableAllAnimalsModel(animaux));
    	view.getNomTextField(client).setText(client.getNomClient());
    	view.getPrenomTextField(client).setText(client.getPrenomClient());
    	view.getVilleTextField(client).setText(client.getVille());
    	view.getCodePostalTextField(client).setText(client.getCodePostal());
    	view.getCodeJLabel(client).setText(String.valueOf(client.getCodeClient()));
    	view.getChckbxArchive(client).setSelected(client.isArchive());
    	view.getEmailTextField(client).setText(client.getEmail());
    	view.getTelTextField(client).setText(client.getNumTel());
    	view.getRemarqueTextField(client).setText(client.getRemarque());
    	view.getAssuranceTextField(client).setText(client.getAssurance());
	}
	
	public static void show(int id) {
        animaux = animalManager.getAnimauxOfClient(id);
    	client = clientManager.getClient(id);
		view = new ClientView(client, animaux);
	}

	public static void addAnimal() {
		new AnimalController(client.getCodeClient());
	}

	public static void editAnimal() {
		if(!view.getTable(animaux).getSelectionModel().isSelectionEmpty()) {
			selectedRow = view.getTable(animaux).getSelectedRow(); 
			new AnimalController(client.getCodeClient(), (int)view.getTable(animaux).getValueAt(selectedRow, 0));
		}
		
	}
	
	public static void nouveau() {

		Client cli = getCurrentClient(false);
		try {
			clientManager.addClient(cli);
			JOptionPane.showMessageDialog(null, cli.getNomClient() + " a bien été ajouté aux clients !");
			ClientsController.miseAJourDesDonnees(cli.getCodeClient());
			addClientView.dispose();
		} catch (BLLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Informations invalides, merci de bien compléter les champs !");
		}
	}

	private static Client getCurrentClient(boolean edit) {
		Client cli = new Client();
		if(edit) {
			cli.setCodeClient(Integer.valueOf(view.getCodeJLabel(client).getText()));
			cli.setAdresse1(view.getAdresse1TextField(client).getText());
			cli.setAdresse2(view.getAdresse2TextField(client).getText());
			cli.setArchive(view.isActive());
			cli.setAssurance(view.getAssuranceTextField(client).getText());
			cli.setCodePostal(view.getCodePostalTextField(client).getText());
			cli.setEmail(view.getEmailTextField(client).getText());
			cli.setNomClient(view.getNomTextField(client).getText());
			cli.setNumTel(view.getTelTextField(client).getText());
			cli.setPrenomClient(view.getPrenomTextField(client).getText());
			cli.setRemarque(view.getRemarqueTextField(client).getText());
			cli.setVille(view.getVilleTextField(client).getText());
		}else {
			cli.setCodeClient(Integer.valueOf(addClientView.getLblCodeClient().getText()));
			cli.setAdresse1(addClientView.getTextFieldAdresse1().getText());
			cli.setAdresse2(addClientView.getTextFieldAdresse2().getText());
			cli.setArchive(addClientView.isActive());
			cli.setAssurance(addClientView.getTextFieldAssurance().getText());
			cli.setCodePostal(addClientView.getTextFieldCP().getText());
			cli.setEmail(addClientView.getTextFieldEmail().getText());
			cli.setNomClient(addClientView.getTextFieldNom().getText());
			cli.setNumTel(addClientView.getTextFieldTel().getText());
			cli.setPrenomClient(addClientView.getTextFieldPrenom().getText());
			cli.setRemarque(addClientView.getTextFieldRemarque().getText());
			cli.setVille(addClientView.getTextFieldVille().getText());
		}
		
		return cli;
	}

	public static void add() {
		addClientView = new AddClientView();
		try {
			addClientView.getLblCodeClient().setText(String.valueOf(clientManager.getNextId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void cancel(boolean addView) {
		if(addView) {
			addClientView.dispose();	
		}else {
			view.dispose();
			new SearchClientController();
		}
	}

	public static void remove() {
		int choice = JOptionPane.showConfirmDialog(null, "Êtes vous sûr de vouloir supprimer " + client.getNomClient() + " ?");
		if(choice == 0) {
			rdvManager.removeRdv(client.getCodeClient(), false);
			animalManager.removeAnimaux(client.getCodeClient());
			clientManager.removeClient(client.getCodeClient());
			view.dispose();
			new SearchClientController();
		}	
	}

	public static void update() {
		Client cli = getCurrentClient(true);
		try {
			clientManager.updateClient(cli);
			JOptionPane.showMessageDialog(null, cli.getNomClient() + " " + cli.getPrenomClient() + " a bien été modifié !");
			ClientsController.miseAJourDesDonnees(cli.getCodeClient());
		} catch (BLLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Informations invalides, merci de bien compléter les champs !");
		}
	}
}
