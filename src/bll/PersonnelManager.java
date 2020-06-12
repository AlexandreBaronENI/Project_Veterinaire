package bll;

import java.sql.SQLException;
import java.util.List;

import bo.Personnel;
import dal.DAOFactory;
import dal.PersonnelDAO;

public class PersonnelManager {

	private PersonnelDAO daoPersonnel;
	private static PersonnelManager instance;
	
	private PersonnelManager() throws SQLException {
		daoPersonnel = DAOFactory.getPersonnelDAO();
	}
	
	public static PersonnelManager getInstance(){
		if (instance == null) {
			try {
				instance = new PersonnelManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public void addPersonnel(Personnel pers) throws BLLException {
		validerPersonnel(pers);
		try {
			daoPersonnel.insert(pers);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Personnel> getAllPersonnel(){
		try {
			return daoPersonnel.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePersonnel(Personnel pers) throws BLLException {
			validerPersonnel(pers);
			try {
				daoPersonnel.update(pers);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void removePersonnel(Integer idPersonnel) {
		try {
			daoPersonnel.delete(idPersonnel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Personnel getPersonnel(Integer idPersonnel) {
		try {
			return daoPersonnel.selectById(idPersonnel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Personnel getPersonnel(String nom, String password) {
		try {
			return daoPersonnel.selectByLog(nom, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void validerPersonnel(Personnel pers) throws BLLException {
		if (pers == null) {
			throw new BLLException("Personnel can't null");
		}
		boolean ok = true;

		StringBuilder msgErrors = new StringBuilder("\n");
		
		if(pers.getMotPasse() == null || pers.getMotPasse().trim().length() == 0) {
			msgErrors.append("MotPasse can't be null\n");
			ok = false;
		}
		
		if(pers.getNom() == null || pers.getNom().trim().length() == 0) {
			msgErrors.append("Nom can't be null\n");
			ok = false;
		}
		
		if(pers.getRole() == null || pers.getRole().trim().length() == 0) {
			msgErrors.append("Role can't be null\n");
			ok = false;
		}

		if (!ok) {
			throw new BLLException(msgErrors.toString());
		}
	}

}
