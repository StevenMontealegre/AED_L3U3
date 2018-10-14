package model;

public class NodoRojoNegro<T extends Comparable<? super T>> {

	public static final int NEGRO= 1;
	public static final int ROJO= 0;
	
	private T elemento;
	
	public NodoRojoNegro<T> nill;
	
	private boolean raiz;

	private NodoRojoNegro<T> padre;
	private NodoRojoNegro<T> derecha;
	private NodoRojoNegro<T> izquierda;
	
	private int color;
	
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
	public NodoRojoNegro(T elemento) {
		this.elemento= elemento;
		derecha = null;
		izquierda = null;
        color = ROJO;
        setDerecha( nill );
        setIzquierda( nill);
        padre = null;
	}
    public NodoRojoNegro(){
    	raiz= true;
        this.elemento = null;
        color = NEGRO;
        padre = null;
    }
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	public boolean isRaiz() {
		return raiz;
	}
	public void setRaiz(boolean raiz) {
		this.raiz = raiz;
	}
	public NodoRojoNegro<T> getDerecha(){
		return derecha;
	}
	public NodoRojoNegro<T> getIzquierda(){
		return izquierda;
	}
	public void setPadre(NodoRojoNegro<T> padre) {
		this.padre = padre;
	}
	public void setIzquierda(NodoRojoNegro<T> a){
		a.setPadre(this);
		izquierda = a;
	}
	public void setDerecha(NodoRojoNegro<T> a){
		a.setPadre(this);
		derecha = a;
	}
    public NodoRojoNegro<T> getPadre( ){
        return padre;
    }
    public NodoRojoNegro<T> getTio( ){
        if(padre==null||padre.padre== null){
            return null;
        }
        else{
            if(padre.padre.esHijoDerecho(padre))return padre.padre.getIzquierda();
            else return padre.padre.getDerecha();
        }

    }
	private boolean esHijoDerecho(NodoRojoNegro<T> nodo) {
		return derecha.equals(nodo);
	}
    public boolean esHijoIzquierdo( NodoRojoNegro<T> nodo ){
        return izquierda.equals(nodo);
    }
    public boolean hijoDerechoHoja( ){
        return derecha.equals(nill);
    }
    public boolean hijoIzquierdaHoja(){
        return derecha.equals(nill);
    }
    public boolean esHoja() {
    	return this.getDerecha().esNill() && this.getIzquierda().esNill();
    }
	public boolean esNill() {
		return this.equals(nill);
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
    public NodoRojoNegro<T> maximo(){
    	if(this.hijoDerechoHoja()!=true){
    		return this.getDerecha().maximo();
    	}
    	else return this;
    }

    public NodoRojoNegro<T> minimo( ){
    	if(this.hijoIzquierdaHoja()!=true) {
    		return this.getIzquierda().minimo();
    	}
    	else return this;
    }
    public int darAltura(){
        if(esHoja()) {
            return 0;
        }
        int altura1 = getIzquierda().darAltura( );
        int altura2 = getDerecha().darAltura( );
        if(altura1 >= altura2) return altura1 + 1;
        else return altura2 + 1;
    }
    public int darPeso(){
    	if(esHoja()) {
    		return 0;
    	}
    	else {
    		return 1 + derecha.darPeso() + izquierda.darPeso();
    	}
    }
	@SuppressWarnings("unchecked")
	public boolean yaExiste(T e) {
       T elementoBuscado=(T) buscarElemento(e);
       if(elementoBuscado==null) return false;
       else return true;
    }
	public NodoRojoNegro<T> buscarElemento( T elem ) 	    {
        int comparador = elem.compareTo(this.elemento);
        if( comparador == 0 )return this;
        else if( comparador < 0 ){
            if(!getIzquierda().esHoja())return izquierda.buscarElemento( elem );
            else return null;
        }
        else{
            if(!getDerecha().esHoja())return derecha.buscarElemento( elem );
            else return null;
        }
    }
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
    public boolean derechaNegro(){
        return derecha.getColor() == NEGRO;
    }
    public boolean izquierdaNegro(){
        return izquierda.getColor() == NEGRO;
    }
    public boolean hijosNegros(){
    	boolean retorno=false;
    	if(derechaNegro()&&izquierdaNegro())retorno =true;
        return retorno;
    }
    public NodoRojoNegro<T> darHermano(){
    	if(padre==null) return null;
    	else if(padre.esHijoDerecho(this)) return padre.getIzquierda();
    	else return padre.getDerecha();
    }
    public NodoRojoNegro<T> getNill() {
		return nill;
	}
	public void setNill(NodoRojoNegro<T> nill) {
		this.nill = nill;
	}
    public NodoRojoNegro<T> rotarIzquierda(){
        if(hijoDerechoHoja()) {
            return this;
        }
        else{
            NodoRojoNegro<T> aux= derecha;
            setDerecha( aux.getIzquierda());
            aux.setPadre( padre );
            aux.setIzquierda( this );
            return aux;
        }
    }
    public NodoRojoNegro<T> rotarDerecha(){
        if(hijoIzquierdaHoja()) {
            return this;
        }
        else{
            NodoRojoNegro<T> aux = izquierda;
            setIzquierda( aux.getDerecha( ) );
            aux.setPadre( padre );
            aux.setDerecha( this );
            return aux;
        }
    }
    public void izquierdaRotar(NodoRojoNegro<T> x) {
    	NodoRojoNegro<T> aux= x.getDerecha();
    	x.setDerecha(x.getIzquierda());
    	x.getIzquierda().setPadre(this);
    	aux.setPadre(this.getPadre());
    	if(this.getPadre()==nill) {
    		this.setRaiz(false);
    		aux.setRaiz(true);
    	}
    	else {
    		if(this.equals(x.getPadre().getIzquierda())) {
    			x.getPadre().setIzquierda(aux);
    		}
    		else x.getPadre().setDerecha(aux);
    		aux.setIzquierda(this);
    		x.setPadre(aux);
    	}
    }
    public void derechaRotar(NodoRojoNegro<T> x) {
    	NodoRojoNegro<T> aux= x.getIzquierda();
    	x.setIzquierda(x.getDerecha());
    	x.getDerecha().setPadre(this);
    	aux.setPadre(this.getPadre());
    	if(this.getPadre()==nill) {
    		this.setRaiz(false);
    		aux.setRaiz(true);
    	}
    	else {
    		if(this.equals(x.getPadre().getDerecha())) {
    			x.getPadre().setDerecha(aux);
    		}
    		else x.getPadre().setIzquierda(aux);
    		aux.setDerecha(this);
    		x.setPadre(aux);
    	}
    }
	// -----------------------------------------------------------------
    // Insertar y eliminar
    // -----------------------------------------------------------------
    public void insertar( NodoRojoNegro<T> nodo ){
        if(buscarElemento(nodo.getElemento())==null){
        	//Elemento ya existe
        }
        else if(elemento.compareTo(nodo.getElemento())<0){
            if(hijoDerechoHoja()){
                setDerecha(nodo);
                nodo.setPadre(this);
            }
            else getDerecha().insertar( nodo );
        }
        else{
            if(hijoIzquierdaHoja()){
                setIzquierda(nodo);
                nodo.setPadre(this);
            }
            else getIzquierda().insertar( nodo );
        }
        arreglarInsertar(nodo);
    }
    public void arreglarInsertar(NodoRojoNegro<T> nodo) {
    	while( nodo.getPadre().getColor()== ROJO) {
    		if(nodo.getPadre().equals(nodo.getPadre().getPadre().getIzquierda())) {
    			NodoRojoNegro<T> aux= nodo.getPadre().getPadre().getDerecha();
    			if( aux.getColor()== ROJO) {
    				nodo.getPadre().setColor(NEGRO);
    				aux.setColor(NEGRO);
    				nodo.getPadre().getPadre().setColor(ROJO);
    				nodo= getPadre().getPadre();
    			}
    			else {
    				if(nodo.equals(nodo.getPadre().getIzquierda())) {
    					nodo= nodo.getPadre();
    					izquierdaRotar(nodo);
    				}
    				nodo.getPadre().setColor(NEGRO);
					nodo.getPadre().getPadre().setColor(ROJO);
					derechaRotar(nodo.getPadre().getPadre());
    			}
    		}
    		else {
    			NodoRojoNegro<T> aux= nodo.getPadre().getPadre().getIzquierda();
    			if( aux.getColor()== ROJO) {
    				nodo.getPadre().setColor(NEGRO);
    				aux.setColor(NEGRO);
    				nodo.getPadre().getPadre().setColor(ROJO);
    				nodo= getPadre().getPadre();
    			}
    			else {
    				if(nodo.equals(nodo.getPadre().getDerecha())) {
    					nodo= nodo.getPadre();
    					derechaRotar(nodo);
    				}
    				nodo.getPadre().setColor(NEGRO);
					nodo.getPadre().getPadre().setColor(ROJO);
					izquierdaRotar(nodo.getPadre().getPadre());
    			}
    		}
    	}
    	//Raiz negra
    }
}
