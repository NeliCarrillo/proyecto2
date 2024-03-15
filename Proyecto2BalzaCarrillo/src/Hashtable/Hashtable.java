/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hashtable;

/**
 * Clase que define el hashtable a utilizar para almacenar los clientes hospedados
 * @author tito_
 */
public class Hashtable {

    //Atributos de la clase
    private Lista[] array;
    private int hashSize;

    /**
     * Constructor de la clase
     * @param hashSize, longitud del hashtable
     */
    public Hashtable(int hashSize) {
        this.array = new Lista[hashSize];
        this.hashSize = hashSize;
    }

    /**
     * Metodo que permite obtener la lista de clientes almacenados en una clave del hashtable
     * @return array de clientes almacenados en una clave del hashtable
     */
    public Lista[] getArray() {
        return array;
    }

    /**
     * Metodo que permite modificar la lista de clientes almacenados en una clave del hashtable
     * @param array, nueva lista de clientes a almacenar en una clave del hashtable
     */
    public void setArray(Lista[] array) {
        this.array = array;
    }

    /**
     * Metodo que permite obtener la longitud del hashtable
     * @return longitud del hashtable
     */
    public int getHashSize() {
        return hashSize;
    }

    /**
     * Metodo que permite modificar la longitud del hashtable
     * @param hashSize, nueva longitud del hashtable
     */
    public void setHashSize(int hashSize) {
        this.hashSize = hashSize;
    }

    /**
     * Metodo que permite obtener el valor ASCII de una palabra
     * @param palabra 
     * @return valor ASCII de la palabra ingresada
     */
    public int getAsciiValue(String palabra) {
        int suma = 0;

        for (int i = 0; i < palabra.length(); i++) {
            char character = palabra.charAt(i);
            int ascii = (int) character;
            suma += ascii;
        }
        return suma;
    }

    /**
     * Metodo que permite obtener el hashcode a partir del valor ASCII del nombre y apellido del cliente
     * @param name, nombre del cliente
     * @param lastName, apellido del cliente
     * @return hashcode del cliente
     */
    public int hashCode(String name, String lastName) {
        int clave;
        name = name.toLowerCase();
        lastName = lastName.toLowerCase();
        String junto = name + lastName;
        clave = getAsciiValue(junto) % getHashSize();
        return clave;
    }

    /**
     * Metodo que permite insertar un cliente en el hashtable
     * @param value, cliente a ingresar
     */
    public void insertInHashtable(Client value) {

        String name = value.getName();
        String lastName = value.getLastName();
        int key = hashCode(name, lastName);
        Lista subLista = new Lista();
        subLista.insertFinal(value);
        Lista valorArreglo = getArray()[key];
        if (valorArreglo != null) {
            valorArreglo.insertFinal(value);
        } else {
            getArray()[key] = subLista;
        }
    }

    /**
     * Metodo que permite imprimir el hashtable
     */
    public void printTable() {
        for (int i = 0; i < hashSize; i++) {
            if (array[i] != null) {
                System.out.println("key: " + i);
                array[i].printList();
            }

        }
    }

    /**
     * Metodo que permite eliminar un cliente del hashtable
     * @param name, nombre del cliente a eliminar
     * @param lastName, apellido del cliente
     */
    public void removeHospedado(String name, String lastName) {
        int clave = hashCode(name, lastName);
        if (array[clave] != null) {
            for (int i = 0; i < array[clave].getSize(); i++) {
                Client currentClient = (Client) array[clave].getDato(i).getElement();
                if (currentClient.getLastName().equals(lastName)) {
                    if (currentClient.getRoomNum() != -1) {
                        array[clave].deleteInIndex(i);
                    } else {
                        System.out.println("El cliente aun no ha realizado el check-in y por lo tanto no se le ha asignado una habitacion");
                    }
                }
            }
        } else {
            System.out.println("No se ha encontrado ningun cliente alojado bajo ese nombre");
        }
    }

    /**
     * Metodo que permite obtener el numero de habitacion de un huesped
     * @param name, nombre del cliente cuyo numero de habitacion se quiere obtener
     * @param lastName, apellido del cliente cuyo numero de habitacion se quiere obtener 
     * @return numero de habitacion del cliente, o -1 si el cliente no se encuentra hospedado en el hotel
     */
    public int searchClient(String name, String lastName) {
        int clave = hashCode(name, lastName);
        if (array[clave] != null) {
            for (int i = 0; i < array[clave].getSize(); i++) {
                Client currentClient = (Client) array[clave].getDato(i).getElement();
                if (currentClient.getLastName().equals(lastName)) {
                    if (currentClient.getRoomNum() != -1) {
                        return currentClient.getRoomNum();
                    } else {
                        System.out.println("El cliente aun no ha realizado el check-in y por lo tanto no se le ha asignado una habitacion");
                    }
                }
            }
        } else {
            System.out.println("No se ha encontrado ningun cliente alojado bajo ese nombre");
        }
        return -1;
    }

    /**
     * Metodo que permite chequear si el cliente se encuentra guardado en el hashtable
     * @param cliente a buscar
     * @return valor logico de si el cliente se encuentra guardado en el hashtable
     */
    public boolean checkClient(Client cliente) {
        boolean check = false;
        String name = cliente.getName();
        String lastName = cliente.getLastName();
        int key = hashCode(name, lastName);
        if (array[key] != null) {
            for (int i = 0; i < array[key].getSize(); i++) {
                if (array[key].getDato(i).getElement() == cliente) {
                    check = true;
                }

            }
        }return check;
    }
    
    /**
     * Metodo que permite obtener el cliente registrado a partir del nombre y apellido ingresado
     * @param name, nombre del cliente
     * @param lastName, apellido del cliente
     * @return (Client) cliente registrado con el nombre y apellido ingresado, o null si el cliente no se encuentra registrado 
     */
    public Client obtenerCliente(String name, String lastName) {
      int clave = hashCode(name, lastName);
      if (array[clave] != null) {
          for (int i = 0; i < array[clave].getSize(); i++) {
              Client currentClient = (Client) array[clave].getDato(i).getElement();
              if (currentClient.getLastName().equals(lastName)) {
                  if (currentClient.getRoomNum() != -1) {
                      return currentClient;
                  } else {
                      System.out.println("El cliente aun no ha realizado el check-in y por lo tanto no se le ha asignado una habitacion");
                  }
              }
          }
      } else {
          System.out.println("No se ha encontrado ningun cliente alojado bajo ese nombre");
      }
      return null;
  }
}
