/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import ABB.ABBReservaciones;
import Files.BasicFunctions;
import GUI.BuscarReservacion;


/**
 *
 * @author nelsoncarrillo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //esto deberia ir en el codigo de la interfaz prinicpal lo dejo aqui para probar
        BasicFunctions nuevoss = new BasicFunctions();
        ABBReservaciones arbol = nuevoss.Reservas();
       BuscarReservacion nuevo = new BuscarReservacion(arbol);
        nuevo.setVisible(true);
        //Hasta aqui
        
       
    }
    
}
