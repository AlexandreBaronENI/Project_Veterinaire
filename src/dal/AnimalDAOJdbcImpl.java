package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import bo.Animal;
import bo.Client;
import dal.jdbc.JdbcTools;

public class AnimalDAOJdbcImpl implements AnimalDAO{

	private Connection conn;
	   
	   
	public AnimalDAOJdbcImpl() throws SQLException {
		this.conn = JdbcTools.getConnection();
	}

	public Animal selectById(int idAnimal) throws SQLException {

		Animal anm = null;
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM Animaux Where CodeAnimal = ?");
		stm.setInt(1, idAnimal);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			anm = mapping(rs);
			return anm;
		} 
		return anm;
	}
	
	public List<Animal> selectAll() {
		
		List<Animal> listeAnimaux = new ArrayList<>();
		
		String query = "SELECT * FROM Animaux";

	    Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			Animal anm = null;
			while (rs.next())
			{
				anm = mapping(rs);
				listeAnimaux.add(anm);
			}
			return listeAnimaux;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeAnimaux;
	}
	
	public List<Animal> selectAllByCli(int idAnimal) {

		List<Animal> listeAnimaux = new ArrayList<Animal>();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM Animaux Where CodeClient = ?");
			stm.setInt(1, idAnimal);
			ResultSet rs = stm.executeQuery();
			Animal anm = null;
			while (rs.next())
			{
				anm = mapping(rs);
				listeAnimaux.add(anm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeAnimaux;
	}
	
	public void update(Animal anm) {
		
		PreparedStatement st;
		try {
			st = conn.prepareStatement("UPDATE `veterinaire_db`.`animaux`" + 
					"SET " + 
					"`CodeAnimal` = ?, " + 
					"`NomAnimal` = ?, " + 
					"`Sexe` = ?, " + 
					"`Couleur` = ?, " + 
					"`Race` = ?, " + 
					"`Espece` = ?, " + 
					"`CodeClient` = ?, " + 
					"`Tatouage` = ?, " + 
					"`Antecedents` = ?, " + 
					"`Archive` = ? " + 
					"WHERE `CodeAnimal` = ?;");
				setParameter(st, anm);
				st.setInt(11, anm.getCodeAnimal());
				st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Animal anm) {
		PreparedStatement st;
		try {
			st = conn.prepareStatement("INSERT INTO `veterinaire_db`.`animaux`" + 
					"(`CodeAnimal`, " + 
					"`NomAnimal`, " + 
					"`Sexe`, " + 
					"`Couleur`, " + 
					"`Race`, " + 
					"`Espece`, " + 
					"`CodeClient`, " + 
					"`Tatouage`, " + 
					"`Antecedents`, " + 
					"`Archive`) " + 
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
				setParameter(st, anm);
				System.out.println(st);
				int nbEnr = st.executeUpdate();
				if (nbEnr == 1) {
					// Pour récupérer l'identity généré
					ResultSet rs = st.getGeneratedKeys();
					if (rs.next()) {
						int id = rs.getInt(1);
						anm.setCodeAnimal(id);// Mise à jour de l'attribut id
					}
				} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void delete(int idPers) throws SQLException {
				
		String query = "DELETE FROM `veterinaire_db`.`animaux` " + 
				"WHERE `CodeAnimal` = ?;";

	    PreparedStatement st = conn.prepareStatement(query);
		try {
			st.setInt(1, idPers);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void setParameter(PreparedStatement stm, Animal anm) throws SQLException {
		stm.setLong(1, anm.getCodeAnimal());
		stm.setString(2, anm.getNomAnimal());
		stm.setString(3, anm.getSexe());
		stm.setString(4, anm.getCouleur());
		stm.setString(5, anm.getRace());
		stm.setString(6, anm.getEspece());
		stm.setLong(7, anm.getCodeClient());
		stm.setString(8, anm.getTatouage());
		stm.setString(9, anm.getAntecedents());
		stm.setBoolean(10, anm.isArchive());	
	}
	
	// transform rs to Animal
	private Animal mapping(ResultSet rs) throws SQLException {
		Animal anm = null;
		int codeAnimal = rs.getInt("codeAnimal");
		int codeClient = rs.getInt("codeClient");
		String nomAnimal = rs.getString("nomAnimal");
		String sexe = rs.getString("sexe");
		String couleur = rs.getString("couleur");
		String race = rs.getString("race");
		String espece = rs.getString("espece");
		String tatouage = rs.getString("tatouage");
		String antecedents = rs.getString("antecedents");
		boolean archive = rs.getBoolean("archive");

		anm = new Animal(codeAnimal, codeClient, nomAnimal, sexe, couleur, race, espece, tatouage, antecedents, archive);
		
		return anm;
	}

	@Override
	public int selectAutoIncrement() {
		int number = 0;
		String query = "SELECT AUTO_INCREMENT FROM information_schema.TABLES where TABLE_NAME = \"animaux\"";

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

	@Override
	public void deleteByClient(int codeClient) {	
		String query = "DELETE FROM `veterinaire_db`.`animaux` " + 
				"WHERE `CodeClient` = ?;";

		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, codeClient);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
