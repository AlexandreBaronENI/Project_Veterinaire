package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.Animal;
import bo.Client;
import dal.jdbc.JdbcTools;

public class ClientDAOJdbcImpl implements ClientDAO{

	private Connection conn;
	   
	   
	public ClientDAOJdbcImpl() throws SQLException {
		this.conn = JdbcTools.getConnection();
	}

	public Client selectById(int idClient) throws SQLException {

		Client cli = null;
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM clients Where CodeClient = ?");
		stm.setInt(1, idClient);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			cli = mapping(rs);
			return cli;
		} 
		return cli;
	}
	
	public List<Client> selectAll() {
		
		List<Client> listeClients = new ArrayList<>();
		
		String query = "SELECT * FROM Clients";

	    Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			Client cli = null;
			while (rs.next())
			{
				cli = mapping(rs);
				listeClients.add(cli);
			}
			return listeClients;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeClients;
	}
	
	public void update(Client cli) {
		
		PreparedStatement st;
		try {
			st = conn.prepareStatement("UPDATE `veterinaire_db`.`clients`" + 
					"SET " + 
					"`CodeClient` = ?, " + 
					"`NomClient` = ?, " + 
					"`PrenomClient` = ?, " + 
					"`Adresse1` = ?, " + 
					"`Adresse2` = ?, " + 
					"`CodePostal` = ?, " + 
					"`Ville` = ?, " + 
					"`NumTel` = ?, " + 
					"`Assurance` = ?, " + 
					"`Email` = ?, " + 
					"`Remarque` = ?, " + 
					"`Archive` = ? " + 
					"WHERE `CodeClient` = ?;");
				setParameter(st, cli);
				st.setInt(13, cli.getCodeClient());
				st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Client cli) {
		PreparedStatement st;
		try {
			st = conn.prepareStatement("INSERT INTO `veterinaire_db`.`clients`" + 
					"(`CodeClient`," + 
					"`NomClient`," + 
					"`PrenomClient`," + 
					"`Adresse1`," + 
					"`Adresse2`," + 
					"`CodePostal`," + 
					"`Ville`," + 
					"`NumTel`," + 
					"`Assurance`," + 
					"`Email`," + 
					"`Remarque`," + 
					"`Archive`)" + 
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
				setParameter(st, cli);
				int nbEnr = st.executeUpdate();
				if (nbEnr == 1) {
					// Pour récupérer l'identity généré
					ResultSet rs = st.getGeneratedKeys();
					if (rs.next()) {
						int id = rs.getInt(1);
						cli.setCodeClient(id);// Mise à jour de l'attribut id
					}
				} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void delete(int idPers) throws SQLException {
				
		String query = "DELETE FROM `veterinaire_db`.`clients` " + 
				"WHERE `CodeClient` = ?;";

	    PreparedStatement st = conn.prepareStatement(query);
		try {
			st.setInt(1, idPers);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void setParameter(PreparedStatement stm, Client cli) throws SQLException {
		stm.setLong(1, cli.getCodeClient());
		stm.setString(2, cli.getNomClient());	
		stm.setString(3, cli.getPrenomClient());	
		stm.setString(4, cli.getAdresse1());	
		stm.setString(5, cli.getAdresse2());	
		stm.setString(6, cli.getCodePostal());
		stm.setString(7, cli.getVille());
		stm.setString(8, cli.getNumTel());
		stm.setString(9, cli.getAssurance());
		stm.setString(10, cli.getEmail());
		stm.setString(11, cli.getRemarque());
		stm.setBoolean(12, cli.isArchive());	
	}
	
	// transform rs to Client
	private Client mapping(ResultSet rs) throws SQLException {
		Client cli = null;
		int codeClient = rs.getInt("codeClient");
		String nomClient = rs.getString("nomClient");
		String prenomClient = rs.getString("prenomClient");
		String adresse1 = rs.getString("adresse1");
		String adresse2 = rs.getString("adresse2");
		String codePostal = rs.getString("codePostal");
		String ville = rs.getString("ville");
		String numTel = rs.getString("numTel");
		String assurance = rs.getString("assurance");
		String email = rs.getString("email");
		String remarque = rs.getString("remarque");
		boolean archive = rs.getBoolean("archive");

		cli = new Client(codeClient, nomClient, prenomClient, adresse1, adresse2, codePostal, ville, numTel, assurance, email, remarque, archive);
		
		return cli;
	}

	@Override
	public List<Client> selectByName(String name) throws SQLException {
		
		List<Client> listeClients = new ArrayList<>();
				try {
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM Clients where nomclient like ? or prenomclient like ?");

		stm.setString(1, name+'%');
		stm.setString(2, name+'%');
		ResultSet rs = stm.executeQuery();
		Client cli= null;
		while (rs.next())
		{
			cli = mapping(rs);
			listeClients.add(cli);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				System.out.println(listeClients);
		return listeClients;
	}

	@Override
	public int selectAutoIncrement() {
		int number = 0;
		String query = "SELECT AUTO_INCREMENT FROM information_schema.TABLES where TABLE_NAME = \"clients\"";

	    Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			Client cli = null;
			if (rs.next())
			{
				number = rs.getInt("AUTO_INCREMENT");
				return number;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return number;
	}
}
