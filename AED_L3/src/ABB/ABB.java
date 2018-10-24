package ABB;

public class ABB<K extends Comparable<K>, V> implements InterfaceABB<K, V> {

	//Atributos
	protected NodoArbol<K, V> raiz;  
	protected NodoArbol<K, V> nill;
	
	//Constructor
	public ABB() {
		// TODO Auto-generated constructor stub
		raiz = null;
		nill = null;
	}
	
	public NodoArbol<K, V> getRaiz() {
		return raiz;
	}

	public NodoArbol<K, V> getNill() {
		return nill;
	}

	public void setNill(NodoArbol<K, V> nill) {
		this.nill = nill;
	}

	public void setRaiz(NodoArbol<K, V> raiz) {
		this.raiz = raiz;
	}
	
	//La busqueda va a retornar un Arraylist de tipo V o tal vez el mismo nodo.
	@Override
	public NodoArbol<K, V> busquedaIterativa(K k){
		
		NodoArbol<K, V> x = raiz;
		
		while(x != nill && x.getK().compareTo(k) != 0){
			if(x.getK().compareTo(k) > 0){
				x = x.getIzquierdo();
			}else{
				x = x.getDerecho();
			}
		}
		
		return x;
	}
	
	@Override
	public NodoArbol<K, V> insertar(K k, V v){
	
		boolean nodoExistente = false;
		NodoArbol<K, V> y = nill;
		NodoArbol<K, V> x = raiz;
		//Ese nodo asi no se deberia crear aun
		NodoArbol<K, V> z = new NodoArbol<K, V>(k, v);
		
		while(x != nill){
			y = x;
			if(x.getK().compareTo(k) > 0){
				x = x.getIzquierdo();
			}else if(x.getK().compareTo(k) < 0){
				x = x.getDerecho();
			}else{
				nodoExistente = true;
				x.getV().add(v);
				z = x;
				break;
			}
			
		}
		
		if(!nodoExistente){
			z.setPadre(y);
			if(y == nill){
				raiz = z;
			}else if(y.getK().compareTo(z.getK()) > 0){
				y.setIzquierdo(z);
			}else{
				y.setDerecho(z);
			}
		}
		
		return z;
		
	}
	
	@Override
	public void eliminar(NodoArbol<K, V> z){
		
		if(z.getIzquierdo() == nill){
			transplant(z, z.getDerecho());
		}else if(z.getDerecho() == nill){
			transplant(z, z.getIzquierdo());
		}else{
			NodoArbol<K, V> y = minimo(z.getDerecho());
			if(y.getPadre() != z){
				transplant(y, y.getDerecho());
				y.setDerecho(z.getDerecho());
				y.getDerecho().setPadre(y);
			}
			transplant(z, y);
			y.setIzquierdo(z.getIzquierdo());
			y.getIzquierdo().setPadre(y);
		}
		
	}
	
	//Pre condicion: Que el hijo derecho del nodoActual sea diferente de null
	@Override
	public NodoArbol<K, V> rotarIzquierda(NodoArbol<K, V> nodoActual) {
		
		NodoArbol<K, V> y = nodoActual.getDerecho();
		nodoActual.setDerecho(y.getIzquierdo());
		
		if(y.getIzquierdo() != nill){
			y.getIzquierdo().setPadre(nodoActual);
		}
		y.setPadre(nodoActual.getPadre());
		
		if(nodoActual.getPadre() == nill){
			raiz = y;
		}else if(nodoActual == nodoActual.getPadre().getIzquierdo()){
			nodoActual.getPadre().setIzquierdo(y);
		}else{
			nodoActual.getPadre().setDerecho(y);
		}
		y.setIzquierdo(nodoActual);
		nodoActual.setPadre(y);
		
		return y;
	}
	//Pre condicion: Que el hijo izquierdo del nodoActual sea diferente de null
	@Override
	public NodoArbol<K, V> rotarDerecha(NodoArbol<K, V> nodoActual) {
		
		NodoArbol<K, V> y = nodoActual.getIzquierdo();
		nodoActual.setIzquierdo(y.getDerecho());
		
		if(y.getDerecho() != nill){
			y.getDerecho().setPadre(nodoActual);
		}
		y.setPadre(nodoActual.getPadre());
		
		if(nodoActual.getPadre() == nill){
			raiz = y;
		}else if(nodoActual == nodoActual.getPadre().getIzquierdo()){
			nodoActual.getPadre().setIzquierdo(y);
		}else{
			nodoActual.getPadre().setDerecho(y);
		}
		y.setDerecho(nodoActual);
		nodoActual.setPadre(y);
		
		return y;
		
	}
	
	public NodoArbol<K, V> minimo(NodoArbol<K, V> x){
		
		while(x.getIzquierdo() != nill){
			x = x.getIzquierdo();
		}
		
		return x;
	}
	
	public NodoArbol<K, V> maximo(NodoArbol<K, V> x){
		
		while(x.getDerecho() != nill){
			x = x.getDerecho();
		}
		
		return x;
	}
	
	public NodoArbol<K, V> sucesor(NodoArbol<K, V> x){
		
		if(x.getDerecho() != nill){
			return minimo(x.getDerecho());
		}
		
		NodoArbol<K, V> y = x.getPadre();
		while(y != nill && x == y.getDerecho()){
			x = y;
			y = y.getPadre();
		}
		
		return y;
	}
	
	@Override
	public void transplant(NodoArbol<K, V> u, NodoArbol<K, V> v){
		
		if(u.getPadre() == nill){
			raiz = v;
		}else if(u == u.getPadre().getIzquierdo()){
			u.getPadre().setIzquierdo(v);
		}else{
			u.getPadre().setDerecho(v);
		}
		
		if(v != nill){
			v.setPadre(u.getPadre());
		}
	}
	
}
