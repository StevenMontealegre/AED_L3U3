package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import ARB.ARB;
import AVL.AVL;

public class Pruebas {
	
	

	public static void main(String[] args) {
		
		AVL<String, String> arbolAVL;
		arbolAVL = new AVL<String, String>();
		
		arbolAVL.insertar("A", "1");
		arbolAVL.insertar("B", "2");
		arbolAVL.insertar("C", "3");
		arbolAVL.insertar("D", "4");
		arbolAVL.insertar("E", "5");
		arbolAVL.insertar("F", "6");
		arbolAVL.insertar("G", "7");
		arbolAVL.insertar("H", "8");
		arbolAVL.insertar("I", "9");
		arbolAVL.insertar("I", "10");
		
		//Este caso particular manda error
		/*
		arbolAVL.eliminar("C");
		arbolAVL.eliminar("A");
		*/
		arbolAVL.eliminar("D");
		arbolAVL.eliminar("E");
		
		arbolAVL.eliminar("A");
		arbolAVL.eliminar("C");
		arbolAVL.eliminar("B");
		
		/*
		NodoArbol<String, String> nodoBuscado = arbolABB.busquedaIterativa("H");
		for(int i = 0; i < nodoBuscado.getV().size(); i++){
			System.out.println(nodoBuscado.getV().get(i));
		}
		*/
		
		
	}

}
