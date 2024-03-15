/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hashtable;

/**
 * Clase que define a los nodos que conforman a una lista dobkemente enlazada
 * @author tito_;
 * @param <T>, clase de los elemento de la lista, en este caso Client
 */
public class Nodo<T> {
    
    //Atributos de la clase
    private T element;
    private Nodo next;
    private Nodo previous;

    /**
     * Constructor de la clase
     * @param elemento a almacenar en el nodo 
     */
    public Nodo(T elemento) {
        this.element = elemento;
        this.next = null;
        this.previous = null;
    }

    /**
     * Metodo que permite obtener el elemento almacenado en un nodo
     * @return elemento almacenado en el nodo
     */
    public T getElement() {
        return element;
    }

    /**
     * Metodo que permite modificar el elemento almacenado en el nodo
     * @param elemento, nuevo elemento a almacenar en el nodo
     */
    public void setElement(T elemento) {
        this.element = elemento;
    }

    /**
     * Metodo que permite obtener el nodo siguiente al actual
     * @return nodo siguiente al actual
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * Metodo que permite modificar el nodo siguiente al actual
     * @param siguiente, nuevo nodo siguiente al actual
     */
    public void setNext(Nodo siguiente) {
        this.next = siguiente;
    }

    /**
     * Metodo que permite obtener el nodo previo al actual
     * @return nodo previo al actual
     */
    public Nodo getPrevious() {
        return previous;
    }

    /**
     * Metodo que permite modificar el nodo previo al actual
     * @param previous, nuevo nodo previo al actual
     */
    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }
    
    
}