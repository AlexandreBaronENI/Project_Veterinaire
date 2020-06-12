package ihm.controller;

import java.awt.EventQueue;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ComboBoxModel;

import bll.AnimalManager;
import bll.ClientManager;
import bll.PersonnelManager;
import bll.RdvManager;
import bo.Personnel;
import bo.Rdv;
import ihm.view.AgendaView;
import ihm.view.component.TableAllRdvModel;

public class AgendaController {
	static AgendaView view;
	private static PersonnelManager personnelManager;
	private static ClientManager clientManager;
	private static AnimalManager animalManager;
	private static RdvManager rdvManager;
	private static List<Rdv> allrdv;

	public AgendaController(List<Rdv> listRdv, Personnel veto) {
		personnelManager = PersonnelManager.getInstance();
		clientManager = ClientManager.getInstance();
		animalManager = AnimalManager.getInstance();
		rdvManager = RdvManager.getInstance();
		
		listRdv.forEach(r -> r.setClient(clientManager.getClient(animalManager.getAnimal(r.getCodeAnimal()).getCodeClient())));
		listRdv.forEach(r -> r.setAnimal(animalManager.getAnimal(r.getCodeAnimal())));
		listRdv.forEach(r -> r.setVeto(veto));
		view = new AgendaView(listRdv, veto);
		allrdv = listRdv;
	}

	public static String[] getVetoList() {
		List<Personnel> allPersonnel = personnelManager.getAllPersonnel();
		List<String> vetos = allPersonnel.stream().map(v -> v.getRole().equals("vet")?v.getNom():null).collect(Collectors.toList());
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

	public static void search(Personnel veto) {
		List<Rdv> listRdv = rdvManager.getAllRdv(veto.getCodePers(), Date.valueOf(view.getTextFieldDate(allrdv).getText()));
		System.out.println(listRdv);
		miseAJourDesDonnees(listRdv);
	}

	private static void miseAJourDesDonnees(List<Rdv> listRdv) {
		listRdv.forEach(r -> r.setClient(clientManager.getClient(animalManager.getAnimal(r.getCodeAnimal()).getCodeClient())));
		listRdv.forEach(r -> r.setAnimal(animalManager.getAnimal(r.getCodeAnimal())));
		listRdv.forEach(r -> r.setVeto(personnelManager.getPersonnel(r.getCodePersonnel())));
		allrdv = listRdv;
		view.getTable(allrdv).setModel(new TableAllRdvModel(listRdv));
	}

	public static void folder() {
		Rdv rdv = allrdv.get(view.getTable(allrdv).getSelectedRow());
		new DossierMedicalController(rdv);
	}
}
