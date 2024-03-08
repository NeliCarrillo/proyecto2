package ABB;

import Hotel.Cliente;

/**
 * Clase que define el ABB que guarda las reservaciones del hotel.
 * Esto en funci&oacute;n del n&uacute;mero de c&eacute;dula del cliente
 * que hizo la reserva.
 * 
 * @version 8 marzo 2024
 * @author nelsoncarrillo
 */
public class ABBReservaciones {

    //Atributos de la clase
    private NodoReservacion root;

    /**
     * Constructor de la clase.
     * Crea una instancia del ABB.
     */
    public ABBReservaciones() {
        this.root = null;
    }

    /**
     * Getter de la ra&iacute;z
     * del ABB.
     * 
     * @return <code>NodoReservacion</code> ra&iacute;z del arbol
     */
    public NodoReservacion getRoot() {
        return root;
    }

    /**
     * Setter de la ra&iacute;z
     * 
     * @param root ra&iacute;z nueva del arbol
     */
    public void setRoot(NodoReservacion root) {
        this.root = root;
    }
    
    /**
     * Verifica si el &aacute;rbol est&aacute; vac&iacute;o
     * 
     * @return <code>true</code> si tiene ra&iacute;z.
     *         <code>false</code> si apunta a nada.
     */
    public boolean isEmpty() {
        return getRoot() == null;
    }
    
    /**
     * Metodo que permite almacenar un elemento dentro de un nodo y lo inserta.
     * El ABB se ordena acorde al n&uacute;mero de c&eacute;dula.
     * 
     * @param raiz nodo ra&iacute;z del &aacute;rbol
     * @param cliente cliente a agregar (que hizo reserva previamente).
     */
    public void insertNodo(NodoReservacion raiz, Cliente cliente){
        NodoReservacion node = new NodoReservacion(cliente);
        if (this.isEmpty()) {
            this.setRoot(node);
        }else{
            if(cliente.getCedula() <= raiz.getElement().getCedula()) {
                if (raiz.getLeftSon() == null) {
                    raiz.setLeftSon(node);
                    node.setFather(raiz);
                } else {
                    insertNodo(raiz.getLeftSon(), cliente);
                }
            } else {
                if (raiz.getRightSon() == null) {
                    raiz.setRightSon(node);
                    node.setFather(raiz);
                } else {
                    insertNodo(raiz.getRightSon(), cliente);
                }
            }
        }
    }
    
    /**
     * Permite obtener un objeto de tipo Client a partir de su CI.
     * Se bsuca recursivamente si es mayor o menor la CI se va moviendo entre
     * los nodos constitutivos del ABB.
     * 
     * @param root, raiz del arbol
     * @param cedula del cliente a buscar
     * @return <code>Cliente</code> que tiene el CI ingresado
     *         <code>null</code> si el cliente no existe (No hizo reserva).
     */
    public Cliente buscarReservacion(NodoReservacion root, int cedula) {
        if (!this.isEmpty()) {
            if (root == null) {
                return null;
            } else {
                if (cedula ==root.getElement().getCedula()) {
                    return root.getElement();
                } else if (cedula < root.getElement().getCedula()) {
                    return buscarReservacion(root.getLeftSon(), cedula);
                } else {
                    return buscarReservacion(root.getRightSon(), cedula);
                }
            }
        }
        return null;
    }

    
    
}