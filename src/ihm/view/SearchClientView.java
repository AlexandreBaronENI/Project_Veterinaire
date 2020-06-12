package ihm.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

import bo.Client;
import ihm.controller.ClientsController;
import ihm.controller.SearchClientController;
import ihm.view.component.TableClients;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class SearchClientView extends CommonView{
	private JTextField nameTextField;
	private JTable tableClients;
	public SearchClientView(List<Client> clients) {
		super("Rechercher un client");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		panel.add(getNameTextField());
		
		JButton btnSearch = new JButton("Rechercher");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	               SearchClientController.search();
			}
		});
		panel.add(btnSearch);
		
		getContentPane().add(getTableClients(clients), BorderLayout.CENTER);
		pack();
	}
	
	public JTextField getNameTextField() {
		if(nameTextField == null) {
			nameTextField = new JTextField();
			nameTextField.setText("Nom ou pr\u00E9nom du client");
			nameTextField.setColumns(20);
		}
		return nameTextField;
	}
	
	public JTable getTableClients(List<Client>clients) {
		if(tableClients == null) {
			tableClients = new TableClients(clients);
			tableClients.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {
		               SearchClientController.select();
		            }
		         }
		      });
		}
		return tableClients;
	}

}
