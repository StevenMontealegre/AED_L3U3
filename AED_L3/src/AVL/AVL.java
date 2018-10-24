package AVL;

import java.awt.HeadlessException;

import javax.swing.text.AbstractDocument.LeafElement;

import ABB.ABB;
import ABB.NodoArbol;

public class AVL<K extends Comparable<K>, V> extends ABB<K, V> {

	public AVL() {
		nill = null;
		raiz = nill;
	}
	
	public int height(NodoArbol<K, V> x){
		if(x==null){
			return 0;
		}else{
			return x.getFactorBalanceo();
		}
	}
	
	public int getBalance(NodoArbol<K, V> n){
		if(n == null)
			return 0;
		return height(n.getIzquierdo()) - height(n.getDerecho());
	}
	
	@Override
	public NodoArbol<K, V> rotarIzquierda(NodoArbol<K, V> nodoActual) {
		// TODO Auto-generated method stub
		//return super.rotarIzquierda(nodoActual);
		NodoArbol<K, V> y = nodoActual.getDerecho();
		NodoArbol<K, V> t2 = y.getIzquierdo();
		
		y.setIzquierdo(nodoActual);
		nodoActual.setDerecho(t2);
		
		nodoActual.setFactorBalanceo(Math.max(height(nodoActual.getIzquierdo()), height(nodoActual.getDerecho())) + 1);
		y.setFactorBalanceo(Math.max(height(y.getIzquierdo()), height(y.getDerecho())) + 1);
		
		return y;
		
	}
	
	@Override
	public NodoArbol<K, V> rotarDerecha(NodoArbol<K, V> nodoActual) {
		// TODO Auto-generated method stub
		//return super.rotarDerecha(nodoActual);
		NodoArbol<K, V> x = nodoActual.getIzquierdo();
		NodoArbol<K, V> t2 = x.getDerecho();
		
		x.setDerecho(nodoActual);
		nodoActual.setIzquierdo(t2);
		
		nodoActual.setFactorBalanceo(Math.max(height(nodoActual.getIzquierdo()), height(nodoActual.getDerecho())) + 1);
		x.setFactorBalanceo(Math.max(height(x.getIzquierdo()), height(x.getDerecho())) + 1);
		
		return x;
	}
	
	//node es la raiz
	public NodoArbol<K, V> insertarAVL( NodoArbol<K, V> node, NodoArbol<K, V> nuevo){
		
		boolean nodoExistente = false;
		if(node == null)
			return new NodoArbol<K, V>(nuevo.getK(), nuevo.getV().get(0));
		
		if(node.getK().compareTo(nuevo.getK()) > 0){
			node.setIzquierdo(insertarAVL(node.getIzquierdo(), nuevo));
		}else if(nuevo.getK().compareTo(node.getK()) > 0){
			node.setDerecho(insertarAVL(node.getDerecho(), nuevo));
		}else{
			//Este es el caso donde son iguales
			node.getV().add(nuevo.getV().get(0));
			nodoExistente = true;
			//
			//
			//
			//Continua
		}
		
		if(!nodoExistente){
			node.setFactorBalanceo(1 + Math.max(height(node.getIzquierdo()), height(node.getDerecho())));
			
			int balance = getBalance(node);
			
			if(balance > 1 && node.getIzquierdo().getK().compareTo(nuevo.getK()) > 0){
				return rotarDerecha(node);
			}
			if(balance < -1 && nuevo.getK().compareTo(node.getDerecho().getK()) > 0){
				return rotarIzquierda(node);
			}
			
			if(balance > 1 && nuevo.getK().compareTo(node.getIzquierdo().getK()) > 0){
				node.setIzquierdo(rotarIzquierda(node.getIzquierdo()));
				return rotarDerecha(node);
			}
			
			if(balance < -1 && node.getDerecho().getK().compareTo(nuevo.getK()) > 0){
				node.setDerecho(rotarDerecha(node.getDerecho()));
				return rotarIzquierda(node);
			}
		}
		
		return node;
	}
	
	public NodoArbol<K, V> eliminarAVL( NodoArbol<K, V> root, K key){
		
		if(root == null)
			return root;
		
		if(root.getK().compareTo(key) > 0){
			root.setIzquierdo(eliminarAVL(root.getIzquierdo(), key));
		}else if(key.compareTo(root.getK()) > 0){
			root.setDerecho(eliminarAVL(root.getDerecho(), key));
		}else{
			
			if((root.getIzquierdo() == null) || (root.getDerecho() == null)){ //El problema debe estar aqui, porque no se hace distincion cuando los dos hijos son null
				
				NodoArbol<K, V> temp = null;
				if(temp == root.getIzquierdo())
					temp = root.getDerecho();
				else
					temp = root.getIzquierdo();
				
				if(temp == null){
					temp = root;
					root = null;
				}else{
					root = temp;
				}
				
				
			}else{
				NodoArbol<K, V> temp = minValueNode(root.getDerecho());
				
				root.setK(temp.getK());
				
				root.setDerecho(eliminarAVL(root.getDerecho(), temp.getK()));
			}
			
		}
		
		if(root == null)
			return root;
		
		root.setFactorBalanceo(Math.max(height(root.getIzquierdo()), height(root.getDerecho())) + 1);
		
		int balance = getBalance(root);
		
		if(balance > 1 && getBalance(root.getIzquierdo()) >= 0)
			return rotarDerecha(root);
		
		if(balance > 1 && getBalance(root.getIzquierdo()) < 0){
			root.setIzquierdo(rotarIzquierda(root.getIzquierdo()));
			return rotarDerecha(root);
		}
		
		if(balance < -1 && getBalance(root.getDerecho()) <= 0)
			return rotarIzquierda(root);
		
		 if (balance < -1 && getBalance(root.getDerecho()) > 0){
			 root.setDerecho(rotarDerecha(root.getDerecho()));
			 return rotarIzquierda(root);
		 }
	            
	     return root;
					
	}
	
	@Override
	public NodoArbol<K, V> insertar(K k, V v) {
		// TODO Auto-generated method stub
		//return super.insertar(k, v);
		NodoArbol<K, V> nuevo = new NodoArbol<K, V>(k, v);
		if(raiz == null){
			raiz = nuevo;
		}else{
			raiz = insertarAVL(raiz, nuevo);
		}
		return nuevo;
	}
	
	public void eliminar(K k){
		eliminarAVL(raiz, k);
	}
	
	public NodoArbol<K, V> minValueNode(NodoArbol<K, V> node){
		NodoArbol<K, V> current = node;
		while(current.getIzquierdo() != null)
			current = current.getIzquierdo();
		
		return current;
	}
	
	
}
