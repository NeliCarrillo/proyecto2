package ABB;

import Hashtable.Cliente;

/**
 * Clase que define los nodos que conforman el ABB.
 * ABB pues que almacena las reservaciones del hotel.
 * 
 * @version 8 marzo 2024
 * @author nelsoncarrillo
 */
public class NodoReservacion {
    
    //Atributos de la clase
    private Cliente element;
    private NodoReservacion rightSon,leftSon,father;

    /**
     * Constructor de la clase.
     * Crea una instancia de objeto.
     * 
     * @param element cliente a almacenar en el nodo.
     */
    public NodoReservacion(Cliente element) {
        this.element = element;
        this.rightSon = this.leftSon = this.father = null;
    }

    /**
     * Getter del cliente.
     * Almacenado en el nodo.
     * 
     * @return cliente almacenado en el nodo
     */
    public Cliente getElement() {
        return element;
    }

    /**
     * Metodo que permite modificar el cliente almacenado en un nodo
     * @param element, cliente nuevo a almacenar
     */
    public void setElement(Cliente element) {
        this.element = element;
    }

    /**
     * Metodo que permite obtener el hijo derecho del nodo actual
     * @return hijo derecho del nodo actual
     */
    public NodoReservacion getRightSon() {
        return rightSon;
    }

    /**
     * Metodo que permite modificar el hijo derecho del nodo actual
     * @param rightSon, nuevo hijo derecho del nodo actual
     */
    public void setRightSon(NodoReservacion rightSon) {
        this.rightSon = rightSon;
    }

    /**
     * Metodo que permite obtener el hijo izquierdo del nodo actual
     * @return hijo izquierdo del nodo actual
     */
    public NodoReservacion getLeftSon() {
        return leftSon;
    }

    /**
     * Metodo que permite modificar el hijo izquierdo del nodo actual
     * @param leftSon, nuevo hijo izquierdo del nodo actual
     */
    public void setLeftSon(NodoReservacion leftSon) {
        this.leftSon = leftSon;
    }

    /**
     * Metodo que permite obtener el padre del nodo actual
     * @return padre del nodo actual
     */
    public NodoReservacion getFather() {
        return father;
    }

    /**
     * Metodo que permite modificar el padre del nodo actual
     * @param father, nuevo padre del nodo actual
     */
    public void setFather(NodoReservacion father) {
        this.father = father;
    }
    
    /**
     * Metodo que permite verificar si un nodo es una hoja del arbol (no tiene hijos)
     * @return valor logico de si es una hoja 
     */
    public boolean isLeaf(){
        return (leftSon == null && rightSon == null);
    }
    
    /**
     * Metodo que permite verificar si un nodo tiene unicamente hijo derecho
     * @return valor logico de si tiene unicamente hijo derecho
     */
    public boolean hasOnlyRightSon(){
        return (leftSon == null && rightSon != null);
    }
    
    /**
     * Metodo que permite verificar si un nodo tiene unicamente hijo izquierdo
     * @return valor logico de si tiene unicamente hijo izquierdo
     */
    public boolean hasOnlyLeftSon(){
        return (leftSon != null && rightSon == null);
    }

}
