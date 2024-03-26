package ABB;

import Hashtable.Client;
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
    
     public void deleteNodo(Cliente element, NodoReservacion raiz, NodoReservacion previousNode) {
        if (isEmpty()) {
            System.out.println("There are no elements to delete");
        } else {
            if (element == raiz.getElement()) {
                if (raiz.isLeaf()) {
                    // Cuando es una hoja
                    if (previousNode == null) {
                        setRoot(null);
                    } else {
                        if (element.getCedula() < previousNode.getElement().getCedula()) {
                            previousNode.setLeftSon(null);
                        } else {
                            previousNode.setRightSon(null);
                        }
                    }
                } else if (raiz.hasOnlyRightSon()) {
                    // Cuando tiene hijo derecho
                    if (previousNode == null) {
                        setRoot(raiz.getRightSon());
                    } else {
                        if (element.getCedula() < previousNode.getElement().getCedula()) {
                            previousNode.setLeftSon(raiz.getRightSon());
                        } else {
                            previousNode.setRightSon(raiz.getRightSon());
                        }
                    }
                } else if (raiz.hasOnlyLeftSon()) {
                    // Cuando tiene hijo izquierdo
                    if (previousNode == null) {
                        setRoot(raiz.getLeftSon());
                    } else {
                        if (element.getCedula() < previousNode.getElement().getCedula()) {
                            previousNode.setLeftSon(raiz.getLeftSon());
                        } else {
                            previousNode.setRightSon(raiz.getLeftSon());
                        }
                    }
                } else {
                    // Tiene ambos hijos
                    boolean haveRightSons = validateLeftSon(raiz.getLeftSon());
                    if (haveRightSons) {
                        NodoReservacion nodo = searchNodoToReplace(raiz.getLeftSon());
                        nodo.setLeftSon(raiz.getLeftSon());
                        nodo.setRightSon(raiz.getRightSon());
                        if (element.getCedula() < previousNode.getElement().getCedula()) {
                            previousNode.setLeftSon(nodo);
                        } else {
                            previousNode.setRightSon(nodo);
                        }
                    } else {
                        NodoReservacion nodo = raiz.getLeftSon();
                        nodo.setRightSon(raiz.getRightSon());
                        if (element.getCedula() < previousNode.getElement().getCedula()) {
                            previousNode.setLeftSon(nodo);
                        } else {
                            previousNode.setRightSon(nodo);
                        }
                    }
                }
            } else if(element.getCedula() < raiz.getElement().getCedula()) {
                deleteNodo(element, raiz.getLeftSon(), raiz);
            } else {
                deleteNodo(element, raiz.getRightSon(), raiz);
            }
        }
    }
    public boolean checkClient(NodoReservacion root, Client element) {
        boolean found = false;
        if (!isEmpty()) {
            if (root == null) {
                System.out.println("No se consiguio el nodo");
            } else {
                if (element.getCedula() == root.getElement().getCedula()) {
                    found = true;
                } else if (element.getCedula() < root.getElement().getCedula()) {
                    return checkClient(root.getLeftSon(), element);
                } else {
                    return checkClient(root.getRightSon(), element);
                }
            }
        }
        return found;
    }
    
    public NodoReservacion searchNodoToReplace(NodoReservacion raiz){
        while(raiz.getRightSon() != null) {
            raiz = raiz.getRightSon();
        }
        return raiz;
    }

     public boolean validateLeftSon(NodoReservacion raiz) {
        return raiz.getRightSon() != null;
    }
    /**
     * Permite obtener un objeto de tipo Client a partir de su CI.
     * Se busca recursivamente si es mayor o menor la CI se va moviendo entre
     * los nodos constitutivos (subtrees) del ABB.
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
                if (cedula == root.getElement().getCedula()) {
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