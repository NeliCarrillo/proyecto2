/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hashtable;

import javax.swing.JOptionPane;

/**
 * Clase que define a una lista doblemente enlazada
 * @author tito_
 * @param <T>, Objeto de tipo Cliente 
 */
public class Lista<T> {
    
    //Atributos de la clase
    private Nodo head;
    private Nodo tail;
    private int size;

    /**
     * Constructor de la clase
     */
    public Lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Metodo que permite obtener la cola de la lista
     * @return ultimo nodo de la lista
     */
    public Nodo getTail() {
        return tail;
    }

    /**
     * Metodo que permite modificar la cola de la lista
     * @param tail, nodo que sera la nueva cola de la lista
     */
    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    /**
     * Metodo que permite obtener la cabeza de la lista
     * @return primer nodo de la lista
     */
    public Nodo getHead() {
        return head;
    }

    /**
     * Metodo que permite modificar la cabeza de la lista
     * @param head, nodo que sera la nueva cabeza de la lista
     */
    public void setHead(Nodo head) {
        this.head = head;
    }

    /**
     * Metodo que permite obtener la longitud de la lista
     * @return longitud de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Metodo que permite modificar la longitud de la lista
     * @param size, nueva longitud de la lista
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Metodo que permite verificar si una lista esta vacia
     * @return valor logico de si la lista esta vacia o no
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
     * Metodo que permite insertar un elemento al principio de la lista
     * @param element, elemento a agregar
     * @return nodo agregado 
     */
    public Nodo insertBegin(T element) {
        Nodo node = new Nodo(element);
        if (isEmpty()) {
            setHead(node);
            setTail(node);
        } else {
            node.setNext(getHead());
            getHead().setPrevious(node);
            setHead(node);
            Nodo pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            setTail(pointer);
        }
        size++;
        return node;
    }
    
    /**
     * Metodo que permite insertar un nodo al final de la lista
     * @param element, elemento a agregar
     * @return nodo agregado 
     */
    public Nodo insertFinal(T element){
        Nodo node = new Nodo(element);
        if (isEmpty()) {
            setHead(node);
            setTail(node);
        } else {
            Nodo pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
            node.setPrevious(pointer);
            setTail(node);
        }
        size++;
        return node;
    }
    
    /**
     * Metodo que permite insertar un elemento en un indice especifico de la lista
     * @param index, valor del indice en donde se quiere agregar el nodo
     * @param element, elemento a agregar
     * @return nodo agregado a la lista
     */
    public Nodo insertInIndex(int index, T element) {
        Nodo node = new Nodo(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            if (index > getSize()) {
                System.out.println("The index is bigger than the size");
                return insertFinal(element);
            } else {
                if (index > getSize() / 2) {
                    Nodo pointer = getTail();
                    int cont = 0;
                    while (cont < (getSize() - index) && pointer.getPrevious()!= null) {
                        pointer = pointer.getPrevious();
                        cont++;
                    }
  
                    node.setNext(pointer.getNext());
                    node.setPrevious(pointer);
                    pointer.getNext().setPrevious(node);
                    pointer.setNext(node);
                } else {
                    Nodo pointer = getHead();
                    int cont = 0;
                    while (cont < (index-1) && pointer.getNext()!= null) {
                        pointer = pointer.getNext();
                        cont++;
                    }
                    node.setNext(pointer.getNext());
                    node.setPrevious(pointer);
                    pointer.getNext().setPrevious(pointer);
                    pointer.setNext(node);
                }
            }
        }
        size++;
        return node;
    }
    
    /**
     * Metodo que permite eliminar el primer nodo de la lista
     */
    public void deleteFirst() {

        if (!isEmpty()) {
            Nodo<T> pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;

        } else {
            JOptionPane.showMessageDialog(null, "Error. Cannot delete node because the list is empty.");

        }
    }
    
    /**
     * Metodo que permite eliminar el ultimo nodo de la lista
     * @return 
     */
    public Nodo deleteFinal(){
        if (!isEmpty()){
            Nodo pointer = getHead();
            if (getSize() == 1) {
                setHead(null);
                size--;
            } else {
                while (pointer.getNext() != null && pointer.getNext().getNext() != null){
                    pointer = pointer.getNext();
                }
                pointer.getNext().setPrevious(null);
                Nodo nodeReturn = pointer.getNext();
                pointer.setNext(null);
                setTail(pointer);
                size--;
                return nodeReturn;
            }
        }
        return null;
    }
    
    /**
     * Metodo que permite eliminar un nodo en una posicion especifica de la lista
     * @param index, indice del nodo a eliminar
     * @return nodo eliminado
     */
    public Nodo<T> deleteInIndex(int index) {
        if (!isEmpty()) {
            Nodo<T> pointer = getHead();
            if (index > getSize()) {
                System.out.println("The index is bigger than the size");
                return deleteFinal();
                
            } else if (index == 0){
                deleteFirst();
                
            } else if (index +1 == getSize()){
                deleteFinal();
                
            } else {
                if (index > getSize() / 2) {
                    pointer = getTail();
                    int cont = 0;
                    while (cont <= (getSize() - index - 1) && pointer.getPrevious() != getTail()) {
                        pointer = pointer.getPrevious();
                        cont++;
                    }
                    Nodo<T> temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.getNext().setPrevious(pointer);
                    temp.setNext(null);
                    temp.setPrevious(null);
                    size--;
                    return temp;

                } else {
                    pointer = getHead();
                    int cont = 0;
                    while (cont < (index - 1) && pointer.getNext() != getHead()) {
                        pointer = pointer.getNext();
                        cont++;
                    }
                    Nodo<T> temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.getNext().setPrevious(pointer);
                    temp.setNext(null);
                    temp.setPrevious(null);
                    size--;
                    return temp;
                }
            }
        }
        return null;
    }
    
    /**
     * Metodo que permite obtener el valor de un nodo en una posicion especifica de la lista
     * @param index, indice del nodo que se quiere obtener
     * @return nodo en el indice ingresado
     */
   public Nodo<T> getDato(int index) {
        if (isEmpty()) {
            return null;

        } else {
            Nodo<T> pointer = getHead();
            int counter = 0;
            while (counter < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                counter++;
            }
            return pointer;
        }
    }
    
   /**
    * Metodo que permite imprimir todos los elementos de la lista
    */
    public void printList(){
        for (int i = 0; i < getSize(); i++) {
            Nodo objeto = getDato(i);
            Cliente currentClient = (Cliente) objeto.getElement();
            System.out.println(i + ": "+ currentClient.getName());
        }
    }
    
}