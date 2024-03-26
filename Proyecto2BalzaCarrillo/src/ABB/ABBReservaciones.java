package ABB;

import Hashtable.Cliente;

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
     * Constructor de la clase
     */
    public ABBReservaciones() {
        this.root = null;
    }

    /**
     * Metodo que permite obtener la raiz del arbol
     * @return raiz del arbol
     */
    public NodoReservacion getRoot() {
        return root;
    }

    /**
     * Metodo que permite modificar la raiz del arbol
     * @param root, raiz nueva del arbol
     */
    public void setRoot(NodoReservacion root) {
        this.root = root;
    }

    /**
     * Metodo que permite almacenar un elemento dentro de un nodo y lo inserta al arbol
     * @param raiz del arbol
     * @param element, elemento a agregar
     */
    public void insertNodo(NodoReservacion raiz, Cliente element) {
        NodoReservacion node = new NodoReservacion(element);
        if (isEmpty()) {
            setRoot(node);
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

    /**
     * Metodo que permite verificar si el arbol esta vacio
     * @return valor logico de si esta vacio
     */
    public boolean isEmpty() {
        return getRoot() == null;
    }

    /**
     * Metodo que permite imprimir el arbol siguiendo la secuenca de PreOrden (raiz-izquierda-derecha)
     * @param root, raiz del arbol
     */
    public void preOrden(NodoReservacion root) {
        if (root != null) {
            System.out.println("{ " + root.getElement().getName() + " }");
            preOrden(root.getLeftSon());
            preOrden(root.getRightSon());
        }
    }

    /**
     * Metodo que permite imprimir el arbol siguiendo la secuenca de InOrden (izquierda-raiz-derecha)
     * @param root, raiz del arbol
     */
    public void inOrden(NodoReservacion root) {
        if (root != null) {
            preOrden(root.getLeftSon());
            System.out.println("{ " + root.getElement().getName() + " }");
            preOrden(root.getRightSon());
        }
    }

    /**
     * Metodo que permite imprimir el arbol siguiendo la secuenca de PostOrden (izquierda-derecha-raiz)
     * @param root, raiz del arbol
     */
    public void postOrden(NodoReservacion root) {
        if (root != null) {
            preOrden(root.getLeftSon());
            preOrden(root.getRightSon());
            System.out.println("{ " + root.getElement().getName() + " }");
        }
    }

    /**
     * Metodo que permite eliminar un elemento del arbol
     * @param element, elemento a eliminar
     * @param raiz del arbol
     * @param previousNode, nodo previo al actual
     */
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
    
    /**
     * Metodo que permite verificar si un nodo del arbol tiene hijo izquierdo
     * @param raiz del arbol
     * @return valor logico de si el nodo tiene hijo izquierdo
     */
    public boolean validateLeftSon(NodoReservacion raiz) {
        return raiz.getRightSon() != null;
    }
    
    /**
     * Metodo que permite buscar el nodo a remplazar 
     * @param raiz actual del arbol
     * @return nodo a reemplazar
     */
    public NodoReservacion searchNodoToReplace(NodoReservacion raiz){
        while(raiz.getRightSon() != null) {
            raiz = raiz.getRightSon();
        }
        return raiz;
    }

    /**
     * Metodo que permite verificar si un elemento se encuentra almacenado en el arbol
     * @param root, raiz del arbol
     * @param element, elemento a buscar 
     * @return valor logico de si el elemento se encuentra almacenado en algun nodo del arbol
     */
    public boolean checkClient(NodoReservacion root, Cliente element) {
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

    /**
     * Metodo que permite obtener un objeto de tipo Client a partir de su numero de cedula
     * @param root, raiz del arbol
     * @param cedula del cliente a buscar
     * @return el cliente que tiene el numero de cedula ingresado, o null si el cliente no existe 
     */
    public Cliente reservationDetails(NodoReservacion root, int cedula) {
        if (!isEmpty()) {
            if (root == null) {
                System.out.println("El cliente no posee reservacion");
            } else {
                if (cedula == root.getElement().getCedula()) {
                    return root.getElement();
                } else if (cedula < root.getElement().getCedula()) {
                    return reservationDetails(root.getLeftSon(), cedula);
                } else {
                    return reservationDetails(root.getRightSon(), cedula);
                }
            }
        }return null;
    }
}