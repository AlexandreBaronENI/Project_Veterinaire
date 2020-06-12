package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Animal;
import bo.Personnel;

public interface AnimalDAO {

	Animal selectById(int id) throws SQLException;

	List<Animal> selectAll() throws SQLException;

	List<Animal> selectAllByCli(int id) throws SQLException;

	void update(Animal personnel) throws SQLException;

	void insert(Animal personnel) throws SQLException;

	void delete(int id) throws SQLException;

	int selectAutoIncrement();

	void deleteByClient(int codeClient);
	
}
