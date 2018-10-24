package ARB;

import java.awt.Color;

import javax.security.auth.x500.X500Principal;

import ABB.ABB;
import ABB.NodoArbol;

public class ARB<K extends Comparable<K>, V> extends ABB<K, V> { //Al decir K extends comparable le decimos que al elemento K que se compare con otro K
	
	
	public ARB() {
		//Deberia ser igual a un nodoABB de color negro
		//Preguntar porque no puedo poner el nill por defecto como un nodoARB
		nill = new NodoArbol<K, V>(null, null);
		nill.setColor(Color.BLACK);
		raiz = nill;
	}
	
	public void insertarARB(K k, V v){
		
		NodoArbol<K, V> z = insertar(k, v);
		z.setIzquierdo(nill);
		z.setDerecho(nill);
		z.setColor(Color.RED);
		
		insertarARBFixup(z);
	}
	
	public void insertarARBFixup(NodoArbol<K, V> z){
		
		while(z.getPadre().getColor() == Color.RED){
			if(z.getPadre() == z.getPadre().getPadre().getIzquierdo()){
				NodoArbol<K, V> y = z.getPadre().getPadre().getDerecho();
				if(y.getColor() == Color.RED){
					z.getPadre().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					z.getPadre().getPadre().setColor(Color.RED);
					z = z.getPadre().getPadre();
				}else{
					
					if(z == z.getPadre().getDerecho()){
						z = z.getPadre();
						rotarIzquierda(z);
					}
					
					//Estas 3 lineas podrian ir adentro del else if
					z.getPadre().setColor(Color.BLACK);
					z.getPadre().getPadre().setColor(Color.RED);
					rotarDerecha(z.getPadre().getPadre());
				}
				
			}else{
				
				//Pendiente para revision
				NodoArbol<K, V> y = z.getPadre().getPadre().getIzquierdo();
				if(y.getColor() == Color.RED){
					z.getPadre().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					z.getPadre().getPadre().setColor(Color.RED);
					z = z.getPadre().getPadre();
				}else{
					if(z == z.getPadre().getIzquierdo()){
						z = z.getPadre();
						rotarDerecha(z);
					}
					//Estas 3 lineas podrian ir adentro del else if
					z.getPadre().setColor(Color.BLACK);
					z.getPadre().getPadre().setColor(Color.RED);
					rotarIzquierda(z.getPadre().getPadre());
				}
				
				
			}
		}
		
		raiz.setColor(Color.BLACK);
		
	}
	
	public void transplantARB(NodoArbol<K, V> u, NodoArbol<K, V> v){
		
		//Ojo con lo del nill, al meterse en transplant de ABB no se si coga el nill de aca o el de alla
		transplant(u, v);
		v.setPadre(u.getPadre());
	}
	
	@Override
	public void eliminar(NodoArbol<K, V> z) {
	
		//super.eliminar(z);
		NodoArbol<K, V> y = z;
		NodoArbol<K, V> x = null;
		Color colorOriginalY = y.getColor();
		if(z.getIzquierdo() == nill){
			x = z.getDerecho();
			transplantARB(z, z.getDerecho());
		}else if(z.getDerecho() == nill){
			x = z.getIzquierdo();
			transplantARB(z, z.getIzquierdo());
		}else{
			y = minimo(z.getDerecho());
			colorOriginalY = y.getColor();
			x = y.getDerecho();
			if(y.getPadre() == z){
				x.setPadre(y);
			}else{
				transplantARB(y, y.getDerecho());
				y.setDerecho(z.getDerecho());
				y.getDerecho().setPadre(y);
			}
			transplantARB(z, y);
			y.setIzquierdo(z.getIzquierdo());
			y.getIzquierdo().setPadre(y);
			y.setColor(z.getColor());
		}
		
		if(colorOriginalY == Color.BLACK){
			eliminarARBFixup(x);
		}
		
	}
	
	public void eliminarARBFixup(NodoArbol<K, V> x){
		
		while(x != raiz && x.getColor() == Color.BLACK){
			
			if(x == x.getPadre().getIzquierdo()){
				NodoArbol<K, V> w = x.getPadre().getDerecho();
				if(w.getColor() == Color.RED){
					w.setColor(Color.BLACK);
					x.getPadre().setColor(Color.RED);
					rotarIzquierda(x.getPadre());
					w = x.getPadre().getDerecho();
				}
				if(w.getIzquierdo().getColor() == Color.BLACK && w.getDerecho().getColor() == Color.BLACK){
					w.setColor(Color.RED);
					x = x.getPadre();
				}else{
					if(w.getDerecho().getColor() == Color.BLACK){
						w.getIzquierdo().setColor(Color.BLACK);
						w.setColor(Color.RED);
						rotarDerecha(w);
						w = x.getPadre().getDerecho();
					}
					w.setColor(x.getPadre().getColor());
					x.getPadre().setColor(Color.BLACK);
					w.getDerecho().setColor(Color.BLACK);
					rotarIzquierda(x.getPadre());
					x = raiz;
				}
			}else{
				
				//De lo contrario lo mismo 
				NodoArbol<K, V> w = x.getPadre().getIzquierdo();
				if(w.getColor() == Color.RED){
					w.setColor(Color.BLACK);
					x.getPadre().setColor(Color.RED);
					rotarDerecha(x.getPadre());
					w = x.getPadre().getIzquierdo();
				}
				if(w.getDerecho().getColor() == Color.BLACK && w.getIzquierdo().getColor() == Color.BLACK){
					w.setColor(Color.RED);
					x = x.getPadre();
				}else{
					if(w.getIzquierdo().getColor() == Color.BLACK){
						w.getDerecho().setColor(Color.BLACK);
						w.setColor(Color.RED);
						rotarIzquierda(w);
						w = x.getPadre().getIzquierdo();
					}
					w.setColor(x.getPadre().getColor());
					x.getPadre().setColor(Color.BLACK);
					w.getIzquierdo().setColor(Color.BLACK);
					rotarDerecha(x.getPadre());
					x = raiz;
				}
				
			}
			
		}
		x.setColor(Color.BLACK);
	}
	
}
