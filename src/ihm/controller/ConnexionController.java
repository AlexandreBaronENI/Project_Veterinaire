package ihm.controller;

import java.awt.EventQueue;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import bll.BLLException;
import bll.PersonnelManager;
import bll.RdvManager;
import bo.Personnel;
import bo.Rdv;
import ihm.view.ConnexionView;

public class ConnexionController {
	
	private static ConnexionView view;
    int indexCatalogue = 0;
    private List < Personnel > catalogue;
	private static PersonnelManager personnelManager;
	private static RdvManager rdvManager;
	private static List<Rdv> listRdv;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionController controller = new ConnexionController();
					controller.showScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ConnexionController() {
		view = new ConnexionView();
	}
	
    public void initData() throws BLLException {
        personnelManager = PersonnelManager.getInstance();
        rdvManager = RdvManager.getInstance();
        catalogue = personnelManager.getAllPersonnel();
    }
    
    private void showPersonnel(Personnel pers) {
        String motPasse = "", nom = "";

        view.getPasswordField().setText(motPasse);
        view.getNomTextField().setText(nom);
    }

	public static void login() {
		Personnel pers = getCurrentPersonnel();
		
		pers = personnelManager.getPersonnel(pers.getNom(), pers.getMotPasse());
		if(pers==null) {
			JOptionPane.showMessageDialog(null, "Connexion impossible, veuillez vérifier le nom ou le mot de passe !");
		}else {
			view.dispose();
			switch(pers.getRole()) {
			case Personnel.SECRETAIRE:
				java.sql.Date dd = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				listRdv = rdvManager.getAllRdv(dd);
				System.out.println(listRdv);
				RdvController rdvController = new RdvController(listRdv);
				break;

			case Personnel.ADMIN:
				AdminController adminController = new AdminController();
				break;

			case Personnel.VETERINAIRE:
				listRdv = rdvManager.getAllRdv(pers.getCodePers(), new java.sql.Date(Calendar.getInstance().getTime().getTime()));
				AgendaController agendaController = new AgendaController(listRdv, pers);
				break;
			}
		}
	}
    
	private static Personnel getCurrentPersonnel() {
		Personnel pers = new Personnel();
		
		pers.setNom(view.getNomTextField().getText());
		pers.setMotPasse(view.getPasswordField().getText());
		
		return pers;
	}

    public void showScreen() {
        try {
            initData();

            if (catalogue.size() > 0) {
            	indexCatalogue = 0;
                showPersonnel(catalogue.get(indexCatalogue));
            }
        } catch (BLLException e) {
            e.printStackTrace();
        }
    }
}
