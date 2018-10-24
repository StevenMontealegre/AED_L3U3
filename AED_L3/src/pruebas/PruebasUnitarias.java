package pruebas;

import java.awt.Color;

import ABB.ABB;
import ABB.NodoArbol;
import ARB.ARB;
import AVL.AVL;
import junit.framework.TestCase;

public class PruebasUnitarias extends TestCase {

	
	/*
	public void test() {
		fail("Not yet implemented");
	}
	*/
	
	private ABB<String, String> arbolABB;
	private ARB<String, String> arbolARB;
	private AVL<String, String> arbolAVL;
	
	private void setupEscenario1(){
		arbolABB = new ABB<String, String>();
		arbolABB.insertar("F", "1");
		arbolABB.insertar("C", "2");
		arbolABB.insertar("N", "3");
		arbolABB.insertar("A", "4");
		arbolABB.insertar("B", "5");
		arbolABB.insertar("D", "6");
	}
	
	private void setupEscenario2(){
		arbolARB = new ARB<String, String>();
		
		arbolARB.insertarARB("B", "1");
		arbolARB.insertarARB("G", "2");
		arbolARB.insertarARB("Z", "3");
		arbolARB.insertarARB("A", "4");
		arbolARB.insertarARB("I", "5");
		arbolARB.insertarARB("J", "6");
		arbolARB.insertarARB("H", "7");
		
	}
	
	private void setupEscenario3(){
		arbolAVL = new AVL<String, String>();
		arbolAVL.insertar("A", "1");
		arbolAVL.insertar("B", "2");
		arbolAVL.insertar("C", "3");
		arbolAVL.insertar("D", "4");
		arbolAVL.insertar("F", "5");
		arbolAVL.insertar("G", "6");
		arbolAVL.insertar("H", "7");
	}
	
	public void testRotarIzquierda(){
		setupEscenario1();
		
		arbolABB.rotarIzquierda(arbolABB.busquedaIterativa("A"));
		assertTrue(arbolABB.getRaiz().getIzquierdo().getIzquierdo().getK().equals("B"));
		assertTrue(arbolABB.getRaiz().getIzquierdo().getIzquierdo().getIzquierdo().getK().equals("A"));
		
	}
	
	public void testRotarDerecha(){
		
		setupEscenario1();
		arbolABB.insertar("H", "7");
		
		arbolABB.rotarDerecha(arbolABB.busquedaIterativa("N"));
		
		assertTrue(arbolABB.getRaiz().getDerecho().getK().equals("H"));
		assertTrue(arbolABB.getRaiz().getDerecho().getDerecho().getK().equals("N"));
	}
	
	public void testAgregarABB(){
		
		setupEscenario1();
		
		arbolABB.insertar("H", "7");
		
		assertTrue(arbolABB.getRaiz().getDerecho().getIzquierdo().getK().equals("H"));
	}
	
	public void testAgregarABBClaveRepetida(){
		
		setupEscenario1();
		arbolABB.insertar("N", "7");
		arbolABB.insertar("N", "8");
		
		assertTrue(arbolABB.getRaiz().getDerecho().getV().size() == 3);
	}
	
	public void testBuscarABB(){
		
		setupEscenario1();
		
		NodoArbol<String, String> nodoC = arbolABB.busquedaIterativa("C");
		
		assertTrue(nodoC.getV().get(0).equals("2"));
		assertTrue(nodoC.getIzquierdo().getK().equals("A"));
		assertTrue(nodoC.getDerecho().getK().equals("D"));
	}
	
	public void testBuscarABBVariosV(){
			
		setupEscenario1();
		arbolABB.insertar("D", "7");
		arbolABB.insertar("D", "8");
		
		
		NodoArbol<String, String> nodoD = arbolABB.busquedaIterativa("D");
		
		assertTrue(arbolABB.busquedaIterativa("D").getV().size() == 3);
	}
	
	public void testEliminarABBCaso1(){
		
		setupEscenario1();
		arbolABB.eliminar(arbolABB.busquedaIterativa("D"));
		
		assertTrue(arbolABB.getRaiz().getIzquierdo().getDerecho() == null);
	}
	
	public void testEliminarABBCaso2(){
		
		setupEscenario1();
		arbolABB.eliminar(arbolABB.busquedaIterativa("A"));
		
		assertTrue(arbolABB.getRaiz().getIzquierdo().getIzquierdo().getK().equals("B"));
	}
	
	public void testEliminarABBCaso3(){
		
		setupEscenario1();
		arbolABB.insertar("H", "7");
		arbolABB.eliminar(arbolABB.busquedaIterativa("F"));
		
		assertTrue(arbolABB.getRaiz().getK().equals("H"));
		assertTrue(arbolABB.getRaiz().getDerecho().getIzquierdo() == null);
	}
	
	public void testMinimo(){
		
		setupEscenario1();
		
		assertTrue(arbolABB.minimo(arbolABB.busquedaIterativa("F")).getK().equals("A"));
	}
	
	public void testMaximo(){
		
		setupEscenario1();
		
		assertTrue(arbolABB.maximo(arbolABB.busquedaIterativa("F")).getK().equals("N"));
	}
	
	public void testSucesor(){
		
		setupEscenario1();
		arbolABB.insertar("H", "7");
		
		assertTrue(arbolABB.sucesor(arbolABB.busquedaIterativa("F")).getK().equals("H"));
	}
	
	public void testAgregarARB(){
		
		setupEscenario2();
		arbolARB.insertarARB("C", "7");
		
		assertTrue(arbolARB.getRaiz().getIzquierdo().getDerecho().getK().equals("C") && arbolARB.getRaiz().getIzquierdo().getDerecho().getColor() == Color.RED);
	}
	
	public void testAgregarARBClaveRepetida(){
		
		setupEscenario2();
		arbolARB.insertarARB("C", "7");
		arbolARB.insertarARB("C", "8");
		arbolARB.insertarARB("C", "9");
		arbolARB.insertarARB("C", "10");
		
		assertTrue(arbolARB.getRaiz().getIzquierdo().getDerecho().getV().size() == 4);
	}
	
	public void testEliminarCaso1(){
		
		setupEscenario2();
		arbolARB.insertarARB("C", "7");
		
		arbolARB.eliminar(arbolARB.busquedaIterativa("A"));
		
		assertTrue(arbolARB.getRaiz().getIzquierdo().getIzquierdo() == arbolARB.getNill());
		assertTrue(arbolARB.getRaiz().getIzquierdo().getColor() == Color.BLACK);
	}
	
	public void testEliminarCaso2(){
		
		setupEscenario2();
		arbolARB.insertarARB("C", "7");
		
		arbolARB.eliminar(arbolARB.busquedaIterativa("I"));
		
		assertTrue(arbolARB.getRaiz().getDerecho().getIzquierdo().getK().equals("H") && arbolARB.getRaiz().getDerecho().getIzquierdo().getIzquierdo() == arbolARB.getNill());
	}
	
	public void testEliminarCaso3(){
		
		setupEscenario2();
		arbolARB.insertarARB("C", "7");
		
		arbolARB.eliminar(arbolARB.busquedaIterativa("Z"));
		
		assertTrue(arbolARB.getRaiz().getDerecho().getK().equals("I") && arbolARB.getRaiz().getDerecho().getColor() == Color.RED);
		assertTrue(arbolARB.getRaiz().getDerecho().getIzquierdo().getK().equals("H") && arbolARB.getRaiz().getDerecho().getIzquierdo().getColor() == Color.BLACK);
		assertTrue(arbolARB.getRaiz().getDerecho().getDerecho().getK().equals("J") && arbolARB.getRaiz().getDerecho().getDerecho().getColor() == Color.BLACK);
	}
	
	
	public void testInsertarAVL(){
		setupEscenario3();
		arbolAVL.insertar("I", "8");
		
		assertTrue(arbolAVL.getRaiz().getFactorBalanceo() == 4);
		assertTrue(arbolAVL.getRaiz().getDerecho().getDerecho().getDerecho().getK().equals("I"));		
		
	}
	
	public void testEliminarAVLCaso1(){
		setupEscenario3();
		
		arbolAVL.eliminar("A");
		
		assertTrue(arbolAVL.getRaiz().getFactorBalanceo() == 3);
		assertTrue(arbolAVL.getRaiz().getIzquierdo().getIzquierdo() == null);
		
	}
	
	public void testEliminarAVLCaso2(){
		
		setupEscenario3();
		
		arbolAVL.eliminar("B");
		arbolAVL.eliminar("A");
		
		assertTrue(arbolAVL.getRaiz().getIzquierdo().getFactorBalanceo() == 1);
		assertTrue(arbolAVL.getRaiz().getIzquierdo().getIzquierdo() == null && arbolAVL.getRaiz().getIzquierdo().getDerecho() == null);
		
	}
	public void testEliminarAVLCaso3(){
		
		setupEscenario3();
		
		arbolAVL.eliminar("D");
		
		assertTrue(arbolAVL.getRaiz().getK().equals("F"));
		assertTrue(arbolAVL.getRaiz().getDerecho().getIzquierdo() == null);
		
	}
	
}

