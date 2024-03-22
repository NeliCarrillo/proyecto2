package ABB;

import Hashtable.Client;
import Hashtable.Lista;

/**
 *Clase que define el ABB que almacena el historial de las habitaciones del hotel.
 * @author nelsoncarrillo
 */
public class ABBHistorial {
    //Atributos de la clase
    private NodoHistorial root;

    /**
     * Constructor de la clase.
     */
    public ABBHistorial() {
        this.root = null;
    }

    /**
     * Metodo que permite obtener la raiz del arbol
     * @return raiz del arbol
     */
    public NodoHistorial getRoot() {
        return root;
    }

    /**
     * Metodo que permite modificar la raiz del arbol
     * @param root, raiz nueva del arbol
     */
    public void setRoot(NodoHistorial root) {
        this.root = root;
    }
    
    /**
     * Metodo que permite almacenar un elemento dentro de un nodo y lo inserta al arbol
     * @param room, numero de habitacion a agregar
     * @param raiz actual del arbol
     */
    public void insertNodo(int room, NodoHistorial raiz) {
         NodoHistorial node = new NodoHistorial(room);
         if (isEmpty()) {
             setRoot(node);
         } else {
             if (room < raiz.getRoom()) {
                 if (raiz.getLeftSon() == null) {
                     raiz.setLeftSon(node);
                 } else {
                     insertNodo(room, raiz.getLeftSon());
                 }
             } else {
                 if (raiz.getRightSon() == null) {
                     raiz.setRightSon(node);
                 } else {
                     insertNodo(room, raiz.getRightSon());
                 }
             }
         }
     }

    /**
     * Metodo que permite insertar un cliente al arbol
     * @param raiz actual del arbol
     * @param cliente a agregar
     */
     public void insertarCliente(NodoHistorial raiz, Client cliente) {

         if (!isEmpty()) {
             if (raiz == null) {
                 System.out.println("No se consiguio el nodo");
             } else {
                 if (cliente.getRoomNum() == raiz.getRoom()) {
                     raiz.getElement().insertFinal(cliente);
                 } else if (cliente.getRoomNum() < raiz.getRoom()) {
                     insertarCliente(raiz.getLeftSon(), cliente);
                 } else {
                     insertarCliente(raiz.getRightSon(), cliente);
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
    public void preOrden(NodoHistorial root) {
        if (root != null) {
            System.out.println(root.getRoom() + ": ");
            for (int i = 0; i < root.getElement().getSize(); i++) {
                Client currentClient = (Client) root.getElement().getDato(i).getElement();
                System.out.println("--> " + currentClient.getLastName());
            }
            preOrden(root.getLeftSon());
            preOrden(root.getRightSon());
        }
    }
    
    /**
     * Metodo que permite imprimir el arbol siguiendo la secuenca de InOrden (izquierda-raiz-derecha)
     * @param root, raiz del arbol
     */
    public void inOrden(NodoHistorial root) {
        if (root != null) {
            preOrden(root.getLeftSon());
            System.out.println("{ "+root.getElement()+" }");
            preOrden(root.getRightSon());
        }
    }
    
    /**
     * Metodo que permite imprimir el arbol siguiendo la secuenca de PostOrden (izquierda-derecha-raiz)
     * @param root, raiz del arbol
     */
    public void postOrden(NodoHistorial root) {
        if (root != null) {
            preOrden(root.getLeftSon());
            preOrden(root.getRightSon());
            System.out.println("{ "+root.getElement()+" }");
        }
    }
    
    /**
     * Metodo que permite eliminar un nodo del arbol a partir del elemento almacenado en el
     * @param raiz actual del arbol
     * @param room, numero de habitacion a eliminar 
     */
    public void deleteNodo(NodoHistorial raiz, int room) {
        if (!isEmpty()) {
            if (raiz == null) {
                System.out.println("No se consiguio el nodo");
            } else {
                if (room == raiz.getRoom()) {
                    if (raiz.getLeftSon() == null && raiz.getRightSon() == null) {
                        // Es una Hoja
                        if (room < raiz.getFather().getRoom()) {
                            raiz.getFather().setLeftSon(null);
                        } else {
                            raiz.getFather().setRightSon(null);
                        }
                        raiz.setFather(null);
                    } else if (raiz.getLeftSon() == null) {
                        // Tiene solo hijo derecho
                        if (room < raiz.getFather().getRoom()) {
                            raiz.getFather().setLeftSon(raiz.getRightSon());
                        } else {
                            raiz.getFather().setRightSon(raiz.getRightSon());
                        }
                        raiz.getRightSon().setFather(raiz.getFather());
                        raiz.setRightSon(null);
                        raiz.setFather(null);
                    } else if (raiz.getRightSon() == null) {
                        // Tiene solo hijo izquierdo
                        if (room < raiz.getFather().getRoom()) {
                            raiz.getFather().setLeftSon(raiz.getLeftSon());
                        } else {
                            raiz.getFather().setRightSon(raiz.getLeftSon());
                        }
                        raiz.getLeftSon().setFather(raiz.getFather());
                        raiz.setLeftSon(null);
                        raiz.setFather(null);
                    }
                } else if (room < raiz.getRoom()) {
                    deleteNodo(raiz.getLeftSon(), room);
                } else {
                    deleteNodo(raiz.getRightSon(), room);
                }
            }
        } else {
            System.out.println("No hay elementos para eliminar");
        }
    }
    
    /**
     * Metodo que permite obtener la lista de clientes almacenados en un nodo a partir del numero de habitacion
     * @param room, numero de habitacion cuyo historial se quiere buscar
     * @param raiz actual del arbol
     * @return lista de clientes que conforman el historial de la habitacion ingresada
     */
    public Lista searchRoomHis(int room, NodoHistorial raiz){
        if (!isEmpty()) {
            if (raiz == null) {
                System.out.println("No se consiguio el nodo");
            } else {
                if (room == raiz.getRoom()) {
                    return raiz.getElement();
                } else if (room < raiz.getRoom()) {
                    return searchRoomHis(room, raiz.getLeftSon());
                } else {
                    return searchRoomHis(room, raiz.getRightSon());
                }
            }
        } return null;
    }
    
}
