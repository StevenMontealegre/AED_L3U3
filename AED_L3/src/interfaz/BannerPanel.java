package interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BannerPanel extends JPanel {

	public BannerPanel() {
		setLayout(new BorderLayout());
		
		JLabel imagen = new JLabel();
		ImageIcon icono = new ImageIcon("./docs/balon.jpg");
		imagen.setIcon(icono);
		
		add(imagen, BorderLayout.CENTER);
	}
}
