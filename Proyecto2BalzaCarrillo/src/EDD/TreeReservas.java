package EDD;

import Hotel.Client;

/**
 * Clase que define el ABB que guarda las reservaciones del hotel.
 * @author nelsoncarrillo
 */
public class TreeReservas {

    //Atributos de la clase
    private NodoReservas root;

    /**
     * Constructor de la clase.
     * Crea una instancia del AB.
     */
    public TreeReservas() {
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
    
    /**
     * Metodo que permite verificar si el arbol esta vacio
     * @return valor logico de si esta vacio
     */
    public boolean isEmpty() {
        return getRoot() == null;
    }
    
    /**
     * Metodo que permite almacenar un elemento dentro de un nodo y lo inserta.
     * El ABB se ordena acorde al n&uacute;mero de c&eacute;dula.
     * @param raiz del arbol
     * @param element, elemento a agregar
     */
    public void insertNodo(NodoReservas raiz, Client element) {
        NodoReservas node = new NodoReservas(element);
        if (isEmpty()) {
            this.setRoot(node);
        } else {
            if (element.getCedula() <= raiz.getElement().getCedula()) {
                if (raiz.getLeftSon() == null) {
                    raiz.setLeftSon(node);
                    node.setFather(raiz);
                } else {
                    insertNodo(raiz.getLeftSon(), element);
                }
            } else {
                if (raiz.getRightSon() == null) {
                    raiz.setRightSon(node);
                    node.setFather(raiz);
                } else {
                    insertNodo(raiz.getRightSon(), element);
                }
            }
        }
    }

    
    
}