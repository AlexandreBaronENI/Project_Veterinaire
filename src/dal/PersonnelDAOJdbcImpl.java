package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import bo.Personnel;
import dal.jdbc.JdbcTools;

public class PersonnelDAOJdbcImpl implements PersonnelDAO{

	private Connection conn;
	   
	   
	public PersonnelDAOJdbcImpl() throws SQLException {
		this.conn = JdbcTools.getConnection();
	}

	public Personnel selectById(int idPers) throws SQLException {

		Personnel pers = null;
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM Personnels Where CodePers = ?");
		stm.setInt(1, idPers);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			pers = mapping(rs);
			return pers;
		} 
		return pers;
	}

	public Personnel selectByLog(String nom, String password) throws SQLException {

		Personnel pers = null;
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM Personnels Where Nom = ? AND MotPasse = ?");
		stm.setString(1, nom);
		stm.setString(2, password);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			pers = mapping(rs);
			return pers;
		} 
		return pers;
	}
	
	public List<Personnel> selectAll() {
		
		List<Personnel> listePersonnel = new ArrayList<>();
		
		String query = "SELECT * FROM Personnels";

	    Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			Personnel pers = null;
			while (rs.next())
			{
				pers = mapping(rs);
				listePersonnel.add(pers);
			}
			return listePersonnel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listePersonnel;
	}
	
	public void update(Personnel pers) {
		
		PreparedStatement st;
		try {
			st = conn.prepareStatement("UPDATE `veterinaire_db`.`personnels`" + 
					"SET " + 
					"`CodePers` = ?, " + 
					"`Nom` = ?, " + 
					"`MotPasse` = ?, " + 
					"`Role` = ?, " + 
					"`Archive` = ? " + 
					"WHERE `CodePers` = ?;");
				setParameter(st, pers);
				st.setInt(6, pers.getCodePers());
				st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Personnel pers) {
		PreparedStatement st;
		try {
			st = conn.prepareStatement("INSERT INTO `veterinaire_db`.`personnels`" + 
					"(`CodePers`, " + 
					"`Nom`, " + 
					"`MotPasse`, " + 
					"`Role`, " + 
					"`Archive`) " + 
					"VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
				setParameter(st, pers);
				int nbEnr = st.executeUpdate();
				if (nbEnr == 1) {
					// Pour récupérer l'identity généré
					ResultSet rs = st.getGeneratedKeys();
					if (rs.next()) {
						int id = rs.getInt(1);
						pers.setCodePers(id);// Mise à jour de l'attribut id
					}
				} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void delete(int idPers) throws SQLException {
				
		String query = "DELETE FROM `veterinaire_db`.`personnels` " + 
				"WHERE `CodePers` = ?;";

	    PreparedStatement st = conn.prepareStatement(query);
		try {
			st.setInt(1, idPers);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void setParameter(PreparedStatement stm, Personnel pers) throws SQLException {
		stm.setLong(1, pers.getCodePers());
		stm.setString(2, pers.getNom());
		stm.setString(3, pers.getMotPasse());
		stm.setString(4, pers.getRole());
		stm.setBoolean(5, pers.isArchive());	
	}
	
	// transform rs to Personnel
	private Personnel mapping(ResultSet rs) throws SQLException {
		Personnel pers = null;
		int codePers = rs.getInt("codePers");
		String nom = rs.getString("nom").trim();
		String motPasse = rs.getString("motPasse").trim();
		String role = rs.getString("role").trim();
		boolean archive = rs.getBoolean("archive");

		pers = new Personnel(codePers, nom, motPasse, role, archive);
		
		return pers;
	}
}
