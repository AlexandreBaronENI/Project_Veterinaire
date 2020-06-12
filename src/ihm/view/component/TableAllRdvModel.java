package ihm.view.component;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import bo.Animal;
import bo.Client;
import bo.Personnel;
import bo.Rdv;

public class TableAllRdvModel extends AbstractTableModel {

	private List<Rdv> allRdv;
	public String[] columnNames = { "Heure","Nom du client", "Animal", "Race"};
	
	public TableAllRdvModel(List<Rdv> allRdv) {
		super();
		this.allRdv = allRdv;
	}
	
	@Override
	public int getRowCount() {
		return allRdv.size();
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
		Rdv rdv = allRdv.get(rowIndex);
		switch(columnIndex) {
		case 0:
			res = rdv.getDateRdv().substring(rdv.getDateRdv().length() - 8);
			break;
		case 1:
			res = rdv.getClient().getPrenomClient()+ " " + rdv.getClient().getNomClient();
			break;
		case 2:
			res = rdv.getAnimal().getNomAnimal();
			break;
		case 3:
			res = rdv.getAnimal().getEspece();
			break;
		}
		return res;

	}
}