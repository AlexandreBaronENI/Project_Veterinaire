package ihm.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CommonView extends JFrame{
	
	public CommonView(String title) {
		this.setTitle(title);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(ConnexionView.class.getResource("/resources/ico_veto.png")));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
