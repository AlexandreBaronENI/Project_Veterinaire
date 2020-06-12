package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import bo.Rdv;
import bo.Client;
import dal.jdbc.JdbcTools;

public class RdvDAOJdbcImpl implements RdvDAO{

	private Connection conn;
	   
	   
	public RdvDAOJdbcImpl() throws SQLException {
		this.conn = JdbcTools.getConnection();
	}

	@Override
	public Rdv select(Rdv rdvInput) throws SQLException {
		Rdv rdv = null;
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM agendas Where DateRdv = ? and CodeVeto = ? and CodeAnimal = ?");
		stm.setString(1, rdvInput.getDateRdv());
		stm.setInt(2, rdvInput.getCodePersonnel());
		stm.setInt(3, rdvInput.getCodeAnimal());
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			rdv = mapping(rs);
			return rdv;
		} 
		return rdv;
	}

	@Override
	public List<Rdv> selectAll() throws SQLException {
		List<Rdv> listeRdv = new ArrayList<>();
		
		String query = "SELECT * FROM agendas";

	    Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			Rdv rdv = null;
			while (rs.next())
			{
				rdv = mapping(rs);
				listeRdv.add(rdv);
			}
			return listeRdv;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeRdv;
	}

	@Override
	public void insert(Rdv rdv) throws SQLException {
		PreparedStatement st;
		try {
			st = conn.prepareStatement("INSERT INTO `veterinaire_db`.`agendas`" + 
					"(`CodeVeto`," + 
					"`DateRdv`," + 
					"`CodeAnimal`)" + 
					"VALUES (?, ?, ?);");
				st.setInt(1, rdv.getCodePersonnel());
				st.setString(2,  rdv.getDateRdv());
				st.setInt(3, rdv.getCodeAnimal());

				st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Rdv rdv) throws SQLException {
		PreparedStatement st;
		try {
			st = conn.prepareStatement("delete from `veterinaire_db`.`agendas`" + 
					"where `CodeVeto` = ? " + 
					"and `DateRdv` = ? " + 
					"and `CodeAnimal` = ?;");
				st.setInt(1, rdv.getCodePersonnel());
				st.setString(2, rdv.getDateRdv());
				st.setInt(3, rdv.getCodeAnimal());
				st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// transform rs to Client
	private Rdv mapping(ResultSet rs) throws SQLException {
		Rdv rdv = null;
		int codeVeto = rs.getInt("CodeVeto");
		String dateRdv = rs.getString("DateRdv");
		int CodeAnimal = rs.getInt("CodeAnimal");
		
		rdv = new Rdv(dateRdv, CodeAnimal, codeVeto);
		
		return rdv;
	}

	@Override
	public List<Rdv> select(int codeVeto, java.sql.Date date) throws SQLException {
		List<Rdv> listeRdv = new ArrayList<>();

		PreparedStatement stm = conn.prepareStatement("SELECT * FROM agendas Where DateRdv Like ? and CodeVeto = ?");
		stm.setString(1, date+"%");
		stm.setInt(2, codeVeto);
		try {
			ResultSet rs = stm.executeQuery();
			System.out.println(stm);
			Rdv rdv = null;
			while (rs.next())
			{
				rdv = mapping(rs);
				listeRdv.add(rdv);
			}
			return listeRdv;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeRdv;
	}

	@Override
	public List<Rdv> select(java.sql.Date date) throws SQLException {
		List<Rdv> listeRdv = new ArrayList<>();

		PreparedStatement stm = conn.prepareStatement("SELECT * FROM agendas Where DateRdv Like ? ");
		stm.setString(1, date+"%");
		System.out.println(stm);
		try {
			ResultSet rs = stm.executeQuery();
			Rdv rdv = null;
			while (rs.next())
			{
				rdv = mapping(rs);
				listeRdv.add(rdv);
			}
			return listeRdv;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeRdv;
	}

	@Override
	public void delete(int code, boolean isAnimal) throws SQLException {
		PreparedStatement st;
		try {
			if(isAnimal) {
				st = conn.prepareStatement("delete from `veterinaire_db`.`agendas`" + 
						"where `CodeAnimal` = ?;");
			}else {
				st = conn.prepareStatement("delete from `veterinaire_db`.`agendas`" + 
						"where `CodeVeto` = ?;");
			}
				st.setInt(1, code);
				st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
