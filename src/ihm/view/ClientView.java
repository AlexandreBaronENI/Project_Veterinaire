package ihm.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bo.Animal;
import bo.Client;
import bo.Personnel;
import ihm.controller.AdminController;
import ihm.controller.AnimalController;
import ihm.controller.ClientsController;
import ihm.controller.SearchClientController;
import ihm.view.component.TableAnimaux;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ClientView extends CommonView{

	private JTable tableAnimaux;
	private JLabel lblCode;
	private JTextField nomTextField;
	private JTextField prenomTextField;
	private JTextField adresse1TextField;
	private JTextField adresse2TextField;
	private JTextField codePostalTextField;
	private JTextField villeTextField;
	public Client client;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;
	private JTextField textFieldRemarque;
	private JTextField textFieldAssurance;
	private JCheckBox chckbxArchive;

    public ClientView(Client client, List<Animal> animaux) {
    	super("Gestion du personnel");
    	this.client = client; 
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(610, 280));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JButton btnSearch = new JButton("Rechercher");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new SearchClientController();
        	}
        });
        btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
        btnSearch.setIcon(new ImageIcon(new ImageIcon(ClientView.class.getResource("/resources/search.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        menuBar.add(btnSearch);
        
        JButton btnAdd = new JButton("Ajouter");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ClientsController.add();
        	}
        });
        btnAdd.setIcon(new ImageIcon(new ImageIcon(ClientView.class.getResource("/resources/plus.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        menuBar.add(btnAdd);
        
        JButton btnRemove = new JButton("Supprimer");
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ClientsController.remove();
        	}
        });
        btnRemove.setIcon(new ImageIcon(new ImageIcon(ClientView.class.getResource("/resources/minus.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        menuBar.add(btnRemove);
        
        JButton btnValidate = new JButton("Valider");
        btnValidate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ClientsController.update();
        	}
        });
        btnValidate.setHorizontalAlignment(SwingConstants.RIGHT);
        btnValidate.setIcon(new ImageIcon(new ImageIcon(ClientView.class.getResource("/resources/checkbox.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        menuBar.add(btnValidate);
        
        JButton btnCancel = new JButton("Annuler");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ClientsController.cancel(false);
        	}
        });
        btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
        btnCancel.setIcon(new ImageIcon(new ImageIcon(ClientView.class.getResource("/resources/reset.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        menuBar.add(btnCancel);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JPanel panelClient = new JPanel();

        BoxLayout layout = new BoxLayout(panelClient, BoxLayout.Y_AXIS);
        panelClient.setLayout(layout);
        
        getContentPane().add(panelClient);
        
        JPanel panelCode = new JPanel();
        panelClient.add(panelCode);
        
        JLabel lblCode = new JLabel("Code");
        panelCode.add(lblCode);
        
        panelCode.add(getCodeJLabel(this.client));
        
        JPanel panelNom = new JPanel();
        panelClient.add(panelNom);
        
        JLabel lblNom = new JLabel("Nom");
        panelNom.add(lblNom);
        
        panelNom.add(getNomTextField(this.client));
        
        JPanel panelPrenom = new JPanel();
        panelClient.add(panelPrenom);
        
        JLabel lblPrenom = new JLabel("Prenom");
        panelPrenom.add(lblPrenom);
        
        panelPrenom.add(getPrenomTextField(this.client));
        
        JPanel panelAdresse1 = new JPanel();
        panelClient.add(panelAdresse1);
        
        JLabel lblAdresse1 = new JLabel("Adresse");
        panelAdresse1.add(lblAdresse1);

        panelAdresse1.add(getAdresse1TextField(this.client));
        
        JPanel panelAdresse2 = new JPanel();
        panelClient.add(panelAdresse2);

        panelAdresse2.add(getAdresse2TextField(this.client));
        
        JLabel lblAdresse2 = new JLabel("");
        panelAdresse2.add(lblAdresse2);
        
        JPanel panelCodePostal = new JPanel();
        panelClient.add(panelCodePostal);
        
        JLabel lblCP = new JLabel("Code Postal");
        panelCodePostal.add(lblCP);
        
        panelCodePostal.add(getCodePostalTextField(this.client));
        
        JPanel panelVille = new JPanel();
        panelClient.add(panelVille);
        
        JLabel lblVille = new JLabel("Ville");
        panelVille.add(lblVille);
        
        panelVille.add(getVilleTextField(this.client));
        
        JPanel panelArchive = new JPanel();
        panelClient.add(panelArchive);
        
        JLabel lblArchive = new JLabel("Archive");
        panelArchive.add(lblArchive);
        
        panelArchive.add(getChckbxArchive(this.client));
        
        JPanel panelEmail = new JPanel();
        panelClient.add(panelEmail);
        
        JLabel lblEmail = new JLabel("Email");
        panelEmail.add(lblEmail);
        
        panelEmail.add(getEmailTextField(this.client));
        
        JPanel panelTel = new JPanel();
        panelClient.add(panelTel);
        
        JLabel lblTel = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone");
        panelTel.add(lblTel);
        
        panelTel.add(getTelTextField(this.client));
        
        JPanel panelRemarque = new JPanel();
        panelClient.add(panelRemarque);
        
        JLabel lblRemarque = new JLabel("Remarque");
        panelRemarque.add(lblRemarque);
        
        panelRemarque.add(getRemarqueTextField(this.client));
        
        JPanel panelAssurance = new JPanel();
        panelClient.add(panelAssurance);
        
        JLabel lblAssurance = new JLabel("Assurance");
        panelAssurance.add(lblAssurance);
        
        panelAssurance.add(getAssuranceTextField(this.client));
        
        JPanel panelAnimal = new JPanel();
        getContentPane().add(panelAnimal);
        GridBagLayout gbl_panelAnimal = new GridBagLayout();
        gbl_panelAnimal.columnWidths = new int[]{0, 0};
        gbl_panelAnimal.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_panelAnimal.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panelAnimal.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panelAnimal.setLayout(gbl_panelAnimal);
                
        JScrollPane scrollPaneTable = new JScrollPane();
        GridBagConstraints gbc_scrollPaneTable = new GridBagConstraints();
        gbc_scrollPaneTable.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPaneTable.fill = GridBagConstraints.BOTH;
        gbc_scrollPaneTable.gridx = 0;
        gbc_scrollPaneTable.gridy = 0;
        panelAnimal.add(getTable(animaux));
        panelAnimal.add(scrollPaneTable, gbc_scrollPaneTable);
        
        JPanel panelBtnAnimal = new JPanel();
        GridBagConstraints gbc_panelBtnAnimal = new GridBagConstraints();
        gbc_panelBtnAnimal.anchor = GridBagConstraints.EAST;
        gbc_panelBtnAnimal.fill = GridBagConstraints.VERTICAL;
        gbc_panelBtnAnimal.gridx = 0;
        gbc_panelBtnAnimal.gridy = 3;
        panelAnimal.add(panelBtnAnimal, gbc_panelBtnAnimal);
        
        JButton btnSupprimerAnimal = new JButton("Supprimer");
        btnSupprimerAnimal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AnimalController.removeAnimal();
        	}
        });
        panelBtnAnimal.add(btnSupprimerAnimal);
        
        JButton btnAddAnimal = new JButton("Ajouter");
        btnAddAnimal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ClientsController.addAnimal();
        	}
        });
        panelBtnAnimal.add(btnAddAnimal);
        
        JButton btnEditAnimal = new JButton("Modifier");
        btnEditAnimal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ClientsController.editAnimal();
        	}
        });
        panelBtnAnimal.add(btnEditAnimal);
		pack();
    }
    
    public JLabel getCodeJLabel(Client client) {
    	if(lblCode == null) {
            lblCode = new JLabel();
            lblCode.setText(String.valueOf(client.getCodeClient()));
    	}
    	return lblCode;
    }
    
    public JTextField getNomTextField(Client client) {
    	if(nomTextField == null) {
    		nomTextField = new JTextField();
            nomTextField.setColumns(10);
            nomTextField.setText(client.getNomClient());
    	}
    	return nomTextField;
    }
    
    public JTextField getPrenomTextField(Client client) {
    	if(prenomTextField == null) {
    		prenomTextField = new JTextField();
    		prenomTextField.setColumns(10);
    		prenomTextField.setText(client.getPrenomClient());
    	}
    	return prenomTextField;
    }
    
    public JTextField getEmailTextField(Client client) {
    	if(textFieldEmail == null) {
    		textFieldEmail = new JTextField();
    		textFieldEmail.setColumns(10);
    		textFieldEmail.setText(client.getEmail());
    	}
    	return textFieldEmail;
    }
    
    public JTextField getTelTextField(Client client) {
    	if(textFieldTel == null) {
    		textFieldTel = new JTextField();
    		textFieldTel.setColumns(10);
    		textFieldTel.setText(client.getNumTel());
    	}
    	return textFieldTel;
    }
    
    public JTextField getRemarqueTextField(Client client) {
    	if(textFieldRemarque == null) {
    		textFieldRemarque = new JTextField();
    		textFieldRemarque.setColumns(10);
    		textFieldRemarque.setText(client.getRemarque());
    	}
    	return textFieldRemarque;
    }
    
    public JTextField getAssuranceTextField(Client client) {
    	if(textFieldAssurance== null) {
    		textFieldAssurance = new JTextField();
    		textFieldAssurance.setColumns(10);
    		textFieldAssurance.setText(client.getAssurance());
    	}
    	return textFieldAssurance;
    }
    
    public JTextField getAdresse1TextField(Client client) {
    	if(adresse1TextField == null) {
    		adresse1TextField = new JTextField();
    		adresse1TextField.setColumns(10);
    		adresse1TextField.setText(client.getAdresse1());
    	}
    	return adresse1TextField;
    }
    
    public JTextField getAdresse2TextField(Client client) {
    	if(adresse2TextField == null) {
    		adresse2TextField = new JTextField();
    		adresse2TextField.setColumns(10);
    		adresse2TextField.setText(client.getAdresse2());
    	}
    	return adresse2TextField;
    }
    
    public JTextField getCodePostalTextField(Client client) {
    	if(codePostalTextField == null) {
    		codePostalTextField = new JTextField();
    		codePostalTextField.setColumns(10);
    		codePostalTextField.setText(client.getCodePostal());
    	}
    	return codePostalTextField;
    }
    
    public JTextField getVilleTextField(Client client) {
    	if(villeTextField == null) {
    		villeTextField = new JTextField();
    		villeTextField.setColumns(10);
    		villeTextField.setText(client.getVille());
    	}
    	return villeTextField;
    }
    
    public JCheckBox getChckbxArchive(Client client) {
    	if(chckbxArchive == null) {
    		chckbxArchive = new JCheckBox();
    		chckbxArchive.setSelected(client.isArchive());
    	}
    	return chckbxArchive;
    }

	public JTable getTable(List<Animal> animaux) {
		if (tableAnimaux == null) {
			tableAnimaux = new TableAnimaux(animaux);
		}
		return tableAnimaux;
	}
}
