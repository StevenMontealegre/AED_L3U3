package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.Player;

public class ViewPanel extends JPanel {


	private JTextArea area;
	private JScrollPane scroll;
	
	
	public ViewPanel() {
		
		setLayout(new BorderLayout());
		scroll = new JScrollPane( );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setPreferredSize( new Dimension( 500, 500 ) );
        
		area = new JTextArea();
		area.setEditable(false);
        scroll.getViewport( ).add( area);
        
        add(scroll,BorderLayout.NORTH);
        
	}
	
	public void viewPlayerInformation(Player player) {
		
	}
}
