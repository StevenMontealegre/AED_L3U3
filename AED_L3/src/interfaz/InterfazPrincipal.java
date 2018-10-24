package interfaz;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

import ABB.ABB;
import ABB.NodoArbol;
import ARB.ARB;
import AVL.AVL;

public class InterfazPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelBanner banner;
	private PanelOperaciones operaciones;
	private PanelArea area;

	private String nombreCampos;

	private ARB<String, String> nombreCandidato;

	private ARB<String, String> nombrePartido;

	private AVL<String, String> nombreMunicipio;

	private int contadorRegistros = 0;
	private String separador = ",";

	public InterfazPrincipal() {

		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setSize(70, 100);

		banner = new PanelBanner();
		operaciones = new PanelOperaciones(this);
		area = new PanelArea(this);

		add(banner, BorderLayout.NORTH);
		add(operaciones, BorderLayout.CENTER);
		add(area, BorderLayout.SOUTH);

		pack();
		cargarPrograma();
	}

	public void cargarPrograma() {

		nombreCandidato = new ARB<String, String>();

		nombrePartido = new ARB<String, String>();

		nombreMunicipio = new AVL<String, String>();

		nombreCampos = "";

		BufferedReader br = null;
		int contador = 1;

		try {

			br = new BufferedReader(
					new FileReader(
							"C:\\Users\\HP\\Desktop\\Resultados_Senado_Elecciones_2014.csv"));
			String line = br.readLine();
			nombreCampos = line;
			line = br.readLine();
			while (line != null) {

				String[] campos = line.split(separador);
				String nombreArchivo = contador + ".txt";

				nombreCandidato.insertarARB(campos[13], nombreArchivo);
				nombrePartido.insertarARB(campos[11], nombreArchivo);
				nombreMunicipio.insertar(campos[3], nombreArchivo);

				File archivo = new File(
						"C:\\Users\\HP\\Desktop\\registros\\"
								+ nombreArchivo);
				FileWriter fw = new FileWriter(archivo);
				fw.write(line);
				fw.close();

				contador++;
				contadorRegistros++;
				line = br.readLine();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		// Vamos a probar que tal quedo el arbol

		// NodoArbol<String, String> elementoBuscado =
		// nombreMunicipio.busquedaIterativa("wscurlock4@apache.org");
		// String ruta = elementoBuscado.getV();
		// try {
		// BufferedReader brBusqueda = new BufferedReader(new
		// FileReader("C:\\Users\\HP\\Desktop\\registros\\" + ruta));
		// String linea = brBusqueda.readLine();
		//
		// System.out.println(linea);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public static void main(String[] args) {
		InterfazPrincipal principal = new InterfazPrincipal();
		principal.setVisible(true);

	}

	public ABB<String, String> crearArbol(int posicion) {
		ABB<String, String> arbolito = new ABB<String, String>();

		for (int i = 1; i <= contadorRegistros; i++) {
			String nombreArchivo = i + ".txt";
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(
						"C:\\Users\\HP\\Desktop\\registros\\" + nombreArchivo));
				String line = br.readLine();
				String[] arreglo = line.split(separador);
				arbolito.insertar(arreglo[posicion], nombreArchivo);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return arbolito;

	}

	public NodoArbol<String, String> buscar(String nombreCampo, String valor) {
		NodoArbol<String, String> actual = null;
		switch (nombreCampo) {
		case "Nombre municipio":
			actual = nombreMunicipio.busquedaIterativa(valor);
			break;
		case "Nombre candidato":
			actual = nombreCandidato.busquedaIterativa(valor);
			break;
		case "Nombre partido":
			actual = nombrePartido.busquedaIterativa(valor);
			break;
		case "Código departamento":
			ABB<String, String> arbol = crearArbol(0);
			actual = arbol.busquedaIterativa(valor);

		case "Nombre departamento":
			ABB<String, String> arbol1 = crearArbol(1);
			actual = arbol1.busquedaIterativa(valor);

		case "Código municipio":
			ABB<String, String> arbol2 = crearArbol(2);
			actual = arbol2.busquedaIterativa(valor);

		case "Código zona":
			ABB<String, String> arbol3 = crearArbol(4);
			actual = arbol3.busquedaIterativa(valor);

		case "Código puesto":
			ABB<String, String> arbol4 = crearArbol(5);
			actual = arbol4.busquedaIterativa(valor);

		case "Número de mesa":
			ABB<String, String> arbol5 = crearArbol(6);
			actual = arbol5.busquedaIterativa(valor);

		case "Código com":
			ABB<String, String> arbol6 = crearArbol(7);
			actual = arbol6.busquedaIterativa(valor);

		case "Boletín":
			ABB<String, String> arbol7 = crearArbol(8);
			actual = arbol7.busquedaIterativa(valor);

		case "Código circunscripción":
			ABB<String, String> arbol8 = crearArbol(9);
			actual = arbol8.busquedaIterativa(valor);

		case "Código partido":
			ABB<String, String> arbol9 = crearArbol(10);
			actual = arbol9.busquedaIterativa(valor);

		case "Código candidato":
			ABB<String, String> arbol10 = crearArbol(12);
			actual = arbol10.busquedaIterativa(valor);

		case "Apellidos candidato":
			ABB<String, String> arbol11 = crearArbol(14);
			actual = arbol11.busquedaIterativa(valor);

		case "Votación":
			ABB<String, String> arbol12 = crearArbol(15);
			actual = arbol12.busquedaIterativa(valor);

		case "Votos en blanco":
			ABB<String, String> arbol13 = crearArbol(16);
			actual = arbol13.busquedaIterativa(valor);

		case "Votos nulos":
			ABB<String, String> arbol14 = crearArbol(17);
			actual = arbol14.busquedaIterativa(valor);

		case "Votos no marcados":
			ABB<String, String> arbol15 = crearArbol(18);
			actual = arbol15.busquedaIterativa(valor);

		case "Votos rotos":
			ABB<String, String> arbol16 = crearArbol(19);
			actual = arbol16.busquedaIterativa(valor);

		}
		return actual;
	}

	/**
	 * pre : La cadena de texto recibida en la interfaz cumple con estructura requerida (cantidad comas adecuadas). 
	 */
	public void insertar(){
		String cadena = operaciones.darTexto();
		contadorRegistros++;
		File archivo = new File("C:\\Users\\HP\\Desktop\\registros\\"
				+ contadorRegistros +".txt");
		FileWriter fw;
		try {
			fw = new FileWriter(archivo);
			fw.write(cadena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] arreglo = cadena.split(separador);
		
		nombreCandidato.insertar(arreglo[13], contadorRegistros+".txt");
		nombreMunicipio.insertar(arreglo[3],  contadorRegistros+".txt");
		nombrePartido.insertar(arreglo[11],  contadorRegistros+".txt");
	
	}
	
	public void pintarTextArea(String texto){
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(
					"C:\\Users\\HP\\Desktop\\registros\\" + texto));
			String line = br.readLine();
			area.modificarTexArea(line);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}
	
	
//	public void eliminar(){
//		
//		nombreCandidato.eliminar(nombreCandidato.busquedaIterativa(operaciones.darTexto()));
//		nombrePartido.eliminar(nombrePartido.busquedaIterativa(operaciones.darTexto()));
//		nombreMunicipio.eliminar(operaciones.darTexto());
//		
//	}
}
