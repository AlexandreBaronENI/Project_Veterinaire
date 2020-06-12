package dal;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import bo.Animal;
import bo.Personnel;
import bo.Rdv;

public interface RdvDAO {

	List<Rdv> select(int codeVeto, java.sql.Date date) throws SQLException;

	List<Rdv> selectAll() throws SQLException;

	void insert(Rdv rdv) throws SQLException;

	void delete(Rdv rdv) throws SQLException;

	void delete(int code, boolean isAnimal) throws SQLException;

	Rdv select(Rdv rdv) throws SQLException;

	List<Rdv> select(java.sql.Date date) throws SQLException;
}
