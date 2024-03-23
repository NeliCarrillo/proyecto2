package main;

import ABB.ABBHistorial;
import ABB.ABBReservaciones;
import Functions.BasicFunctions;
import GUI.MenuPrincipal;
import Hashtable.Client;
import Hashtable.Hashtable;
import Hashtable.Lista;


/**
 *
 * @author nelsoncarrillo
 */
public class main {
    
    public static Hashtable hash;
    public static ABBReservaciones reservas;
    public static ABBHistorial historial;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Se instancia la columna vertebral
        //Para la lectura y desglose de datos de los CSV.
        BasicFunctions func = new BasicFunctions();

        // Reservaciones
        reservas = func.Reservas();

        // Estado Actual
        Lista<Client> guests = func.Estado();
        hash = func.createHashtable(guests);

        // Historial de Habitaciones
        Lista<Client> history = func.Historial();
        historial = func.crearHistorial(history);
        
        //Interfaz iniciada
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        
       
    }
    
}
