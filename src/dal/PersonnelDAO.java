package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Personnel;

public interface PersonnelDAO {

	Personnel selectById(int id) throws SQLException;

	Personnel selectByLog(String nom, String password) throws SQLException;

	List<Personnel> selectAll() throws SQLException;

	void update(Personnel personnel) throws SQLException;

	void insert(Personnel personnel) throws SQLException;

	void delete(int id) throws SQLException;
	
}
