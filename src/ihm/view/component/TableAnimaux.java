package ihm.view.component;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import bo.Animal;

public class TableAnimaux extends JTable{

	public TableAnimaux(List<Animal> animaux) {
		super(new TableAllAnimalsModel(animaux));
		setPreferredScrollableViewportSize(new Dimension(500, 50));
		setFillsViewportHeight(true);
		getColumnModel().getColumn(0).setPreferredWidth(50);
		getColumnModel().getColumn(1).setPreferredWidth(100);
		getColumnModel().getColumn(2).setPreferredWidth(50);
		getColumnModel().getColumn(3).setPreferredWidth(100);
		getColumnModel().getColumn(4).setPreferredWidth(100);
		getColumnModel().getColumn(5).setPreferredWidth(100);
		getColumnModel().getColumn(6).setPreferredWidth(100);	
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		setRowHeight(50);
	}
	
	

}
