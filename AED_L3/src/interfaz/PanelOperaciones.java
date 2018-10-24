package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ABB.NodoArbol;

public class PanelOperaciones extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static final String BUSCAR = "Buscar";
	public static final String INSERTAR = "Insertar";
	public static final String ELIMINAR = "Eliminar";
	
	private InterfazPrincipal principal;
	//private PanelArea area;
	
	private JComboBox cbIdentificadores;
	private JComboBox cbCampos;

	private JButton bBuscar;
	private JButton bInsertar;
	private JButton bEliminar;
	

	private JLabel lIdentificadores;
	private JLabel lCampos;

	private JLabel lUniversal;

	
	private JTextField tUniversal;

	public PanelOperaciones(InterfazPrincipal v) {
		
		principal = v;
		GridLayout a = new GridLayout(5, 3);
		setLayout(a);
		a.setHgap(60);
		a.setVgap(10);

		
		
		tUniversal = new JTextField();
		tUniversal.setEditable(true);

		
		cbIdentificadores = new JComboBox<>();
		cbIdentificadores.addItem("---");
		cbIdentificadores.addItem("Nombre municipio");
		cbIdentificadores.addItem("Nombre candidato");
		cbIdentificadores.addItem("Nombre partido");

		cbCampos = new JComboBox<>();
		cbCampos.addItem("---");
		cbCampos.addItem("Código departamento");
		cbCampos.addItem("Nombre departamento");
		cbCampos.addItem("Código municipio");
		cbCampos.addItem("Código zona");
		cbCampos.addItem("Código puesto");
		cbCampos.addItem("Número de mesa");
		cbCampos.addItem("Código com");
		cbCampos.addItem("Boletín");
		cbCampos.addItem("Código circunscripción");
		cbCampos.addItem("Código partido");
		cbCampos.addItem("Código candidato");
		cbCampos.addItem("Apellidos candidato");
		cbCampos.addItem("Votación");
		cbCampos.addItem("Votos en blanco");
		cbCampos.addItem("Votos nulos");
		cbCampos.addItem("Votos no marcados");
		cbCampos.addItem("Votos rotos");

		cbIdentificadores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccionado1 = (String) cbIdentificadores.getSelectedItem();
				if (!seleccionado1.equals("---")) {
					
					cbCampos.setSelectedItem("---");
					

				}
			}
		});
		cbCampos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccionado2 = (String) cbCampos.getSelectedItem();

				if (!seleccionado2.equals("---")) {

					tUniversal.setText("");
					cbIdentificadores.setSelectedItem("---");
				
				}

			}
		});

		bBuscar = new JButton(BUSCAR);
		bBuscar.setActionCommand(BUSCAR);
		bBuscar.addActionListener(this);
		
		bInsertar = new JButton(INSERTAR);
		bInsertar.setActionCommand(INSERTAR);
		bInsertar.addActionListener(this);
		
		bEliminar = new JButton(ELIMINAR);
		bEliminar.setActionCommand(ELIMINAR);
		bEliminar.addActionListener(this);
		
		lIdentificadores = new JLabel("Seleccione un identificador...");
		lCampos = new JLabel("Seleccione un campo...");

		lUniversal = new JLabel("Digite el elemento a operar...");
	
		add(lIdentificadores);
		add(new JLabel("    "));
		add(lCampos);
		add(cbIdentificadores);
		add(new JLabel("     "));
		add(cbCampos);
		add(new JLabel("     "));
		add(lUniversal);
		add(new JLabel("     "));
		add(new JLabel("     "));
		add(tUniversal);
		add(new JLabel("     "));
		add(bInsertar);
		add(bBuscar);
		add(bEliminar);
	}

	
	public void actualizarArea(ArrayList<String> a){
		for (int i = 0; i < a.size(); i++) {
			principal.pintarTextArea(a.get(i));
			//area.getArea().append(a.get(i));
		}
		
	}
	
	public String darTexto(){
		return tUniversal.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		String i = cbIdentificadores.getSelectedItem().toString(); 
		String c = cbCampos.getSelectedItem().toString();
		if (comando.equals(BUSCAR)) {
			if(i.equals("---")){
			NodoArbol<String, String> a = principal.buscar(c, darTexto());
			actualizarArea(a.getV());
			}
			else{
				NodoArbol<String, String> b = principal.buscar(i, darTexto());
				actualizarArea(b.getV());
			}
		}else if(comando.equals(INSERTAR)) {
			principal.insertar();
			JOptionPane.showMessageDialog(null, "El registro "+ darTexto()+"\nSe ha agregado satisfactoriamente a la base de datos...");
		}
//		else if(comando.equals(ELIMINAR)) {
//		principal.eliminar();
//		JOptionPane.showMessageDialog(null, "El registro "+ darTexto()+"\nSe ha agregado satisfactoriamente a la base de datos...");
//		}

	}

}
