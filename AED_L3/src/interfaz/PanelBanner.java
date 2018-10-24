package interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBanner extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel imagen;
	
	public PanelBanner(){
		setLayout(new BorderLayout());
		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("docs/img/banner.png"));
		add(imagen, BorderLayout.CENTER);
	}
}
