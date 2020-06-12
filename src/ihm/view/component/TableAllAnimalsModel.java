package ihm.view.component;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import bo.Animal;
import bo.Personnel;

public class TableAllAnimalsModel extends AbstractTableModel {

	private List<Animal> allAnimaux;
	public String[] columnNames = { "Numéro", "Nom", "Sexe", "Couleur", "Race", "Espèce", "Tatouage"};
	
	public TableAllAnimalsModel(List<Animal> allAnimaux) {
		super();
		this.allAnimaux = allAnimaux;
	}
	
	@Override
	public int getRowCount() {
		return allAnimaux.size();
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
		Animal anm= allAnimaux.get(rowIndex);
		switch(columnIndex) {
		case 0:
			res = anm.getCodeAnimal();
			break;
		case 1:
			res = anm.getNomAnimal();
			break;
		case 2:
			res = anm.getSexe();
			break;
		case 3:
			res = anm.getCouleur();
			break;
		case 4:
			res = anm.getRace();
			break;
		case 5:
			res = anm.getEspece();
			break;
		case 6:
			res = anm.getTatouage();
			break;
		}
		return res;

	}
}