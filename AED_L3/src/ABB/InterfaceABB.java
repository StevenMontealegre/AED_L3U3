package ABB;

public interface InterfaceABB<K extends Comparable<K>, V> {

	//public void agregar(K k, V v, int inicio, NodoABB<K, V> nodoActual);
	public NodoArbol<K, V> insertar(K k, V v);
	//public NodoABB<K, V> buscar(K k, int inicio, NodoABB<K, V> nodoActual);
	public NodoArbol<K, V> busquedaIterativa(K k);
	//public boolean eliminar(K k, int inicio, NodoABB<K, V> nodoActual);
	public void eliminar(NodoArbol<K, V> z);
	public NodoArbol<K, V> rotarIzquierda(NodoArbol<K, V> nodoActual);
	public NodoArbol<K, V> rotarDerecha(NodoArbol<K, V> nodoActual);
	public void transplant(NodoArbol<K, V> u, NodoArbol<K, V> v);
	
}
