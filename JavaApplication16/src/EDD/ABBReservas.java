package EDD;

/**
 * Clase que define el ABB que guarda las reservaciones del hotel.
 * @author nelsoncarrillo
 */
public class ABBReservas {

    //Atributos de la clase
    private NodoReservas root;

    /**
     * Constructor de la clase
     */
    public ABBReservas() {
        this.root = null;
    }

    /**
     * Metodo que permite obtener la raiz del arbol
     * @return raiz del arbol
     */
    public NodoReservas getRoot() {
        return root;
    }

    /**
     * Metodo que permite modificar la raiz del arbol
     * @param root, raiz nueva del arbol
     */
    public void setRoot(NodoReservas root) {
        this.root = root;
    }
    
}