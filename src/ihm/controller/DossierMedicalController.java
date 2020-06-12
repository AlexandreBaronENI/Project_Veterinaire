package ihm.controller;

import bll.AnimalManager;
import bll.BLLException;
import bo.Animal;
import bo.Rdv;
import ihm.view.DossierMedView;

public class DossierMedicalController {
	private static DossierMedView view;
	private static AnimalManager animalManager;
	private static Rdv rdv;

	public DossierMedicalController(Rdv rdv) {
		this.rdv = rdv;
		animalManager = AnimalManager.getInstance();
		view = new DossierMedView(rdv);
	}

	public static void update(Animal anm) {
		anm.setAntecedents(view.getTextPane(rdv).getText().trim());
		try {
			animalManager.updateAnimal(anm);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		view.dispose();
	}

	public static void cancel() {
		view.dispose();
	}
}
