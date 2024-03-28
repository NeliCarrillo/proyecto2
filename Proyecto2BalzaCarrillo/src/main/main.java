package main;

import ABB.ABBHistorial;
import ABB.ABBReservaciones;
import Functions.BasicFunctions;
import GUI.MenuPrincipal;
import Hashtable.Cliente;
import Hashtable.Hashtable;
import Hashtable.Lista;


/**
*                    Proyecto 2 Hotel Cas Cabildo.
*                  Universidad Metropolitana
*                     Estructura de Datos
*                  Prof. Fernando Torre secc. 3
*                Hecho por: Nelson Carrillo
*                           Tito Balza
* 
*  NOTA: descargar la libreria java (archivo .jar) 
* a trav&eacute;s de este link:
* http://www.java2s.com/Code/JarDownload/javacsv/javacsv.jar.zip
* 
* @author nelsoncarrillo & tito_
*/
public class main {
    
    public static Hashtable hash;
    public static ABBReservaciones reservas;
    public static ABBHistorial historial;
    public static Lista rooms;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Se instancia la columna vertebral
        //Para la lectura y desglose de datos de los CSV.
        BasicFunctions func = new BasicFunctions();
        
        // Estado Actual
        Lista<Cliente> guests = func.Estado();
        hash = func.createHashtable(guests);
        
        // Reservaciones
        reservas = func.Reservas();
        rooms = func.Habitaciones();
        rooms = func.setFreeRooms(rooms, guests);


        // Historial de Habitaciones
        Lista<Cliente> history = func.Historial();
        historial = func.crearHistorial(history);
        
        //Interfaz iniciada
        MenuPrincipal inicio = new MenuPrincipal();
        inicio.setVisible(true);
        
       
    }
    
}
