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
     * Constructor de la clase.
     * @param num_hab, numero de habitaci&oacute;n.
     * @param tipo_hab, tipo de habitaci&oacute;n.
     * @param piso, piso en donde se encuentra la habitaci&oacute;n.
     */
    public Habitacion (int num_hab, String tipo_hab, int piso) {
        this.num_hab = num_hab;
        this.tipo_hab = tipo_hab;
        this.piso = piso;
        this.free = true;
    }

    /**
     * M&eacute;todo que permite obtener el numero de habitaci&oacute;n.
     * @return numero de habitaci&oacute;n
     */
    public int getNum_hab() {
        return num_hab;
    }

    /**
     * M&eacute;todo que permite modificar el numero de habitaci&oacute;n.
     * @param num_hab, nuevo numero de habitaci&oacute;n
     */
    public void setNum_hab(int num_hab) {
        this.num_hab = num_hab;
    }

    /**
     * M&eacute;todo que permite obtener el tipo de habitaci&oacute;n.
     * @return tipo de habitaci&oacute;n
     */
    public String getTipo_hab() {
        return tipo_hab;
    }

    /**
     * M&eacute;todo que permite modificar el tipo de habitaci&oacute;n.
     * @param tipo_hab, nuevo tipo de habitaci&oacute;n
     */
    public void setTipo_hab(String tipo_hab) {
        this.tipo_hab = tipo_hab;
    }

    /**
     * M&eacute;todo que permite obtener el piso de la habitaci&oacute;n.
     * @return numero del piso de la habitaci&oacute;n
     */
    public int getPiso() {
        return piso;
    }

    /**
     * M&eacute;todo que permite modificar el piso de la habitaci&oacute;n.
     * @param piso, nuevo numero de piso de la habitaci&oacute;n
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    /**
     * M&eacute;todo que permite obtener la disponibilidad de la habitaci&oacute;n.
     * @return valor logico de si la habitaci&oacute;n esta disponible
     */
    public boolean isFree() {
        return free;
    }

    /**
     * M&eacute;todo que permite modificar la disponibilidad de la habitaci&oacute;n.
     * @param free, valor logico 
     */
    public void setFree(boolean free) {
        this.free = free;
    }
    
    
}

