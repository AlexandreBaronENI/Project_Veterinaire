package ihm.view.component;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import bo.Animal;
import bo.Client;

public class TableClients extends JTable{

	public TableClients(List<Client> clients) {
		super(new TableAllClientsModel(clients));
		setPreferredScrollableViewportSize(new Dimension(500, 50));
		setFillsViewportHeight(true);
		getColumnModel().getColumn(0).setPreferredWidth(50);
		getColumnModel().getColumn(1).setPreferredWidth(100);
		getColumnModel().getColumn(2).setPreferredWidth(100);
		getColumnModel().getColumn(3).setPreferredWidth(50);
		getColumnModel().getColumn(4).setPreferredWidth(100);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		setRowHeight(50);
	}
}
