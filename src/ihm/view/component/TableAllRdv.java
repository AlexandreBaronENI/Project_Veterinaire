package ihm.view.component;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import bo.Animal;
import bo.Rdv;

public class TableAllRdv extends JTable{

	public TableAllRdv(List<Rdv> allRdv) {
		super(new TableAllRdvModel(allRdv));
		setPreferredScrollableViewportSize(new Dimension(500, 50));
		setFillsViewportHeight(true);
		getColumnModel().getColumn(0).setPreferredWidth(50);
		getColumnModel().getColumn(1).setPreferredWidth(100);
		getColumnModel().getColumn(2).setPreferredWidth(100);
		getColumnModel().getColumn(3).setPreferredWidth(100);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		setRowHeight(50);
	}
	
	

}
