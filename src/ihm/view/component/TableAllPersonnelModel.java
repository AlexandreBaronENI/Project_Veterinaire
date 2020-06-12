package ihm.view.component;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import bo.Personnel;

public class TableAllPersonnelModel extends AbstractTableModel {

	private List<Personnel> allPersonnel;
	private String[] columnNames = { "Nom", "Rôle", "Mot de passe" };
	
	public TableAllPersonnelModel(List<Personnel> allPersonnel) {
		super();
		this.allPersonnel = allPersonnel;
	}
	
	@Override
	public int getRowCount() {
		return allPersonnel.size();
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
		Personnel pers= allPersonnel.get(rowIndex);
		switch(columnIndex) {
		case 0:
			res = pers.getNom();
			break;
		case 1:
			res = pers.getRole();
			break;
		case 2:
			res = pers.getMotPasse();
			break;
		}
		return res;

	}
}