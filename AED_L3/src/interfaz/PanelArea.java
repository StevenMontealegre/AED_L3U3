package interfaz;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelArea extends JPanel{


	private static final long serialVersionUID = 1L;
	private JTextArea area;
	private JScrollPane scroll;
	private InterfazPrincipal principal;
	
	public PanelArea(InterfazPrincipal v) {
		principal = v;
		setLayout(new FlowLayout());
		area = new JTextArea(20,100);
		area.setWrapStyleWord(true);
		area.setEditable(true);
		scroll = new JScrollPane();
		scroll.setViewportView(area);
		
		add(scroll);
	}
	
	public void modificarTexArea(String texto){
		area.append(texto);
	}

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
}
