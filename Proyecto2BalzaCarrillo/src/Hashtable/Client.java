/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hashtable;

/**
 * Clase cliente que contiene los datos de cada cliente del hotel
 * @author tito_
 */
public class Client {
    
    //Atributos de la clase
    private int cedula;
    private String name;
    private String lastName;
    private String email;
    private String genero;
    private String tipoHab;
    private String tlf;
    private String llegada;
    private String salida;
    private int roomNum;

    /**
     * Constructor de la clase
     * @param cedula del cliente
     * @param name, nombre del cliente
     * @param lastName, apellido del cliente
     * @param email del cliente
     * @param genero del cliente
     * @param tipoHab, tipo de habitacion del cliente
     * @param tlf, numero telefonico del cliente
     * @param llegada, fecha de llegada del cliente
     * @param salida, fecha de salida del cliente
     * @param roomNum, numero de habitacion del cliente
     */
    public Client(int cedula, String name, String lastName, String email, String genero, String tipoHab, String tlf, String llegada, String salida, int roomNum) {
        this.cedula = cedula;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.genero = genero;
        this.tipoHab = tipoHab;
        this.tlf = tlf;
        this.llegada = llegada;
        this.salida = salida;
        this.roomNum = roomNum;
    }

    /**
     * Metodo que permite obtener el numero de habitacion de un cliente
     * @return numero de habitacion del usuario
     */
    public int getRoomNum() {
        return roomNum;
    }

    /**
     * Metodo que permite modificar el numero de habitacion de un cliente
     * @param roomNum, nuevo numero de habitacion del cliente 
     */
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
  
    /**
     * Metodo que permite obtener el numero de cedula de un cliente
     * @return numero de cedula del cliente
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Metodo que permite modificar el numero de cedula de un cliente
     * @param cedula, nueva cedula del cliente
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo que permite obtener el nombre de un cliente
     * @return nombre del cliente
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que permite modificar el nombre de un cliente
     * @param name, nombre nuevo del cliente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que permite obtener el apellido de un cliente
     * @return apellido del cliente
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Metodo que permite modificar el apellido de un cliente
     * @param lastName, nuevo apellido del cliente
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Metodo que permite obtener el correo electronico de un cliente
     * @return correo electronico del cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo que permite modificar el correo electronico de un cliente
     * @param email, correo electronico nuevo del cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo que permite obtener el genero de un cliente
     * @return genero del cliente
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Metodo que permite modificar el genero de un cliente
     * @param genero, nuevo genero del cliente
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Metodo que permite obtener el tipo de habitacion de un cliente
     * @return tipo de habitacion del cliente
     */
    public String getTipoHab() {
        return tipoHab;
    }

    /**
     * Metodo que permite modificar el tipo de habitacion de un cliente
     * @param tipoHab, nuevo tipo de habitacion del cliente
     */
    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    /**
     * Metodo que permite obtener el numero telefonico de un cliente
     * @return numero telefonico del cliente
     */
    public String getTlf() {
        return tlf;
    }

    /**
     * Metodo que permite modificar el numero telefonico de un cliente
     * @param tlf, nuevo numero telefonico del cliente
     */
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    /**
     * Metodo que permite obtener la fecha de llegada de un cliente
     * @return fecha de llegada del cliente 
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * Metodo que permite modificar la fecha de llegada de un cliente
     * @param llegada, nueva fecha de llegada del cliente
     */
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    /**
     * Metodo que permite obtener la fecha de salida de un cliente
     * @return fecha de salida del cliente
     */
    public String getSalida() {
        return salida;
    }

    /**
     * Metodo que permite modificar la fecha de salida de un cliente
     * @param salida, nueva fecha de salida del cliente
     */
    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    
}
