package ihm.view.component;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import bo.Animal;
import bo.Client;
import bo.Personnel;

public class TableAllClientsModel extends AbstractTableModel {

	private List<Client> clients;
	public String[] columnNames = { "","Nom", "Prénom", "Code postal", "Ville"};
	
	public TableAllClientsModel(List<Client> clients) {
		super();
		this.clients = clients;
	}
	
	@Override
	public int getRowCount() {
		return clients.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object res = null;
		Client cli= clients.get(rowIndex);
		switch(columnIndex) {
		case 0:
			res = cli.getCodeClient();
			break;
		case 1:
			res = cli.getNomClient();
			break;
		case 2:
			res = cli.getPrenomClient();
			break;
		case 3:
			res = cli.getCodePostal();
			break;
		case 4:
			res = cli.getVille();
			break;
		}
		return res;

	}
}