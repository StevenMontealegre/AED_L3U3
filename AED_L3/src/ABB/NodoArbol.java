package ABB;

import java.awt.Color;
import java.util.ArrayList;

public class NodoArbol<K, V> { //Por ahora no necesitamos comparar 

	private K k;
	//El nodo va a tener un Arraylist de tipo V el valor es el nombre del archivo de texto
	//private V v;
	private ArrayList<V> v = new ArrayList<>();
	private NodoArbol<K, V> padre;
	private NodoArbol<K, V> derecho;
	private NodoArbol<K, V> izquierdo;
	private Color color;
	private int factorBalanceo;
	
	public NodoArbol(K k, V v) {
		// TODO Auto-generated constructor stub
		this.k = k;
		//this.v = v;
		this.v.add(v);
		derecho = null;
		izquierdo = null;
		padre = null;
		factorBalanceo = 1;
	}
	/*
	public NodoABB<K, V> menor(){
		
		NodoABB<K, V> menor = null;
		
		if(this.izquierdo != null){
			this.getIzquierdo().menor();
		}else{
			menor = this;
		}
		
		return menor;
		
	}
	
	public NodoABB<K, V> mayor(){
		
		NodoABB<K, V> mayor = null;
		
		if(this.derecho != null){
			this.getDerecho().mayor();
		}else{
			mayor = this;
		}
		
		return mayor;
		
	}
	*/
	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}
	
	public ArrayList<V> getV() {
		return v;
	}
	public void setV(ArrayList<V> v) {
		this.v = v;
	}
	public NodoArbol<K, V> getPadre() {
		return padre;
	}

	public void setPadre(NodoArbol<K, V> padre) {
		this.padre = padre;
	}

	public NodoArbol<K, V> getDerecho() {
		return derecho;
	}

	public void setDerecho(NodoArbol<K, V> derecho) {
		this.derecho = derecho;
	}

	public NodoArbol<K, V> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(NodoArbol<K, V> izquierdo) {
		this.izquierdo = izquierdo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getFactorBalanceo() {
		return factorBalanceo;
	}
	public void setFactorBalanceo(int factorBalanceo) {
		this.factorBalanceo = factorBalanceo;
	}
	
	
	
	
	
}
