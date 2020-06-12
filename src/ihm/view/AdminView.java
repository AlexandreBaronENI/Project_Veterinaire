package ihm.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bo.Personnel;
import ihm.controller.AdminController;
import ihm.view.component.TableAllPersonnelModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminView extends CommonView{

	public JButton addPersonnelB, removePersonnelB, reinitPersonnelB;
	private JButton btnAddPersonnel;
	private JButton btnRemove;
	private JButton btnReinitialiser;
	private JTable table;

    public AdminView(List<Personnel>allPersonnel) {
    	super("Gestion du personnel");
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        GridBagConstraints gbc_btnAddPersonnel = new GridBagConstraints();
        gbc_btnAddPersonnel.insets = new Insets(0, 0, 5, 5);
        gbc_btnAddPersonnel.gridx = 0;
        gbc_btnAddPersonnel.gridy = 0;
        getContentPane().add(getBtnAddPersonnel(), gbc_btnAddPersonnel);
        GridBagConstraints gbc_btnRemove = new GridBagConstraints();
        gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
        gbc_btnRemove.gridx = 1;
        gbc_btnRemove.gridy = 0;
        getContentPane().add(getBtnRemove(), gbc_btnRemove);
        GridBagConstraints gbc_btnReinitialiser = new GridBagConstraints();
        gbc_btnReinitialiser.insets = new Insets(0, 0, 5, 0);
        gbc_btnReinitialiser.gridx = 2;
        gbc_btnReinitialiser.gridy = 0;
        getContentPane().add(getBtnReinitialiser(), gbc_btnReinitialiser);
        GridBagConstraints gbc_table = new GridBagConstraints();
        gbc_table.gridwidth = 3;
        gbc_table.insets = new Insets(0, 0, 0, 5);
        gbc_table.fill = GridBagConstraints.BOTH;
        gbc_table.gridx = 0;
        gbc_table.gridy = 1;
        getContentPane().add(getTable(allPersonnel), gbc_table);
		pack();
    }

    public JButton getBtnAddPersonnel() {
		if (btnAddPersonnel == null) {
			btnAddPersonnel = new JButton("Ajouter");
			btnAddPersonnel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdminController.addPersonnelScreen();
				}
			});
			btnAddPersonnel.setIcon(new ImageIcon(new ImageIcon(AdminView.class.getResource("/resources/plus.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		}
		return btnAddPersonnel;
	}
    
	public JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Supprimer");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdminController.removePersonnel();
				}
			});
			btnRemove.setIcon(new ImageIcon(new ImageIcon(AdminView.class.getResource("/resources/minus.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		}
		return btnRemove;
	}
	public JButton getBtnReinitialiser() {
		if (btnReinitialiser == null) {
			btnReinitialiser = new JButton("Réinitialiser");
			btnReinitialiser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdminController.reinitPasswordPersonnel();
				}
			});
			btnReinitialiser.setIcon(new ImageIcon(new ImageIcon(AdminView.class.getResource("/resources/reset.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		}
		return btnReinitialiser;
	}
	public JTable getTable(List<Personnel> allPersonnel) {
		if (table == null) {
			table = new JTable(new TableAllPersonnelModel(allPersonnel));
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					AdminController.changeSelectPersonnel();
				}
			});
		}
		return table;
	}
}
