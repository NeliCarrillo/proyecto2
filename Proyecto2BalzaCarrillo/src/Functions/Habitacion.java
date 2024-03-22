/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;


/**
 * Clase que contiene los datos de las distintas habitaciones del hotel.
 * Facilita su b&uacute;squeda y almacenamiento hash.
 * 
 * @author nelsoncarrillo
 */

public class Habitacion {
    
    //Atributos de la clase
    private int num_hab; 
    private String tipo_hab; 
    private int piso; 
    private boolean free; 

    /**
     * Constructor de la clase
     * @param num_hab, numero de habitacion
     * @param tipo_hab, tipo de habitacion
     * @param piso, piso en donde se encuentra la habitacion
     */
    public Habitacion (int num_hab, String tipo_hab, int piso) {
        this.num_hab = num_hab;
        this.tipo_hab = tipo_hab;
        this.piso = piso;
        this.free = true;
    }

    /**
     * Metodo que permite obtener el numero de habitacion
     * @return numero de habitacion
     */
    public int getNum_hab() {
        return num_hab;
    }

    /**
     * Metodo que permite modificar el numero de habitacion
     * @param num_hab, nuevo numero de habitacion
     */
    public void setNum_hab(int num_hab) {
        this.num_hab = num_hab;
    }

    /**
     * Metodo que permite obtener el tipo de habitacion
     * @return tipo de habitacion
     */
    public String getTipo_hab() {
        return tipo_hab;
    }

    /**
     * Metodo que permite modificar el tipo de habitacion
     * @param tipo_hab, nuevo tipo de habitacion
     */
    public void setTipo_hab(String tipo_hab) {
        this.tipo_hab = tipo_hab;
    }

    /**
     * Metodo que permite obtener el piso de la habitacion
     * @return numero del piso de la habitacion
     */
    public int getPiso() {
        return piso;
    }

    /**
     * Metodo que permite modificar el piso de la habitacion
     * @param piso, nuevo numero de piso de la habitacion
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    /**
     * Metodo que permite obtener la disponibilidad de la habitacion
     * @return valor logico de si la habitacion esta disponible
     */
    public boolean isFree() {
        return free;
    }

    /**
     * Metodo que permite modificar la disponibilidad de la habitacion
     * @param free, valor logico 
     */
    public void setFree(boolean free) {
        this.free = free;
    }
    
    
}

