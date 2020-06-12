package bll;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import bo.Rdv;
import dal.DAOFactory;
import dal.RdvDAO;

public class RdvManager {

	private RdvDAO daoRdv;
	private static RdvManager instance;
	
	private RdvManager() throws SQLException {
		daoRdv = DAOFactory.getRdvDAO();
	}
	
	public static RdvManager getInstance(){
		if (instance == null) {
			try {
				instance = new RdvManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public void addRdv(Rdv rdv) throws BLLException {
		validerRdv(rdv);
		try {
			daoRdv.insert(rdv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Rdv> getAllRdv(){
		try {
			return daoRdv.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Rdv> getAllRdv(int codeVeto, Date date){
		try {
			return daoRdv.select(codeVeto, date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Rdv> getAllRdv(Date date){
		try {
			return daoRdv.select(date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void removeRdv(Rdv rdv) {
		try {
			daoRdv.delete(rdv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeRdv(int code, boolean isAnimal) {
		try {
			daoRdv.delete(code, isAnimal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Rdv getRdv(Rdv rdv) {
		try {
			return daoRdv.select(rdv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void validerRdv(Rdv rdv) throws BLLException {
		if (rdv == null) {
			throw new BLLException("Rdv can't be null");
		}
		boolean ok = true;

		StringBuilder msgErrors = new StringBuilder("\n");
		/*
		if(rdv.getCouleur() == null || rdv.getCouleur().trim().length() == 0) {
			msgErrors.append("Couleur can't be null\n");
			ok = false;
		}
		
		if(rdv.getEspece() == null || rdv.getEspece().trim().length() == 0) {
			msgErrors.append("Espece can't be null\n");
			ok = false;
		}
		
		if(rdv.getNomRdv() == null || rdv.getNomRdv().trim().length() == 0) {
			msgErrors.append("Nom can't be null\n");
			ok = false;
		}
		
		if(rdv.getRace() == null || rdv.getRace().trim().length() == 0) {
			msgErrors.append("Race can't be null\n");
			ok = false;
		}	*/

		if (!ok) {
			throw new BLLException(msgErrors.toString());
		}
	}
}
