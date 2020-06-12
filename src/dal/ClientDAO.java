package dal;

import java.sql.SQLException;
import java.util.List;

import bo.Animal;
import bo.Client;
import bo.Personnel;

public interface ClientDAO {

	Client selectById(int id) throws SQLException;

	List<Client> selectAll() throws SQLException;

	List<Client> selectByName(String name) throws SQLException;

	void update(Client personnel) throws SQLException;

	void insert(Client personnel) throws SQLException;

	void delete(int id) throws SQLException;

	int selectAutoIncrement();
	
}
