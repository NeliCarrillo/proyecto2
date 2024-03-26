/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;


import Hashtable.Cliente;
import javax.swing.JOptionPane;
import static main.main.hash;
import static main.main.historial;
import static main.main.rooms;
import static main.main.reservas;

/**
 * Clase que define las funciones de Check-In y Check-Out y los distintos metodos necesarios para la ejecucion de las mismas
 * @author Maria Daniela
 */
public class Funciones {

    /**
     * Metodo que permite que un cliente con reservacion ingrese al hotel 
     * @param cliente que desea ingresar
     */
    public void checkIn(Cliente cliente) {
        
        /**
        * Metodo que asigna la habitación a un cliente que se encuentra reservado
        */

        if (reservas.checkClient(reservas.getRoot(), cliente)) {
            int hab = asignarHab(cliente);
            if (hab != -1) {
                cliente.setRoomNum(hab);
                reservas.deleteNodo(cliente, reservas.getRoot(), null);
                hash.insertInHashtable(cliente);
            } else {
                JOptionPane.showMessageDialog(null, "El hotel no tiene habitaciones " + cliente.getTipoHab() + " disponibles.");
            }
        } else {
            System.out.println("Error. El cliente no posee una reservacion en el Hotel Oasis.");
        }
    }

    /**
     * Metodo que permite que un huesped abandone el hotel y guarda sus datos en el historial
     * @param cliente que desea abandonar el hotal
     */
    public void checkOut(Cliente cliente) {
        
        /**
        * Metodo que hace referencia al momento de salida del huesped del hotel, y desocupa la habitación
        */
        if (hash.checkClient(cliente)) {
            hash.removeHospedado(cliente.getName(), cliente.getLastName());
            historial.insertarCliente(historial.getRoot(), cliente);
            freeRoom(cliente);

        } else {
            JOptionPane.showMessageDialog(null, "Error. El cliente"+cliente.getName()+" "+cliente.getLastName()+" no se encuentra hospedado en el Hotel Oasis.");
        }
    }

    /**
     * Metodo que le asigna una habitacion libre a un cliente, que corresponda con el tipo de habitacion que desea
     * @param cliente al cual se le asignara la habitacion
     * @return numero de habitacion asignado al cliente
     */
    public int asignarHab(Cliente cliente) {
        
        /**
        * Metodo que busca las habitaciones disponibles del hotel para asignarla a los huespedes
        */
        
        String roomType = cliente.getTipoHab();
        for (int i = 0; i < rooms.getSize(); i++) {
            Habitacion room = (Habitacion) rooms.getDato(i).getElement();
            if (room.isFree()) {
                if (roomType.equals(room.getTipo_hab())) {
                    room.setFree(false);
                    return room.getNum_hab();
                }
            }
        }
        return -1;
    }
    
    /**
     * Metodo que libera la habitacion de un cliente cuando el mismo abandona el hotel
     * @param cliente cuya habitacion se liberara
     */
    public void freeRoom(Cliente cliente){
        /**
        * Metodo que determina la disponibilidad de las habitaciones del hotel
        */
        
        int roomNum = cliente.getRoomNum();
        Habitacion room = (Habitacion) rooms.getDato(roomNum-1).getElement();
        room.setFree(true);
        cliente.setRoomNum(-1);
    }

    /**
     * Metodo que verifica si una palabra contiene numeros
     * @param word, palabra a verificar
     * @return valor logico de si la palabra contiene numeros 
     */
     public boolean containsNumbers (String word){
         
        /**
        * Metodo que valida que un texto contenga unicamente Strings y no números
        */
         
        for (int i = 0; i < word.length(); i++) {
        if (Character.isDigit(word.charAt(i))) {
            return true;
        }
    }
    return false;
    }
     
}
