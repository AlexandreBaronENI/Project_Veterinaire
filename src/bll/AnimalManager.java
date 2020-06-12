package bll;

import java.sql.SQLException;
import java.util.List;

import bo.Animal;
import dal.DAOFactory;
import dal.AnimalDAO;

public class AnimalManager {

	private AnimalDAO daoAnimal;
	private static AnimalManager instance;
	
	private AnimalManager() throws SQLException {
		daoAnimal = DAOFactory.getAnimalDAO();
	}
	
	public static AnimalManager getInstance(){
		if (instance == null) {
			try {
				instance = new AnimalManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public void addAnimal(Animal anm) throws BLLException {
		validerAnimal(anm);
		try {
			daoAnimal.insert(anm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Animal> getAnimaux(){
		try {
			return daoAnimal.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Animal> getAnimauxOfClient(int idClient){
		try {
			return daoAnimal.selectAllByCli(idClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateAnimal(Animal anm) throws BLLException {
			validerAnimal(anm);
			try {
				daoAnimal.update(anm);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void removeAnimal(Integer idAnimal) {
		try {
			daoAnimal.delete(idAnimal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Animal getAnimal(Integer idAnimal) {
		try {
			return daoAnimal.selectById(idAnimal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void validerAnimal(Animal anm) throws BLLException {
		if (anm == null) {
			throw new BLLException("Animal can't be null");
		}
		boolean ok = true;

		StringBuilder msgErrors = new StringBuilder("\n");
		
		if(anm.getCouleur() == null || anm.getCouleur().trim().length() == 0) {
			msgErrors.append("Couleur can't be null\n");
			ok = false;
		}
		
		if(anm.getEspece() == null || anm.getEspece().trim().length() == 0) {
			msgErrors.append("Espece can't be null\n");
			ok = false;
		}
		
		if(anm.getNomAnimal() == null || anm.getNomAnimal().trim().length() == 0) {
			msgErrors.append("Nom can't be null\n");
			ok = false;
		}
		
		if(anm.getRace() == null || anm.getRace().trim().length() == 0) {
			msgErrors.append("Race can't be null\n");
			ok = false;
		}	

		if (!ok) {
			throw new BLLException(msgErrors.toString());
		}
	}
	
	public int getNextId() throws SQLException {
		return daoAnimal.selectAutoIncrement();
	}

	public void removeAnimaux(int codeClient) {
		daoAnimal.deleteByClient(codeClient);
	}

}
