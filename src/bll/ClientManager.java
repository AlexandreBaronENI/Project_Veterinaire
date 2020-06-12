package bll;

import java.sql.SQLException;
import java.util.List;

import bo.Client;
import dal.DAOFactory;
import dal.ClientDAO;

public class ClientManager {

	private ClientDAO daoClient;
	private static ClientManager instance;
	
	private ClientManager() throws SQLException {
		daoClient = DAOFactory.getClientDAO();
	}
	
	public static ClientManager getInstance(){
		if (instance == null) {
			try {
				instance = new ClientManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public void addClient(Client cli) throws BLLException {
		validerClient(cli);
		try {
			daoClient.insert(cli);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Client> getAllClient(){
		try {
			return daoClient.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateClient(Client cli) throws BLLException {
			validerClient(cli);
			try {
				daoClient.update(cli);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void removeClient(Integer idClient) {
		try {
			daoClient.delete(idClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Client getClient(Integer idClient) {
		try {
			return daoClient.selectById(idClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Client> getClient(String name) {
		try {
			return daoClient.selectByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void validerClient(Client cli) throws BLLException {
		if (cli == null) {
			throw new BLLException("Client can't null");
		}
		boolean ok = true;

		StringBuilder msgErrors = new StringBuilder("\n");

		if(cli.getAdresse1() == null || cli.getAdresse1().trim().length() == 0) {
			msgErrors.append("Adresse 1 can't be null\n");
			ok = false;
		}
		if(cli.getAssurance() == null || cli.getAssurance().trim().length() == 0) {
			msgErrors.append("Assurance can't be null\n");
			ok = false;
		}
		if(cli.getCodePostal() == null || cli.getCodePostal().trim().length() == 0) {
			msgErrors.append("Code postal can't be null\n");
			ok = false;
		}
		if(cli.getEmail() == null || cli.getEmail().trim().length() == 0) {
			msgErrors.append("Email can't be null\n");
			ok = false;
		}
		if(cli.getNomClient() == null || cli.getNomClient().trim().length() == 0) {
			msgErrors.append("Nom can't be null\n");
			ok = false;
		}
		if(cli.getPrenomClient() == null || cli.getPrenomClient().trim().length() == 0) {
			msgErrors.append("Prenom can't be null\n");
			ok = false;
		}
		if(cli.getNumTel() == null || cli.getNumTel().trim().length() == 0) {
			msgErrors.append("Num tel can't be null\n");
			ok = false;
		}
		if(cli.getVille() == null || cli.getVille().trim().length() == 0) {
			msgErrors.append("Ville tel can't be null\n");
			ok = false;
		}

		if (!ok) {
			throw new BLLException(msgErrors.toString());
		}
	}

	public int getNextId() throws SQLException {
		return daoClient.selectAutoIncrement();
	}

}
