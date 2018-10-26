package interfaz;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

public class BasketballInterface extends JFrame {

	private BannerPanel bannerPanel;
	private ViewPanel viewPanel;
	
	public BasketballInterface() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		setTitle("Mundial FIBA");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bannerPanel = new BannerPanel();
		add(bannerPanel, BorderLayout.NORTH);
		
		
		viewPanel = new ViewPanel();
		add(viewPanel, BorderLayout.SOUTH);
		
		
	}
	
	public static void main(String[] args) {
		BasketballInterface window = new BasketballInterface();
		window.setVisible(true);
	}
}
