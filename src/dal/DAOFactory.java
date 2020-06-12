package dal;

import java.sql.SQLException;

public class DAOFactory {
	public static PersonnelDAO getPersonnelDAO() throws SQLException {
		return new PersonnelDAOJdbcImpl();
	}
	public static AnimalDAO getAnimalDAO() throws SQLException {
		return new AnimalDAOJdbcImpl();
	}
	public static ClientDAO getClientDAO() throws SQLException {
		return new ClientDAOJdbcImpl();
	}
	public static RdvDAO getRdvDAO() throws SQLException {
		return new RdvDAOJdbcImpl();
	}
}
