package ABB;

import Hashtable.Lista;

/**
 * Clase que define los nodos que conforman el ABB.
 * que almacena el historial de las habitaciones del hotel.
 * 
 * @author nelsoncarrillo
 */
public class NodoHistorial {
    
    //Atributos de la clase
    private Lista element;
    private int room;
    private NodoHistorial rightSon,leftSon,father;

    /**
     * Constructor de la clase
     * @param room, numero de habitacion 
     */
    public NodoHistorial(int room) {
        this.element = new Lista();
        this.rightSon = this.leftSon = this.father = null;
        this.room = room;
    }

    /**
     * Metodo que permite la lista almacenada en el nodo
     * @return lista almacenada en el nodo
     */
    public Lista getElement() {
        return element;
    }

    /**
     * Metodo que permite modificar la lista almacenada en el nodo
     * @param element, nueva lista a almacenar en el nodo
     */
    public void setElement(Lista element) {
        this.element = element;
    }

    /**
     * Metodo que permite obtener el hijo derecho del nodo actual
     * @return hijo derecho del nodo actual
     */
    public NodoHistorial getRightSon() {
        return rightSon;
    }

    /**
     * Metodo que permite modificar el hijo derecho del nodo actual
     * @param rightSon, nuevo hijo derecho del nodo actual
     */
    public void setRightSon(NodoHistorial rightSon) {
        this.rightSon = rightSon;
    }

    /**
     * Metodo que permite obtener el hijo izquierdo del nodo actual
     * @return hijo izquierdo del nodo actual
     */
    public NodoHistorial getLeftSon() {
        return leftSon;
    }

    /**
     * Metodo que permite modificar el hijo izquierdo del nodo actual
     * @param leftSon, nuevo hijo izquierdo del nodo actual
     */
    public void setLeftSon(NodoHistorial leftSon) {
        this.leftSon = leftSon;
    }

    /**
     * Metodo que permite obtener el padre del nodo actual
     * @return padre del nodo actual
     */
    public NodoHistorial getFather() {
        return father;
    }

    /**
     * Metodo que permite modificar el padre del nodo actual
     * @param father, nuevo padre del nodo actual
     */
    public void setFather(NodoHistorial father) {
        this.father = father;
    }

    /**
     * Metodo que permite obtener el numero de habitacion del nodo actual
     * @return numero de habitacion del nodo actual
     */
    public int getRoom() {
        return room;
    }

    /**
     * Metodo que permite modificar el numero de habitacion del nodo actual
     * @param room, nuevo numero de habitacion del nodo actual
     */
    public void setRoom(int room) {
        this.room = room;
    }
}
