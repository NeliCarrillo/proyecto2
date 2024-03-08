package Files;
import EDD.TreeReservas;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *Clase de funciones para iniciar el programa.
 * Ejemplo: crear &aacute;rboles, hash,etc.
 * 
 * @version 7 marzo 2024
 * @author nelsoncarrillo
 */
public class BasicFunctions {
    
    /**
     * M&eacute;todo que Guarda las Reservas del archivo CSV.
     * Esto mediante el uso de la libreria javacsv
     * 
     * @author nelsoncarrillo
     * @version 7 marzo 2024
     * @return ABB que contiene las reservaciones del hotel
     */
    public TreeReservas Reservas(){
        TreeReservas reservas = new TreeReservas(); 
        
        try{
            
            CsvReader leerUsuarios = new CsvReader("Reservaciones.csv");
            leerUsuarios.readHeaders();
            
            // Mientras haya lineas se obtienen los datos del archivo
            while(leerUsuarios.readRecord()) {
                
                String ci = leerUsuarios.get(0);
                ci = ci.replace(".","");
                int cedula = Integer.parseInt(ci);
                
                String f_name = leerUsuarios.get(1);
                String l_name = leerUsuarios.get(2);
                String email = leerUsuarios.get(3);
                String genero = leerUsuarios.get(4);
                String tipo_hab = leerUsuarios.get(5);
                String celular = leerUsuarios.get(6);
                String llegada = leerUsuarios.get(7);
                String salida = leerUsuarios.get(8);
                
                //Client cliente = new Client(cedula,f_name,l_name,email,genero,tipo_hab,celular,llegada,salida,-1);
                //reservas.insertNodo(reservas.getRoot(), cliente);
                
            }
            
            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
        return reservas; 
    }
}
