package interfaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SearchPanel extends JPanel {

	private JButton searchButton;
	
	public SearchPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		searchButton = new JButton("Search Player");
		add(searchButton, BorderLayout.CENTER);
	}
}
